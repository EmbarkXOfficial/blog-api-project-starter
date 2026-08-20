# Developer's Guide

This guide provides instructions on how to run the blog API project and details the available API endpoints.

## How to Run

### Prerequisites

- Java 25 or later
- Maven

### Running the Application

1. Open a terminal or command prompt.
2. Navigate to the root directory of the project.
3. Run the following command:

```bash
mvn spring-boot:run
```
The application will start on the default port (usually 8080).

## Available APIs

### Create a Post
- **URL**: `/api/posts`
- **Method**: `POST`
- **Parameters**:
  - `title`: The title of the post.
  - `content`: The content of the post.
- **Description**: Creates a new blog post.

### Get All Posts
- **URL**: `/api/posts`
- **Method**: `GET`
- **Description**: Retrieves a list of all blog posts.

### Get a Single Post
- **URL**: `/api/posts/{id}`
- **Method**: `GET`
- **Parameters**:
  - `id`: The ID of the post to retrieve.
- **Description**: Retrieves a single blog post by its ID.

### Validate Content
- **URL**: `/api/posts/validate`
- **Method**: `POST`
- **Parameters**:
  - `content`: The content to validate.
- **Description**: Checks if the content length is within the allowed limit (5000 characters).

### Delete a Post
- **URL**: `/api/posts/{id}`
- **Method**: `DELETE`
- **Parameters**:
  - `id`: The ID of the post to delete.
- **Description**: Deletes a blog post by its ID.

### Get Total Word Count
- **URL**: `/api/posts/total`
- **Method**: `GET`
- **Description**: Retrieves the total word count of all posts.
