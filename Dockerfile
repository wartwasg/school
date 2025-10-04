# Use Java 21 JDK
FROM eclipse-temurin:21-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR from the target folder
COPY target/registration-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Command to run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
