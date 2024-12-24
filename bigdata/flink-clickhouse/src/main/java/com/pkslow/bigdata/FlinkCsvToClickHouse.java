package com.pkslow.bigdata;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.TableEnvironment;

public class FlinkCsvToClickHouse {
    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .inStreamingMode()
                .build();
        TableEnvironment tableEnv = TableEnvironment.create(settings);

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

        String printTable = "CREATE TABLE print_table (\n" +
                "  id INT,\n" +
                "  name STRING,\n" +
                "  age INT\n" +
                ") WITH (\n" +
                "  'connector' = 'print'\n" +
                ");";

        tableEnv.executeSql(printTable);

        String insertSQL = "INSERT INTO print_table SELECT * FROM csv_source";
        tableEnv.executeSql(insertSQL);




    }
}