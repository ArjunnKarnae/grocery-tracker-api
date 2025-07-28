# Grocery Tracker API

This repository hosts the backend API for the Grocery Tracker application. It provides the necessary endpoints for managing grocery items, user authentication, and other core functionalities, serving as the data and logic layer for the UI.

## Technologies Used

* **Java**: The core programming language for the application.
* **Spring Boot**: A powerful framework that simplifies the development of production-ready, stand-alone, and robust Spring applications. It's used here for rapid application development and simplified configuration.
* **Spring Security**: Provides comprehensive security services for Java EE-based enterprise software applications, ensuring secure authentication (with JWT) and authorization for API endpoints.
* **Maven** (or Gradle, depending on your setup): Used for dependency management and building the project.
* **JWT (JSON Web Tokens)**: Utilized for securely transmitting information between parties as a JSON object, enabling stateless authentication for your API.
* **Database**: MongoDB - Used for persisting grocery item data and user information.

## Features

The Grocery Tracker API provides the following key functionalities:

1.  **User Management & Authentication**:
    * **User Registration**: Endpoint for new users to sign up and create accounts.
    * **User Login**: Endpoint for existing users to authenticate and receive a JWT.
    * **JWT-based Security**: All protected API endpoints require a valid JWT for access, ensuring secure communication.
2.  **Grocery Item Management**:
    * **Create Item**: API to add new grocery items to the tracker.
    * **Read Items**: Endpoints to retrieve lists of grocery items, potentially filtered by category or searched by name.
    * **Update Item**: API to modify details of existing grocery items.
    * **Delete Item**: API to remove grocery items from the list.
3.  **Categorization & Search**:
    * APIs supporting item categorization and filtering based on category type.
    * APIs enabling searching for grocery items by name.
4.  **Data Persistence**: Manages the storage and retrieval of all user and grocery data in the connected database.
