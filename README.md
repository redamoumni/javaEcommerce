Here's a sample README file for your project in English:

---

# E-Commerce Application

## Introduction

This project is a simple E-Commerce application built with Spring Boot. It includes functionality for managing users, including creating, updating, retrieving, and deleting user information.

## Features

- **Get User by ID**: Retrieve user details using a unique user ID.
- **Get All Users**: Retrieve a list of all users.
- **Create User**: Add a new user to the system.
- **Update User**: Update the details of an existing user.
- **Delete User**: Remove a user from the system.

## Technologies Used

- **Java 11**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**
- **JUnit 5**
- **Mockito**

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven

### Installation

1. Clone the repository:

2. Build the project:

    ```sh
    mvn clean install
    ```

3. Run the application:

    ```sh
    mvn spring-boot:run
    ```

### Configuration

The application uses H2 in-memory database for simplicity. You can find the configuration in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
```

### Running Tests

To run the tests, use the following command:

```sh
mvn test
```

## Usage

Once the application is running, you can interact with the user management features using a REST client (e.g., Postman) or via curl commands.

### API Endpoints

- **Get User by ID**

    ```sh
    GET /users/{id}
    ```

    Example:

    ```sh
    curl -X GET http://localhost:8080/users/1
    ```

- **Get All Users**

    ```sh
    GET /users
    ```

    Example:

    ```sh
    curl -X GET http://localhost:8080/users
    ```

- **Create User**

    ```sh
    POST /users
    ```

    Example:

    ```sh
    curl -X POST http://localhost:8080/users \
        -H "Content-Type: application/json" \
        -d '{"email": "newuser@example.com", "fullName": "New User"}'
    ```

- **Update User**

    ```sh
    PUT /users/{id}
    ```

    Example:

    ```sh
    curl -X PUT http://localhost:8080/users/1 \
        -H "Content-Type: application/json" \
        -d '{"email": "updated@example.com", "fullName": "Updated User"}'
    ```

- **Delete User**

    ```sh
    DELETE /users/{id}
    ```

    Example:

    ```sh
    curl -X DELETE http://localhost:8080/users/1
    ```

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License.

## Acknowledgements

Special thanks to the contributors and the open-source community for their valuable work and support.

---

Feel free to modify this README file according to your project's specific details and requirements.