FROM amazoncorretto:8

MAINTAINER FireDust97

COPY target/firedust-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

entrypoint ["java","-jar","/app.jar"]