FROM openjdk:17-oracle
ARG JAR_FILE=target/redis-example-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]