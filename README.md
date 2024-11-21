# Product Management API

## About
This API CRUD for managing products. It's built using java for the purpose of learning and assignment for a job interview only.
In this project, I used **_Spring Boot_**, **_Spring Data JPA_**, **_Spring AOP_** for aspect oriented programming, **_Redis_** or caching and applied the best practices for RESTful API.
I would really appreciate any feedback or suggestions for improvement.

Best Regards,
Haris Naufal Rasyid

## Getting Started (How to run the project)
### Prerequisites
- Java 17+
- Spring Boot 3.3.5
- PostgreSQL 14+ or Any other RDBMS
- Redis for caching
- Git for version control
- Docker for containerization

### Setup Local
1. **Clone this repository**
```bash
https://github.com/harisrsyd/product_management.git
```
2. **Create a new database in PostgreSQL**
```sql 
CREATE DATABASE product_management;
```
3. **Open the project in your favorite IDE (IntelliJ IDEA, Eclipse, etc)**
4. **Change the database configuration in `application.properties`**
5. **Wait until all dependencies are downloaded**
6. **Run Redis**

### Run the project
1. **Make sure your java version is 17+**
2. **Run the project**
```bash
mvn spring-boot:run
```
3. **Verify the project is running properly** (default port is 8989)
```bash
curl http://localhost:9090/api/products
```
4. **You can also access the API documentation in Swagger UI**
```bash
http://localhost:8989/swagger-ui.html
```

## API Endpoints Documentation
You can access the full API endpoint documentation by accessing the **Swagger UI** in your browser.

### Now, feel free to explore the API and give me feedback. Thank you!
