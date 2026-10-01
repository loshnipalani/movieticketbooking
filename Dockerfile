FROM eclipse-temurin:25-jdk

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar",git add .github/workflows/docker.yml "app.jar"]