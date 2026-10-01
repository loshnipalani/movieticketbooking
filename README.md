# Movie Ticket Booking System

A Spring Boot based REST API project for managing movie ticket bookings. The application uses Spring Boot, JPA, MySQL, Docker, GitHub Actions, and Docker Hub.

## Technologies Used

* Java 25
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* REST API
* Postman
* Docker
* Docker Hub
* GitHub Actions
* GitHub

## Project Features

* Add movie bookings
* View all bookings
* View a booking by ID
* Update booking details
* Delete bookings
* Execute SQL JOIN queries through REST APIs
* MySQL database integration
* Docker containerization
* Automatic Docker image build and push using GitHub Actions

## Project Structure

```text
movieticketbooking
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.movieticketbooking
│   │   │       ├── controller
│   │   │       ├── entity
│   │   │       └── repository
│   │   │
│   │   └── resources
│   │       ├── application.properties
│   │       └── static
│   │
├── .github
│   └── workflows
│       └── docker.yml
│
├── Dockerfile
├── pom.xml
└── README.md
```

## REST API Endpoints

### Get All Bookings

```text
GET /bookings
```

Example:

```text
http://localhost:8080/bookings
```

### Get Booking by ID

```text
GET /bookings/{id}
```

Example:

```text
http://localhost:8080/bookings/BK01
```

### Add Booking

```text
POST /bookings
```

### Update Booking

```text
PUT /bookings
```

### Delete Booking

```text
DELETE /bookings/{id}
```

## JOIN APIs

The project also demonstrates different SQL JOIN operations through REST APIs.

### INNER JOIN

```text
GET /bookings/innerjoin
```

Returns records where matching data exists in both tables.

### LEFT JOIN

```text
GET /bookings/leftjoin
```

Returns all records from the left side and matching records from the right side.

### RIGHT JOIN

```text
GET /bookings/rightjoin
```

Returns all records from the right side and matching records from the left side.

### FULL OUTER JOIN

```text
GET /bookings/fullouterjoin
```

Returns matching records as well as unmatched records from both sides.

## Database

The project uses MySQL.

Database:

```text
movie_ticket_booking
```

The application connects to MySQL using Spring Data JPA and Hibernate.

For Docker, the application connects to the MySQL database running on the host machine using:

```text
host.docker.internal
```

The database password is provided through an environment variable and is not stored directly in the source code.

## Running the Project Locally

### 1. Clone the Repository

```bash
git clone https://github.com/loshnipalani/movieticketbooking.git
```

### 2. Open the Project

Open the project in IntelliJ IDEA.

### 3. Configure MySQL

Create the database:

```sql
CREATE DATABASE movie_ticket_booking;
```

Configure the database connection in `application.properties`.

### 4. Build the Project

```bash
mvn clean package -DskipTests
```

### 5. Run the Spring Boot Application

Run:

```text
MovieticketbookingApplication
```

The application runs on:

```text
http://localhost:8080
```

## Docker

The project is containerized using Docker.

### Dockerfile

The application uses an Eclipse Temurin Java image and runs the generated Spring Boot JAR.

Build the Docker image:

```bash
docker build -t loshnipm/movieticketbooking:latest .
```

Run the container:

```bash
docker run -d -p 8080:8080 -e DB_PASSWORD=YOUR_DATABASE_PASSWORD loshnipm/movieticketbooking:latest
```

The application can then be accessed at:

```text
http://localhost:8080
```

### Check Running Container

```bash
docker ps
```

The port mapping is:

```text
8080 → 8080
```

Example:

```text
0.0.0.0:8080->8080/tcp
```

## Docker Hub

Docker image:

```text
loshnipm/movieticketbooking:latest
```

The image can be pulled using:

```bash
docker pull loshnipm/movieticketbooking:latest
```

Then run it using:

```bash
docker run -d -p 8080:8080 -e DB_PASSWORD=YOUR_DATABASE_PASSWORD loshnipm/movieticketbooking:latest
```

## GitHub Actions

GitHub Actions is used to automatically build and push the Docker image when changes are pushed to the `main` branch.

Workflow file:

```text
.github/workflows/docker.yml
```

The workflow performs the following steps:

```text
Git Push
   ↓
GitHub Actions
   ↓
Checkout Source Code
   ↓
Set up Java
   ↓
Build Spring Boot JAR
   ↓
Login to Docker Hub
   ↓
Build Docker Image
   ↓
Push Docker Image to Docker Hub
```

## Testing

The REST APIs were tested using Postman.

Tested APIs include:

* GET all bookings
* GET booking by ID
* POST booking
* PUT booking
* DELETE booking
* INNER JOIN
* LEFT JOIN
* RIGHT JOIN
* FULL OUTER JOIN

## Security

The database password is not stored directly in the source code.

The application uses:

```text
${DB_PASSWORD}
```

The database password should be supplied through an environment variable.

GitHub Actions uses GitHub Secrets for Docker Hub authentication.

## Author

**P.M. Loshni**

GitHub:

```text
https://github.com/loshnipalani
```
