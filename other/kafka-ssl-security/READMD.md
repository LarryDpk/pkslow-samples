

```shell
PROJECT_HOME=/Users/larry/IdeaProjects/pkslow-samples

$PROJECT_HOME/other/install-kafka-cluster/src/main/kafka/kafka_2.13-3.4.0/bin/zookeeper-server-start.sh \
$PROJECT_HOME/other/install-kafka-cluster/src/main/kafka/kafka_2.13-3.4.0/config/zookeeper.properties
```



```shell
# SSL
PROJECT_HOME=/Users/larry/IdeaProjects/pkslow-samples
$PROJECT_HOME/other/install-kafka-cluster/src/main/kafka/kafka_2.13-3.4.0/bin/kafka-server-start.sh \
$PROJECT_HOME/other/kafka-ssl-security/server.properties
```



```shell
# No SSL
PROJECT_HOME=/Users/larry/IdeaProjects/pkslow-samples
$PROJECT_HOME/other/install-kafka-cluster/src/main/kafka/kafka_2.13-3.4.0/bin/kafka-server-start.sh \
$PROJECT_HOME/other/install-kafka-cluster/src/main/kafka/kafka_2.13-3.4.0/config/server.properties
```

