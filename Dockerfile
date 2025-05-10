# Use Eclipse Temurin Java 21 JDK base image
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/ecowatt-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
