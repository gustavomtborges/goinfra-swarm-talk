FROM openjdk:8-jdk-alpine
LABEL maintainer="gmartins@asert.com.br"

ADD target/beers-api.jar app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
