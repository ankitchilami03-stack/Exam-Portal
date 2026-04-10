# 🎯  Exam Portal System (Spring Boot REST API)

A production-style backend Quiz Management System built using **Java, Spring Boot, and MySQL**.  
This project demonstrates clean architecture, REST API design, and database integration.

---

##  Key Highlights

-  Built with Spring Boot (REST API architecture)
-  Clean layered structure (Controller → Service → Repository)
-  MySQL database integration using JPA/Hibernate
-  RESTful endpoints for easy frontend integration
-  Maven build system

---

##  System Architecture

Client (Postman / Frontend)  
↓  
Controller Layer (API Requests)  
↓  
Service Layer (Business Logic)  
↓  
Repository Layer (Database Access)  
↓  
MySQL Database  

---

## 📂 Project Structure

src/main/java/com/example/quizapp  
│  
├── controller        → REST APIs    
├── service           → Service implementation  
├── repository        → Database operations  
├── model             → Entity classes  
└── Exam Portal → Main Spring Boot class  

src/main/resources  
├── application.properties  
└── static (optional frontend files)  

---

## 🔗 REST API Endpoints

| Method | Endpoint           | Description        |
|--------|-------------------|--------------------|
| GET    | /quiz/all         | Get all questions  |
| GET    | /quiz/{id}        | Get question by ID |
| POST   | /quiz/add         | Add new question   |
| PUT    | /quiz/update/{id} | Update question    |
| DELETE | /quiz/delete/{id} | Delete question    |

---

## ⚙️ Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- REST APIs

---

## 🛠️ Setup Instructions

### 1. Clone Repository
git clone https://github.com/your-username/Exam Portal System.git

---

### 2. Configure Database

Update `application.properties`:

spring.datasource.url=jdbc:mysql://localhost:3306/quizdb  
spring.datasource.username=root  
spring.datasource.password=yourpassword  

spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true  

---

### 3. Run Application

mvn spring-boot:run

---

##  What This Project Demonstrates

- Strong understanding of Spring Boot architecture
- REST API design principles
- Database integration using MySQL
- Clean code separation using MVC pattern
- Backend development skills

---

##  Future Enhancements

- JWT Authentication (Login system)
- User roles (Admin/User)
- Quiz scoring system
- Timer-based quiz feature
- Frontend integration (React / Angular)

---

##  Author

Name: Ankit    
Project:Exam Portal System

---

##  Status

✔ Backend Completed  
 Frontend Completed
