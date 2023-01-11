# pkslow-samples
There articles and code samples on website  www.pkslow.com. 

Mainly Topics: Java, Spring Boot, Spring Cloud, Docker, Kubernetes, Cloud, Big Data, Python

<img src="https://pkslow.oss-cn-shenzhen.aliyuncs.com/images/pkslow-topics.png" width="400" alt="pkslow.com">

Build Package:
```shell script
mvn clean install
```

# 南瓜慢说
你终于来了！ 欢迎来到**南瓜慢说**的世界。

南瓜慢说的个人网站为 www.pkslow.com ，寓意就是南瓜慢说(pumpkin slow). 该网站会记录我最新和最全的文章，部分文章会同步其它平台。

对应的GitHub仓库为：[pkslow-samples](https://github.com/LarryDpk/pkslow-samples)，该仓库主要是个人技术文章和相关的代码示例。
主要涉及的内容有：
- Java
- Spring Boot
- Spring Cloud
- Docker
- Kubernetes
- Cloud
- Big Data
- Python


可以通过以下命令构建项目：

```bash
mvn clean install
```

![Star History Chart](https://api.star-history.com/svg?repos=LarryDpk/pkslow-samples,LarryDpk/terraform-101&type=Date)



> 看着STAR数慢慢增加，也是一件值得开心的事。

将坚持记录所思所想，希望带给自己成长的同时，能帮助到别人。

做一个简简单单的人，

做一个普普通通的人，

做一个不伤害社会的人，

做一个至少有一点点益处的人。

<br/>
过好自己渺小的一生，而不至于虚无、后悔。

每一个不曾起舞的日子，都是对生命的辜负。

> 敢一行，则予知。脚踏实地，知行合一。

Table of Contents
=================

* [pkslow-samples](#pkslow-samples)
* [南瓜慢说](#南瓜慢说)
* [Spring Boot](#spring-boot)
  * [GraalVM相关](#graalvm相关)
  * [配置](#配置)
  * [SSL](#ssl)
  * [监控](#监控)
  * [数据操作](#数据操作)
  * [Web开发](#web开发)
  * [Security](#security)
  * [Spring Batch](#spring-batch)
  * [其它](#其它)
* [Spring Cloud](#spring-cloud)
  * [Spring Cloud Data Flow](#spring-cloud-data-flow)
  * [Spring Cloud Stream](#spring-cloud-stream)
  * [其它](#其它-1)
* [Docker](#docker)
  * [Docker知识](#docker知识)
  * [其它](#其它-2)
* [Kubernetes](#kubernetes)
  * [安装指导](#安装指导)
* [Cloud](#cloud)
  * [dapr](#dapr)
  * [Istio](#istio)
  * [Google Cloud Platform](#google-cloud-platform)
  * [《Terraform 101 从入门到实践》](#terraform-101-从入门到实践)
  * [Terraform](#terraform)
* [Java基础](#java基础)
  * [集合类](#集合类)
* [其它技术](#其它技术)
  * [Mac](#mac)
  * [Python](#python)
  * [Linux](#linux)
  * [App开发](#app开发)
  * [数据库](#数据库)
  * [IDEA](#idea)
  * [VSCode](#vscode)
* [生活](#生活)
  * [生活杂事](#生活杂事)
  * [旅行](#旅行)
  * [育儿](#育儿)
  * [诗词歌赋](#诗词歌赋)
* [状态](#状态)
* [Thanks to JetBrains](#thanks-to-jetbrains)
  * [JetBrains](#jetbrains)

<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

# Spring Boot


<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## GraalVM相关

[GraalVM和Spring Native尝鲜，一步步让Springboot启动飞起来，66ms完成启动](https://www.pkslow.com/archives/spring-boot-native-graalvm)
- Code: [/spring-boot/spring-boot-native-graalvm](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/spring-boot-native-graalvm)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/10/20221030.GraalVM%E5%92%8CSpring%20Native%E5%B0%9D%E9%B2%9C%EF%BC%8C%E4%B8%80%E6%AD%A5%E6%AD%A5%E8%AE%A9Springboot%E5%90%AF%E5%8A%A8%E9%A3%9E%E8%B5%B7%E6%9D%A5%EF%BC%8C66ms%E5%AE%8C%E6%88%90%E5%90%AF%E5%8A%A8.md)

[Spring Native打包本地镜像，无需通过Graal的maven插件buildtools](https://www.pkslow.com/archives/spring-boot-native-without-buildtools)
- Code: [/spring-boot/spring-boot-native-without-buildtools](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/spring-boot-native-without-buildtools)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/11/20221103.Spring%20Native%E6%89%93%E5%8C%85%E6%9C%AC%E5%9C%B0%E9%95%9C%E5%83%8F%EF%BC%8C%E6%97%A0%E9%9C%80%E9%80%9A%E8%BF%87Graal%E7%9A%84maven%E6%8F%92%E4%BB%B6buildtools.md)

[Quarkus入门体验，22ms启动一个Web服务](https://www.pkslow.com/archives/quarkus-quickstart)
- Code: [/other/quarkus-quickstart](https://github.com/LarryDpk/pkslow-samples/tree/master/other/quarkus-quickstart)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/11/20221101.Quarkus%E5%85%A5%E9%97%A8%E4%BD%93%E9%AA%8C%EF%BC%8C22ms%E5%90%AF%E5%8A%A8%E4%B8%80%E4%B8%AAWeb%E6%9C%8D%E5%8A%A1.md)



<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## 配置
[Springboot整合Jasypt，让配置信息安全最优雅方便的方式](https://www.pkslow.com/archives/springboot-jasypt)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/12/20191213.Springboot.Springboot%E6%95%B4%E5%90%88Jasypt%EF%BC%8C%E8%AE%A9%E9%85%8D%E7%BD%AE%E4%BF%A1%E6%81%AF%E5%AE%89%E5%85%A8%E6%9C%80%E4%BC%98%E9%9B%85%E6%96%B9%E4%BE%BF%E7%9A%84%E6%96%B9%E5%BC%8F.md)

[注解@ConfigurationProperties让配置整齐而简单](https://www.pkslow.com/archives/springboot-annotation-configurationproperties)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/01/20200111.Springboot.%E6%B3%A8%E8%A7%A3%40ConfigurationProperties%E8%AE%A9%E9%85%8D%E7%BD%AE%E6%95%B4%E9%BD%90%E8%80%8C%E7%AE%80%E5%8D%95.md)

[只想用一篇文章记录@Value的使用，不想再找其它了](https://www.pkslow.com/archives/spring-annotation-value)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/12/20191222.Spring.%E5%8F%AA%E6%83%B3%E7%94%A8%E4%B8%80%E7%AF%87%E6%96%87%E7%AB%A0%E8%AE%B0%E5%BD%95%40Value%E7%9A%84%E4%BD%BF%E7%94%A8%EF%BC%8C%E4%B8%8D%E6%83%B3%E5%86%8D%E6%89%BE%E5%85%B6%E5%AE%83%E4%BA%86.md)

[Spring自定义转换类，让@Value更方便](https://www.pkslow.com/archives/spring-custom-convert)
- Code: [/spring-cloud/rest-service](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-cloud/rest-service)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/12/20201220.Spring%E8%87%AA%E5%AE%9A%E4%B9%89%E8%BD%AC%E6%8D%A2%E7%B1%BB%EF%BC%8C%E8%AE%A9%40Value%E6%9B%B4%E6%96%B9%E4%BE%BF.md)

[使用SpringBootCondition更自由地定义条件化配置](https://www.pkslow.com/archives/springbootcondition)
- Code: [/spring-boot/springboot-common](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/springboot-common)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/03/20210331.%E4%BD%BF%E7%94%A8SpringBootCondition%E6%9B%B4%E8%87%AA%E7%94%B1%E5%9C%B0%E5%AE%9A%E4%B9%89%E6%9D%A1%E4%BB%B6%E5%8C%96%E9%85%8D%E7%BD%AE.md)

[用ApplicationContextRunner测试配置类](https://www.pkslow.com/archives/test-config-class-with-applicationcontextrunner)
- Code: [/spring-boot/springboot-common](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/springboot-common)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/03/20210331.%E7%94%A8ApplicationContextRunner%E6%B5%8B%E8%AF%95%E9%85%8D%E7%BD%AE%E7%B1%BB.md)


[Bean初始化操作initMethod、@PostConstruct和InitializingBean](https://www.pkslow.com/archives/bean-initializing)
- Code: [/spring-boot/springboot-common](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/springboot-common)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/02/20210206.Bean%E5%88%9D%E5%A7%8B%E5%8C%96%E6%93%8D%E4%BD%9CinitMethod%E3%80%81%40PostConstruct%E5%92%8CInitializingBean.md)


<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## SSL
[Springboot整合https原来这么简单](https://www.pkslow.com/archives/springboot-ssl-basic)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/04/20200426.Springboot%E6%95%B4%E5%90%88https%E5%8E%9F%E6%9D%A5%E8%BF%99%E4%B9%88%E7%AE%80%E5%8D%95.md)

[实例讲解Springboot以Template方式整合Redis及序列化问题](https://www.pkslow.com/archives/springboot-redis-template)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/04/20200424.%E5%AE%9E%E4%BE%8B%E8%AE%B2%E8%A7%A3Springboot%E4%BB%A5Template%E6%96%B9%E5%BC%8F%E6%95%B4%E5%90%88Redis%E5%8F%8A%E5%BA%8F%E5%88%97%E5%8C%96%E9%97%AE%E9%A2%98.md)

[实例讲解Springboot以Repository方式整合Redis](https://www.pkslow.com/archives/springboot-redis-repository)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/04/20200423.%E5%AE%9E%E4%BE%8B%E8%AE%B2%E8%A7%A3Springboot%E4%BB%A5Repository%E6%96%B9%E5%BC%8F%E6%95%B4%E5%90%88Redis.md)

[Springboot以Jetty为容器实现http重定向到https](https://www.pkslow.com/archives/springboot-ssl-redirect-jetty)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/05/20200501.Springboot%E4%BB%A5Jetty%E4%B8%BA%E5%AE%B9%E5%99%A8%E5%AE%9E%E7%8E%B0http%E9%87%8D%E5%AE%9A%E5%90%91%E5%88%B0https.md)

[Springboot以Tomcat为容器实现http重定向到https的两种方式](https://www.pkslow.com/archives/springboot-ssl-redirect-tomcat)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/04/20200430.Springboot%E4%BB%A5Tomcat%E4%B8%BA%E5%AE%B9%E5%99%A8%E5%AE%9E%E7%8E%B0http%E9%87%8D%E5%AE%9A%E5%90%91%E5%88%B0https%E7%9A%84%E4%B8%A4%E7%A7%8D%E6%96%B9%E5%BC%8F.md)

[Https双向验证与Springboot整合测试-人来人往我只认你](https://www.pkslow.com/archives/two-way-ssl)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/05/20200505.Https%E5%8F%8C%E5%90%91%E9%AA%8C%E8%AF%81%E4%B8%8ESpringboot%E6%95%B4%E5%90%88%E6%B5%8B%E8%AF%95-%E4%BA%BA%E6%9D%A5%E4%BA%BA%E5%BE%80%E6%88%91%E5%8F%AA%E8%AE%A4%E4%BD%A0.md)

[Springboot-WebFlux实现http重定向到https](https://www.pkslow.com/archives/springboot-ssl-redirect-webflux)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/05/20200503.Springboot-WebFlux%E5%AE%9E%E7%8E%B0http%E9%87%8D%E5%AE%9A%E5%90%91%E5%88%B0https.md)



<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## 监控
[用Springboot Admin监控你的微服务应用](https://www.pkslow.com/archives/monitor-microservice-by-springboot-admini)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/12/20191215.Springboot.%E7%94%A8Springboot%20Admin%E7%9B%91%E6%8E%A7%E4%BD%A0%E7%9A%84%E5%BE%AE%E6%9C%8D%E5%8A%A1%E5%BA%94%E7%94%A8.md)


[实例讲解Springboot整合OpenTracing分布式链路追踪系统（Jaeger和Zipkin）](https://www.pkslow.com/archives/springboot-opentracing-with-jaeger-zipkin)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/04/20200405.Springboot.%E5%AE%9E%E4%BE%8B%E8%AE%B2%E8%A7%A3Springboot%E6%95%B4%E5%90%88OpenTracing%E5%88%86%E5%B8%83%E5%BC%8F%E9%93%BE%E8%B7%AF%E8%BF%BD%E8%B8%AA%E7%B3%BB%E7%BB%9F%EF%BC%88Jaeger%E5%92%8CZipkin%EF%BC%89.md)

[用Prometheus+Grafana监控Springboot应用](https://www.pkslow.com/archives/springboot-monitored-by-prometheus-grafana)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/03/20200325.Springboot.%E7%94%A8Prometheus%2BGrafana%E7%9B%91%E6%8E%A7Springboot%E5%BA%94%E7%94%A8.md)

[用InfluxDB+Grafana监控Springboot应用](https://www.pkslow.com/archives/springboot-monitored-by-influxdb-grafana)
- Code: [/spring-boot/springboot-influxdb](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/springboot-influxdb)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/09/20200920.%E7%94%A8InfluxDB%2BGrafana%E7%9B%91%E6%8E%A7Springboot%E5%BA%94%E7%94%A8.md)





<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## 数据操作
[实例讲解Springboot整合MongoDB进行CRUD操作的两种方式](https://www.pkslow.com/archives/springboot-mongodb-repository-template)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/04/20200420.%E5%AE%9E%E4%BE%8B%E8%AE%B2%E8%A7%A3Springboot%E6%95%B4%E5%90%88MongoDB%E8%BF%9B%E8%A1%8CCRUD%E6%93%8D%E4%BD%9C%E7%9A%84%E4%B8%A4%E7%A7%8D%E6%96%B9%E5%BC%8F.md)

[简化RESTful开发，Spring Data REST让你少掉发](https://www.pkslow.com/archives/spring-data-rest)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200802.%E7%AE%80%E5%8C%96RESTful%E5%BC%80%E5%8F%91%EF%BC%8CSpring%20Data%20REST%E8%AE%A9%E4%BD%A0%E5%B0%91%E6%8E%89%E5%8F%91.md)


[Spring Data JPA的Audit功能，审计数据库的变更](https://www.pkslow.com/archives/spring-data-jpa-audit)
- Code: [/spring-boot/spring-data-jpa-audit](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/spring-data-jpa-audit)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/01/20210115.Spring%20Data%20JPA%E7%9A%84Audit%E5%8A%9F%E8%83%BD%EF%BC%8C%E5%AE%A1%E8%AE%A1%E6%95%B0%E6%8D%AE%E5%BA%93%E7%9A%84%E5%8F%98%E6%9B%B4.md)





<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## Web开发
[Springboot整合Swagger](https://www.pkslow.com/archives/springboot-swagger)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200721.Springboot%E6%95%B4%E5%90%88Swagger.md)


[Springboot的Web应用中HTTP请求头RequestHeader过大](https://www.pkslow.com/archives/springboot-http-request-header-too-large)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/01/20210122.Springboot%E7%9A%84Web%E5%BA%94%E7%94%A8%E4%B8%ADHTTP%E8%AF%B7%E6%B1%82%E5%A4%B4RequestHeader%E8%BF%87%E5%A4%A7.md)


[Spring MVC获取HTTP请求头的两种方式](https://www.pkslow.com/archives/spring-mvc-get-headers)
- Code: [/spring-boot/spring-data-jpa-audit](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/spring-data-jpa-audit)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/01/20210125.Spring%20MVC%E8%8E%B7%E5%8F%96HTTP%E8%AF%B7%E6%B1%82%E5%A4%B4%E7%9A%84%E4%B8%A4%E7%A7%8D%E6%96%B9%E5%BC%8F.md)


[在Spring WebFlux的任何地方获取Request对象](https://www.pkslow.com/archives/spring-webflux-get-request)
- Code: [/spring-cloud/webflux-service](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-cloud/webflux-service)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/01/20210112.%E5%9C%A8Spring%20WebFlux%E7%9A%84%E4%BB%BB%E4%BD%95%E5%9C%B0%E6%96%B9%E8%8E%B7%E5%8F%96Request%E5%AF%B9%E8%B1%A1.md)


[用Springboot干掉IBM的WAS-为公司省点钱](https://www.pkslow.com/archives/springboot-replace-was)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/06/20200613.%E7%94%A8Springboot%E5%B9%B2%E6%8E%89IBM%E7%9A%84WAS-%E4%B8%BA%E5%85%AC%E5%8F%B8%E7%9C%81%E7%82%B9%E9%92%B1.md)


[在Spring Boot中整合Katharsis，来快速开发JSON API的Web应用](https://www.pkslow.com/archives/springboot-katharsis)
- Code: [/spring-boot/spring-boot-katharsis](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/spring-boot-katharsis)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/11/20221121.%E5%9C%A8Spring%20Boot%E4%B8%AD%E6%95%B4%E5%90%88Katharsis%EF%BC%8C%E6%9D%A5%E5%BF%AB%E9%80%9F%E5%BC%80%E5%8F%91JSON%20API%E7%9A%84Web%E5%BA%94%E7%94%A8.md)

[Spring在Filter中记录Web请求Request和返回Response的内容及时长](https://www.pkslow.com/archives/spring-log-request-response)
- Code: [/spring-boot/springboot-common](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/springboot-common)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/12/20221221.Spring%E5%9C%A8Filter%E4%B8%AD%E8%AE%B0%E5%BD%95Web%E8%AF%B7%E6%B1%82Request%E5%92%8C%E8%BF%94%E5%9B%9EResponse%E7%9A%84%E5%86%85%E5%AE%B9%E5%8F%8A%E6%97%B6%E9%95%BF.md)


<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## Security
[Springboot集成Spring Security实现JWT认证](https://www.pkslow.com/archives/springboot-spring-security-jwt-web)
- Code: [/spring-boot/spring-security-jwt](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/spring-security-jwt)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/02/20210206.Springboot%E9%9B%86%E6%88%90Spring%20Security%E5%AE%9E%E7%8E%B0JWT%E8%AE%A4%E8%AF%81.md)


[Springboot WebFlux集成Spring Security实现JWT认证](https://www.pkslow.com/archives/springboot-spring-security-jwt-webflux)
- Code: [/spring-boot/spring-security-jwt-webflux](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/spring-security-jwt-webflux)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/02/20210210.Springboot%20WebFlux%E9%9B%86%E6%88%90Spring%20Security%E5%AE%9E%E7%8E%B0JWT%E8%AE%A4%E8%AF%81.md)


<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## Spring Batch
[通过例子讲解Spring Batch入门，优秀的批处理框架](https://www.pkslow.com/archives/spring-batch-introduction)
- Code: [/other/spring-batch/spring-batch-simple](https://github.com/LarryDpk/pkslow-samples/tree/master/other/spring-batch/spring-batch-simple)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/09/20200913.%E9%80%9A%E8%BF%87%E4%BE%8B%E5%AD%90%E8%AE%B2%E8%A7%A3Spring%20Batch%E5%85%A5%E9%97%A8%EF%BC%8C%E4%BC%98%E7%A7%80%E7%9A%84%E6%89%B9%E5%A4%84%E7%90%86%E6%A1%86%E6%9E%B6.md)


[Spring Batch远程分区的本地Jar包模式](https://www.pkslow.com/archives/spring-batch-remote-partition-local-jar)
- Code: [/other/spring-batch/remote-partition-local](https://github.com/LarryDpk/pkslow-samples/tree/master/other/spring-batch/remote-partition-local)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/09/20200915.Spring%20Batch%E8%BF%9C%E7%A8%8B%E5%88%86%E5%8C%BA%E7%9A%84%E6%9C%AC%E5%9C%B0Jar%E5%8C%85%E6%A8%A1%E5%BC%8F.md)

[大量数据也不在话下，Spring Batch并行处理四种模式初探](https://www.pkslow.com/archives/spring-batch-scaling)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/09/20200913.%E5%A4%A7%E9%87%8F%E6%95%B0%E6%8D%AE%E4%B9%9F%E4%B8%8D%E5%9C%A8%E8%AF%9D%E4%B8%8B%EF%BC%8CSpring%20Batch%E5%B9%B6%E8%A1%8C%E5%A4%84%E7%90%86%E5%9B%9B%E7%A7%8D%E6%A8%A1%E5%BC%8F%E5%88%9D%E6%8E%A2.md)



<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## 其它

[Springboot整合邮件服务](https://www.pkslow.com/archives/springboot-with-email)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/10/20191019.Springboot.Springboot%E6%95%B4%E5%90%88%E9%82%AE%E4%BB%B6%E6%9C%8D%E5%8A%A1.md)


[Spring的定时任务注解@Scheduled原来如此简单](https://www.pkslow.com/archives/spring-scheduled-annotation)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/11/20191119.Spring.Spring%E7%9A%84%E5%AE%9A%E6%97%B6%E4%BB%BB%E5%8A%A1%E6%B3%A8%E8%A7%A3%40Scheduled%E5%8E%9F%E6%9D%A5%E5%A6%82%E6%AD%A4%E7%AE%80%E5%8D%95.md)



[单元测试中使用Spring的ReflectionTestUtils更方便](https://www.pkslow.com/archives/reflectiontestutils)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/05/20200508.%E5%8D%95%E5%85%83%E6%B5%8B%E8%AF%95%E4%B8%AD%E4%BD%BF%E7%94%A8Spring%E7%9A%84ReflectionTestUtils%E6%9B%B4%E6%96%B9%E4%BE%BF.md)



[如何开发Springboot命令行非Web应用](https://www.pkslow.com/archives/springboot-commandline)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200826.%E5%A6%82%E4%BD%95%E5%BC%80%E5%8F%91Springboot%E5%91%BD%E4%BB%A4%E8%A1%8C%E9%9D%9EWeb%E5%BA%94%E7%94%A8.md)




[Spring Boot Actuator show the git and build info](https://www.pkslow.com/archives/springboot-actuator-git-build-info-en)
- Code: [/spring-boot/springboot-common](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/springboot-common)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/11/20211112.Spring%20Boot%20Actuator%20show%20the%20git%20and%20build%20info.md)


[Spring Boot通过Actuator显示git和build的信息](https://www.pkslow.com/archives/springboot-actuator-git-build-info)
- Code: [/spring-boot/springboot-common](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/springboot-common)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/11/20211112.Spring%20Boot%E9%80%9A%E8%BF%87Actuator%E6%98%BE%E7%A4%BAgit%E5%92%8Cbuild%E7%9A%84%E4%BF%A1%E6%81%AF.md)

[Spring AOP与AspectJ的对比及应用](https://www.pkslow.com/archives/spring-aop-vs-aspectj)
- Code: [/spring-boot/springboot-aspectj](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/springboot-aspectj)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2023/01/20230105.Spring%20AOP%E4%B8%8EAspectJ%E7%9A%84%E5%AF%B9%E6%AF%94%E5%8F%8A%E5%BA%94%E7%94%A8.md)


[Springboot整合AOP和注解，实现丰富的切面功能](https://www.pkslow.com/archives/springboot-aspectj-annotation)
- Code: [/spring-boot/springboot-aspectj](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/springboot-aspectj)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2023/01/20230105.Springboot%E6%95%B4%E5%90%88AOP%E5%92%8C%E6%B3%A8%E8%A7%A3%EF%BC%8C%E5%AE%9E%E7%8E%B0%E4%B8%B0%E5%AF%8C%E7%9A%84%E5%88%87%E9%9D%A2%E5%8A%9F%E8%83%BD.md)


<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>


# Spring Cloud



<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## Spring Cloud Data Flow

[Spring Cloud Data Flow初体验，以Local模式运行](https://www.pkslow.com/archives/spring-cloud-data-flow)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200729.Spring%20Cloud%20Data%20Flow%E5%88%9D%E4%BD%93%E9%AA%8C%EF%BC%8C%E4%BB%A5Local%E6%A8%A1%E5%BC%8F%E8%BF%90%E8%A1%8C.md)


[Spring Cloud Data Flow用Shell来操作，方便建立CICD](https://www.pkslow.com/archives/spring-cloud-dataflow-shell)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200802.Spring%20Cloud%20Data%20Flow%E7%94%A8Shell%E6%9D%A5%E6%93%8D%E4%BD%9C%EF%BC%8C%E6%96%B9%E4%BE%BF%E5%BB%BA%E7%AB%8BCICD.md)


[Spring Cloud Data Flow整合UAA使用外置数据库和API接口](https://www.pkslow.com/archives/spring-cloud-dataflow-uaa-api)
- Code: [/spring-cloud/cloudfoundry-uaa-server](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-cloud/cloudfoundry-uaa-server)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/12/20201227.Spring%20Cloud%20Data%20Flow%E6%95%B4%E5%90%88UAA%E4%BD%BF%E7%94%A8%E5%A4%96%E7%BD%AE%E6%95%B0%E6%8D%AE%E5%BA%93%E5%92%8CAPI%E6%8E%A5%E5%8F%A3.md)


[Spring Cloud Data Flow整合Cloudfoundry UAA服务做权限控制](https://www.pkslow.com/archives/spring-cloud-dataflow-uaa)
- Code: [/spring-cloud/cloudfoundry-uaa-server](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-cloud/cloudfoundry-uaa-server)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/12/20201225.Spring%20Cloud%20Data%20Flow%E6%95%B4%E5%90%88Cloudfoundry%20UAA%E6%9C%8D%E5%8A%A1%E5%81%9A%E6%9D%83%E9%99%90%E6%8E%A7%E5%88%B6.md)


[Spring Cloud Data Flow整合UAA之使用LDAP进行账号管理](https://www.pkslow.com/archives/spring-cloud-dataflow-uaa-ldap)
- Code: [/spring-cloud/ldap-server](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-cloud/ldap-server)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/01/20210101.Spring%20Cloud%20Data%20Flow%E6%95%B4%E5%90%88UAA%E4%B9%8B%E4%BD%BF%E7%94%A8LDAP%E8%BF%9B%E8%A1%8C%E8%B4%A6%E5%8F%B7%E7%AE%A1%E7%90%86.md)




<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## Spring Cloud Stream
[整合Spring Cloud Stream Binder与RabbitMQ进行消息发送与接收](https://www.pkslow.com/archives/spring-cloud-stream-binder-rabbit)
- Code: [/spring-cloud/spring-cloud-stream/spring-cloud-stream-binder-rabbit](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-cloud/spring-cloud-stream/spring-cloud-stream-binder-rabbit)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/05/20210511.%E6%95%B4%E5%90%88Spring%20Cloud%20Stream%20Binder%E4%B8%8ERabbitMQ%E8%BF%9B%E8%A1%8C%E6%B6%88%E6%81%AF%E5%8F%91%E9%80%81%E4%B8%8E%E6%8E%A5%E6%94%B6.md)


[Integrate Spring Cloud Stream Binder with Kafka](https://www.pkslow.com/archives/spring-cloud-stream-binder-kafka-en)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/06/20210620.Integrate%20Spring%20Cloud%20Stream%20Binder%20with%20Kafka.md)


[整合Spring Cloud Stream Binder与Kafka进行消息发送与接收](https://www.pkslow.com/archives/spring-cloud-stream-binder-kafka)
- Code: [/spring-cloud/spring-cloud-stream/spring-cloud-stream-binder-kafka](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-cloud/spring-cloud-stream/spring-cloud-stream-binder-kafka)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/06/20210620.%E6%95%B4%E5%90%88Spring%20Cloud%20Stream%20Binder%E4%B8%8EKafka%E8%BF%9B%E8%A1%8C%E6%B6%88%E6%81%AF%E5%8F%91%E9%80%81%E4%B8%8E%E6%8E%A5%E6%94%B6.md)







<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## 其它



[使用Spring Cloud Config统一管理配置，别再到处放配置文件了](https://www.pkslow.com/archives/spring-cloud-config)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200814.%E4%BD%BF%E7%94%A8Spring%20Cloud%20Config%E7%BB%9F%E4%B8%80%E7%AE%A1%E7%90%86%E9%85%8D%E7%BD%AE%EF%BC%8C%E5%88%AB%E5%86%8D%E5%88%B0%E5%A4%84%E6%94%BE%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6%E4%BA%86.md)


[Spring Cloud Config在Spring Cloud Task中的应用，比Web应用更简单](https://www.pkslow.com/archives/spring-cloud-config-for-cloud-task)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200823.Spring%20Cloud%20Config%E5%9C%A8Spring%20Cloud%20Task%E4%B8%AD%E7%9A%84%E5%BA%94%E7%94%A8%EF%BC%8C%E6%AF%94Web%E5%BA%94%E7%94%A8%E6%9B%B4%E7%AE%80%E5%8D%95.md)


[Spring Cloud Gateway简单入门，强大的微服务网关](https://www.pkslow.com/archives/spring-cloud-gateway-introduction)
- Code: [/spring-cloud/spring-cloud-gateway](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-cloud/spring-cloud-gateway)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/12/20201213.Spring%20Cloud%20Gateway%E7%AE%80%E5%8D%95%E5%85%A5%E9%97%A8%EF%BC%8C%E5%BC%BA%E5%A4%A7%E7%9A%84%E5%BE%AE%E6%9C%8D%E5%8A%A1%E7%BD%91%E5%85%B3.md)



[Spring Cloud服务发现组件Eureka](https://www.pkslow.com/archives/spring-cloud-eureka)
- Code: [/spring-cloud/spring-cloud-eureka](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-cloud/spring-cloud-eureka)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/01/20220111.Spring%20Cloud%E6%9C%8D%E5%8A%A1%E5%8F%91%E7%8E%B0%E7%BB%84%E4%BB%B6Eureka.md)

[Spring Cloud Service Discovery with Netflix Eureka](https://www.pkslow.com/archives/spring-cloud-eureka-en)
- Code: [/spring-cloud/spring-cloud-eureka](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-cloud/spring-cloud-eureka)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/01/20220111.Spring%20Cloud%20Service%20Discovery%20with%20Netflix%20Eureka.md)


<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>



# Docker

<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## Docker知识
[Docker入门——理解Docker的核心概念](https://www.pkslow.com/archives/docker-concept)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/06/20200630.Docker%E5%85%A5%E9%97%A8%E2%80%94%E2%80%94%E7%90%86%E8%A7%A3Docker%E7%9A%84%E6%A0%B8%E5%BF%83%E6%A6%82%E5%BF%B5.md)

[打不死的小强，让Docker的容器自动重启](https://www.pkslow.com/archives/docker-container-auto-restart)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200721.%E6%89%93%E4%B8%8D%E6%AD%BB%E7%9A%84%E5%B0%8F%E5%BC%BA%EF%BC%8C%E8%AE%A9Docker%E7%9A%84%E5%AE%B9%E5%99%A8%E8%87%AA%E5%8A%A8%E9%87%8D%E5%90%AF.md)

[Dockerfile复制时如何保留子目录的结构](https://www.pkslow.com/archives/dockerfile-copy-keep-subdirectory-structure)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200720.Dockerfile%E5%A4%8D%E5%88%B6%E6%97%B6%E5%A6%82%E4%BD%95%E4%BF%9D%E7%95%99%E5%AD%90%E7%9B%AE%E5%BD%95%E7%9A%84%E7%BB%93%E6%9E%84.md)

[Dockerfile复制上级目录文件](https://www.pkslow.com/archives/dockerfile-copy-parent-files)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200720.Dockerfile%E5%A4%8D%E5%88%B6%E4%B8%8A%E7%BA%A7%E7%9B%AE%E5%BD%95%E6%96%87%E4%BB%B6.md)

[Docker这些none:none的镜像，难道就不配拥有名字吗](https://www.pkslow.com/archives/docker-none-none-images)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200723.Docker%E8%BF%99%E4%BA%9Bnone%3Anone%E7%9A%84%E9%95%9C%E5%83%8F%EF%BC%8C%E9%9A%BE%E9%81%93%E5%B0%B1%E4%B8%8D%E9%85%8D%E6%8B%A5%E6%9C%89%E5%90%8D%E5%AD%97%E5%90%97.md)

[如何查看Docker容器环境变量，如何向容器传递环境变量](https://www.pkslow.com/archives/docker-env)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200730.%E5%A6%82%E4%BD%95%E6%9F%A5%E7%9C%8BDocker%E5%AE%B9%E5%99%A8%E7%8E%AF%E5%A2%83%E5%8F%98%E9%87%8F%EF%BC%8C%E5%A6%82%E4%BD%95%E5%90%91%E5%AE%B9%E5%99%A8%E4%BC%A0%E9%80%92%E7%8E%AF%E5%A2%83%E5%8F%98%E9%87%8F.md)


[Docker因权限问题无法启动Springboot](https://www.pkslow.com/archives/docker-failed-to-start-springboot-due-to-permission)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200730.Docker%E5%9B%A0%E6%9D%83%E9%99%90%E9%97%AE%E9%A2%98%E6%97%A0%E6%B3%95%E5%90%AF%E5%8A%A8Springboot.md)

[一行代码的变更让我陷入无尽加班，Dockerfile的ENTRYPOINT的两种格式](https://www.pkslow.com/archives/docker-entrypoint-issue)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/09/20200904.%E4%B8%80%E8%A1%8C%E4%BB%A3%E7%A0%81%E7%9A%84%E5%8F%98%E6%9B%B4%E8%AE%A9%E6%88%91%E9%99%B7%E5%85%A5%E6%97%A0%E5%B0%BD%E5%8A%A0%E7%8F%AD%EF%BC%8CDockerfile%E7%9A%84ENTRYPOINT%E7%9A%84%E4%B8%A4%E7%A7%8D%E6%A0%BC%E5%BC%8F.md)

[如何从Docker镜像中导出文件](https://www.pkslow.com/archives/extract-files-from-docker-image)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/05/20210516.%E5%A6%82%E4%BD%95%E4%BB%8EDocker%E9%95%9C%E5%83%8F%E4%B8%AD%E5%AF%BC%E5%87%BA%E6%96%87%E4%BB%B6.md)


<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## 其它

[用Docker安装一个MongoDB最新版玩玩](https://www.pkslow.com/archives/start-mongodb-with-docker)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/11/20191125.MongoDB.%E7%94%A8Docker%E5%AE%89%E8%A3%85%E4%B8%80%E4%B8%AAMongoDB%E6%9C%80%E6%96%B0%E7%89%88%E7%8E%A9%E7%8E%A9.md)

[Docker安装Redis并介绍漂亮的可视化客户端进行操作](https://www.pkslow.com/archives/docker-redis)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/04/20200421.Docker%E5%AE%89%E8%A3%85Redis%E5%B9%B6%E4%BB%8B%E7%BB%8D%E6%BC%82%E4%BA%AE%E7%9A%84%E5%8F%AF%E8%A7%86%E5%8C%96%E5%AE%A2%E6%88%B7%E7%AB%AF%E8%BF%9B%E8%A1%8C%E6%93%8D%E4%BD%9C.md)

[Docker搭建代码检测平台SonarQube并检测maven项目](https://www.pkslow.com/archives/docker-sonarqube)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/05/20200516.Docker%E6%90%AD%E5%BB%BA%E4%BB%A3%E7%A0%81%E6%A3%80%E6%B5%8B%E5%B9%B3%E5%8F%B0SonarQube%E5%B9%B6%E6%A3%80%E6%B5%8Bmaven%E9%A1%B9%E7%9B%AE.md)

[Maven一键部署Springboot到Docker仓库，为自动化做准备](https://www.pkslow.com/archives/docker-maven-plugin)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200707.Maven%E4%B8%80%E9%94%AE%E9%83%A8%E7%BD%B2Springboot%E5%88%B0Docker%E4%BB%93%E5%BA%93%EF%BC%8C%E4%B8%BA%E8%87%AA%E5%8A%A8%E5%8C%96%E5%81%9A%E5%87%86%E5%A4%87.md)

[Springboot整合MongoDB的Docker开发，其它应用也类似](https://www.pkslow.com/archives/docker-springboot-mongo)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200705.Springboot%E7%9A%84Docker%E5%BC%80%E5%8F%91%EF%BC%8C%E5%85%B6%E5%AE%83%E5%BA%94%E7%94%A8%E4%B9%9F%E7%B1%BB%E4%BC%BC.md)

[Docker可视化工具Portainer](https://www.pkslow.com/archives/docker-portainer)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200705.Docker%E5%8F%AF%E8%A7%86%E5%8C%96%E5%B7%A5%E5%85%B7Portainer.md)



[Docker启动PostgreSQL并推荐几款连接工具](https://www.pkslow.com/archives/docker-install-postgres)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/10/20201020.Docker%E5%90%AF%E5%8A%A8PostgreSQL%E5%B9%B6%E6%8E%A8%E8%8D%90%E5%87%A0%E6%AC%BE%E8%BF%9E%E6%8E%A5%E5%B7%A5%E5%85%B7.md)

[使用Harbor搭建Docker私有仓库](https://www.pkslow.com/archives/harbor-docker-registry)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/11/20201101.%E4%BD%BF%E7%94%A8Harbor%E6%90%AD%E5%BB%BADocker%E7%A7%81%E6%9C%89%E4%BB%93%E5%BA%93.md)

[Docker启动PostgreSQL时创建多个数据库](https://www.pkslow.com/archives/docker-postgresql-multiple-databases)
- Code: [/docker/postgresql-multiple-databases](https://github.com/LarryDpk/pkslow-samples/tree/master/docker/postgresql-multiple-databases)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/03/20210305.Docker%E5%90%AF%E5%8A%A8PostgreSQL%E6%97%B6%E5%88%9B%E5%BB%BA%E5%A4%9A%E4%B8%AA%E6%95%B0%E6%8D%AE%E5%BA%93.md)

[Docker安装Kong API Gateway并使用](https://www.pkslow.com/archives/kong-docker)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/08/20210804.Docker%E5%AE%89%E8%A3%85Kong%20API%20Gateway%E5%B9%B6%E4%BD%BF%E7%94%A8.md)


[通过Docker启动DB2，并在Spring Boot整合DB2](https://www.pkslow.com/archives/db2)
- Code: [/spring-boot/spring-data-jpa-db2](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/spring-data-jpa-db2)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/03/20220301.%E9%80%9A%E8%BF%87Docker%E5%90%AF%E5%8A%A8DB2%EF%BC%8C%E5%B9%B6%E5%9C%A8Spring%20Boot%E6%95%B4%E5%90%88DB2.md)

[通过Docker启动Solace，并在Spring Boot通过JMS整合Solace](https://www.pkslow.com/archives/solace)
- Code: [/spring-boot/springboot-jms-solace](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/springboot-jms-solace)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/03/20220308.%E9%80%9A%E8%BF%87Docker%E5%90%AF%E5%8A%A8Solace%EF%BC%8C%E5%B9%B6%E5%9C%A8Spring%20Boot%E9%80%9A%E8%BF%87JMS%E6%95%B4%E5%90%88Solace.md)


<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>


# Kubernetes


[用Helm部署Kubernetes应用，支持多环境部署与版本回滚](https://www.pkslow.com/archives/kubernetes-helm)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200709.%E7%94%A8Helm%E9%83%A8%E7%BD%B2Kubernetes%E5%BA%94%E7%94%A8%EF%BC%8C%E6%94%AF%E6%8C%81%E5%A4%9A%E7%8E%AF%E5%A2%83%E9%83%A8%E7%BD%B2%E4%B8%8E%E7%89%88%E6%9C%AC%E5%9B%9E%E6%BB%9A.md)

[用Kubernetes部署Springboot或Nginx，也就一个文件的事](https://www.pkslow.com/archives/kubernetes-springboot-nginx-demo)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200708.%E7%94%A8Kubernetes%E9%83%A8%E7%BD%B2Springboot%E6%88%96Nginx%EF%BC%8C%E4%B9%9F%E5%B0%B1%E4%B8%80%E4%B8%AA%E6%96%87%E4%BB%B6%E7%9A%84%E4%BA%8B.md)

[Kubectl设置默认命令空间namespace](https://www.pkslow.com/archives/kubernetes-default-namespace)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200719.Kubectl%E8%AE%BE%E7%BD%AE%E9%BB%98%E8%AE%A4%E5%91%BD%E4%BB%A4%E7%A9%BA%E9%97%B4namespace.md)

[把Spring Cloud Data Flow部署在Kubernetes上，再跑个任务试试](https://www.pkslow.com/archives/spring-cloud-data-flow-on-kubernetes)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200729.%E6%8A%8ASpring%20Cloud%20Data%20Flow%E9%83%A8%E7%BD%B2%E5%9C%A8Kubernetes%E4%B8%8A%EF%BC%8C%E5%86%8D%E8%B7%91%E4%B8%AA%E4%BB%BB%E5%8A%A1%E8%AF%95%E8%AF%95.md)

[把H2数据库从jar包部署到Kubernetes，并解决Ingress不支持TCP的问题](https://www.pkslow.com/archives/kubernetes-h2-database)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200809.%E6%8A%8AH2%E6%95%B0%E6%8D%AE%E5%BA%93%E4%BB%8Ejar%E5%8C%85%E9%83%A8%E7%BD%B2%E5%88%B0Kubernetes%EF%BC%8C%E5%B9%B6%E8%A7%A3%E5%86%B3Ingress%E4%B8%8D%E6%94%AF%E6%8C%81TCP%E7%9A%84%E9%97%AE%E9%A2%98.md)

[Kubernetes用Helm安装Ingress并踩一下使用的坑](https://www.pkslow.com/archives/kubernetes-ingress)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200808.Kubernetes%E7%94%A8Helm%E5%AE%89%E8%A3%85Ingress%E5%B9%B6%E8%B8%A9%E4%B8%80%E4%B8%8B%E4%BD%BF%E7%94%A8%E7%9A%84%E5%9D%91.md)

[Kubernetes备份所有集群中的资源为yaml文件](https://www.pkslow.com/archives/kubernetes-backup-all-yaml)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200809.Kubernetes%E5%A4%87%E4%BB%BD%E6%89%80%E6%9C%89%E9%9B%86%E7%BE%A4%E4%B8%AD%E7%9A%84%E8%B5%84%E6%BA%90%E4%B8%BAyaml%E6%96%87%E4%BB%B6.md)

[Spring Cloud Config整合Spring Cloud Kubernetes，在k8s上管理配置](https://www.pkslow.com/archives/spring-cloud-config-kubernetes)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200820.Spring%20Cloud%20Config%E6%95%B4%E5%90%88Spring%20Cloud%20Kubernetes%EF%BC%8C%E5%9C%A8k8s%E4%B8%8A%E7%AE%A1%E7%90%86%E9%85%8D%E7%BD%AE.md)

[如何把文件放进Docker或Kubernetes中，如何拷贝出来](https://www.pkslow.com/archives/docker-kubernetes-copy-files)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200815.%E5%A6%82%E4%BD%95%E6%8A%8A%E6%96%87%E4%BB%B6%E6%94%BE%E8%BF%9BDocker%E6%88%96Kubernetes%E4%B8%AD%EF%BC%8C%E5%A6%82%E4%BD%95%E6%8B%B7%E8%B4%9D%E5%87%BA%E6%9D%A5.md)

[这么高颜值的Kubernetes管理工具Lens，难道还不能C位出道吗](https://www.pkslow.com/archives/kubernetes-lens)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200823.%E8%BF%99%E4%B9%88%E9%AB%98%E9%A2%9C%E5%80%BC%E7%9A%84Kubernetes%E7%AE%A1%E7%90%86%E5%B7%A5%E5%85%B7Lens%EF%BC%8C%E9%9A%BE%E9%81%93%E8%BF%98%E4%B8%8D%E8%83%BDC%E4%BD%8D%E5%87%BA%E9%81%93%E5%90%97.md)

[Kubernetes的Jobs和CronJobs的使用](https://www.pkslow.com/archives/kubernetes-jobs-cronjobs)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200827.Kubernetes%E7%9A%84Jobs%E5%92%8CCronJobs%E7%9A%84%E4%BD%BF%E7%94%A8.md)

[Springboot整合Spring Cloud Kubernetes读取ConfigMap，支持自动刷新配置](https://www.pkslow.com/archives/spring-cloud-kubernetes-configmap)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200826.Springboot%E6%95%B4%E5%90%88Spring%20Cloud%20Kubernetes%E8%AF%BB%E5%8F%96ConfigMap%EF%BC%8C%E6%94%AF%E6%8C%81%E8%87%AA%E5%8A%A8%E5%88%B7%E6%96%B0%E9%85%8D%E7%BD%AE.md)

[被Spring坑了一把，查看源码终于解决了DataFlow部署K8s应用的问题](https://www.pkslow.com/archives/spring-cloud-dataflow-affinity)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200829.%E8%A2%ABSpring%E5%9D%91%E4%BA%86%E4%B8%80%E6%8A%8A%EF%BC%8C%E6%9F%A5%E7%9C%8B%E6%BA%90%E7%A0%81%E7%BB%88%E4%BA%8E%E8%A7%A3%E5%86%B3%E4%BA%86DataFlow%E9%83%A8%E7%BD%B2K8s%E5%BA%94%E7%94%A8%E7%9A%84%E9%97%AE%E9%A2%98.md)

[Docker和Kubernetes常用命令（持续整理）](https://www.pkslow.com/archives/docker-kubernetes-frequently-used-commands)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/10/20201015.Docker%E5%92%8CKubernetes%E5%B8%B8%E7%94%A8%E5%91%BD%E4%BB%A4%EF%BC%88%E6%8C%81%E7%BB%AD%E6%95%B4%E7%90%86%EF%BC%89.md)


[2020年11月CKA新题考试心得体会](https://www.pkslow.com/archives/cka-exam)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/12/20201214.2020%E5%B9%B411%E6%9C%88CKA%E6%96%B0%E9%A2%98%E8%80%83%E8%AF%95%E5%BF%83%E5%BE%97%E4%BD%93%E4%BC%9A.md)

[How to pass the CKA exam](https://www.pkslow.com/archives/how-to-pass-cka-exam)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/01/20210125.How%20to%20pass%20the%20CKA%20exam.md)

[Mac为docker和kubectl添加自动命令补全](https://www.pkslow.com/archives/docker-kubectl-bash-completion-for-mac)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/01/20210110.Mac%E4%B8%BAdocker%E5%92%8Ckubectl%E6%B7%BB%E5%8A%A0%E8%87%AA%E5%8A%A8%E5%91%BD%E4%BB%A4%E8%A1%A5%E5%85%A8.md)

[最好的Kubernetes客户端Java库fabric8io，快来自定义你的操作](https://www.pkslow.com/archives/kubernetes-client-fabric8io)
- Code: [/kubernetes/kubernetes-client-fabric8io](https://github.com/LarryDpk/pkslow-samples/tree/master/kubernetes/kubernetes-client-fabric8io)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/01/20210107.%E6%9C%80%E5%A5%BD%E7%9A%84Kubernetes%E5%AE%A2%E6%88%B7%E7%AB%AFJava%E5%BA%93fabric8io%EF%BC%8C%E5%BF%AB%E6%9D%A5%E8%87%AA%E5%AE%9A%E4%B9%89%E4%BD%A0%E7%9A%84%E6%93%8D%E4%BD%9C.md)

[CORS跨源资源共享概念及配置（Kubernetes Ingress和Spring Cloud Gateway）](https://www.pkslow.com/archives/http-cors)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/02/20210228.CORS%E8%B7%A8%E6%BA%90%E8%B5%84%E6%BA%90%E5%85%B1%E4%BA%AB%E6%A6%82%E5%BF%B5%E5%8F%8A%E9%85%8D%E7%BD%AE%EF%BC%88Kubernetes%20Ingress%E5%92%8CSpring%20Cloud%20Gateway%EF%BC%89.md)

[Kubernetes ConfigMap详解，多种方式创建、多种方式使用](https://www.pkslow.com/archives/kubernetes-configmap)
- Code: [/kubernetes/configmap-springboot](https://github.com/LarryDpk/pkslow-samples/tree/master/kubernetes/configmap-springboot)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/02/20210222.Kubernetes%20ConfigMap%E8%AF%A6%E8%A7%A3%EF%BC%8C%E5%A4%9A%E7%A7%8D%E6%96%B9%E5%BC%8F%E5%88%9B%E5%BB%BA%E3%80%81%E5%A4%9A%E7%A7%8D%E6%96%B9%E5%BC%8F%E4%BD%BF%E7%94%A8.md)

[解决Kubernetes以root用户mount volumn导致无写权限的问题](https://www.pkslow.com/archives/kubernetes-mount-volumn-as-none-root)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/05/20210501.%E8%A7%A3%E5%86%B3Kubernetes%E4%BB%A5root%E7%94%A8%E6%88%B7mount%20volumn%E5%AF%BC%E8%87%B4%E6%97%A0%E5%86%99%E6%9D%83%E9%99%90%E7%9A%84%E9%97%AE%E9%A2%98.md)

[Kubernetes Pod中容器的Liveness、Readiness和Startup探针](https://www.pkslow.com/archives/kubernetes-liveness-readiness-startup-probes)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/04/20210409.Kubernetes%20Pod%E4%B8%AD%E5%AE%B9%E5%99%A8%E7%9A%84Liveness%E3%80%81Readiness%E5%92%8CStartup%E6%8E%A2%E9%92%88.md)

[Kubernetes使用Keda进行弹性伸缩，更合理利用资源](https://www.pkslow.com/archives/keda)
- Code: [/kubernetes/keda](https://github.com/LarryDpk/pkslow-samples/tree/master/kubernetes/keda)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/05/20210506.Kubernetes%E4%BD%BF%E7%94%A8Keda%E8%BF%9B%E8%A1%8C%E5%BC%B9%E6%80%A7%E4%BC%B8%E7%BC%A9%EF%BC%8C%E6%9B%B4%E5%90%88%E7%90%86%E5%88%A9%E7%94%A8%E8%B5%84%E6%BA%90.md)

[Helm Template初体验，方便管理多环境](https://www.pkslow.com/archives/helm-template)
- Code: [/cloud/helm](https://github.com/LarryDpk/pkslow-samples/tree/master/cloud/helm)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/07/20210718.Helm%20Template%E5%88%9D%E4%BD%93%E9%AA%8C%EF%BC%8C%E6%96%B9%E4%BE%BF%E7%AE%A1%E7%90%86%E5%A4%9A%E7%8E%AF%E5%A2%83.md)



<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## 安装指导
[Mac上使用Docker Desktop启动Kubernetes，踩坑后终于搞掂](https://www.pkslow.com/archives/mac-kubernetes-docker-desktop)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200702.Mac%E4%B8%8A%E4%BD%BF%E7%94%A8Docker%20Desktop%E5%90%AF%E5%8A%A8Kubernetes%EF%BC%8C%E8%B8%A9%E5%9D%91%E5%90%8E%E7%BB%88%E4%BA%8E%E6%90%9E%E6%8E%82.md)

[在Ubuntu用Minikube安装Kubernetes](https://www.pkslow.com/archives/minikube-ubuntu)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/10/20211002.%E5%9C%A8Ubuntu%E7%94%A8Minikube%E5%AE%89%E8%A3%85Kubernetes.md)

[在CentOS 8用Minikube安装Kubernetes](https://www.pkslow.com/archives/minikube-centos)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/10/20211027.%E5%9C%A8CentOS%208%E7%94%A8Minikube%E5%AE%89%E8%A3%85Kubernetes.md)

[详细记录用kubeadm在Ubuntu上安装Kubernetes集群](https://www.pkslow.com/archives/install-kubernetes-on-ubuntu-with-kubeadm)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/10/20201018.%E8%AF%A6%E7%BB%86%E8%AE%B0%E5%BD%95%E7%94%A8kubeadm%E5%9C%A8Ubuntu%E4%B8%8A%E5%AE%89%E8%A3%85Kubernetes%E9%9B%86%E7%BE%A4.md)


<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>


# Cloud

[在Ubuntu上安装OpenShift并使用](https://www.pkslow.com/archives/openshift)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/03/20220301.%E5%9C%A8Ubuntu%E4%B8%8A%E5%AE%89%E8%A3%85OpenShift%E5%B9%B6%E4%BD%BF%E7%94%A8.md)

[K8ssandra入门-详细记录在Linux上部署K8ssandra到Kubernetes](https://www.pkslow.com/archives/k8ssandra)
- Code: [/cloud/k8ssandra](https://github.com/LarryDpk/pkslow-samples/tree/master/cloud/k8ssandra)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/10/20211001.K8ssandra%E5%85%A5%E9%97%A8-%E8%AF%A6%E7%BB%86%E8%AE%B0%E5%BD%95%E5%9C%A8Linux%E4%B8%8A%E9%83%A8%E7%BD%B2K8ssandra%E5%88%B0Kubernetes.md)

[使用Stargate访问K8ssandra，Springboot整合Cassandra](https://www.pkslow.com/archives/k8ssandra-stargatre)
- Code: [/spring-boot/spring-data-cassandra](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-boot/spring-data-cassandra)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/10/20211002.%E4%BD%BF%E7%94%A8Stargate%E8%AE%BF%E9%97%AEK8ssandra%EF%BC%8CSpringboot%E6%95%B4%E5%90%88Cassandra.md)


<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## dapr 
[dapr本地托管的服务调用体验与Java SDK的Spring Boot整合](https://www.pkslow.com/archives/dapr-java-sdk-springboot)
- Code: [/cloud/dapr/dapr-springboot](https://github.com/LarryDpk/pkslow-samples/tree/master/cloud/dapr/dapr-springboot)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/11/20221106.dapr%E6%9C%AC%E5%9C%B0%E6%89%98%E7%AE%A1%E7%9A%84%E6%9C%8D%E5%8A%A1%E8%B0%83%E7%94%A8%E4%BD%93%E9%AA%8C%E4%B8%8EJava%20SDK%E7%9A%84Spring%20Boot%E6%95%B4%E5%90%88.md)

[dapr入门与本地托管模式尝试](https://www.pkslow.com/archives/dapr-quickstart)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/11/20221105.dapr%E5%85%A5%E9%97%A8%E4%B8%8E%E6%9C%AC%E5%9C%B0%E6%89%98%E7%AE%A1%E6%A8%A1%E5%BC%8F%E5%B0%9D%E8%AF%95.md)


<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## Istio
[在Mac上安装Istio并使用，有丰富的监控Kiali、Grafana、Jaeger](https://www.pkslow.com/archives/istio-mac)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/08/20210810.%E5%9C%A8Mac%E4%B8%8A%E5%AE%89%E8%A3%85Istio%E5%B9%B6%E4%BD%BF%E7%94%A8%EF%BC%8C%E6%9C%89%E4%B8%B0%E5%AF%8C%E7%9A%84%E7%9B%91%E6%8E%A7Kiali%E3%80%81Grafana%E3%80%81Jaeger.md)

[服务网格Istio入门-详细记录Kubernetes安装Istio并使用](https://www.pkslow.com/archives/istio)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/08/20210809.%E6%9C%8D%E5%8A%A1%E7%BD%91%E6%A0%BCIstio%E5%85%A5%E9%97%A8-%E8%AF%A6%E7%BB%86%E8%AE%B0%E5%BD%95Kubernetes%E5%AE%89%E8%A3%85Istio%E5%B9%B6%E4%BD%BF%E7%94%A8.md)



<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## Google Cloud Platform
[Mac安装Google Cloud SDK](https://www.pkslow.com/archives/mac-install-gcp-sdk)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/05/20210510.Mac%E5%AE%89%E8%A3%85Google%20Cloud%20SDK.md)

[GCP常用命令（gcloud、gsutil）](https://www.pkslow.com/archives/gcp-commands)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/05/20210507.GCP%E5%B8%B8%E7%94%A8%E5%91%BD%E4%BB%A4%EF%BC%88gcloud%E3%80%81gsutil%EF%BC%89.md)

[如何在GCE访问GKE中的TCP服务](https://www.pkslow.com/archives/gce-access-tcp-in-gke)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/05/20210503.%E5%A6%82%E4%BD%95%E5%9C%A8GCE%E8%AE%BF%E9%97%AEGKE%E4%B8%AD%E7%9A%84TCP%E6%9C%8D%E5%8A%A1.md)

[整合Spring Cloud Stream Binder与GCP Pubsub进行消息发送与接收](https://www.pkslow.com/archives/spring-cloud-stream-binder-pubsub)
- Code: [/spring-cloud/spring-cloud-stream/spring-cloud-stream-binder-pubsub](https://github.com/LarryDpk/pkslow-samples/tree/master/spring-cloud/spring-cloud-stream/spring-cloud-stream-binder-pubsub)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/05/20210511.%E6%95%B4%E5%90%88Spring%20Cloud%20Stream%20Binder%E4%B8%8EGCP%20Pubsub%E8%BF%9B%E8%A1%8C%E6%B6%88%E6%81%AF%E5%8F%91%E9%80%81%E4%B8%8E%E6%8E%A5%E6%94%B6.md)

[GCP Pubsub Introduction - so easy to use](https://www.pkslow.com/archives/gcp-pubsub-en)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/06/20210620.GCP%20Pubsub%20Introduction%20-%20so%20easy%20to%20use.md)

[GCP消息队列Pubsub详解，简单好用还不用自己运维](https://www.pkslow.com/archives/gcp-pubsub)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/06/20210620.GCP%E6%B6%88%E6%81%AF%E9%98%9F%E5%88%97Pubsub%E8%AF%A6%E8%A7%A3%EF%BC%8C%E7%AE%80%E5%8D%95%E5%A5%BD%E7%94%A8%E8%BF%98%E4%B8%8D%E7%94%A8%E8%87%AA%E5%B7%B1%E8%BF%90%E7%BB%B4.md)

[在GCP上创建Cloud SQL的三种方式(Console,gcloud,Terraform)](https://www.pkslow.com/archives/create-gcp-cloudsql)
- Code: [/cloud/terraform/src/main/terraform/gcp/cloudsql](https://github.com/LarryDpk/pkslow-samples/tree/master/cloud/terraform/src/main/terraform/gcp/cloudsql)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/11/20211123.%E5%9C%A8GCP%E4%B8%8A%E5%88%9B%E5%BB%BACloud%20SQL%E7%9A%84%E4%B8%89%E7%A7%8D%E6%96%B9%E5%BC%8F(Console%2Cgcloud%2CTerraform).md)

[Three ways to create Cloud SQL on GCP(Console,gcloud,Terraform)](https://www.pkslow.com/archives/create-gcp-cloudsql-en)
- Code: [/cloud/terraform/src/main/terraform/gcp/cloudsql](https://github.com/LarryDpk/pkslow-samples/tree/master/cloud/terraform/src/main/terraform/gcp/cloudsql)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/11/20211123.Three%20ways%20to%20create%20Cloud%20SQL%20on%20GCP(Console%2Cgcloud%2CTerraform).md)

[在GCP上创建GCE的三种方式(Console,gcloud,Terraform)](https://www.pkslow.com/archives/create-gcp-gce)
- Code: [/cloud/terraform/src/main/terraform/gcp/gce](https://github.com/LarryDpk/pkslow-samples/tree/master/cloud/terraform/src/main/terraform/gcp/gce)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/11/20211115.%E5%9C%A8GCP%E4%B8%8A%E5%88%9B%E5%BB%BAGCE%E7%9A%84%E4%B8%89%E7%A7%8D%E6%96%B9%E5%BC%8F(Console%2Cgcloud%2CTerraform).md)

[Three ways to create GCE on GCP(Console,gcloud,Terraform)](https://www.pkslow.com/archives/create-gcp-gce-en)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/11/20211115.Three%20ways%20to%20create%20GCE%20on%20GCP(Console%2Cgcloud%2CTerraform).md)

[通过gcloud创建Google Kubernetes Engine(GKE)并通过kubectl访问](https://www.pkslow.com/archives/create-gke-with-gcloud)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/11/20211114.%E9%80%9A%E8%BF%87gcloud%E5%88%9B%E5%BB%BAGoogle%20Kubernetes%20Engine(GKE)%E5%B9%B6%E9%80%9A%E8%BF%87kubectl%E8%AE%BF%E9%97%AE.md)

[Provision the Google Kubernetes Engine(GKE) with gcloud and access with kubectl](https://www.pkslow.com/archives/create-gke-with-gcloud-en)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/11/20211114.Provision%20the%20Google%20Kubernetes%20Engine(GKE)%20with%20gcloud%20and%20access%20with%20kubectl.md)

[通过Google Cloud Storage(GCS)管理Terraform的状态State](https://www.pkslow.com/archives/terraform-gcs)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/11/20211114.%E9%80%9A%E8%BF%87Google%20Cloud%20Storage(GCS)%E7%AE%A1%E7%90%86Terraform%E7%9A%84%E7%8A%B6%E6%80%81State.md)

[Manage Terraform State on Google Cloud Storage(GCS)](https://www.pkslow.com/archives/terraform-gcs-en)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/11/20211114.Manage%20Terraform%20State%20on%20Google%20Cloud%20Storage(GCS).md)

[通过Terraform创建GCP Pubsub](https://www.pkslow.com/archives/terraform-gcp-pubsub)
- Code: [/cloud/terraform/src/main/terraform/gcp/pubsub](https://github.com/LarryDpk/pkslow-samples/tree/master/cloud/terraform/src/main/terraform/gcp/pubsub)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/11/20211113.%E9%80%9A%E8%BF%87Terraform%E5%88%9B%E5%BB%BAGCP%20Pubsub.md)

[Manage GCP Pubsub with Terraform](https://www.pkslow.com/archives/terraform-gcp-pubsub-en)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/11/20211113.Manage%20GCP%20Pubsub%20with%20Terraform.md)

[初始化一个GCP项目并用gcloud访问操作](https://www.pkslow.com/archives/init-gcp-sdk)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/11/20211113.%E5%88%9D%E5%A7%8B%E5%8C%96%E4%B8%80%E4%B8%AAGCP%E9%A1%B9%E7%9B%AE%E5%B9%B6%E7%94%A8gcloud%E8%AE%BF%E9%97%AE%E6%93%8D%E4%BD%9C.md)

[How to initiate the GCP project and use gcloud to access](https://www.pkslow.com/archives/init-gcp-sdk-en)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/11/20211113.How%20to%20initiate%20the%20GCP%20project%20and%20use%20gcloud%20to%20access.md)

[在GCP的Kubernetes上安装dapr](https://www.pkslow.com/archives/dapr-kubernetes-mode)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/11/20221109.%E5%9C%A8GCP%E7%9A%84Kubernetes%E4%B8%8A%E5%AE%89%E8%A3%85dapr.md)

[让Apache Beam在GCP Cloud Dataflow上跑起来](https://www.pkslow.com/archives/apache-beam-dataflow)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/11/20221103.%E8%AE%A9Apache%20Beam%E5%9C%A8GCP%20Cloud%20Dataflow%E4%B8%8A%E8%B7%91%E8%B5%B7%E6%9D%A5.md)




<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## 《Terraform 101 从入门到实践》
这部分内容在GitHub [terraform-101](https://github.com/LarryDpk/terraform-101)：

[《Terraform 101 从入门到实践》 前言](https://www.pkslow.com/archives/terraform-101-preface)

[《Terraform 101 从入门到实践》 第一章 Terraform初相识](https://www.pkslow.com/archives/terraform-101-introduction)

[《Terraform 101 从入门到实践》 第二章 Providers插件管理](https://www.pkslow.com/archives/terraform-101-providers)

[《Terraform 101 从入门到实践》 第三章 Modules模块化](https://www.pkslow.com/archives/terraform-101-modules)

[《Terraform 101 从入门到实践》 第四章 States状态管理](https://www.pkslow.com/archives/terraform-101-states)

[《Terraform 101 从入门到实践》 第五章 HCL语法](https://www.pkslow.com/archives/terraform-101-hcl)

[《Terraform 101 从入门到实践》 Terraform常用命令](https://www.pkslow.com/archives/terraform-101-commands)

[《Terraform 101 从入门到实践》 Functions函数](https://www.pkslow.com/archives/terraform-101-functions)


<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## Terraform

[Terraform Module - extract and reuse](https://www.pkslow.com/archives/terraform-module-en)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/06/20210606.Terraform%20Module%20-%20extract%20and%20reuse.md)

[Terraform常用命令](https://www.pkslow.com/archives/terraform-commands)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/06/20210606.Terraform%E5%B8%B8%E7%94%A8%E5%91%BD%E4%BB%A4.md)

[Terraform模块Module管理，聚合资源的抽取与复用](https://www.pkslow.com/archives/terraform-module)
- Code: [/cloud/terraform/src/main/terraform/module-example](https://github.com/LarryDpk/pkslow-samples/tree/master/cloud/terraform/src/main/terraform/module-example)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/06/20210606.Terraform%E6%A8%A1%E5%9D%97Module%E7%AE%A1%E7%90%86%EF%BC%8C%E8%81%9A%E5%90%88%E8%B5%84%E6%BA%90%E7%9A%84%E6%8A%BD%E5%8F%96%E4%B8%8E%E5%A4%8D%E7%94%A8.md)

[Terraform状态State管理，让变更有记录](https://www.pkslow.com/archives/terraform-state)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/06/20210605.Terraform%E7%8A%B6%E6%80%81State%E7%AE%A1%E7%90%86%EF%BC%8C%E8%AE%A9%E5%8F%98%E6%9B%B4%E6%9C%89%E8%AE%B0%E5%BD%95.md)

[Terraform插件Provider管理，搜索、定义、下载](https://www.pkslow.com/archives/terraform-provider)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/06/20210605.Terraform%E6%8F%92%E4%BB%B6Provider%E7%AE%A1%E7%90%86%EF%BC%8C%E6%90%9C%E7%B4%A2%E3%80%81%E5%AE%9A%E4%B9%89%E3%80%81%E4%B8%8B%E8%BD%BD.md)

[Terraform入门教程，示例展示管理Docker和Kubernetes资源](https://www.pkslow.com/archives/terraform)
- Code: [/cloud/terraform/src/main/terraform/docker](https://github.com/LarryDpk/pkslow-samples/tree/master/cloud/terraform/src/main/terraform/docker)
- Code: [/cloud/terraform/src/main/terraform/kubernetes](https://github.com/LarryDpk/pkslow-samples/tree/master/cloud/terraform/src/main/terraform/kubernetes)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/05/20210529.Terraform%E5%85%A5%E9%97%A8%E6%95%99%E7%A8%8B%EF%BC%8C%E7%A4%BA%E4%BE%8B%E5%B1%95%E7%A4%BA%E7%AE%A1%E7%90%86Docker%E5%92%8CKubernetes%E8%B5%84%E6%BA%90.md)

[How to Pass the Terraform Associate Certificate Exam](https://www.pkslow.com/archives/terraform-associate-en)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/12/20211218.How%20to%20Pass%20the%20Terraform%20Associate%20Certificate%20Exam.md)

[如何通过Terraform Associate考试并获得证书](https://www.pkslow.com/archives/terraform-associate)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/12/20211218.%E5%A6%82%E4%BD%95%E9%80%9A%E8%BF%87Terraform%20Associate%E8%80%83%E8%AF%95%E5%B9%B6%E8%8E%B7%E5%BE%97%E8%AF%81%E4%B9%A6.md)


<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>


# Java基础

[使用正则统计英文文章中的高频词汇](https://www.pkslow.com/archives/java-wordcount)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/10/20191009.%E4%BD%BF%E7%94%A8%E6%AD%A3%E5%88%99%E7%BB%9F%E8%AE%A1%E8%8B%B1%E6%96%87%E6%96%87%E7%AB%A0%E4%B8%AD%E7%9A%84%E9%AB%98%E9%A2%91%E8%AF%8D%E6%B1%87.md)

[统计String单词数的三种方法](https://www.pkslow.com/archives/java-oneline-string-wordcount)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/10/20191008.%E7%BB%9F%E8%AE%A1String%E5%8D%95%E8%AF%8D%E6%95%B0%E7%9A%84%E4%B8%89%E7%A7%8D%E6%96%B9%E6%B3%95.md)

[Java 8之条件断言Predicate的使用](https://www.pkslow.com/archives/java8-predicate)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/10/20191005.Java%208%E4%B9%8B%E6%9D%A1%E4%BB%B6%E6%96%AD%E8%A8%80Predicate%E7%9A%84%E4%BD%BF%E7%94%A8.md)

[Java双大括号{}的初始化](https://www.pkslow.com/archives/java-double-brace-initialization)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/09/20190927.Java%E5%8F%8C%E5%A4%A7%E6%8B%AC%E5%8F%B7%7B%7D%E7%9A%84%E5%88%9D%E5%A7%8B%E5%8C%96.md)

[String.intern()原来还能这么用（原理与应用）](https://www.pkslow.com/archives/string-intern)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/11/20191110.Java%E5%BF%85%E4%BF%AE%E8%AF%BE.String.intern()%E5%8E%9F%E6%9D%A5%E8%BF%98%E8%83%BD%E8%BF%99%E4%B9%88%E7%94%A8%EF%BC%88%E5%8E%9F%E7%90%86%E4%B8%8E%E5%BA%94%E7%94%A8%EF%BC%89.md)


[如何使用优秀的加密库Jasypt来保护你的敏感信息？](https://www.pkslow.com/archives/introduction-to-jasypt)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/12/20191211.Java%E5%BA%93.%E5%A6%82%E4%BD%95%E4%BD%BF%E7%94%A8%E4%BC%98%E7%A7%80%E7%9A%84%E5%8A%A0%E5%AF%86%E5%BA%93Jasypt%E6%9D%A5%E4%BF%9D%E6%8A%A4%E4%BD%A0%E7%9A%84%E6%95%8F%E6%84%9F%E4%BF%A1%E6%81%AF%EF%BC%9F.md)

[使用Thumbnailator生成缩略图（缩放、旋转、裁剪、水印）](https://www.pkslow.com/archives/java-thumbnailator)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/12/20191201.Java%E5%AE%9E%E4%BE%8B.%E4%BD%BF%E7%94%A8Thumbnailator%E7%94%9F%E6%88%90%E7%BC%A9%E7%95%A5%E5%9B%BE%EF%BC%88%E7%BC%A9%E6%94%BE%E3%80%81%E6%97%8B%E8%BD%AC%E3%80%81%E8%A3%81%E5%89%AA%E3%80%81%E6%B0%B4%E5%8D%B0%EF%BC%89.md)

[判断String是否包含子串的四种方法及性能对比](https://www.pkslow.com/archives/string-contains-performance)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/03/20200310.Java%E5%BF%85%E4%BF%AE%E8%AF%BE.%E5%88%A4%E6%96%ADString%E6%98%AF%E5%90%A6%E5%8C%85%E5%90%AB%E5%AD%90%E4%B8%B2%E7%9A%84%E5%9B%9B%E7%A7%8D%E6%96%B9%E6%B3%95%E5%8F%8A%E6%80%A7%E8%83%BD%E5%AF%B9%E6%AF%94.md)

[Mockito如何mock一条链式调用](https://www.pkslow.com/archives/mockito-chained-methods)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/05/20200510.Mockito%E5%A6%82%E4%BD%95mock%E4%B8%80%E6%9D%A1%E9%93%BE%E5%BC%8F%E8%B0%83%E7%94%A8.md)

[Mockito不能mock final类的解决办法](https://www.pkslow.com/archives/cannot-mock-final-class)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/05/20200510.Mockito%E4%B8%8D%E8%83%BDmock%20final%E7%B1%BB%E7%9A%84%E8%A7%A3%E5%86%B3%E5%8A%9E%E6%B3%95.md)

[Java怎么从这四个位置读取配置文件Properties（普通文件系统-classpath-jar-URL）](https://www.pkslow.com/archives/java-load-properties)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/05/20200509.Java%E6%80%8E%E4%B9%88%E4%BB%8E%E8%BF%99%E5%9B%9B%E4%B8%AA%E4%BD%8D%E7%BD%AE%E8%AF%BB%E5%8F%96%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6Properties%EF%BC%88%E6%99%AE%E9%80%9A%E6%96%87%E4%BB%B6%E7%B3%BB%E7%BB%9F-classpath-jar-URL%EF%BC%89.md)

[Java创建对象的六种方法-权当记录一下](https://www.pkslow.com/archives/6-ways-to-create-object)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/05/20200509.Java%E5%88%9B%E5%BB%BA%E5%AF%B9%E8%B1%A1%E7%9A%84%E5%85%AD%E7%A7%8D%E6%96%B9%E6%B3%95-%E6%9D%83%E5%BD%93%E8%AE%B0%E5%BD%95%E4%B8%80%E4%B8%8B.md)

[Maven整合JaCoCo和Sonar，看看你的测试写够了没](https://www.pkslow.com/archives/maven-jacoco-sonar)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/05/20200516.Maven%E6%95%B4%E5%90%88JaCoCo%E5%92%8CSonar%EF%BC%8C%E7%9C%8B%E7%9C%8B%E4%BD%A0%E7%9A%84%E6%B5%8B%E8%AF%95%E5%86%99%E5%A4%9F%E4%BA%86%E6%B2%A1.md)

[让人又爱又恨的Lombok，到底该不该用](https://www.pkslow.com/archives/lombok-or-not)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/06/20200616.%E8%AE%A9%E4%BA%BA%E5%8F%88%E7%88%B1%E5%8F%88%E6%81%A8%E7%9A%84Lombok%EF%BC%8C%E5%88%B0%E5%BA%95%E8%AF%A5%E4%B8%8D%E8%AF%A5%E7%94%A8.md)

[Java从BufferedReader一行一行读取数据](https://www.pkslow.com/archives/java-read-bufferedreader)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200816.Java%E4%BB%8EBufferedReader%E4%B8%80%E8%A1%8C%E4%B8%80%E8%A1%8C%E8%AF%BB%E5%8F%96%E6%95%B0%E6%8D%AE.md)

[Java从网上下载文件的几种方式](https://www.pkslow.com/archives/java-sava-a-file-from-internet)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200815.Java%E4%BB%8E%E7%BD%91%E4%B8%8A%E4%B8%8B%E8%BD%BD%E6%96%87%E4%BB%B6%E7%9A%84%E5%87%A0%E7%A7%8D%E6%96%B9%E5%BC%8F.md)

[通过Java上传下载AWS S3文件，并解决文件数量超过1000的问题](https://www.pkslow.com/archives/java-aws-s3)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200821.%E9%80%9A%E8%BF%87Java%E4%B8%8A%E4%BC%A0%E4%B8%8B%E8%BD%BDAWS%20S3%E6%96%87%E4%BB%B6%EF%BC%8C%E5%B9%B6%E8%A7%A3%E5%86%B3%E6%96%87%E4%BB%B6%E6%95%B0%E9%87%8F%E8%B6%85%E8%BF%871000%E7%9A%84%E9%97%AE%E9%A2%98.md)

[Java处理csv文件](https://www.pkslow.com/archives/java-csv-files)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200821.Java%E5%A4%84%E7%90%86csv%E6%96%87%E4%BB%B6.md)

[Java通过SFTP处理文件三种方法，支持密钥文件登陆](https://www.pkslow.com/archives/java-sftp)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200822.Java%E9%80%9A%E8%BF%87SFTP%E5%A4%84%E7%90%86%E6%96%87%E4%BB%B6%E4%B8%89%E7%A7%8D%E6%96%B9%E6%B3%95%EF%BC%8C%E6%94%AF%E6%8C%81%E5%AF%86%E9%92%A5%E6%96%87%E4%BB%B6%E7%99%BB%E9%99%86.md)

[Java连接Zookeeper](https://www.pkslow.com/archives/java-zookeeper)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200831.Java%E8%BF%9E%E6%8E%A5Zookeeper.md)

[如何安装Zookeeper的单机模式及集群模式](https://www.pkslow.com/archives/zookeeper-installation)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200830.%E5%A6%82%E4%BD%95%E5%AE%89%E8%A3%85Zookeeper%E7%9A%84%E5%8D%95%E6%9C%BA%E6%A8%A1%E5%BC%8F%E5%8F%8A%E9%9B%86%E7%BE%A4%E6%A8%A1%E5%BC%8F.md)

[IntelliJ IDEA远程Debug Linux的Java程序，找问题不要只会看日志了](https://www.pkslow.com/archives/idea-remote-debug)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200829.IntelliJ%20IDEA%E8%BF%9C%E7%A8%8BDebug%20Linux%E7%9A%84Java%E7%A8%8B%E5%BA%8F%EF%BC%8C%E6%89%BE%E9%97%AE%E9%A2%98%E4%B8%8D%E8%A6%81%E5%8F%AA%E4%BC%9A%E7%9C%8B%E6%97%A5%E5%BF%97%E4%BA%86.md)

[Protobuf入门与使用示例，高性能的序列化框架](https://www.pkslow.com/archives/protobuf-introduction)
- Code: [/java-basic/protobuf](https://github.com/LarryDpk/pkslow-samples/tree/master/java-basic/protobuf)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/10/20201001.Protobuf%E5%85%A5%E9%97%A8%E4%B8%8E%E4%BD%BF%E7%94%A8%E7%A4%BA%E4%BE%8B%EF%BC%8C%E9%AB%98%E6%80%A7%E8%83%BD%E7%9A%84%E5%BA%8F%E5%88%97%E5%8C%96%E6%A1%86%E6%9E%B6.md)

[远程过程调用框架gRPC入门及Java示例代码](https://www.pkslow.com/archives/grpc-introduction)
- Code: [/java-basic/grpc](https://github.com/LarryDpk/pkslow-samples/tree/master/java-basic/grpc)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/10/20201003.%E8%BF%9C%E7%A8%8B%E8%BF%87%E7%A8%8B%E8%B0%83%E7%94%A8%E6%A1%86%E6%9E%B6gRPC%E5%85%A5%E9%97%A8%E5%8F%8AJava%E7%A4%BA%E4%BE%8B%E4%BB%A3%E7%A0%81.md)

[通过Maven用LiquiBase对数据库变更进行版本控制](https://www.pkslow.com/archives/liquibase)
- Code: [/java-basic/liquibase](https://github.com/LarryDpk/pkslow-samples/tree/master/java-basic/liquibase)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/10/20201023.%E9%80%9A%E8%BF%87Maven%E7%94%A8LiquiBase%E5%AF%B9%E6%95%B0%E6%8D%AE%E5%BA%93%E5%8F%98%E6%9B%B4%E8%BF%9B%E8%A1%8C%E7%89%88%E6%9C%AC%E6%8E%A7%E5%88%B6.md)

[用pl.pojo.tester测试Pojo类，提高测试覆盖率](https://www.pkslow.com/archives/pl-pojo-tester)
- Code: [/java-basic/pl-pojo-tester](https://github.com/LarryDpk/pkslow-samples/tree/master/java-basic/pl-pojo-tester)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/03/20210330.%E7%94%A8pl.pojo.tester%E6%B5%8B%E8%AF%95Pojo%E7%B1%BB%EF%BC%8C%E6%8F%90%E9%AB%98%E6%B5%8B%E8%AF%95%E8%A6%86%E7%9B%96%E7%8E%87.md)

[Java如何设置代理来访问受限资源](https://www.pkslow.com/archives/java-proxy)
- Code: [/java-basic/java-proxy](https://github.com/LarryDpk/pkslow-samples/tree/master/java-basic/java-proxy)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/05/20210514.Java%E5%A6%82%E4%BD%95%E8%AE%BE%E7%BD%AE%E4%BB%A3%E7%90%86%E6%9D%A5%E8%AE%BF%E9%97%AE%E5%8F%97%E9%99%90%E8%B5%84%E6%BA%90.md)


[Apache Beam入门及Java SDK开发初体验](https://www.pkslow.com/archives/apache-beam)
- Code: [/bigdata/apache-beam/direct-runner](https://github.com/LarryDpk/pkslow-samples/tree/master/bigdata/apache-beam/direct-runner)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/10/20211017.Apache%20Beam%E5%85%A5%E9%97%A8%E5%8F%8AJava%20SDK%E5%BC%80%E5%8F%91%E5%88%9D%E4%BD%93%E9%AA%8C.md)

[Java如何测量方法执行时间](https://www.pkslow.com/archives/java-elapsed-time)
- Code: [/java-basic/java-elapsed-time](https://github.com/LarryDpk/pkslow-samples/tree/master/java-basic/java-elapsed-time)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/12/20221220.Java%E5%A6%82%E4%BD%95%E6%B5%8B%E9%87%8F%E6%96%B9%E6%B3%95%E6%89%A7%E8%A1%8C%E6%97%B6%E9%97%B4.md)

[Java JDK Proxy和CGLib动态代理示例讲解](https://www.pkslow.com/archives/jdk-cglib-proxy)
- Code: [/java-basic/jdk-cglib-proxy](https://github.com/LarryDpk/pkslow-samples/tree/master/java-basic/jdk-cglib-proxy)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2023/01/20230104.Java%20JDK%20Proxy%E5%92%8CCGLib%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86%E7%A4%BA%E4%BE%8B%E8%AE%B2%E8%A7%A3.md)

[Mac Linux Windows等系统安装各版本JDK环境](https://www.pkslow.com/archives/install-jdk)
- [GitHub]()


<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## 集合类
[如何创建和初始化一个HashMap？](https://www.pkslow.com/archives/java-initialize-hashmap)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/09/20190929.%E5%A6%82%E4%BD%95%E5%88%9B%E5%BB%BA%E5%92%8C%E5%88%9D%E5%A7%8B%E5%8C%96%E4%B8%80%E4%B8%AAHashMap%EF%BC%9F.md)

[一图说尽排序，一文细说Sorting(Array、List、Stream的排序)](https://www.pkslow.com/archives/java-sorting)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/10/20191013.%E4%B8%80%E5%9B%BE%E8%AF%B4%E5%B0%BD%E6%8E%92%E5%BA%8F%EF%BC%8C%E4%B8%80%E6%96%87%E7%BB%86%E8%AF%B4Sorting(Array%E3%80%81List%E3%80%81Stream%E7%9A%84%E6%8E%92%E5%BA%8F).md)

[Java 8中map()与flatMap()在Optional和Stream中的区别](https://www.pkslow.com/archives/java-difference-map-and-flatmap)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/09/20190928.Java%208%E4%B8%ADmap()%E4%B8%8EflatMap()%E5%9C%A8Optional%E5%92%8CStream%E4%B8%AD%E7%9A%84%E5%8C%BA%E5%88%AB.md)

[Java 8之例说Stream的合并](https://www.pkslow.com/archives/java8-merge-stream)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/09/20190926.Java%208%E4%B9%8B%E4%BE%8B%E8%AF%B4Stream%E7%9A%84%E5%90%88%E5%B9%B6.md)

[Java 8基本类型的Stream](https://www.pkslow.com/archives/java8-primitive-streams)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/09/20190925.Java%208%E5%9F%BA%E6%9C%AC%E7%B1%BB%E5%9E%8B%E7%9A%84Stream.md)

[Java 8 Streams的简单介绍与入门](https://www.pkslow.com/archives/java8-stream-introduction)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/09/20190924.Java%208%20Streams%E7%9A%84%E7%AE%80%E5%8D%95%E4%BB%8B%E7%BB%8D%E4%B8%8E%E5%85%A5%E9%97%A8.md)

[HashMap性能很好？问过我EnumMap没](https://www.pkslow.com/archives/introduction-to-enummap)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/11/20191107.Java%E5%BF%85%E4%BF%AE%E8%AF%BE.HashMap%E6%80%A7%E8%83%BD%E5%BE%88%E5%A5%BD%EF%BC%9F%E9%97%AE%E8%BF%87%E6%88%91EnumMap%E6%B2%A1.md)

[通过Value获取Map中的键值Key的四种方法](https://www.pkslow.com/archives/map-fetch-key-by-value)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/11/20191103.Java%E5%BF%85%E4%BF%AE%E8%AF%BE.%E9%80%9A%E8%BF%87Value%E8%8E%B7%E5%8F%96Map%E4%B8%AD%E7%9A%84%E9%94%AE%E5%80%BCKey%E7%9A%84%E5%9B%9B%E7%A7%8D%E6%96%B9%E6%B3%95.md)

[四类方法删除List里面的所有null值](https://www.pkslow.com/archives/list-remove-null)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/10/20191031.Java%E5%BF%85%E4%BF%AE%E8%AF%BE.%E5%9B%9B%E7%B1%BB%E6%96%B9%E6%B3%95%E5%88%A0%E9%99%A4List%E9%87%8C%E9%9D%A2%E7%9A%84%E6%89%80%E6%9C%89null%E5%80%BC.md)

[各种集合类的合并(数组、List、Set、Map)](https://www.pkslow.com/archives/collections-merge)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/10/20191027.Java%E5%BF%85%E4%BF%AE%E8%AF%BE.%E5%90%84%E7%A7%8D%E9%9B%86%E5%90%88%E7%B1%BB%E7%9A%84%E5%90%88%E5%B9%B6(%E6%95%B0%E7%BB%84%E3%80%81List%E3%80%81Set%E3%80%81Map).md)

[ArrayList与HashSet的contains方法性能比较（JMH性能测试）](https://www.pkslow.com/archives/arraylist-hashset-contains-compare)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/10/20191023.Java%E5%BF%85%E4%BF%AE%E8%AF%BE.ArrayList%E4%B8%8EHashSet%E7%9A%84contains%E6%96%B9%E6%B3%95%E6%80%A7%E8%83%BD%E6%AF%94%E8%BE%83%EF%BC%88JMH%E6%80%A7%E8%83%BD%E6%B5%8B%E8%AF%95%EF%BC%89.md)

[好用的Arrays.asList也有这三个坑](https://www.pkslow.com/archives/arraylist-pitfall)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/10/20191020.Java%E5%BF%85%E4%BF%AE%E8%AF%BE.%E5%A5%BD%E7%94%A8%E7%9A%84Arrays.asList%E4%B9%9F%E6%9C%89%E8%BF%99%E4%B8%89%E4%B8%AA%E5%9D%91.md)

[图说Stream中的skip()和limit()方法及组合使用](https://www.pkslow.com/archives/stream-skip-limit)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/12/20191221.Java%E5%BF%85%E4%BF%AE%E8%AF%BE.%E5%9B%BE%E8%AF%B4Stream%E4%B8%AD%E7%9A%84skip()%E5%92%8Climit()%E6%96%B9%E6%B3%95%E5%8F%8A%E7%BB%84%E5%90%88%E4%BD%BF%E7%94%A8.md)


<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>


# 其它技术

[记一次上线前的紧急定位与修复-献上九条小经验](https://www.pkslow.com/archives/find-bugs-at-20191113)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/11/20191113.%E8%BF%90%E7%BB%B4.%E8%AE%B0%E4%B8%80%E6%AC%A1%E4%B8%8A%E7%BA%BF%E5%89%8D%E7%9A%84%E7%B4%A7%E6%80%A5%E5%AE%9A%E4%BD%8D%E4%B8%8E%E4%BF%AE%E5%A4%8D-%E7%8C%AE%E4%B8%8A%E4%B9%9D%E6%9D%A1%E5%B0%8F%E7%BB%8F%E9%AA%8C.md)

[HTTPS之密钥知识与密钥工具Keytool和Keystore-Explorer](https://www.pkslow.com/archives/sslkey-knowledge-keytools)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/04/20200427.HTTPS%E4%B9%8B%E5%AF%86%E9%92%A5%E7%9F%A5%E8%AF%86%E4%B8%8E%E5%AF%86%E9%92%A5%E5%B7%A5%E5%85%B7Keytool%E5%92%8CKeystore-Explorer.md)

[nginx开启ssl并把http重定向到https的两种方式](https://www.pkslow.com/archives/nginx-ssl-and-redirect-http)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/05/20200502.nginx%E5%BC%80%E5%90%AFssl%E5%B9%B6%E6%8A%8Ahttp%E9%87%8D%E5%AE%9A%E5%90%91%E5%88%B0https%E7%9A%84%E4%B8%A4%E7%A7%8D%E6%96%B9%E5%BC%8F.md)

[使用ngrok实现内网穿透以便外网访问](https://www.pkslow.com/archives/mac-ngrok)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/04/20200419.%E4%BD%BF%E7%94%A8ngrok%E5%AE%9E%E7%8E%B0%E5%86%85%E7%BD%91%E7%A9%BF%E9%80%8F%E4%BB%A5%E4%BE%BF%E5%A4%96%E7%BD%91%E8%AE%BF%E9%97%AE.md)

[一键下载网页所有图片，把美丽存下来](https://www.pkslow.com/archives/download-all-pic-on-webpage)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/06/20200614.%E4%B8%80%E9%94%AE%E4%B8%8B%E8%BD%BD%E7%BD%91%E9%A1%B5%E6%89%80%E6%9C%89%E5%9B%BE%E7%89%87%EF%BC%8C%E6%8A%8A%E7%BE%8E%E4%B8%BD%E5%AD%98%E4%B8%8B%E6%9D%A5.md)

[防止Google重定向到其它地区](https://www.pkslow.com/archives/google-no-country-redirection)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200719.%E9%98%B2%E6%AD%A2Google%E9%87%8D%E5%AE%9A%E5%90%91%E5%88%B0%E5%85%B6%E5%AE%83%E5%9C%B0%E5%8C%BA.md)

[如何部署ReactJs打包后的build目录文件](https://www.pkslow.com/archives/reactjs-deploy-build-folder)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200721.%E5%A6%82%E4%BD%95%E9%83%A8%E7%BD%B2ReactJs%E6%89%93%E5%8C%85%E5%90%8E%E7%9A%84build%E7%9B%AE%E5%BD%95%E6%96%87%E4%BB%B6.md)

[不带www访问网站失败，加条解析即可](https://www.pkslow.com/archives/fail-access-website-without-www)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200801.%E4%B8%8D%E5%B8%A6www%E8%AE%BF%E9%97%AE%E7%BD%91%E7%AB%99%E5%A4%B1%E8%B4%A5%EF%BC%8C%E5%8A%A0%E6%9D%A1%E8%A7%A3%E6%9E%90%E5%8D%B3%E5%8F%AF.md)

[搭建Go语言开发环境](https://www.pkslow.com/archives/go-setup-env)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200821.%E6%90%AD%E5%BB%BAGo%E8%AF%AD%E8%A8%80%E5%BC%80%E5%8F%91%E7%8E%AF%E5%A2%83.md)

[用org.codehaus.mojo的插件exec-maven-plugin执行程序，实在是太方便了](https://www.pkslow.com/archives/codehaus-mojo-exec-maven-plugin)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/09/20200903.%E7%94%A8org.codehaus.mojo%E7%9A%84%E6%8F%92%E4%BB%B6exec-maven-plugin%E6%89%A7%E8%A1%8C%E7%A8%8B%E5%BA%8F%EF%BC%8C%E5%AE%9E%E5%9C%A8%E6%98%AF%E5%A4%AA%E6%96%B9%E4%BE%BF%E4%BA%86.md)

[在Jenkins pipeline中无法执行npm，报错Cannot run program npm](https://www.pkslow.com/archives/jenkins-cannot-run-npm)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/09/20200903.%E5%9C%A8Jenkins%20pipeline%E4%B8%AD%E6%97%A0%E6%B3%95%E6%89%A7%E8%A1%8Cnpm%EF%BC%8C%E6%8A%A5%E9%94%99Cannot%20%20run%20program%20npm.md)

[常用好用软件整理](https://www.pkslow.com/archives/favorite-software-list)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/10/20201018.%E5%B8%B8%E7%94%A8%E5%A5%BD%E7%94%A8%E8%BD%AF%E4%BB%B6%E6%95%B4%E7%90%86.md)

[解决ssh连接长时间不操作断开连接的问题（client_loop/ send disconnect/ Broken pipe）](https://www.pkslow.com/archives/ssh-keep-alive)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/11/20201114.%E8%A7%A3%E5%86%B3ssh%E8%BF%9E%E6%8E%A5%E9%95%BF%E6%97%B6%E9%97%B4%E4%B8%8D%E6%93%8D%E4%BD%9C%E6%96%AD%E5%BC%80%E8%BF%9E%E6%8E%A5%E7%9A%84%E9%97%AE%E9%A2%98%EF%BC%88client_loop%3A%20send%20disconnect%3A%20Broken%20pipe%EF%BC%89.md)

[使用Go module和GoLand初始化一个Go项目](https://www.pkslow.com/archives/go-create-project)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/12/20201213.%E4%BD%BF%E7%94%A8Go%20module%E5%92%8CGoLand%E5%88%9D%E5%A7%8B%E5%8C%96%E4%B8%80%E4%B8%AAGo%E9%A1%B9%E7%9B%AE.md)

[调试Http Basic认证，用base64加密解密](https://www.pkslow.com/archives/http-basic-authentication)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/01/20210114.%E8%B0%83%E8%AF%95Http%20Basic%E8%AE%A4%E8%AF%81%EF%BC%8C%E7%94%A8base64%E5%8A%A0%E5%AF%86%E8%A7%A3%E5%AF%86.md)

[南瓜慢说文章汇总](https://www.pkslow.com/archives/all)

[HTTP Cookies知识-查看、发送、获取、返回](https://www.pkslow.com/archives/http-cookies)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/02/20210227.HTTP%20Cookies%E7%9F%A5%E8%AF%86-%E6%9F%A5%E7%9C%8B%E3%80%81%E5%8F%91%E9%80%81%E3%80%81%E8%8E%B7%E5%8F%96%E3%80%81%E8%BF%94%E5%9B%9E.md)

[IT资源收集整理](https://www.pkslow.com/archives/it-resources)

[超级好用的轻量级JSON处理命令jq](https://www.pkslow.com/archives/jq)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/10/20211029.%E8%B6%85%E7%BA%A7%E5%A5%BD%E7%94%A8%E7%9A%84%E8%BD%BB%E9%87%8F%E7%BA%A7JSON%E5%A4%84%E7%90%86%E5%91%BD%E4%BB%A4jq.md)

[设计模式整理与总结、心得与体会](https://www.pkslow.com/archives/design-patterns)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/10/20211027.%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F%E6%95%B4%E7%90%86%E4%B8%8E%E6%80%BB%E7%BB%93%E3%80%81%E5%BF%83%E5%BE%97%E4%B8%8E%E4%BD%93%E4%BC%9A.md)

[git常用命令](https://www.pkslow.com/archives/git-commands)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/07/20220717.git%E5%B8%B8%E7%94%A8%E5%91%BD%E4%BB%A4.md)

[生成GitHub README的markdown导航目录](https://www.pkslow.com/archives/gh-md-toc)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/12/20221216.%E7%94%9F%E6%88%90GitHub%20README%E7%9A%84markdown%E5%AF%BC%E8%88%AA%E7%9B%AE%E5%BD%95.md)

[GitHub如何在README中返回顶部](https://www.pkslow.com/archives/github-readme-back-to-top)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/12/20221220.GitHub%E5%A6%82%E4%BD%95%E5%9C%A8README%E4%B8%AD%E8%BF%94%E5%9B%9E%E9%A1%B6%E9%83%A8.md)



<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## Mac

[Mac国内加速GitHub访问的方法](https://www.pkslow.com/archives/mac-github-speed-up)

[Mac uses pstree to show the process tree](https://www.pkslow.com/archives/mac-pstree-en)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/12/20211204.Mac%20uses%20pstree%20to%20show%20the%20process%20tree.md)

[Mac通过命令pstree显示进程树](https://www.pkslow.com/archives/mac-pstree)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/12/20211204.Mac%E9%80%9A%E8%BF%87%E5%91%BD%E4%BB%A4pstree%E6%98%BE%E7%A4%BA%E8%BF%9B%E7%A8%8B%E6%A0%91.md)

[Mac触摸板与鼠标滚动方向独立设置](https://www.pkslow.com/archives/scroll-reverse-for-mac)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/10/20201004.Mac%E8%A7%A6%E6%91%B8%E6%9D%BF%E4%B8%8E%E9%BC%A0%E6%A0%87%E6%BB%9A%E5%8A%A8%E6%96%B9%E5%90%91%E7%8B%AC%E7%AB%8B%E8%AE%BE%E7%BD%AE.md)

[Mac让ssh通过代理来连接服务器](https://www.pkslow.com/archives/mac-ssh-proxy)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/11/20201114.Mac%E8%AE%A9ssh%E9%80%9A%E8%BF%87%E4%BB%A3%E7%90%86%E6%9D%A5%E8%BF%9E%E6%8E%A5%E6%9C%8D%E5%8A%A1%E5%99%A8.md)

[没有Esc键的Macbook Pro怎么用vim](https://www.pkslow.com/archives/mac-no-esc)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/12/20201213.%E6%B2%A1%E6%9C%89Esc%E9%94%AE%E7%9A%84Macbook%20Pro%E6%80%8E%E4%B9%88%E7%94%A8vim.md)

[Mac查看端口占用](https://www.pkslow.com/archives/mac-check-port)

[Mac以树形结构显示目录](https://www.pkslow.com/archives/mac-tree-show-dir)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/08/20200809.Mac%E4%BB%A5%E6%A0%91%E5%BD%A2%E7%BB%93%E6%9E%84%E6%98%BE%E7%A4%BA%E7%9B%AE%E5%BD%95.md)



<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## Python

[如何在IntelliJ IDEA设置Python开发环境](https://www.pkslow.com/archives/idea-python-support)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/11/20221126.%E5%A6%82%E4%BD%95%E5%9C%A8IntelliJ%20IDEA%E8%AE%BE%E7%BD%AEPython%E5%BC%80%E5%8F%91%E7%8E%AF%E5%A2%83.md)

[用Python做了一个广东疫情新增病例动态视频](https://www.pkslow.com/archives/python-covid-19-guangdong)
- Code: [/python/src/main/python/covid-19-Guangdong](https://github.com/LarryDpk/pkslow-samples/tree/master/python/src/main/python/covid-19-Guangdong)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/11/20221126.%E7%94%A8Python%E5%81%9A%E4%BA%86%E4%B8%80%E4%B8%AA%E5%B9%BF%E4%B8%9C%E7%96%AB%E6%83%85%E6%96%B0%E5%A2%9E%E7%97%85%E4%BE%8B%E5%8A%A8%E6%80%81%E8%A7%86%E9%A2%91.md)

[用Python库BeautifulSoup来读取广东疫情近期数据并存在csv上](https://www.pkslow.com/archives/python-bs4-csv)
- Code: [/python/src/main/python/beautifulsoup4-example](https://github.com/LarryDpk/pkslow-samples/tree/master/python/src/main/python/beautifulsoup4-example)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/11/20221128.%E7%94%A8Python%E5%BA%93BeautifulSoup%E6%9D%A5%E8%AF%BB%E5%8F%96%E5%B9%BF%E4%B8%9C%E7%96%AB%E6%83%85%E8%BF%91%E6%9C%9F%E6%95%B0%E6%8D%AE%E5%B9%B6%E5%AD%98%E5%9C%A8csv%E4%B8%8A.md)

[用GPU来运行Python代码](https://www.pkslow.com/archives/run-python-with-gpu)
- Code: [/python/src/main/python/cuda](https://github.com/LarryDpk/pkslow-samples/tree/master/python/src/main/python/cuda)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/12/20221207.%E7%94%A8GPU%E6%9D%A5%E8%BF%90%E8%A1%8CPython%E4%BB%A3%E7%A0%81.md)



<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## Linux

[Ubuntu玩机记录，让我破电脑又飞起来了](https://www.pkslow.com/archives/ubuntu-tutorial)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/12/20221205.Ubuntu%E7%8E%A9%E6%9C%BA%E8%AE%B0%E5%BD%95%EF%BC%8C%E8%AE%A9%E6%88%91%E7%A0%B4%E7%94%B5%E8%84%91%E5%8F%88%E9%A3%9E%E8%B5%B7%E6%9D%A5%E4%BA%86.md)

[vim常用命令，linux必备](https://www.pkslow.com/archives/vim-commands)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/11/20201103.vim%E5%B8%B8%E7%94%A8%E5%91%BD%E4%BB%A4%EF%BC%8Clinux%E5%BF%85%E5%A4%87.md)

[Linux常用命令整理](https://www.pkslow.com/archives/linux-commands)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/05/20210503.Linux%E5%B8%B8%E7%94%A8%E5%91%BD%E4%BB%A4%E6%95%B4%E7%90%86.md)

<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## App开发
[打包iOS App并上架到TestFlight测试](https://www.pkslow.com/archives/ios-build-and-testflight)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/06/20220609.%E6%89%93%E5%8C%85iOS%20App%E5%B9%B6%E4%B8%8A%E6%9E%B6%E5%88%B0TestFlight%E6%B5%8B%E8%AF%95.md)

[iOS真机调试包](https://www.pkslow.com/archives/ios-device-support)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/05/20220520.iOS%E7%9C%9F%E6%9C%BA%E8%B0%83%E8%AF%95%E5%8C%85.md)

[用Transporter上传iOS App，大大降低出错概率](https://www.pkslow.com/archives/upload-ios-app-with-transporter)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/07/20220723.%E7%94%A8Transporter%E4%B8%8A%E4%BC%A0iOS%20App%EF%BC%8C%E5%A4%A7%E5%A4%A7%E9%99%8D%E4%BD%8E%E5%87%BA%E9%94%99%E6%A6%82%E7%8E%87.md)

[Pkslow Timeline is release(南瓜时线发布啦)](https://www.pkslow.com/archives/pkslow-timeline)

<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## 数据库
[2019年MongoDB中文社区广州大会，干货满满的分享活动](https://www.pkslow.com/archives/mongodb-meeting-in-guangzhou)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/11/20191123.MongoDB.2019%E5%B9%B4MongoDB%E4%B8%AD%E6%96%87%E7%A4%BE%E5%8C%BA%E5%B9%BF%E5%B7%9E%E5%A4%A7%E4%BC%9A%EF%BC%8C%E5%B9%B2%E8%B4%A7%E6%BB%A1%E6%BB%A1%E7%9A%84%E5%88%86%E4%BA%AB%E6%B4%BB%E5%8A%A8.md)

[MongoDB开发中遇到的问题记录](https://www.pkslow.com/archives/mongodb-issues-in-development)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/07/20200701.MongoDB%E5%BC%80%E5%8F%91%E4%B8%AD%E9%81%87%E5%88%B0%E7%9A%84%E9%97%AE%E9%A2%98%E8%AE%B0%E5%BD%95.md)

[如何安放你的大文件，MongoDB GridFS可以帮助你](https://www.pkslow.com/archives/mongo-gridfs-intro)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/05/20200522.%E5%A6%82%E4%BD%95%E5%AE%89%E6%94%BE%E4%BD%A0%E7%9A%84%E5%A4%A7%E6%96%87%E4%BB%B6%EF%BC%8CMongoDB%20GridFS%E5%8F%AF%E4%BB%A5%E5%B8%AE%E5%8A%A9%E4%BD%A0.md)

[Oracle SQLPlus导出数据到csv文件](https://www.pkslow.com/archives/sqlplus-export-csv)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/05/20200514.Oracle%20SQLPlus%E5%AF%BC%E5%87%BA%E6%95%B0%E6%8D%AE%E5%88%B0csv%E6%96%87%E4%BB%B6.md)

[Oracle用decode函数或CASE-WHEN实现自定义排序](https://www.pkslow.com/archives/oracle-order-with-decode-and-case-when)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/05/20200514.Oracle%E7%94%A8decode%E5%87%BD%E6%95%B0%E6%88%96CASE-WHEN%E5%AE%9E%E7%8E%B0%E8%87%AA%E5%AE%9A%E4%B9%89%E6%8E%92%E5%BA%8F.md)

[How to partition the big table in PostgreSQL - Range List Hash](https://www.pkslow.com/archives/postgresql-partitioning-en)
- Code: [/other/postgresql](https://github.com/LarryDpk/pkslow-samples/tree/master/other/postgresql)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/06/20210627.How%20to%20partition%20the%20big%20table%20in%20PostgreSQL%20-%20Range%20List%20Hash.md)

[示例讲解PostgreSQL表分区的三种方式](https://www.pkslow.com/archives/postgresql-partitioning)
- Code: [/other/postgresql](https://github.com/LarryDpk/pkslow-samples/tree/master/other/postgresql)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/06/20210627.%E7%A4%BA%E4%BE%8B%E8%AE%B2%E8%A7%A3PostgreSQL%E8%A1%A8%E5%88%86%E5%8C%BA%E7%9A%84%E4%B8%89%E7%A7%8D%E6%96%B9%E5%BC%8F.md)

[InfluxDB入门及使用，一个优秀的时序数据库](https://www.pkslow.com/archives/influxdb-introduction)
- Code: [/java-basic/influxdb](https://github.com/LarryDpk/pkslow-samples/tree/master/java-basic/influxdb)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/09/20200920.InfluxDB%E5%85%A5%E9%97%A8%E5%8F%8A%E4%BD%BF%E7%94%A8%EF%BC%8C%E4%B8%80%E4%B8%AA%E4%BC%98%E7%A7%80%E7%9A%84%E6%97%B6%E5%BA%8F%E6%95%B0%E6%8D%AE%E5%BA%93.md)

<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## IDEA

[IDEA failed to import the class due to untrusted project](https://www.pkslow.com/archives/idea-untrusted-project-en)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/06/20210619.IDEA%20failed%20to%20import%20the%20class%20due%20to%20untrusted%20project.md)

[IDEA因Untrusted project无法导入jar包解决方法](https://www.pkslow.com/archives/idea-untrusted-project)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/06/20210619.IDEA%E5%9B%A0Untrusted%20project%E6%97%A0%E6%B3%95%E5%AF%BC%E5%85%A5jar%E5%8C%85%E8%A7%A3%E5%86%B3%E6%96%B9%E6%B3%95.md)

[Lombok在IntelliJ IDEA下出现cannot find symbol问题的解决](https://www.pkslow.com/archives/idea-lombok-cannot-find-symbol)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/10/20221027.Lombok%E5%9C%A8IntelliJ%20IDEA%E4%B8%8B%E5%87%BA%E7%8E%B0cannot%20find%20symbol%E9%97%AE%E9%A2%98%E7%9A%84%E8%A7%A3%E5%86%B3.md)

[IDEA启动Springboot但AOP失效](https://www.pkslow.com/archives/idea-fail-to-trigger-spring-aop)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/10/20221027.IDEA%E5%90%AF%E5%8A%A8Springboot%E4%BD%86AOP%E5%A4%B1%E6%95%88.md)

[如何在Intellij IDEA运行和调试JavaScript](https://www.pkslow.com/archives/idea-run-js)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/11/20211113.%E5%A6%82%E4%BD%95%E5%9C%A8Intellij%20IDEA%E8%BF%90%E8%A1%8C%E5%92%8C%E8%B0%83%E8%AF%95JavaScript.md)

[How to run and debug the JavaScript in Intellij IDEA](https://www.pkslow.com/archives/idea-run-js-en)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/11/20211113.How%20to%20run%20and%20debug%20the%20JavaScript%20in%20Intellij%20IDEA.md)

[Intellij IDEA同一个项目（窗口）多个代码仓库](https://www.pkslow.com/archives/idea-multiple-repo)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/06/20210604.Intellij%20IDEA%E5%90%8C%E4%B8%80%E4%B8%AA%E9%A1%B9%E7%9B%AE%EF%BC%88%E7%AA%97%E5%8F%A3%EF%BC%89%E5%A4%9A%E4%B8%AA%E4%BB%A3%E7%A0%81%E4%BB%93%E5%BA%93.md)

[真香！通过开源项目免费获取JetBrains全家桶License](https://www.pkslow.com/archives/jetbrains-open-source-license)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/06/20210603.%E7%9C%9F%E9%A6%99%EF%BC%81%E9%80%9A%E8%BF%87%E5%BC%80%E6%BA%90%E9%A1%B9%E7%9B%AE%E5%85%8D%E8%B4%B9%E8%8E%B7%E5%8F%96JetBrains%E5%85%A8%E5%AE%B6%E6%A1%B6License.md)

[Intellij IDEA运行报Command line is too long的解决办法](https://www.pkslow.com/archives/idea-error-command-line-too-long)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/05/20200505.Intellij%20IDEA%E8%BF%90%E8%A1%8C%E6%8A%A5Command%20line%20is%20too%20long%E7%9A%84%E8%A7%A3%E5%86%B3%E5%8A%9E%E6%B3%95.md)

[Intellij IDEA利用正则替换，并保留匹配结果](https://www.pkslow.com/archives/idea-regex-replace-with-matched-value)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/12/20221215.Intellij%20IDEA%E5%88%A9%E7%94%A8%E6%AD%A3%E5%88%99%E6%9B%BF%E6%8D%A2%EF%BC%8C%E5%B9%B6%E4%BF%9D%E7%95%99%E5%8C%B9%E9%85%8D%E7%BB%93%E6%9E%9C.md)


<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## VSCode
[好用的VSCode的SFTP插件](https://www.pkslow.com/archives/vscode-sftp)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/06/20210602.%E5%A5%BD%E7%94%A8%E7%9A%84VSCode%E7%9A%84SFTP%E6%8F%92%E4%BB%B6.md)

[VSCode的REST Client指南，超好用的HTTP客户端工具](https://www.pkslow.com/archives/vscode-rest-client)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/05/20210529.VSCode%E7%9A%84REST%20Client%E6%8C%87%E5%8D%97%EF%BC%8C%E8%B6%85%E5%A5%BD%E7%94%A8%E7%9A%84HTTP%E5%AE%A2%E6%88%B7%E7%AB%AF%E5%B7%A5%E5%85%B7.md)

[Visual Studio Code - vscode使用小心得](https://www.pkslow.com/archives/vscode)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/03/20210313.Visual%20Studio%20Code%20-%20vscode%E4%BD%BF%E7%94%A8%E5%B0%8F%E5%BF%83%E5%BE%97.md)

[VSCode巧妙使用正则替换提高效率](https://www.pkslow.com/archives/vscode-replace)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2021/05/20210503.VSCode%E5%B7%A7%E5%A6%99%E4%BD%BF%E7%94%A8%E6%AD%A3%E5%88%99%E6%9B%BF%E6%8D%A2%E6%8F%90%E9%AB%98%E6%95%88%E7%8E%87.md)



<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

# 生活

<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## 生活杂事
[如何制定切实可行的计划并好好执行——2020年，我不想再碌碌无为](https://www.pkslow.com/archives/how-to-make-a-good-plan)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/12/20191229.%E5%A6%82%E4%BD%95%E5%88%B6%E5%AE%9A%E5%88%87%E5%AE%9E%E5%8F%AF%E8%A1%8C%E7%9A%84%E8%AE%A1%E5%88%92%E5%B9%B6%E5%A5%BD%E5%A5%BD%E6%89%A7%E8%A1%8C.md)

[2020，分手快乐；2021，且行且歌](https://www.pkslow.com/archives/from-2020-to-2021)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/12/20201231.2020%EF%BC%8C%E5%88%86%E6%89%8B%E5%BF%AB%E4%B9%90%EF%BC%9B2021%EF%BC%8C%E4%B8%94%E8%A1%8C%E4%B8%94%E6%AD%8C.md)

[自我鼓励墙——生命不息，奋斗不止](https://www.pkslow.com/archives/self-motivate)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/04/20200429.%E8%87%AA%E6%88%91%E9%BC%93%E5%8A%B1%E5%A2%99%E2%80%94%E2%80%94%E7%94%9F%E5%91%BD%E4%B8%8D%E6%81%AF%EF%BC%8C%E5%A5%8B%E6%96%97%E4%B8%8D%E6%AD%A2.md)

[删库吧，Bug浪——我们在同一家摸鱼的公司](https://www.pkslow.com/archives/write-bugs)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/06/20200624.%E5%88%A0%E5%BA%93%E5%90%A7%EF%BC%8CBug%E6%B5%AA%E2%80%94%E2%80%94%E6%88%91%E4%BB%AC%E5%9C%A8%E5%90%8C%E4%B8%80%E5%AE%B6%E6%91%B8%E9%B1%BC%E7%9A%84%E5%85%AC%E5%8F%B8.md)

[IT界的名言名语](https://www.pkslow.com/archives/it-phrases)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/10/20201001.Protobuf%E5%85%A5%E9%97%A8%E4%B8%8E%E4%BD%BF%E7%94%A8%E7%A4%BA%E4%BE%8B%EF%BC%8C%E9%AB%98%E6%80%A7%E8%83%BD%E7%9A%84%E5%BA%8F%E5%88%97%E5%8C%96%E6%A1%86%E6%9E%B6.md)

<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## 旅行
[印尼之行-龙目岛和科莫多岛9日自由行旅婚](https://www.pkslow.com/archives/indonesia-lombok-komodo)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2019/09/20190912.%E5%8D%B0%E5%B0%BC%E4%B9%8B%E8%A1%8C-%E9%BE%99%E7%9B%AE%E5%B2%9B%E5%92%8C%E7%A7%91%E8%8E%AB%E5%A4%9A%E5%B2%9B9%E6%97%A5%E8%87%AA%E7%94%B1%E8%A1%8C%E6%97%85%E5%A9%9A.md)

[黄山徽州五日行-最美风景与攻略献给你](https://www.pkslow.com/archives/huangshan-2020)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/06/20200601.%E9%BB%84%E5%B1%B1%E5%BE%BD%E5%B7%9E%E4%BA%94%E6%97%A5%E8%A1%8C-%E6%9C%80%E7%BE%8E%E9%A3%8E%E6%99%AF%E4%B8%8E%E6%94%BB%E7%95%A5%E7%8C%AE%E7%BB%99%E4%BD%A0.md.backup)

<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## 育儿
[最高频的母婴九大件，陪我度过艰难的第一年](https://www.pkslow.com/archives/baby-products-top9)

[在广州如何带宝宝打疫苗-实战经验分享](https://www.pkslow.com/archives/baby-vaccines-in-guangzhou)

[广州人才引进，本科学历最好的入户方式](https://www.pkslow.com/archives/guangzhou-hukou)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/07/20220723.%E5%B9%BF%E5%B7%9E%E4%BA%BA%E6%89%8D%E5%BC%95%E8%BF%9B%EF%BC%8C%E6%9C%AC%E7%A7%91%E5%AD%A6%E5%8E%86%E6%9C%80%E5%A5%BD%E7%9A%84%E5%85%A5%E6%88%B7%E6%96%B9%E5%BC%8F.md)

[在广州给婴儿办理少儿医保](https://www.pkslow.com/archives/gz-yibao)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/10/20221013.%E5%9C%A8%E5%B9%BF%E5%B7%9E%E7%BB%99%E5%A9%B4%E5%84%BF%E5%8A%9E%E7%90%86%E5%B0%91%E5%84%BF%E5%8C%BB%E4%BF%9D.md)

[二胎随想，没什么大不了的](https://www.pkslow.com/archives/two-children)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2022/11/20221120.%E4%BA%8C%E8%83%8E%E9%9A%8F%E6%83%B3%EF%BC%8C%E6%B2%A1%E4%BB%80%E4%B9%88%E5%A4%A7%E4%B8%8D%E4%BA%86%E7%9A%84.md)




<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

## 诗词歌赋

[送友人](https://www.pkslow.com/archives/farewell-to-friends)

- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/0000-pre/20090322.%E9%80%81%E5%8F%8B%E4%BA%BA.md)

[梦游无名山](https://www.pkslow.com/archives/dream-of-unknown-mountain)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/0000-pre/20090713.%E6%A2%A6%E6%B8%B8%E6%97%A0%E5%90%8D%E5%B1%B1.md)

[哀友文-怀念逝去挚友](https://www.pkslow.com/archives/mourn-my-friends-death)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/0000-pre/20090819.%E5%93%80%E5%8F%8B%E6%96%87.md)

[北征赋——献礼国庆60周年](https://www.pkslow.com/archives/go-north)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/0000-pre/20091001.%E5%8C%97%E5%BE%81%E8%B5%8B.md)

[寒鸦](https://www.pkslow.com/archives/poor-crow)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/0000-pre/20091123.%E5%AF%92%E9%B8%A6.md)


[出Bug表-假如诸葛亮是程序员](https://www.pkslow.com/archives/lets-write-bugs)
- [GitHub](https://github.com/LarryDpk/pkslow-samples/blob/master/articles/2020/10/20201024.%E5%87%BABug%E8%A1%A8-%E5%81%87%E5%A6%82%E8%AF%B8%E8%91%9B%E4%BA%AE%E6%98%AF%E7%A8%8B%E5%BA%8F%E5%91%98%EF%BC%881024%E7%A8%8B%E5%BA%8F%E5%91%98%E8%8A%82%E6%97%A5%E7%8C%AE%E7%A4%BC%EF%BC%89.md)

<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>

# 状态

![Repobeats analytics](https://repobeats.axiom.co/api/embed/13cfae2492671e23cbc71c4f469e6c9c789769f7.svg "Repobeats analytics image")




<div align="right">
    <b><a href="#pkslow-samples">↥ back to top</a></b>
</div>


# Thanks to JetBrains

<h3 align="center">JetBrains</h3>

<p align="center">
  <a href="https://www.jetbrains.com/?from=pkslow-samples">
    <img width="260px" src="jetbrains-variant-4.png">
  </a>
</p>

> Thanks JetBrains to support the project providing such great IDE.