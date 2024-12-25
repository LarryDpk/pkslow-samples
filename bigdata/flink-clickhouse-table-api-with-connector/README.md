
## start app with JDK17
ad vm: `--add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED`



## start ClickHouse with Docker
https://hub.docker.com/r/clickhouse/clickhouse-server

```shell
docker run -itd --name pkslow-clickhouse-server \
-p 8123:8123 -p 9000:9000 \
-e CLICKHOUSE_DB=flink -e CLICKHOUSE_USER=larry -e CLICKHOUSE_DEFAULT_ACCESS_MANAGEMENT=1 -e CLICKHOUSE_PASSWORD=larrydpk \
clickhouse/clickhouse-server:24.12

```

```sql
CREATE TABLE IF NOT EXISTS flink.persons
(
    id Int64,
    name String,
    age Int32
) ENGINE = MergeTree
ORDER BY id
;
```

## Build flink-connector-clickhouse
update version of maven shade plugin:
```xml
<maven-shade-plugin.version>3.6.0</maven-shade-plugin.version>
```
```shell
export JAVA_HOME=/Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home
export PATH=$JAVA_HOME/bin:$PATH

mvn clean install
```
