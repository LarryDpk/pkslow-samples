# pkslow-samples
samples for www.pkslow.com.

Topics: Java, Spring Boot, Spring Cloud, Docker, Kubernetes, Cloud, Big Data

Please visit my webSite for more articles: www.pkslow.com

<img src="https://pkslow.oss-cn-shenzhen.aliyuncs.com/images/pkslow-topics.png" width="400" alt="pkslow.com">

Build Package:
```shell script
mvn clean install
```

## Star History

![Star History Chart](https://api.star-history.com/svg?repos=LarryDpk/pkslow-samples&type=Date)


### 快速到达

[云原生技术相关文章](https://www.pkslow.com/categories/cloud)

[容器化技术相关文章](https://www.pkslow.com/categories/container)

[Spring Boot / Spring Cloud相关文章](https://www.pkslow.com/categories/springboot)

[南瓜慢说文章汇总](https://www.pkslow.com/archives/all)

[Terraform专题](https://www.pkslow.com/tags/terraform)

[如何制定切实可行的计划并好好执行](https://www.pkslow.com/archives/how-to-make-a-good-plan)

## 1 java-basic

### influxdb
[InfluxDB入门及使用，一个优秀的时序数据库](https://www.pkslow.com/archives/influxdb-introduction)

### pl-pojo-tester
[用pl.pojo.tester测试Pojo类，提高测试覆盖率](https://www.pkslow.com/archives/pl-pojo-tester)

### java-proxy
[Java如何设置代理来访问受限资源](https://www.pkslow.com/archives/java-proxy)

### protobuf
[Protobuf入门与使用示例，高性能的序列化框架](https://www.pkslow.com/archives/protobuf-introduction)

### liquibase
[通过Maven用LiquiBase对数据库变更进行版本控制](https://www.pkslow.com/archives/liquibase)

### grpc
[远程过程调用框架gRPC入门及Java示例代码](https://www.pkslow.com/archives/grpc-introduction)

## 2 spring-boot
### springboot-common
- [Bean初始化操作initMethod、@PostConstruct和InitializingBean](https://www.pkslow.com/archives/bean-initializing)
- [使用SpringBootCondition更自由地定义条件化配置](https://www.pkslow.com/archives/springbootcondition)
- [用ApplicationContextRunner测试配置类](https://www.pkslow.com/archives/test-config-class-with-applicationcontextrunner)
- [Spring Boot通过Actuator显示git和build的信息](https://www.pkslow.com/archives/springboot-actuator-git-build-info)


### spring-data-jpa-audit
- [Spring Data JPA的Audit功能，审计数据库的变更](https://www.pkslow.com/archives/spring-data-jpa-audit)
- [Spring MVC获取HTTP请求头的两种方式](https://www.pkslow.com/archives/spring-mvc-get-headers)

### spring-data-jpa-db2
- [通过Docker启动DB2，并在Spring Boot整合DB2](https://www.pkslow.com/archives/db2)


### spring-data-cassandra
[使用Stargate访问K8ssandra，Springboot整合Cassandra](https://www.pkslow.com/archives/k8ssandra-stargatre)


### spring-security-jwt
- [Springboot集成Spring Security实现JWT认证](https://www.pkslow.com/archives/springboot-spring-security-jwt-web)

### spring-security-jwt-webflux
- [Springboot WebFlux集成Spring Security实现JWT认证](https://www.pkslow.com/archives/springboot-spring-security-jwt-webflux)

### springboot-influxdb
[用InfluxDB+Grafana监控Springboot应用](https://www.pkslow.com/archives/springboot-monitored-by-influxdb-grafana)

### springboot-jms-solace
- [通过Docker启动Solace，并在Spring Boot通过JMS整合Solace](https://www.pkslow.com/archives/solace)

### spring-boot-native-graalvm
- [GraalVM和Spring Native尝鲜，一步步让Springboot启动飞起来，66ms完成启动](https://www.pkslow.com/archives/spring-boot-native-graalvm)

### spring-boot-native-without-buildtools
- [Spring Native打包本地镜像，无需通过Graal的maven插件buildtools](https://www.pkslow.com/archives/spring-boot-native-without-buildtools)

## 3 spring-cloud
Sample for Spring Cloud:
- [Spring Cloud Gateway简单入门，强大的微服务网关](https://www.pkslow.com/archives/spring-cloud-gateway-introduction)
- [Spring自定义转换类，让@Value更方便](https://www.pkslow.com/archives/spring-custom-convert)
- [在Spring WebFlux的任何地方获取Request对象](https://www.pkslow.com/archives/spring-webflux-get-request)

### spring-cloud-eureka
[Spring Cloud服务发现组件Eureka](https://www.pkslow.com/archives/spring-cloud-eureka)


### spring-cloud-stream
- [整合Spring Cloud Stream Binder与RabbitMQ进行消息发送与接收](https://www.pkslow.com/archives/spring-cloud-stream-binder-rabbit)
- [整合Spring Cloud Stream Binder与GCP Pubsub进行消息发送与接收](https://www.pkslow.com/archives/spring-cloud-stream-binder-pubsub)
- [整合Spring Cloud Stream Binder与Kafka进行消息发送与接收](https://www.pkslow.com/archives/spring-cloud-stream-binder-kafka)



### spring-cloud-data-flow & cloudfoundry-uaa-server & ldap-server

- [Spring Cloud Data Flow整合Cloudfoundry UAA服务做权限控制](https://www.pkslow.com/archives/spring-cloud-dataflow-uaa)
- [Spring Cloud Data Flow整合UAA使用外置数据库和API接口](https://www.pkslow.com/archives/spring-cloud-dataflow-uaa-api)
- [Spring Cloud Data Flow整合UAA之使用LDAP进行账号管理](https://www.pkslow.com/archives/spring-cloud-dataflow-uaa-ldap)


## 4 docker
### postgresql-multiple-databases
- [Docker启动PostgreSQL时创建多个数据库](https://www.pkslow.com/archives/docker-postgresql-multiple-databases)

## 5 kubernetes
### kubernetes-client-fabric8io
- [最好的Kubernetes客户端Java库fabric8io，快来自定义你的操作](https://www.pkslow.com/archives/kubernetes-client-fabric8io)

### configmap-springboot
- [Kubernetes ConfigMap详解，多种方式创建、多种方式使用](https://www.pkslow.com/archives/kubernetes-configmap)


### keda
[Kubernetes使用Keda进行弹性伸缩，更合理利用资源](https://www.pkslow.com/archives/keda)



## 6 cloud
[Terraform入门教程，示例展示管理Docker和Kubernetes资源](https://www.pkslow.com/archives/terraform)

[Terraform插件Provider管理，搜索、定义、下载](https://www.pkslow.com/archives/terraform-provider)

[Terraform状态State管理，让变更有记录](https://www.pkslow.com/archives/terraform-state)

[Terraform模块Module管理，聚合资源的抽取与复用](https://www.pkslow.com/archives/terraform-module)

[通过Terraform创建GCP Pubsub](https://www.pkslow.com/archives/terraform-gcp-pubsub)

[通过Google Cloud Storage(GCS)管理Terraform的状态State](https://www.pkslow.com/archives/terraform-gcs)

[Helm Template初体验，方便管理多环境](https://www.pkslow.com/archives/helm-template)

[K8ssandra入门-详细记录在Linux上部署K8ssandra到Kubernetes](https://www.pkslow.com/archives/k8ssandra)

[在GCP上创建GCE的三种方式(Console,gcloud,Terraform)](https://www.pkslow.com/archives/create-gcp-gce)

[在GCP上创建Cloud SQL的三种方式(Console,gcloud,Terraform)](https://www.pkslow.com/archives/create-gcp-cloudsql)

### dapr
- [dapr本地托管的服务调用体验与Java SDK的Spring Boot整合](https://www.pkslow.com/archives/dapr-java-sdk-springboot)



## 7 bigdata
[Apache Beam入门及Java SDK开发初体验](https://www.pkslow.com/archives/apache-beam)

## 8 other

### postgresql

[示例讲解PostgreSQL表分区的三种方式](https://www.pkslow.com/archives/postgresql-partitioning)

###  spring-batch

#### spring-batch-simple
[通过例子讲解Spring Batch入门，优秀的批处理框架](https://www.pkslow.com/archives/spring-batch-introduction)
Need to update the config `pkslow.outputFilename` accordingly.

#### remote-partition-local
[Spring Batch远程分区的本地Jar包模式](https://www.pkslow.com/archives/spring-batch-remote-partition-local-jar)
Need to startup a H2 database.

### quarkus-quickstart
- [Quarkus入门体验，22ms启动一个Web服务](https://www.pkslow.com/archives/quarkus-quickstart)

# Thanks to JetBrains

<h3 align="center">JetBrains</h3>

<p align="center">
  <a href="https://www.jetbrains.com/?from=pkslow-samples">
    <img width="260px" src="jetbrains-variant-4.png">
  </a>
</p>

> Thanks JetBrains to support the project providing such great IDE.