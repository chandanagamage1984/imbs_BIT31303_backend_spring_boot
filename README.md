☕ Employee Management System Backend (Spring Boot)
This repository holds the backend API for the Employee Management System, built with Spring Boot and Java. It provides robust RESTful services for managing employee and department data, typically consumed by a frontend application like an Angular UI.

🚀 Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing.

Prerequisites
You will need the following installed:

Java Development Kit (JDK) (version 17 or higher recommended).

Apache Maven (for dependency management and building).

SQL Database (MySQL, PostgreSQL, or H2/HSQLDB for development).

IDE (IntelliJ IDEA or VS Code with Spring extensions).

Installation and Setup
Clone the repository:

Bash

git clone https://github.com/chandanagamage1984/imbs_BIT31303_backend_spring_boot.git

cd imbs_BIT31303_backend_spring_boot

Build the project:

Bash

mvn clean install
Configure the Database Connection:

Open the src/main/resources/application.yml file.

Update the database properties under the spring.datasource section.

Example application.yml for MySQL:

YAML

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/bit31303_emp_mgt_sys
    username: root
    password: your_database_password
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      # Use 'update' to automatically create/update the schema during development
      # Use 'none' or 'validate' for production
      ddl-auto: update
    show-sql: true
(Note: If you are using a relational database, Spring Boot's JPA/Hibernate will handle table creation based on your entity models if ddl-auto is set to update.)

▶️ Running the Application
1. Run via CLI (Maven)
Execute the Spring Boot application directly using Maven:

Bash

mvn spring-boot:run
2. Run via Executable JAR
If you have built the JAR file:

Bash

java -jar target/your-project-name.jar
The application will typically start on HTTP port 8080 by default, unless configured otherwise in application.yml.

⚙️ Configuration
The primary configuration is done in src/main/resources/application.yml. Key server settings include:

Property	Default	Description
server.port	8080	The port the application runs on.
spring.datasource.url	N/A	JDBC connection string for the database.
spring.jpa.hibernate.ddl-auto	none	Controls database schema generation (create, update, validate).
spring.mvc.servlet.path	/	Base path for all REST controllers (e.g., /api).

API Base Path
Assuming your controllers are mapped to /api (e.g., @RequestMapping("/api/employees")), the base URL for the API is usually: http://localhost:8080/api.

🧱 API Endpoints
The API provides endpoints for standard CRUD operations:

Departments API
Method	Endpoint	Description
GET	/api/departments	Retrieves all departments.
GET	/api/departments/{id}	Retrieves a single department by ID.
POST	/api/departments	Creates a new department.
PUT	/api/departments/{id}	Updates an existing department.
DELETE	/api/departments/{id}	Deletes a department.

Employees API
Method	Endpoint	Description
GET	/api/employees	Retrieves all employees.
GET	/api/employees/{id}	Retrieves a single employee by ID.
POST	/api/employees	Creates a new employee.
PUT	/api/employees/{id}	Updates an existing employee.
DELETE	/api/employees/{id}	Deletes an employee.

🤝 Contribution
Contributions are welcome! Please fork the repository and submit a pull request with your suggested changes.
