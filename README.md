# Student Management API

A RESTful backend application for managing student records, built with Java and Spring Boot.

The project demonstrates layered backend architecture, REST API development, database integration, DTO-based API design, validation, exception handling, search, filtering, pagination, and sorting.

## 🚀 Features

* Create a student
* Get all students
* Get student by ID
* Update student
* Delete student
* Search students by name
* Filter students by course
* Pagination
* Sorting
* Request validation
* Global exception handling
* DTO-based request and response design
* MySQL database integration

## 🛠️ Tech Stack

| Technology      | Purpose                         |
| --------------- | ------------------------------- |
| Java 21         | Programming language            |
| Spring Boot     | Backend framework               |
| Spring Web      | REST API development            |
| Spring Data JPA | Database access                 |
| Hibernate       | ORM                             |
| MySQL           | Relational database             |
| Maven           | Dependency management and build |
| Postman         | API testing                     |
| Git & GitHub    | Version control                 |

## 🏗️ Architecture

```text
Client / Postman
       ↓
REST Controller
       ↓
Service Layer
       ↓
Repository
       ↓
Spring Data JPA
       ↓
Hibernate
       ↓
MySQL
```

### Request Flow

```text
HTTP Request
     ↓
Controller
     ↓
DTO
     ↓
Service
     ↓
Entity
     ↓
Repository
     ↓
Hibernate / JPA
     ↓
MySQL
```

### Response Flow

```text
MySQL
   ↓
Entity
   ↓
Service
   ↓
Response DTO
   ↓
Controller
   ↓
JSON Response
```

## 📂 Project Structure

```text
src/main/java/com/manoj/studentmanagement/

├── controller/
│   └── StudentController.java
│
├── dto/
│   ├── StudentRequest.java
│   └── StudentResponse.java
│
├── entity/
│   └── Student.java
│
├── exception/
│   ├── ErrorResponse.java
│   ├── GlobalExceptionHandler.java
│   └── StudentNotFoundException.java
│
├── repository/
│   └── StudentRepository.java
│
└── service/
    └── StudentService.java
```

## 🗄️ Database Setup

Create the MySQL database:

```sql
CREATE DATABASE student_management;
```

Configure the database connection in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_management
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> Do not commit database passwords or other secrets to GitHub.

## ▶️ Running the Application

### 1. Clone the repository

```bash
git clone https://github.com/YennameedhiManojKumar/student-management-api.git
```

### 2. Open the project

Open the project in IntelliJ IDEA or VS Code.

### 3. Configure MySQL

Create the database and configure your local database credentials.

### 4. Run the application

Using Maven:

```bash
mvnw.cmd spring-boot:run
```

Or run the main Spring Boot application from your IDE.

The application runs on:

```text
http://localhost:8080
```

## 🔗 API Endpoints

### Create Student

```http
POST /api/students
```

Request:

```json
{
  "name": "Manoj",
  "email": "manoj@example.com",
  "age": 23,
  "course": "Computer Science"
}
```

### Get All Students

```http
GET /api/students
```

### Get Student By ID

```http
GET /api/students/{id}
```

Example:

```http
GET /api/students/1
```

### Update Student

```http
PUT /api/students/{id}
```

### Delete Student

```http
DELETE /api/students/{id}
```

### Search Students

```http
GET /api/students/search?name=man
```

### Filter By Course

```http
GET /api/students/course?course=Java
```

### Pagination

```http
GET /api/students?page=0&size=10
```

### Sorting

```http
GET /api/students?page=0&size=10&sort=name,asc
```

Descending order:

```http
GET /api/students?page=0&size=10&sort=name,desc
```

## 🔐 Validation

The API validates incoming requests using Jakarta Bean Validation.

Examples:

* Name cannot be blank
* Email must be valid
* Age must be between 18 and 100
* Course cannot be blank

Invalid requests return:

```http
400 Bad Request
```

## ❌ Exception Handling

The application uses centralized exception handling through:

```java
@RestControllerAdvice
```

For example, requesting a student that doesn't exist returns:

```http
404 Not Found
```

instead of exposing a Java exception or stack trace to the client.

## 📚 Concepts Demonstrated

This project was built to practice:

* REST API design
* MVC / layered architecture
* Dependency Injection
* Constructor Injection
* DTO pattern
* Repository pattern
* JPA
* Hibernate
* CRUD operations
* Derived query methods
* Pagination
* Sorting
* Validation
* Exception handling
* HTTP status codes
* MySQL integration

## 🔮 Future Improvements

Possible future enhancements:

* Authentication and authorization
* JWT security
* Unit and integration testing
* API documentation with Swagger / OpenAPI
* Docker containerization
* CI/CD
* Cloud deployment
* Advanced filtering
* Database migrations using Flyway

## 👨‍💻 Author

**Y Manoj Kumar**

Integrated M.Tech — Computer Science & Engineering

Focused on Java, Spring Boot and backend development.
