FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/api-veterniaria-0.0.1.jar
COPY ${JAR_FILE} app_veterinaria.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_veterinaria.jar"]
