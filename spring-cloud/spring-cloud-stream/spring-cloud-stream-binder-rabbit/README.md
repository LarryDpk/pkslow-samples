start up rabbitmq:
```shell script
docker run \
-e RABBITMQ_DEFAULT_USER=pkslow \
-e RABBITMQ_DEFAULT_PASS=123456 \
-p 5672:5672 -p 15672:15672 \
rabbitmq:3.8-management
```