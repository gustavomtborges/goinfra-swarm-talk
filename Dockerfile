FROM openjdk:8-jdk-alpine
LABEL maintainer="gustavo.mtborges@gmail.com"

ADD target/beers-api.jar app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
