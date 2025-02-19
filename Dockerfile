# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar app.jar

# Expose the port used by Spring Boot
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
