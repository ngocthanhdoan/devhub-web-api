# Stage 1: Build
FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn clean install -X -DskipTests

# Stage 2: Package
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/devhub-web-api.jar devhub-web-api.jar
EXPOSE 8080
CMD ["java", "-jar", "devhub-web-api.jar"]
