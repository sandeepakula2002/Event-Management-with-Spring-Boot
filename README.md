Event Management API – Spring Boot Project
Event Management is a RESTful API application developed with Spring Boot and Spring Data JPA. This project focuses on building a scalable backend system for managing events with proper validation, error handling, and API documentation.

🚀 Tech Stack
Java 17

Spring Boot 3.5.10

Spring Data JPA

Hibernate ORM

H2 Database (In-memory)

Maven

Springdoc OpenAPI (Swagger)

Jakarta Validation

🏗️ Architecture
The application follows a clean, layered architecture:

Entity → Repository → Service → Controller

✅ Key Design Principles
Business logic and validations handled in Service layer

Spring Dependency Injection via constructor injection

Clean separation between database, business logic, and API layers

No raw SQL queries – using Spring Data JPA

RESTful API design with proper HTTP status codes

📦 Layers & Responsibilities
🧩 Entity Layer
JPA entities with @Entity, @Id, @GeneratedValue

Validation annotations (@NotBlank, @Future, @NotNull)

Database table mapping with @Table

🗄️ Repository Layer
Extends JpaRepository<Event, Long>

Spring Data JPA automatic query generation

No manual SQL queries required

Built-in CRUD operations

⚙️ Service Layer
Contains complete business logic

Performs validations (future dates, mandatory fields)

Throws custom exceptions (EventNotFoundException)

Transaction management with @Transactional

Logging with SLF4J

🎮 Controller Layer
REST endpoints with @RestController

Request mapping with @RequestMapping

Input validation via @Valid

Proper HTTP status codes (201, 200, 404, 400)

Swagger annotations for API documentation

🛡️ Exception Handling Layer
Global exception handling with @RestControllerAdvice

Custom exception classes

Structured JSON error responses

Validation error mapping to field names

📡 API Endpoints
Event Management
Method	Endpoint	Description	Status Codes
POST	/api/events	Create new event	201, 400
GET	/api/events	Get all events	200
GET	/api/events/{id}	Get event by ID	200, 404
PUT	/api/events/{id}	Update event	200, 400, 404
DELETE	/api/events/{id}	Delete event	200, 404
✨ Features
✅ Event Management
Create event with validation

Retrieve event by ID

List all events

Update existing event

Delete event

✅ Validation
Title: Mandatory, cannot be blank

Location: Mandatory, cannot be blank

Date: Mandatory, must be future date

Automatic validation error responses

✅ Error Handling
400 Bad Request: Invalid input data

404 Not Found: Event not found

500 Internal Server Error: Unexpected errors

JSON error responses with field-specific messages

✅ Documentation
Interactive Swagger UI

OpenAPI 3.0 specification

Endpoint descriptions and examples

🧪 Testing
Valid Request Example
json
POST /api/events
{
  "title": "Spring Boot Workshop",
  "description": "Hands-on workshop on Spring Boot",
  "location": "Visakhapatnam",
  "date": "2026-12-10"
}
Invalid Request Example
json
POST /api/events
{
  "title": "",
  "description": "Test",
  "location": "",
  "date": "2023-01-01"
}
Response:

json
{
  "title": "Title is mandatory",
  "location": "Location is mandatory",
  "date": "Event date must be in the future"
}
🛠️ Setup & Running
1. Prerequisites
Java 17 or higher

Maven 3.8+

IDE (IntelliJ IDEA recommended)

2. Build & Run
bash
# Clone the project
git clone <repository-url>
cd event-management

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
3. Access Points
Swagger UI: http://localhost:8080/swagger-ui.html

H2 Console: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:eventdb

Username: sa

Password: (leave empty)

API Documentation: http://localhost:8080/v3/api-docs

📁 Project Structure
text
event-management/
├── src/main/java/com/eventmanagement/api/
│   ├── EventManagementApplication.java
│   ├── controller/
│   │   └── EventController.java
│   ├── service/
│   │   ├── EventService.java
│   │   └── EventServiceImpl.java
│   ├── repository/
│   │   └── EventRepository.java
│   ├── entity/
│   │   └── Event.java
│   └── exception/
│       ├── EventNotFoundException.java
│       └── GlobalExceptionHandler.java
├── src/main/resources/
│   └── application.properties
├── pom.xml
└── README.md
📌 Application Properties
properties
# Server
server.port=8080

# Database (H2)
spring.datasource.url=jdbc:h2:mem:eventdb
spring.datasource.username=sa
spring.datasource.password=

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# H2 Console
spring.h2.console.enabled=true

# Swagger
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
🧠 Learning Outcomes
Spring Boot application development

RESTful API design principles

Spring Data JPA with Hibernate

Input validation and error handling

Layered architecture implementation

API documentation with Swagger

In-memory database usage

🎯 Future Enhancements
Add user authentication

Implement pagination for GET /events

Add filtering and sorting

Integrate with MySQL/PostgreSQL

Add unit and integration tests

Docker containerization

Deploy to cloud platform

👨‍💻 Author
Sandeep Akula
Event Management API – Spring Boot & Spring Data JPA Project
