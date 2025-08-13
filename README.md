# E-Commerce Web Application - Backend

## Overview
This backend for an E-Commerce Web Application is built with Java and Spring Boot. It provides RESTful APIs for product management including CRUD operations, image upload/download, product filtering, and stock management. PostgreSQL is used as the database with Spring Data JPA for ORM.

## Tech Stack
Java, Spring Boot, Spring Data JPA, PostgreSQL, RESTful APIs, Maven, Git.

## Features
- Developed RESTful APIs using Spring Boot and Spring Data JPA for product catalog CRUD operations.
- Designed and implemented PostgreSQL database schema for efficient product and image data storage.
- Implemented multipart file upload/download endpoints for product images.
- Created API endpoints for filtering products, stock checking, and detailed product retrieval.
- Ensured robust error handling and input validation in backend services.
- Integrated backend APIs with frontend clients using RESTful API design principles.
- Utilized Git and GitHub for version control and collaborative development.

## Setup Instructions
1. Clone the repository: ```bash git clone <your-repo-url> cd <your-project-directory> ```
2. Configure PostgreSQL: Create a database for the application. Update application.properties with your database credentials: ``` ini spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name spring.datasource.username=your_username spring.datasource.password=your_password ```
3. Build and run the application: ```bash mvn clean install mvn spring-boot:run ```

## API Endpoints
- `GET /api/product` - List all products
- `GET /api/product/{id}` - Get product details by ID
- `POST /api/product` - Create a new product with image upload
- `PUT /api/product/{id}` - Update product details and image
- `DELETE /api/product/{id}` - Delete a product
- `GET /api/product/{id}/image` - Retrieve product image

## Notes
- Images stored as byte arrays in the database.
- Release dates formatted as `dd-MM-yyyy`.
- Stock quantity and availability properly managed.
- Backend developed for scalability, maintainability, and clean architecture.

Feel free to contribute or raise issues.
