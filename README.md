**DeviceAtlas Spring Boot Application**

📌 Overview

This is a Spring Boot application that fetches device data from the DeviceAtlas API, stores it in a Microsoft SQL Server database, and provides an API to retrieve tablet devices.

The project includes:

Spring Boot Backend with JPA and Hibernate

Microsoft SQL Server as the database

Docker Support with a Dockerfile for containerization

🚀 Getting Started

1. Prerequisites

Ensure you have the following installed:

Java 17+

Maven

Microsoft SQL Server/ Azure MSSQL Server

Docker (if running in a containerized environment)

2. Setup Database

Start Microsoft SQL Server and create the database:

CREATE DATABASE deviceatlas_db;

Ensure SQL Server is running on port 1433.

Verify connection using:

sqlcmd -S localhost -U sa -P your_password

3. Configure Environment Variables

Update src/main/resources/application.properties with your database and API credentials:

# Microsoft SQL Server Configuration
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=deviceatlas_db;encrypt=false  
spring.datasource.username=sa   
spring.datasource.password=your_password   
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver   

# JPA Configuration
spring.jpa.database-platform=org.hibernate.dialect.SQLServerDialect  
spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true  

# DeviceAtlas API Configuration
deviceatlas.api.url=https://region0.deviceatlascloud.com/v1/detect/properties  
deviceatlas.license.key=YOUR_LICENSE_KEY  

4. Build and Run the Application

Without Docker

Run the following commands:

mvn clean install
mvn spring-boot:run

The application will start on http://localhost:8080.

With Docker

Build the Docker Image:

docker build -t deviceatlas-app .

Run the Container:

docker run -p 8080:8080 --name deviceatlas-container deviceatlas-app

📡 API Endpoints

Method

Endpoint

Description

GET

/devices/fetch

Fetch and store device data from DeviceAtlas API

GET

/devices/tablets

Retrieve stored tablet devices

GET

/devices/all

Retrieve all stored devices

🛠️ Dockerfile

The project includes a Dockerfile to containerize the application.

# Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy JAR file
COPY target/deviceatlas-app.jar deviceatlas-app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "deviceatlas-app.jar"]

✅ Final Checks

Ensure Microsoft SQL Server is running.

The application should automatically create the devices table.

Test API endpoints using Postman or curl.

Now your project is ready to run! 🚀

