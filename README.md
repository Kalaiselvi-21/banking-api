# Week 2 Banking API

A Spring Boot backend application developed as part of the GCT Training Program – Week 2.

This project implements a simple banking domain with Customer, Bank Account, Transaction, and Beneficiary APIs. It demonstrates REST API design, layered architecture, DTO and Entity usage, JPA/Hibernate persistence, PostgreSQL integration, request validation, exception handling, and API testing using Postman.

## Objectives

* Build RESTful banking APIs
* Understand Controller, Service, and Repository layers
* Use DTOs and JPA Entities
* Map Java objects to PostgreSQL tables using Hibernate/JPA
* Implement request validation
* Implement custom exception handling
* Perform CRUD operations
* Test APIs using Postman
* Use Git and GitHub for version control

## Technologies Used

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven
* Postman
* Git
* GitHub

## Project Structure

```text
banking-api/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/bankingapi/
│       │       ├── controller/
│       │       ├── service/
│       │       ├── repository/
│       │       ├── entity/
│       │       ├── dto/
│       │       └── exception/
│       └── resources/
│           └── application.properties
├── postman/
│   └── Week-2-Banking-API.postman_collection.json
├── pom.xml
└── README.md
```

## Architecture

```text
Postman
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
Hibernate / JPA
   ↓
PostgreSQL
```

### Layers

**Controller**

Receives HTTP requests and sends responses.

**Service**

Contains the application/business logic.

**Repository**

Communicates with the database using Spring Data JPA.

**Entity**

Represents the database tables.

**DTO**

Carries request data between the client and application.

**Exception**

Handles errors such as resource-not-found and validation failures.

## Database

PostgreSQL is used as the database.

Database name:

```text
bankingdb
```

Default configuration:

```text
Host: localhost
Port: 5432
Username: postgres
```

The database password is supplied using the `DB_PASSWORD` environment variable.

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bankingdb
spring.datasource.username=postgres
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Database Tables

The application creates/updates the required tables using JPA/Hibernate.

Main tables:

* `customers`
* `bank_account`
* `transactions`
* `beneficiaries`

Relationships:

```text
Customer
   │
   ├── Bank Accounts
   │       │
   │       └── Transactions
   │
   └── Beneficiaries
```

## REST APIs

### Customer APIs

| Method | Endpoint              | Description        |
| ------ | --------------------- | ------------------ |
| POST   | `/api/customers`      | Create a customer  |
| GET    | `/api/customers`      | Get all customers  |
| GET    | `/api/customers/{id}` | Get customer by ID |

### Account APIs

| Method | Endpoint             | Description           |
| ------ | -------------------- | --------------------- |
| POST   | `/api/accounts`      | Create a bank account |
| GET    | `/api/accounts`      | Get all accounts      |
| GET    | `/api/accounts/{id}` | Get account by ID     |

### Transaction APIs

| Method | Endpoint                                 | Description              |
| ------ | ---------------------------------------- | ------------------------ |
| POST   | `/api/accounts/{accountId}/transactions` | Create a transaction     |
| GET    | `/api/accounts/{accountId}/transactions` | Get account transactions |

### Beneficiary APIs

| Method | Endpoint                  | Description           |
| ------ | ------------------------- | --------------------- |
| POST   | `/api/beneficiaries`      | Create a beneficiary  |
| GET    | `/api/beneficiaries`      | Get all beneficiaries |
| DELETE | `/api/beneficiaries/{id}` | Delete a beneficiary  |

## Sample Requests

### Create Customer

```json
{
    "name": "Renu",
    "email": "renu@gmail.com",
    "phone": "9876543210"
}
```

### Create Account

```json
{
    "accountNumber": "ACC102",
    "accountType": "SAVINGS",
    "balance": 50000,
    "customerId": 1
}
```

### Create Transaction

```json
{
    "type": "DEPOSIT",
    "amount": 10000
}
```

### Create Beneficiary

```json
{
    "name": "Renu",
    "accountNumber": "ACC300",
    "customerId": 1
}
```

## Validation

Request validation is implemented using Jakarta Bean Validation.

Examples:

* Customer name cannot be empty
* Email must be valid
* Account number cannot be empty
* Account type cannot be empty
* Account balance cannot be negative
* Transaction amount must be greater than zero
* Beneficiary name and account number cannot be empty
* Customer ID is required

Invalid requests return HTTP `400 Bad Request`.

## Exception Handling

Custom exception handling is implemented using:

```text
ResourceNotFoundException
GlobalExceptionHandler
```

If a requested resource does not exist, the API returns HTTP `404 Not Found`.

Validation errors return HTTP `400 Bad Request` with the corresponding validation messages.

## Running the Application

### 1. Start PostgreSQL

Make sure PostgreSQL is running on port `5432`.

### 2. Create Database

Create a PostgreSQL database named:

```text
bankingdb
```

### 3. Configure Database Password

Set the environment variable:

```text
DB_PASSWORD=your_postgresql_password
```

### 4. Run the Application

Using IntelliJ IDEA, run the Spring Boot main application class.

Or using Maven:

```bash
mvnw.cmd spring-boot:run
```

The application runs on:

```text
http://localhost:8080
```

## Postman Testing

A Postman collection containing all APIs is included in:

```text
postman/Week-2-Banking-API.postman_collection.json
```

The collection contains:

* Customer APIs
* Account APIs
* Transaction APIs
* Beneficiary APIs
* Request bodies for POST operations

## Git Workflow

The project is maintained using Git for version control.

Example commit structure:

```text
Initial banking API setup
Add customer APIs
Add bank account APIs
Add transaction APIs
Add beneficiary APIs
Add validation and exception handling
Add README and Postman collection
```

## Author

**Kalaiselvi G**

B.Tech Information Technology
Government College of Technology, Coimbatore

GitHub: https://github.com/Kalaiselvi-21
