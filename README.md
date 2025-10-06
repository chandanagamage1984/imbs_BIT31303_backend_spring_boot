# Employee Management System - Spring Boot Backend
A robust Spring Boot backend for the Employee Management System, providing RESTful APIs for managing employees, departments, and their relationships. Built with Spring Boot 3.2, JPA/Hibernate, and MySQL.

https://img.shields.io/badge/Spring%2520Boot-3.2-green

https://img.shields.io/badge/Java-17-orange

https://img.shields.io/badge/MySQL-8.0-blue

https://img.shields.io/badge/JPA-Hibernate-lightgrey

https://img.shields.io/badge/Maven-3.6+-red

## 🚀 Features
### Core Functionality
* ✅ Employee Management - Complete CRUD operations for employees

* ✅ Department Management - Full department lifecycle management

* ✅ Employee-Department Relationships - Many-to-many relationships with projects

* ✅ RESTful APIs - Clean, consistent API design

* ✅ Data Validation - Comprehensive input validation and error handling

* ✅ DTO Pattern - Separation of concerns with Data Transfer Objects

### Technical Features
* 🗄️ JPA/Hibernate - Object-relational mapping with MySQL

* 🔒 Data Validation - Bean validation with proper error messages

* 📊 Pagination & Sorting - Ready for large datasets

* 🎯 Custom Queries - Advanced search and filtering capabilities

* 🛡️ Error Handling - Global exception handling with meaningful responses

* 📝 API Documentation - Clean and consistent API structure

## 🛠️ Technology Stack
### Backend
* Spring Boot 3.2 - Main application framework

* Spring Data JPA - Data access layer

* Spring Web - RESTful web services

* Hibernate - JPA implementation

* Bean Validation - Input validation

* Lombok - Reduced boilerplate code

### Database
* MySQL 8.0 - Primary database

* H2 Database - In-memory database for testing

### Build & Dependency Management
* Maven - Build automation and dependency management

* Java 17 - Runtime environment

## 📋 Prerequisites
Before running this application, ensure you have the following installed:

* Java 17 or higher - Download here

* Maven 3.6 or higher - Download here

* MySQL 8.0 or higher - Download here

* Git - For version control

## ⚙️ Installation & Setup
### 1. Clone the Repository
bash
```
git clone <repository-url>
cd employees-management-system-backend
```

## 2. Database Setup
### Create MySQL Database
sql
```
CREATE DATABASE bit31303_emp_mgt_sys;
CREATE USER 'emp_user'@'localhost' IDENTIFIED BY 'emp_password';
GRANT ALL PRIVILEGES ON bit31303_emp_mgt_sys.* TO 'emp_user'@'localhost';
FLUSH PRIVILEGES;
```

### Manual Schema Creation (Optional)
sql
```
CREATE DATABASE IF NOT EXISTS bit31303_emp_mgt_sys;
USE bit31303_emp_mgt_sys;

CREATE TABLE IF NOT EXISTS departments (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    location VARCHAR(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    email VARCHAR(128) UNIQUE NOT NULL,
    phone VARCHAR(10),
    salary DOUBLE,
    department_id INT NOT NULL,
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

CREATE TABLE IF NOT EXISTS projects (
    project_id INT AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(128) NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS employee_projects (
    employee_id INT NOT NULL,
    project_id INT NOT NULL,
    PRIMARY KEY (employee_id, project_id),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
    FOREIGN KEY (project_id) REFERENCES projects(project_id)
);
```

### 3. Configuration
Update src/main/resources/application.yml with your database credentials:

yaml
```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/bit31303_emp_mgt_sys?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: root
    password: your_db_password
  
  jpa:
    database-platform: org.hibernate.dialect.MySQLDialect
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.MySQL8Dialect

server:
  port: 8080

logging:
  level:
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
```

### 4. Build the Application
bash
```
# Clean and build the project
mvn clean compile

# Build the JAR file
mvn clean package

# Skip tests during build
mvn clean package -DskipTests
```

