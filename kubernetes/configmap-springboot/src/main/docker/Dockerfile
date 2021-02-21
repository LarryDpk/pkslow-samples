FROM adoptopenjdk/openjdk8-openj9
VOLUME /tmp

ARG PORT=8080
ARG TIME_ZONE=Asia/Shanghai

ENV TZ=${TIME_ZONE}
EXPOSE ${PORT}

COPY target/*exec.jar pkslow.jar
RUN chmod 755 -R pkslow.jar


ENTRYPOINT ["java", "-jar", "pkslow.jar"]