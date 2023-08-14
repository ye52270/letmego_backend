FROM openjdk:17-alpine AS builder
EXPOSE 8080

WORKDIR /app
ARG JAR_FILE_PATH=./target/*.jar
COPY ${JAR_FILE_PATH} app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]