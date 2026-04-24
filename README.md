# 🚀 TaskFlow Backend

A production-ready Task Management API built using Spring Boot with Google OAuth2 authentication.

---

## ✨ Features

* 🔐 Google OAuth2 Login (No JWT, session-based authentication)
* 📌 Task Management (CRUD)
* 🧑 User auto-registration via Google
* 📊 Task status tracking (TODO, IN_PROGRESS, DONE)
* ⚡ Priority support (LOW, MEDIUM, HIGH)
* 🗂 Clean layered architecture
* 🌐 RESTful APIs
* 🔒 Secure endpoints with Spring Security

---

## 🛠 Tech Stack

* Java 17
* Spring Boot
* Spring Security (OAuth2)
* Spring Data JPA
* PostgreSQL
* Lombok

---

## 🔐 Authentication Flow

1. User clicks "Login with Google"
2. Redirected to Google OAuth2
3. Backend receives callback
4. User is created/updated in DB
5. Session is established (JSESSIONID)

---

## 📂 Project Structure

```
com.taskflow
├── controller
├── service
├── repository
├── entity
├── security
├── config
└── exception
```

---

## 🚀 Getting Started

### 1. Clone Repo

```
git clone https://github.com/your-username/taskflow-backend.git
```

### 2. Configure Database

Update `application.yml` with PostgreSQL credentials

### 3. Add Google OAuth Credentials

```
spring.security.oauth2.client.registration.google.client-id=YOUR_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_CLIENT_SECRET
```

### 4. Run Application

```
./mvnw spring-boot:run
```

---

## 🔗 API Endpoints

| Method | Endpoint        | Description        |
| ------ | --------------- | ------------------ |
| GET    | /api/me         | Get logged-in user |
| POST   | /api/tasks      | Create task        |
| GET    | /api/tasks      | Get user tasks     |
| PUT    | /api/tasks/{id} | Update task        |
| DELETE | /api/tasks/{id} | Delete task        |

---

## 📌 Future Enhancements

* Redis session management
* Docker + CI/CD
* Role-based access
* Notifications system

---

## 👨‍💻 Author

Built by Joe 🚀
