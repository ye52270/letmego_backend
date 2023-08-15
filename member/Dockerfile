FROM cgdevops/openjdk17-jdk
EXPOSE 8080
ARG JAR_FILE_PATH=/member/target/*.jar
COPY ${JAR_FILE_PATH} app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]