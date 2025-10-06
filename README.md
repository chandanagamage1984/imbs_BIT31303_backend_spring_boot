Employee Management System
A modern, responsive web application for managing employees and departments built with Angular and Angular Material. This application provides a complete CRUD (Create, Read, Update, Delete) interface with search functionality and works with both ASP.NET Core and Spring Boot backends.

https://img.shields.io/badge/Angular-17-red https://img.shields.io/badge/Spring%2520Boot-3.2-green https://img.shields.io/badge/ASP.NET%2520Core-7-blue https://img.shields.io/badge/Material%2520Design-3-757575

🚀 Features
Employee Management
✅ View All Employees - Complete list with sorting and pagination

✅ Add New Employees - Modal form with validation

✅ Edit Employees - Inline editing with form validation

✅ Delete Employees - Confirmation dialog for safe deletion

✅ Search Employees - By ID, department, or free text search

✅ Responsive Design - Works on desktop, tablet, and mobile

Department Management
✅ View All Departments - Organized list with department details

✅ Add New Departments - Simple form with required fields

✅ Edit Departments - Quick editing of department information

✅ Delete Departments - Safe deletion with confirmation

✅ Search Departments - By ID, name, or location

Technical Features
🎨 Angular Material UI - Modern, accessible Material Design components

📱 Fully Responsive - Optimized for all screen sizes

🔍 Advanced Search - Multiple search criteria and filters

⚡ Real-time Validation - Form validation with user feedback

🛡️ Error Handling - Comprehensive error handling and user notifications

🔄 Loading States - Visual feedback during API operations

🛠️ Technology Stack
Frontend
Angular 17 - Modern web framework

Angular Material 17 - UI component library

TypeScript - Type-safe JavaScript

RxJS - Reactive programming library

SCSS - Advanced CSS with variables and mixins

Backend (Choose One)
Spring Boot 3.2 - Java-based backend with JPA/Hibernate

ASP.NET Core 7 - C#-based backend with Entity Framework

📋 Prerequisites
Before running this application, ensure you have the following installed:

Node.js (version 16 or higher) - Download here

npm (comes with Node.js) or yarn

Angular CLI (version 17) - Install with:

bash
npm install -g @angular/cli@17
Backend Requirements (Choose One)
For Spring Boot:
Java 17 or higher

Maven 3.6 or higher

MySQL 8.0 or higher

For ASP.NET Core:
.NET 7 SDK or higher

Visual Studio 2022 or Visual Studio Code

SQL Server or MySQL

⚙️ Installation & Setup
1. Clone the Repository
bash
git clone <repository-url>
cd employee-management-ui
2. Install Dependencies
bash
npm install
3. Environment Configuration
Development Environment
Update src/environments/environment.ts:

For Spring Boot:

typescript
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api'
};
For ASP.NET Core:

typescript
export const environment = {
  production: false,
  apiUrl: 'https://localhost:7000/api'
};
Production Environment
Update src/environments/environment.prod.ts:

typescript
export const environment = {
  production: true,
  apiUrl: '/api'  // Relative URL for same domain deployment
};
4. Backend Setup
Option A: Spring Boot Backend
Ensure your Spring Boot application is running on http://localhost:8080

Database should be running and accessible

Verify API endpoints are available at /api/employees and /api/departments

Option B: ASP.NET Core Backend
Ensure your ASP.NET Core application is running on https://localhost:7000

Database should be configured and running

Verify API endpoints are available at /api/employees and /api/departments

5. Development Proxy (Optional)
For development with CORS issues, use the proxy configuration in proxy.conf.json:

json
{
  "/api": {
    "target": "http://localhost:8080",
    "secure": false,
    "changeOrigin": true
  }
}
🚀 Running the Application
Development Server
bash
# Start the Angular development server
ng serve

# Or with specific port
ng serve --port 4200

# The application will be available at:
# http://localhost:4200
Build for Production
bash
# Build the project
ng build

# Build with production configuration
ng build --configuration=production

# The build artifacts will be stored in the `dist/` directory
Running Tests
bash
# Unit tests
ng test

# End-to-end tests
ng e2e

# Code linting
ng lint
📁 Project Structure
text
src/
├── app/
│   ├── components/
│   │   ├── employee/
│   │   │   ├── employee-list/          # Employee list component
│   │   │   └── employee-form/          # Employee form component
│   │   └── department/
│   │       ├── department-list/        # Department list component
│   │       └── department-form/        # Department form component
│   ├── models/                         # TypeScript interfaces
│   │   ├── employee.model.ts
│   │   └── department.model.ts
│   ├── services/                       # API services
│   │   ├── employee.service.ts
│   │   └── department.service.ts
│   ├── material.module.ts              # Angular Material imports
│   └── app.module.ts                   # Main application module
├── assets/                             # Static assets
├── environments/                       # Environment configurations
└── styles.scss                         # Global styles
🎯 API Endpoints
The application expects the following REST API endpoints:

Employee Endpoints
GET /api/employees - Get all employees

GET /api/employees/{id} - Get employee by ID

POST /api/employees - Create new employee

PUT /api/employees/{id} - Update employee

DELETE /api/employees/{id} - Delete employee

GET /api/employees?departmentId={id} - Search by department

Department Endpoints
GET /api/departments - Get all departments

GET /api/departments/{id} - Get department by ID

POST /api/departments - Create new department

PUT /api/departments/{id} - Update department

DELETE /api/departments/{id} - Delete department

🎨 UI Components
Employee Management
Employee List: Table view with sorting, pagination, and search

Employee Form: Modal dialog for adding/editing employees

Search Filters: Search by ID, department, or free text

Department Management
Department List: Clean table with department details

Department Form: Simple form for department management

Search Functionality: Find departments by ID or name

🔧 Configuration
Customizing Styles
Modify src/styles.scss for global styles

Component-specific styles are in respective .scss files

Color scheme can be customized in Angular Material theme

Adding New Features
Create components in appropriate feature folders

Add routes in app.module.ts

Create services for API calls

Define models for data structures

🐛 Troubleshooting
Common Issues
CORS Errors:

Ensure backend has CORS configured

Use proxy configuration during development

Check API URL in environment files

Build Errors:

Verify Node.js and Angular CLI versions

Clear node_modules and reinstall dependencies:

bash
rm -rf node_modules
npm install
API Connection Issues:

Verify backend is running

Check API URLs in environment configuration

Inspect browser network tab for detailed errors

Styling Issues:

Ensure Angular Material is properly imported

Check SCSS compilation errors

Verify component style encapsulation
