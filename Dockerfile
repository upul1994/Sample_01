# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the WAR file into the container
COPY target/demo-0.0.1-SNAPSHOT.war app.war

# Expose the port your Spring Boot app uses (default 8080)
EXPOSE 8080

# Run the Spring Boot WAR
ENTRYPOINT ["java", "-jar", "app.war"]