### 5. Run the Application
#### Option 1: Using Maven
bash
```
mvn spring-boot:run
```

### 6. Verify Installation
The application will start on http://localhost:8080. You can test the API with:

bash
```
# Test if application is running
curl http://localhost:8080/api/departments

# Or open in browser
http://localhost:8080/api/departments
```

## 📁 Project Structure
text
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── employeesmanagement/
│   │           ├── EmployeesManagementSystemApplication.java
│   │           ├── model/
│   │           │   ├── Employee.java
│   │           │   ├── Department.java
│   │           │   ├── Project.java
│   │           │   └── EmployeeProject.java
│   │           ├── dto/
│   │           │   ├── EmployeeWithDepartmentDto.java
│   │           │   ├── EmployeeInputDto.java
│   │           │   ├── EmployeeProjectDetailDto.java
│   │           │   └── EmployeeProjectInputDto.java
│   │           ├── repository/
│   │           │   ├── EmployeeRepository.java
│   │           │   ├── DepartmentRepository.java
│   │           │   ├── ProjectRepository.java
│   │           │   └── EmployeeProjectRepository.java
│   │           ├── service/
│   │           │   ├── EmployeeService.java
│   │           │   ├── DepartmentService.java
│   │           │   ├── ProjectService.java
│   │           │   └── EmployeeProjectService.java
│   │           └── controller/
│   │               ├── EmployeesController.java
│   │               ├── DepartmentsController.java
│   │               ├── ProjectsController.java
│   │               └── EmployeeProjectsController.java
│   └── resources/
│       ├── application.yml
│       └── data.sql (optional)
└── test/
    └── java/
        └── com/employeesmanagement/
            └── EmployeesManagementSystemApplicationTests.java
```

## 🎯 API Endpoints
### Employee Endpoints
| Method   | Endpoint             | Description                               |
| -------- | -------------------- | ----------------------------------------- |
| GET	     | /api/employees	      | Get all employees with department details |
| GET	     | /api/employees/{id}	| Get employee by ID                        |
| POST	   | /api/employees	      | Create new employee                       |
| PUT	     | /api/employees/{id}	| Update employee                           |
| DELETE	 | /api/employees/{id}	| Delete employee                           |

### Department Endpoints
| Method   | Endpoint                | Description            |
| -------- | ----------------------- | ---------------------- |
| GET	     | /api/departments	       | Get all departments    |
| GET	     | /api/departments/{id}	 | Get department by ID   |
| POST	   | /api/departments	       | Create new department  |
| PUT	     | /api/departments/{id}	 | Update department      |
| DELETE	 | /api/departments/{id}	 | Delete department      |

### Project Endpoints
| Method   | Endpoint                | Description            |
| -------- | ----------------------- | ---------------------- |
| GET	     | /api/projects	         | Get all projects       |
| GET	     | /api/projects/{id}	     | Get projects by ID     |
| POST	   | /api/projects	         | Create new project     |
| PUT	     | /api/projects/{id}	     | Update project         |
| DELETE	 | /api/projects/{id}	     | Delete project         |

### Employee-Project Assignment Endpoints
| Method   | Endpoint                                    | Description                          |
| -------- | ------------------------------------------- | ------------------------------------ |
| GET	     | /api/employeeprojects	                     | Get all employee-project assignments |
| GET	     | /api/employeeprojects/employee/{employeeId} | Get projects by employee             |
| GET	     | /api/employeeprojects/project/{projectId}	 | Get employees by project             |
| POST	   | /api/employeeprojects	                     | Assign employee to project           |
| PUT	     | /api/employeeprojects	                     | Update assignment                    |
| DELETE	 | /api/employeeprojects	                     | Remove assignment                    |

## 🤝 Integration with Frontend
### Angular Frontend Configuration
Update your Angular environment configuration:

typescript
```
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api'
};
```
