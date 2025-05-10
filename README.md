# 🌱 Ecowatt - Spring Boot REST API

RESTful API built with Java and Spring Boot as part of **FIAP – Chapter 8: Microservices with Spring – REST with Spring Boot**.  
Developed by **Hugo Farranha**, **Milton Ribeiro**, and **Victor Mazzola**.

The project focuses on ESG-related data collection and monitoring.

## 🚀 Tech Stack

- Java 21
- Spring Boot 3.4.5
- Spring Web (MVC)
- Spring Data JPA
- Spring Validation
- Spring Security (basic auth)
- Flyway
- Oracle Database
- Maven
- Docker + Docker Compose

## 📝 Description

This API allows storing and retrieving energy consumption records for ESG analysis.  
Authentication is required for POST, PUT, and DELETE requests.

## ✅ Features

- ✅ Full CRUD operations for energy consumption
- ✅ Input validation using Spring Validation
- ✅ Exception handling with `@RestControllerAdvice`
- ✅ Oracle DB integration with Flyway migrations
- ✅ Basic authentication via Spring Security
- ✅ Docker support with Docker Compose

## ▶️ How to Run (Local)

```bash
./mvnw spring-boot:run
```

Make sure your Oracle database is running and `application.properties` is correctly configured.



## 🐳 Run with Docker

This project includes Docker support for the API and Oracle DB.

### Requirements

- Docker installed and running
- Docker Compose

### Build and Start

1. Package the app:

```bash
./mvnw clean package -DskipTests
```
2. Run the containers:
```bash
docker-compose up --build
```

### Ports:
- `8080` – Spring Boot API
- `1521` – Oracle Database (FREEPDB1)

### To stop:

```bash
docker-compose down
```