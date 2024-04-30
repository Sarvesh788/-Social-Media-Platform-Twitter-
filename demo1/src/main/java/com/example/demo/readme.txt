# Project Name

## Overview
This project is built using Java, Spring Boot, and Maven.

## Directory Structure
.
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   ├── example
│   │   │   │   │   ├── demo
│   │   │   │   │   │   ├── Controller
│   │   │   │   │   │   ├── DTO
│   │   │   │   │   │   ├── Entity
│   │   │   │   │   │   ├── Repository
│   │   │   │   │   │   ├── Service
│   │   │   │   │   │   ├── Demo1Application.java
│   │   ├── resources
│   ├── test
├── pom.xml
├── readme.txt

## Classes Overview

### Controllers

#### UserController
This controller handles user-related operations such as sign up, sign in, and user details retrieval. It interacts with the `UserRepository` to perform CRUD operations on the `Users` entity.

#### PostController
This controller manages post-related operations such as creating, retrieving, editing, and deleting posts. It interacts with the `PostRepository` to perform CRUD operations on the `Post` entity.

#### CommentController
This controller handles comment-related operations such as creating, retrieving, editing, and deleting comments. It interacts with the `CommentRepository` to perform CRUD operations on the `Comment` entity.

### Models

#### User
This model represents a user in the application. It includes attributes such as ID, email, name, and password.

#### Post
This model represents a post made by a user. It includes attributes such as post ID, post body, date, and comments.

#### Comment
This model represents a comment made on a post. It includes attributes such as comment ID, comment body, and user.

### Repositories

#### UserRepository
This repository provides methods for performing CRUD operations on the `Users` entity.

#### PostRepository
This repository provides methods for performing CRUD operations on the `Post` entity.

#### CommentRepository
This repository provides methods for performing CRUD operations on the `Comment` entity.

### Services
Services in this application handle the business logic and interact with the repositories to perform operations on the database.

### DTOs
Data Transfer Objects (DTOs) are used to transfer data between processes. In this application, DTOs are used to send data from the client to the server and vice versa.

## Technologies Used
- Java
- Spring Boot
- Hibernate
- REST API
- Maven

## Setup
1. Clone the repository.
2. Install dependencies using Maven.
3. Run the application.

## Usage
Use the provided endpoints to interact with the application (e.g., via Postman).
Refer to the API documentation for detailed usage instructions.