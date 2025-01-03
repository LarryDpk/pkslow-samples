package com.pkslow.bigdata;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.TableEnvironment;

public class FlinkCsvToParquet {
    public static void main(String[] args) {
// 1. Set up the streaming execution environment
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1); // Set parallelism to 1 for single output file (optional)

        // 2. Set up the Table environment
        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .inStreamingMode()
                .build();
        TableEnvironment tableEnv = TableEnvironment.create(settings);

        // 3. Define the source table
        String sourceDDL = "CREATE TABLE csv_source (\n" +
                "    id INT,\n" +
                "    name STRING,\n" +
                "    age INT\n" +
                ") WITH (\n" +
                "    'connector' = 'filesystem',\n" +
                "    'path' = 'file:///Users/larry/IdeaProjects/pkslow-samples/bigdata/flink-csv-to-parquet/src/main/resources/input.csv',\n" +  // Update this path
                "    'format' = 'csv',\n" +
                "    'csv.ignore-parse-errors' = 'true'\n" +
                ")";

        tableEnv.executeSql(sourceDDL);

        // 4. Define the sink table with custom filename settings
        String sinkDDL = "CREATE TABLE parquet_sink (\n" +
                "    id INT,\n" +
                "    name STRING,\n" +
                "    age INT\n" +
                ") WITH (\n" +
                "    'connector' = 'filesystem',\n" +
                "    'path' = 'file:///Users/larry/IdeaProjects/pkslow-samples/bigdata/flink-csv-to-parquet/output/',\n" +  // Update this path
                "    'format' = 'parquet',\n" +
                "    'sink.rolling-policy.file-size' = '134217728',\n" +          // 128 MB
                "    'sink.rolling-policy.rollover-interval' = '15 min',\n" +     // 15 minutes
                "    'sink.rolling-policy.inactivity-interval' = '5 min'\n" +     // 5 minutes
                ")";

        tableEnv.executeSql(sinkDDL);

        // 5. Insert data from source to sink
        String insertSQL = "INSERT INTO parquet_sink SELECT * FROM csv_source";
        tableEnv.executeSql(insertSQL);

        String printSink = "CREATE TABLE print_sink (\n" +
                "    id INT,\n" +
                "    name STRING,\n" +
                "    age INT\n" +
                ") WITH (\n" +
                "    'connector' = 'print',\n" +
                "    'print-identifier' = '[Sink data to console]'\n" +
                ")";

        tableEnv.executeSql(printSink);
        tableEnv.executeSql("INSERT INTO print_sink SELECT * FROM csv_source");

        // Note: In Table API, executing DDL and DML statements triggers the job.
        // No need to call env.execute()
    }
}