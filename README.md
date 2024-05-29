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

- `GET /users` - Retrieve a list of all registered users
- `GET /users/{userId}` - Retrieve the details of a specific user
- `POST /users` - Register a new user to the contest
- `PUT /users/{userId}` - Update the score of a specific user
- `DELETE /users/{userId}` - Deregister a specific user from the contest

## Tools and Technologies

- Java 11 or higher
- Spring Boot
- MongoDB
- Gradle

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/your-username/CoderHack.git
cd CoderHack
