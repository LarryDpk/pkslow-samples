package com.pkslow.batch.config;

import com.pkslow.batch.config.listener.PkslowProcessListener;
import com.pkslow.batch.config.listener.PkslowReadListener;
import com.pkslow.batch.config.listener.PkslowWriteListener;
import com.pkslow.batch.entity.Employee;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
public class JobConfig {
    private static final Log logger = LogFactory.getLog(JobConfig.class);

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Value("input/inputData1.csv")
    private Resource[] inputResources;

    @Value("${pkslow.outputFilename}")
    private String outputFilename;



    @Bean
    public Job pkslowCsvJob() {
        return jobBuilderFactory
                .get("pkslowCsvJob")
                .incrementer(new RunIdIncrementer())
                .start(csvStep())
                .build();
    }

    @Bean
    public Step csvStep() {
        return stepBuilderFactory.get("csvStep").<Employee, Employee>chunk(5)
                .reader(multiResourceItemReader())
                .listener(new PkslowReadListener())
                .processor(itemProcessor())
                .listener(new PkslowProcessListener())
                .writer(writer())
                .listener(new PkslowWriteListener())
                .build();
    }


    @Bean
    public MultiResourceItemReader<Employee> multiResourceItemReader()
    {
        MultiResourceItemReader<Employee> resourceItemReader = new MultiResourceItemReader<Employee>();
        resourceItemReader.setResources(inputResources);
        resourceItemReader.setDelegate(reader());
        return resourceItemReader;
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public FlatFileItemReader<Employee> reader()
    {
        //Create reader instance
        FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();

        //Set number of lines to skips. Use it if file has header rows.
        reader.setLinesToSkip(1);

        //Configure how each line will be parsed and mapped to different values
        reader.setLineMapper(new DefaultLineMapper() {
            {
                //3 columns in each row
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[] { "id", "firstName", "lastName" });
                    }
                });
                //Set values in Employee class
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {
                    {
                        setTargetType(Employee.class);
                    }
                });
            }
        });
        return reader;
    }

    public ItemProcessor<Employee, Employee> itemProcessor() {
        return employee -> {
            employee.setLastName(employee.getLastName().toUpperCase());
            return employee;
        };
    }


    @Bean
    public FlatFileItemWriter<Employee> writer()
    {
        //Create writer instance
        FlatFileItemWriter<Employee> writer = new FlatFileItemWriter<>();

        //Set output file location
        writer.setResource(new FileSystemResource(outputFilename));

        //All job repetitions should "append" to same output file
        writer.setAppendAllowed(true);

        //Name field values sequence based on object properties
        writer.setLineAggregator(new DelimitedLineAggregator<Employee>() {
            {
                setDelimiter(",");
                setFieldExtractor(new BeanWrapperFieldExtractor<Employee>() {
                    {
                        setNames(new String[] { "id", "firstName", "lastName" });
                    }
                });
            }
        });
        return writer;
    }



}
