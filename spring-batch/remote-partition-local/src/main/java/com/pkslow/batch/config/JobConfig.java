package com.pkslow.batch.config;

import com.pkslow.batch.entity.Person;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.partition.PartitionHandler;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.deployer.resource.support.DelegatingResourceLoader;
import org.springframework.cloud.deployer.spi.task.TaskLauncher;
import org.springframework.cloud.task.batch.partition.DeployerPartitionHandler;
import org.springframework.cloud.task.batch.partition.DeployerStepExecutionHandler;
import org.springframework.cloud.task.batch.partition.PassThroughCommandLineArgsProvider;
import org.springframework.cloud.task.batch.partition.SimpleEnvironmentVariablesProvider;
import org.springframework.cloud.task.repository.TaskRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.util.*;

@Configuration
public class JobConfig {

    private static final int GRID_SIZE = 4;
    // @checkstyle:off
    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    @Autowired
    public DataSource dataSource;
    @Autowired
    public JobRepository jobRepository;
    // @checkstyle:on
    @Autowired
    private ConfigurableApplicationContext context;
    @Autowired
    private DelegatingResourceLoader resourceLoader;
    @Autowired
    private Environment environment;

    @Value("${pkslow.worker.resource}")
    private String workerResource;

    @Bean
    public PartitionHandler partitionHandler(TaskLauncher taskLauncher, JobExplorer jobExplorer, TaskRepository taskRepository) throws Exception {

        Resource resource = this.resourceLoader.getResource(workerResource);

        DeployerPartitionHandler partitionHandler =
                new DeployerPartitionHandler(taskLauncher, jobExplorer, resource, "workerStep", taskRepository);

        List<String> commandLineArgs = new ArrayList<>(3);
        commandLineArgs.add("--spring.profiles.active=worker");
        commandLineArgs.add("--spring.cloud.task.initialize-enabled=false");
        commandLineArgs.add("--spring.batch.initializer.enabled=false");

        partitionHandler
                .setCommandLineArgsProvider(new PassThroughCommandLineArgsProvider(commandLineArgs));
        partitionHandler
                .setEnvironmentVariablesProvider(new SimpleEnvironmentVariablesProvider(this.environment));
        partitionHandler.setMaxWorkers(2);
        partitionHandler.setGridSize(GRID_SIZE);
        partitionHandler.setApplicationName("PkslowWorkerJob");

        return partitionHandler;
    }

    @Bean
    public Partitioner partitioner() {
        return new Partitioner() {
            @Override
            public Map<String, ExecutionContext> partition(int gridSize) {

                Map<String, ExecutionContext> partitions = new HashMap<>(gridSize);

                for (int i = 0; i < gridSize; i++) {
                    ExecutionContext executionContext = new ExecutionContext();
                    executionContext.put("partitionNumber", i);
                    executionContext.put("person", new Person(0, "pkslow", "www.pkslow.com"));

                    partitions.put("partition" + i, executionContext);
                }

                return partitions;
            }
        };
    }

    @Bean
    @Profile("worker")
    public DeployerStepExecutionHandler stepExecutionHandler(JobExplorer jobExplorer) {
        return new DeployerStepExecutionHandler(this.context, jobExplorer, this.jobRepository);
    }

    @Bean
    @StepScope
    public Tasklet workerTasklet(final @Value("#{stepExecutionContext['partitionNumber']}") Integer partitionNumber,
                                 final @Value("#{stepExecutionContext['person']}") Person person) {

        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                Thread.sleep(6000); //增加延时，查看效果，通过jps：在jar情况下会新起java进程
                System.out.println("This tasklet ran partition: " + partitionNumber);
                System.out.println("person: " + person);


                return RepeatStatus.FINISHED;
            }
        };
    }

    @Bean
    public Step step1(PartitionHandler partitionHandler) throws Exception {
        return this.stepBuilderFactory.get("step1")
                .partitioner(workerStep().getName(), partitioner())
//                .step(workerStep())
                .partitionHandler(partitionHandler)
                .build();
    }

    @Bean
    public Step workerStep() {
        return this.stepBuilderFactory.get("workerStep")
                .tasklet(workerTasklet(null, null))
                .build();
    }

    @Bean
    @Profile("!worker")
    public Job partitionedJob(PartitionHandler partitionHandler) throws Exception {
        Random random = new Random();
        return this.jobBuilderFactory.get("partitionedJob" + random.nextInt())
                .start(step1(partitionHandler))
                .build();
    }
}
