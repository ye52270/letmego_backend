FROM cgdevops/openjdk17-jdk
EXPOSE 8081
ARG JAR_FILE_PATH=/order/target/*.jar
COPY ${JAR_FILE_PATH} app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]