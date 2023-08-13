FROM amazoncorretto:17.0.0-alpine
EXPOSE 8080

WORKDIR /app
ARG JAR_FILE_PATH=build/libs/*.jar
COPY ${JAR_FILE_PATH} app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]