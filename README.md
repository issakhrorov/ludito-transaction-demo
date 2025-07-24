# 💸 Transaction Service (Demo Project)

A Spring Boot REST API for managing users and their financial transactions.

---

## 🔧 Tech Stack

- Java 21
- Spring Boot 3.x
- PostgreSQL
- Gradle (Kotlin DSL or Groovy)
- Docker

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/issakhrorov/ludito-transaction-demo.git
cd ludito-transaction-demo
```

⸻

### 2. Create .env File

```# .env
SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/ludito_demo
SPRING_DATASOURCE_USERNAME=your_username
SPRING_DATASOURCE_PASSWORD=your_password
```

⸻

### 3. Create PostgreSQL Database

You can use your local PostgreSQL database or run PostgreSQL inside Docker.

#### If using local PostgreSQL:

Connect to your PostgreSQL server (e.g., via `psql`), then create the database:

```sql
CREATE DATABASE ludito_demo;
```

### 4. Run Locally (Development)

With Intellij IDEA or any IDE:

- Change spring profile on Dockerfile to dev 

With Maven:

```bash
mvn spring-boot:run
```

With Docker:

```bash
chmod +x wait-for-postgres.sh # Make sure the script is executable
docker compose up --build
```

⸻

API Endpoints

### Authentication
| Method | Endpoint          | Description               |
|--------|-------------------|---------------------------|
| POST   | /auth/register    | Register a new user       |
| POST   | /auth/login       | Login user and get token  |

### Users
| Method | Endpoint                | Description                      |
|--------|-------------------------|----------------------------------|
| GET    | /users/all              | Get all users                    |
| GET    | /users/{id}             | Get user by ID                  |
| GET    | /users/email/{email}    | Get user by email               |
| GET    | /users/me               | Get current authenticated user  |
| PUT    | /users/me               | Update current authenticated user|
| DELETE | /users/me               | Delete current authenticated user|

### Transactions
| Method | Endpoint                              | Description                             |
|--------|-------------------------------------|-----------------------------------------|
| POST   | /transactions/                      | Create a new transaction                |
| GET    | /transactions/all                   | Get all transactions                    |
| GET    | /transactions/all?user_id={id}     | Get transactions filtered by user ID   |
| GET    | /transactions/all?from=YYYY-MM-DD&to=YYYY-MM-DD | Get transactions by date range       |
| GET    | /transactions/all/me                | Get all transactions for current user  |
| GET    | /transactions/check-success/success/{id} | Check success status of a transaction by ID |
| GET    | /transactions/check-success/failure/{id} | Check failure status of a transaction by ID |                              | Create a new transaction       |

⸻

🧪 Example Request (cURL)

```bash
curl -X POST http://localhost:8080/demo_transaction/api/v1/auth/register \
  -H "Content-Type: application/json" \
  -d '{"firstName": "John", "lastName": "Doe", "email": "john@example.com", "password": "12345"}'
```

⸻

📂 Folder Structure

```plaintext
src
├── main
│   ├── java
│   │   └── ludito.demo_transaction
│   │       ├── config
│   │       ├── controller
│   │       ├── dto
│   │       ├── enums
│   │       ├── exception   
│   │       ├── model
│   │       ├── populator
│   │       ├── repository
│   │       ├── service
│   │       └── DemoTransactionApplication.kt
│   └── resources
│       └── application.yml
│       └── application-dev.yml
│       └── application-demo.yml
```

⸻

## 🧑‍💻 Author

**Ismoil Axrorov**  
GitHub: github.com/issakhrorov
Email: ismoilaxrorov6600@gmail.com

⸻