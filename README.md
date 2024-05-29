# CoderHack Leaderboard API

## Overview

CoderHack is a RESTful API service built using Spring Boot to manage the leaderboard of a coding platform contest. It uses MongoDB to persist data and supports CRUD operations for user registrations, score updates, and leaderboard retrieval. Users can earn virtual badges based on their scores.

## Features

- Register users for the contest
- Update user scores
- Award badges based on user scores
- Retrieve sorted leaderboard
- Error handling and validation

## Endpoints

- `GET /users` - Retrieves a list of all registered users.
- `GET /users/{userId}` - Retrieves details of a specific user.
- `POST /users` - Registers a new user to the contest.
- `PUT /users/{userId}` - Updates the score of a specific user.
- `DELETE /users/{userId}` - Deregisters a specific user from the contest.

## Implemented Code

### Controllers

- `CoderHackController` contains endpoints for managing user registrations, updating scores, retrieving users, and deregistering users from the contest.

### DTOs

- `UserDto` represents the data transfer object for user registration.
- `UserIdDto` represents the data transfer object for returning user IDs.
- `UserScoreDto` represents the data transfer object for updating user scores.

### Entities

- `User` is the MongoDB document representing a user entity, including fields for user ID, username, score, and badges.

### Exception Handling

- `GlobalExceptionHandler` handles custom exceptions such as `UserNotFoundException` and `UserAlreadyExistsException`.

### Repositories

- `CoderHackRepository` provides CRUD operations and a custom query for sorting users by score in descending order.

### Services

- `CoderHackService` and its implementation `CoderHackServiceImpl` contain the business logic for user registration, score updates, and leaderboard retrieval.

### Enums

- `Badges` defines the different types of badges that can be awarded to users based on their scores.

### Configuration

- `CoderHackApplication` is the main Spring Boot application class.

## Tools and Technologies

- Java 11 or higher
- Spring Boot
- MongoDB
- Gradle

## Setup and Usage

1. Clone the repository `git clone https://github.com/nikhil1905-n/CoderHack.git`.
2. Configure MySQL database settings in `application.properties`.
3. Run the application using `./gradlew bootrun`.
4. Use endpoints to perform CRUD operations on user.

