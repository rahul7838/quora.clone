# Use the official OpenJDK image from the Docker Hub
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory (for Maven) or build/libs directory (for Gradle)
# COPY target/quora.clone-0.0.1-SNAPSHOT.jar
# For Gradle, use the following line instead:
COPY build/libs/quora.clone-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port your Spring Boot application will run on
EXPOSE 8080

# Command to run your application
ENTRYPOINT ["java", "-jar", "app.jar"]
