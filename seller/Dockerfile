FROM cgdevops/openjdk17-jdk
EXPOSE 8084
ARG JAR_FILE_PATH=target/*.jar
COPY ${JAR_FILE_PATH} app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]