# Restful Booker API Testing

Automated API testing project for the Restful Booker API, built with Java, Rest Assured, TestNG, Jackson, and Maven.

This project tests the main CRUD operations over booking resources: authentication, booking creation, booking retrieval, full update, partial update, deletion, and booking ID listing.

Tech stack: Java, Maven, Rest Assured, TestNG, Jackson.

Tested endpoints:

| Method | Endpoint | Description |
|---|---|---|
| POST | `/auth` | Generates an authentication token |
| GET | `/booking` | Retrieves all booking IDs |
| GET | `/booking/{id}` | Retrieves a specific booking |
| POST | `/booking` | Creates a new booking |
| PUT | `/booking/{id}` | Updates an existing booking |
| PATCH | `/booking/{id}` | Partially updates an existing booking |
| DELETE | `/booking/{id}` | Deletes a booking |

Project structure:

    src
    ├── main
    │   └── java
    │       └── com/rajcic
    │           ├── builder
    │           ├── classes
    │           │   ├── request
    │           │   └── response
    │           ├── config
    │           └── specification
    └── test
        └── java
            ├── constants
            ├── data
            └── tests

The project uses a local `config.properties` file for the base URI and credentials.

Example `config.properties`:

    base_uri=YOUR_URL
    username=YOUR_USERNAME
    password=YOUR_PASSWORD

This file should not be committed if it contains credentials or environment-specific data.


How to run tests:

    git clone https://github.com/rajcic-djordje/Restful-booker-Rest-Assured-testing.git
    cd Restful-booker-Rest-Assured-testing/Restful-Booker
    mvn test

The project is organized into reusable components. `BaseTest` sets the base URI and generates the authentication token. `RequestBuilder` contains reusable methods for sending API requests. `ReqSpecification` defines common request specifications. Model classes are used for request and response serialization/deserialization. Test data is separated into the `ApiTestData` class.

Restful Booker expects exact JSON field names, for example:

    {
      "firstname": "John",
      "lastname": "Doe",
      "totalprice": 100,
      "depositpaid": true,
      "bookingdates": {
        "checkin": "2026-01-01",
        "checkout": "2026-01-12"
      },
      "additionalneeds": "Breakfast"
    }

Jackson annotations are used to keep Java model classes aligned with the API contract and avoid incorrect fields such as `firstName`, `lastName`, or `bookingId` being sent in request bodies.

Author: Djordje Rajcic
