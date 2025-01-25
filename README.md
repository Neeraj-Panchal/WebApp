# CRUD Web Application

## Overview
This is a simple CRUD (Create, Read, Update, Delete) web application built using Spring Boot for the backend and Thymeleaf for the frontend. The application demonstrates basic operations on a data entity and provides a user-friendly interface to interact with the data.

---

## Features
- Add new entries to the database
- View a list of entries
- Update existing entries
- Delete entries
- Input validation for forms

---

## Technologies Used
### Backend
- Java
- Spring Boot
- Spring Data JPA
- MySQL

### Frontend
- Thymeleaf
- HTML
- Bootstrap (for styling)

---

## Getting Started

### Prerequisites
Ensure you have the following installed on your system:
- Java 17+
- Maven 3.8+
- MySQL Server (if using MySQL as the database)
- or you may use Xampp server 


### Configuration
1. Open the `application.properties` file located in `src/main/resources/`.
2. Update the database configuration:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password

   spring.jpa.hibernate.ddl-auto=update
   ```
3.Here i use database with different name you may give your database name on the place of "your_database_name"

### Run the Application
1. Build the project:
   ```bash
   mvn clean install
   ```
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```
3. Access the application in your browser at:
   ```
   http://localhost:8080
   ```

---

## Usage
### 1. Create
- Navigate to the "Add New Client" page.
- Fill out the form and submit.

### 2. Read
- The homepage displays a list of all entries in the database.

### 3. Update
- Click on the "Edit" button next to an Client Details .
- Modify the fields and save changes.

### 4. Delete
- Click on the "Delete" button next to the Update button.

---

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com.example.crudapp/
│   │       ├── controller/
│   │       ├── entity/
│   │       ├── repository/
│   │       └── service/
│   └── resources/
│       ├── static/
│       │   
│       ├── templates/
│       │   ├── index.html
│       │   ├── create.html
│       │   └── edit.html
│       └── application.properties
└── test/
```


## Acknowledgements
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Thymeleaf Documentation](https://www.thymeleaf.org/)

