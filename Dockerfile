FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/comex-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} comex.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/comex.jar"]