# Base image for Maven build
FROM maven:3.8.4-openjdk-17 AS build

# Working directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:resolve

# Copy the source code and package the application
COPY src ./src
RUN mvn package -DskipTests

# Use OpenJDK to run the application
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/pelisivusto-0.0.1-SNAPSHOT.jar /app/pelisivusto.jar

EXPOSE 8080
# Define entry point to run the JAR
ENTRYPOINT ["java", "-jar", "/app/pelisivusto.jar"]
