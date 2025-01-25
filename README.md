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
- Spring Boot (3.x)
- Spring Data JPA
- MySQL (or H2 for in-memory database)

### Frontend
- Thymeleaf
- HTML/CSS
- Bootstrap (for styling, optional)

---

## Getting Started

### Prerequisites
Ensure you have the following installed on your system:
- Java 17+
- Maven 3.8+
- MySQL Server (if using MySQL as the database)

### Clone the Repository
```bash
git clone https://github.com/your-username/repo-name.git
cd repo-name
```

### Configuration
1. Open the `application.properties` file located in `src/main/resources/`.
2. Update the database configuration:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password

   spring.jpa.hibernate.ddl-auto=update
   ```

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
- Navigate to the "Add New Entry" page.
- Fill out the form and submit.

### 2. Read
- The homepage displays a list of all entries in the database.

### 3. Update
- Click on the "Edit" button next to an entry.
- Modify the fields and save changes.

### 4. Delete
- Click on the "Delete" button next to an entry.

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
│       │   └── css/
│       ├── templates/
│       │   ├── index.html
│       │   ├── create.html
│       │   └── edit.html
│       └── application.properties
└── test/
```

---

## Contributing
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new branch for your feature.
3. Commit your changes.
4. Submit a pull request.

---

## License
This project is licensed under the [MIT License](LICENSE).

---

## Author
[Neeraj Panchal](https://github.com/your-username)

---

## Acknowledgements
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Thymeleaf Documentation](https://www.thymeleaf.org/)

