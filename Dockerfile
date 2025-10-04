# Use Java 21 JDK
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the JAR inside the container
RUN ./mvnw clean package -DskipTests

# Copy the JAR to app.jar
RUN cp target/registration-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
