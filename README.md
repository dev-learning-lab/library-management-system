<div align="center">

# 📚 Library Management System API

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge&logo=spring-boot)
![MongoDB](https://img.shields.io/badge/MongoDB-latest-green?style=for-the-badge&logo=mongodb)


# 📚 Library Management System FRONT

![HTML5](https://img.shields.io/badge/HTML5-orange?style=for-the-badge&logo=html5)
![CSS3](https://img.shields.io/badge/CSS3-blue?style=for-the-badge&logo=css3)
![JavaScript](https://img.shields.io/badge/JavaScript-yellow?style=for-the-badge&logo=javascript)


**REST API built with Spring Boot and MongoDB for comprehensive library management**

*This project is being developed to practice backend development, clean architecture, and professional team collaboration using Git workflows.*


[Planned Features](#-planned-features) • [Tech Stack](#-tech-stack) 

</div>

---

## 🎯 Project Overview

A comprehensive Library Management System API that will handle:

- 📖 **Book Management** - Complete CRUD operations for library inventory


This project emphasizes **clean code**, **scalable architecture**, and **industry best practices** in backend development.

---

## ✨ Planned Features

### 📚 Book Management
- [ ] Create, read, update, and delete books
- [ ] Search books by title
- [ ] Filter books by category/genre
- [ ] Track book availability status
- [ ] Manage multiple copies of the same book
- [ ] rent books

---

## 🏗️ Project Architecture

The project follows a **layered architecture** pattern for maintainability and scalability:
```
Controller → Service → Repository → Database
```

### Architecture Layers
```
📁 library-system/
├── 📂 src/main/java/com/Dev_Learning_Lab/library_system/
│   ├── 📂 controller/          # HTTP Request Handlers
│   │   └── LibraryController.java
│   ├── 📂 service/             # Business Logic Layer
│   │   └── LibraryService.java
│   ├── 📂 repository/          # Data Access Layer
│   │   └── LibraryRepository.java
│   └── 📂 model/               # Domain Entities
│       └── Library.java
├── 📂 src/main/resources/
│   ├── 📂 static/              # Frontend Assets
│   │   ├── 📂 css/
│   │   │   └── Style.css
│   │   └── 📂 javascript/
│   │       └── App.js
│   ├── Index.html
│   └── application.properties  # Configuration
└── pom.xml                     # Maven Dependencies
```

### Layer Responsibilities

| Layer | Responsibility |
|-------|---------------|
| **Controller** | Handles HTTP requests/responses, validates input, returns appropriate status codes |
| **Service** | Contains business logic, orchestrates operations, enforces business rules |
| **Repository** | Manages data persistence, executes database queries, handles data mapping |
| **Model** | Represents domain entities and their relationships |

---

## 🛠️ Tech Stack

<div align="center">

### Backend
![Java](https://img.shields.io/badge/Java_17-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_3.x-6DB33F?style=flat-square&logo=spring&logoColor=white)
![Spring Data](https://img.shields.io/badge/Spring_Data_MongoDB-6DB33F?style=flat-square&logo=spring&logoColor=white)

### Database
![MongoDB](https://img.shields.io/badge/MongoDB-47A248?style=flat-square&logo=mongodb&logoColor=white)

### Build & Tools
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apache-maven&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white)

### Frontend
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=flat-square&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=javascript&logoColor=black)

</div>

### Key Technologies

- **Java 17** - Modern LTS version with latest features
- **Spring Boot 3.x** - Rapid application development framework
- **Spring Data MongoDB** - Simplified database operations
- **MongoDB** - NoSQL database for flexible schema design
- **Maven** - Dependency management and build automation
- **Git & GitHub** - Version control and collaboration


---


## 🚀 Getting Started

> **Note:** This project is currently in development. Setup instructions will be updated as the project progresses.

### Prerequisites

Before you begin, ensure you have the following installed:

- ☕ **Java Development Kit (JDK) 17** or higher
- 🍃 **MongoDB** (Community Edition)
- 📦 **Maven 3.6+**
- 🔧 **IDE** (IntelliJ IDEA or VS Code with Java extensions)
- 🌿 **Git**


---


## 👥 Team

<div align="center">

| Developer | Role | GitHub |
|-----------|------|--------|
| **Angel0zzx** | Full-Stack Developer | [@Angel0zzx](https://github.com/Angel0zzx) |
| **torgohd** | Full-Stack Developer | [@torgohd-sketch](https://github.com/torgohd-sketch) |
| **Julianzzx** | Backend Developer | [@Julianzzx](https://github.com/Julianzzx) |

</div>

---


<div align="center">

### ⭐ Star this repo if you find it helpful!

**Made with ☕ and Spring Boot**

[⬆ Back to Top](#-library-management-system-api)

</div>
