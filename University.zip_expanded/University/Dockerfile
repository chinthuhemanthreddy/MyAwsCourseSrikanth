FROM openjdk:8-jdk-alpine

EXPOSE 8083

COPY target/University-0.0.1-SNAPSHOT.jar  University-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/University-0.0.1-SNAPSHOT.jar"]