Event Management API

A RESTful API for managing events, built with Spring Boot and Spring Data JPA. This project provides CRUD operations for events with proper validation, error handling, and API documentation.

🚀 Tech Stack

Java 17

Spring Boot 3.5.10

Spring Data JPA & Hibernate

H2 Database (In-memory)

Maven

Springdoc OpenAPI (Swagger)

Jakarta Validation

🏗 Architecture

The application follows a layered architecture:

Entity → Repository → Service → Controller


Entity Layer: JPA entities with validation annotations

Repository Layer: Extends JpaRepository for CRUD operations

Service Layer: Business logic, validations, and transaction management

Controller Layer: REST endpoints with proper HTTP status codes

Exception Handling: Global handler for structured JSON error responses

📡 API Endpoints
Method	Endpoint	Description	Status Codes
POST	/api/events	Create new event	201, 400
GET	/api/events	Get all events	200
GET	/api/events/{id}	Get event by ID	200, 404
PUT	/api/events/{id}	Update event	200, 400, 404
DELETE	/api/events/{id}	Delete event	200, 404
✅ Features

Create, read, update, and delete events

Input validation: mandatory fields, future dates

Proper HTTP status codes and structured error responses

Swagger UI for interactive API documentation

🧪 Sample Requests

Valid Request:

POST /api/events
{
  "title": "Spring Boot Workshop",
  "description": "Hands-on workshop on Spring Boot",
  "location": "Visakhapatnam",
  "date": "2026-12-10"
}


Invalid Request:

POST /api/events
{
  "title": "",
  "description": "Test",
  "location": "",
  "date": "2023-01-01"
}


Response:

{
  "title": "Title is mandatory",
  "location": "Location is mandatory",
  "date": "Event date must be in the future"
}

🛠 Setup & Run

Prerequisites:

Java 17+

Maven 3.8+

IDE (IntelliJ IDEA recommended)

Build & Run:

# Clone the project
git clone <repository-url>
cd event-management

# Build
mvn clean install

# Run
mvn spring-boot:run


Access Points:

Swagger UI: http://localhost:8080/swagger-ui.html

H2 Console: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:eventdb

Username: sa

Password: (leave empty)

API Docs: http://localhost:8080/v3/api-docs

📁 Project Structure
event-management/
├── src/main/java/com/eventmanagement/api/
│   ├── controller/EventController.java
│   ├── service/EventService.java, EventServiceImpl.java
│   ├── repository/EventRepository.java
│   ├── entity/Event.java
│   ├── exception/EventNotFoundException.java, GlobalExceptionHandler.java
│   └── EventManagementApplication.java
├── src/main/resources/application.properties
├── pom.xml
└── README.md

📌 Application Properties
# Server
server.port=8080

# H2 Database
spring.datasource.url=jdbc:h2:mem:eventdb
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true

# Swagger
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html

🎯 Learning Outcomes

Spring Boot REST API development

Spring Data JPA with Hibernate

Input validation & exception handling

Layered architecture design

API documentation with Swagger

In-memory database usage

🌟 Future Enhancements

Add user authentication

Implement pagination, filtering, and sorting

Integrate with MySQL/PostgreSQL

Unit & integration testing

Docker containerization & cloud deployment

👨‍💻 Author

Sandeep Akula
