# FROM openjdk:11-jre-slim
# Stage 1: Build
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean install -X -DskipTests
# Stage 2: Package
FROM openjdk:17.0.1-jdk-slim 
WORKDIR /app
COPY --from=build /app/target/devhub-web-api-1.0-SNAPSHOT.jar devhub-web-api.jar
ENTRYPOINT ["java","-jar","app.jar"]

