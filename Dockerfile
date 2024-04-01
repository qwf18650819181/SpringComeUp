FROM openjdk:17-jdk-slim
COPY --from=hengyunabc/arthas /opt/arthas /opt/arthas
RUN apt-get update && apt-get install -y tini
VOLUME /tmp
EXPOSE 8080
ADD ./come-up-service/build/libs/come-up-service-0.0.1.jar app.jar
ENTRYPOINT ["tini", "--", "java", "-jar", "-server", \
"-XX:+UseParNewGC", \
"-XX:+UseConcMarkSweepGC", \
"-XX:+CMSScavengeBeforeRemark", \
"-XX:+DisableExplicitGC", \
"-Xloggc:/mnt/logs/gc/spring-come-up-gc.log", \
"-verbose:gc", \
"-XX:+UseGCLogFileRotation", \
"-XX:NumberOfGCLogFiles=10", \
"-XX:+PrintGCDetails", \
"-XX:+PrintGCDateStamps", \
"-XX:+HeapDumpOnOutOfMemoryError", \
"-XX:HeapDumpPath=/path/to/your/heap/dump", \
"/app.jar"]