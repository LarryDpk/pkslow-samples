FROM springci/graalvm-ce:java11-0.12.x
VOLUME /tmp

ARG PORT=8080
ARG TIME_ZONE=Asia/Shanghai

ENV TZ=${TIME_ZONE}
EXPOSE ${PORT}
RUN pwd

RUN mkdir /pkslow-application
WORKDIR /pkslow-application/
RUN cd /pkslow-application
COPY target/classes/ /pkslow-application/classes/
COPY target/lib/ /pkslow-application/lib/

RUN native-image -cp /pkslow-application/classes/:/pkslow-application/lib/* \
    com.pkslow.springboot.SpringbootGraalVMNativeMain \
    Pkslow.SpringbootGraalVMNativeMain


ENTRYPOINT ["/pkslow-application/Pkslow.SpringbootGraalVMNativeMain"]