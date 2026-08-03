

```markdown
# Student Management REST API

A clean, production-ready **Student Management System** built with **Spring Boot 3**, **Spring Data JPA**, and **Hibernate**. 

This project demonstrates proper 3-tier layered architecture, RESTful API design standards, soft-deletion mechanisms, and relational database persistence.

---

## 📸 System Architecture & Workflow


```

```
           +-----------------------------------------------------+
           |                 Student Entity                      |
           +-------------------+------------------+--------------+
                               |                  |
                               v                  v

```

+----------+   HTTP Request   +------------+     +----------+     +------------+     +----------+
|          | ---------------->|  Student   |---->| Student  |---->|  Student   |---->|          |
| Postman  |                  | Controller |     | Service  |     | Repository |     | Database |
|          | <----------------| (Endpoints)|<----| (Logic)  |<----|  (JPA/DB)  |<----|          |
+----------+   HTTP Response  +------------+     +----------+     +------------+     +----------+

```

---

## ✨ Features

* **Layered Architecture:** Clear separation of concerns into Controller, Service, and Repository layers.
* **RESTful Endpoints:** Standardized resource URIs (`/api/students`) with appropriate HTTP verbs (`POST`, `GET`, `PUT`, `DELETE`, `PATCH`).
* **Soft Delete Mechanism:** Includes soft-deletion (`/soft-delete`) to preserve historical data integrity alongside hard deletion (`DELETE`).
* **Derived JPA Query Methods:** Filtered fetches ensuring soft-deleted records are automatically excluded from active queries.
* **Standard Status Codes:** Correct HTTP responses (`201 Created`, `200 OK`, `204 No Content`, `404 Not Found`).

---

## 🛠️ Tech Stack

* **Language:** Java 17+
* **Framework:** Spring Boot 3.x
* **Data Access:** Spring Data JPA / Hibernate
* **Database:** PostgreSQL / MySQL / H2
* **Build Tool:** Maven
* **Testing & API Tool:** Postman

---

## 🚀 Getting Started

### Prerequisites

Ensure you have the following installed:
* **JDK 17** or higher
* **Maven 3.8+**
* **MySQL / PostgreSQL** (or use H2 in-memory DB)

### Configuration

Update your `src/main/resources/application.properties` with your database credentials:

```properties
spring.application.name=Basic_CRUD_App

# Database Configuration (PostgreSQL Example)
spring.datasource.url=jdbc:postgresql://localhost:5432/student_db
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA / Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

```



## 📡 API Endpoints Specification

| Method | Endpoint | Description | Request Body / Parameters | Success Response |
| --- | --- | --- | --- | --- |
| **POST** | `/api/students` | Create a new student | JSON Payload | `201 Created` |
| **GET** | `/api/students` | Fetch all active students | None | `200 OK` |
| **GET** | `/api/students/{id}` | Fetch active student by ID | Path Variable (`id`) | `200 OK` / `404 Not Found` |
| **PUT** | `/api/students/{id}` | Update existing student | Path Variable (`id`), JSON Payload | `200 OK` / `404 Not Found` |
| **PATCH** | `/api/students/{id}/soft-delete` | Mark student as soft-deleted | Path Variable (`id`) | `200 OK` / `404 Not Found` |
| **DELETE** | `/api/students/{id}` | Hard delete student permanently | Path Variable (`id`) | `204 No Content` / `404 Not Found` |

---

## 🧪 Sample Request Payloads

### Create Student (`POST /api/students`)

```json
{
  "name": "Liam O'Connor",
  "mail": "liam.oconnor@analytics.io",
  "gender": "Male",
  "stream": "Data Science & AI"
}

```

### Update Student (`PUT /api/students/1`)

```json
{
  "name": "Devon M. Miles",
  "mail": "devon.miles.senior@foundation.com",
  "gender": "Male",
  "stream": "Robotics Engineering"
}

```

---

## 📄 License

This project is open-source and available under the [MIT License](https://www.google.com/search?q=LICENSE).

```

```
