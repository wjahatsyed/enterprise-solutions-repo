FROM eclipse-temurin:21-jdk AS builder


# Set working directory in the container
WORKDIR /app

# Copy the contents of the backend module into the container
COPY . .

# Ensure mvnw is executable
RUN chmod +x ./mvnw

# Build the application using Maven wrapper
RUN ./mvnw -B -DskipTests clean package

# Expose the port your app runs on
EXPOSE 8088

# Run the application
CMD ["java", "-jar", "target/fragrances-collection-0.0.1-SNAPSHOT.jar"]
