# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working dir in the container
WORKDIR /helloApp

# Copy the packaged jar into the container
COPY /target/demo-0.0.1-SNAPSHOT.jar helloApp.jar

# Expose the port the app runs
EXPOSE 8080

# Run the jar
# used in the following order - "executable", "parameter1", "parameter2"
ENTRYPOINT [ "java", "-jar", "helloApp.jar" ]