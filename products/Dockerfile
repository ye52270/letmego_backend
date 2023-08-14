FROM cgdevops/openjdk17-jdk
EXPOSE 8080

WORKDIR /app
ARG JAR_FILE_PATH=product/target/*.jar
COPY ${JAR_FILE_PATH} app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]