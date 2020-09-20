package com.pkslow.influxdb;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;

import java.util.concurrent.TimeUnit;

public class InfluxDBMain {
    public static void main(String[] args) {
        //创建连接
        InfluxDB influxDB = InfluxDBFactory.connect("http://localhost:8086");

        //创建数据1
        Point point1 = Point.measurement("visits")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("link", "pkslow.com")
                .addField("value", 300.0)
                .build();

        //创建数据2
        Point point2 = Point.measurement("visits")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("link", "www.pkslow.com")
                .addField("value", 333.0)
                .build();

        //创建批量数据
        BatchPoints batchPoints = BatchPoints.database("pkslow")
                .retentionPolicy("autogen")
                .build();
        batchPoints.point(point1);
        batchPoints.point(point2);
        //将数据写入数据库
        influxDB.write(batchPoints);

        //创建查询对象
        Query query = new Query("Select * From visits", "pkslow");
        //查询
        QueryResult result = influxDB.query(query);
        //打印查询结果
        System.out.println(result);
    }
}
