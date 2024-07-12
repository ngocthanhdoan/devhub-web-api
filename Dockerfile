# Stage 1: Build
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean install

# Stage 2: Package
FROM openjdk:17-jre-slim
WORKDIR /app
COPY --from=build /app/target/devhub-web-api-1.0-SNAPSHOT.jar devhub-web-api.jar
EXPOSE 8080
CMD ["java", "-jar", "devhub-web-api.jar"]
 