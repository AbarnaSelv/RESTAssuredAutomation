# REST Assured Automation

This project contains API automation tests using REST Assured in Java.

## Project Structure

- `src/main/java` - Main Java classes.
- `src/main/resources` - XSD files for request/response validation (`calculator.xsd`, `soap-envelope.xsd`, `soap-wrapper.xsd`).
- `src/test/java` - Test classes for API automation:
  - `GetAndPostExamples.java` - Examples of GET and POST requests.
  - `PutPatchDeleteExamples.java` - Examples of PUT, PATCH, and DELETE requests.
  - `JSONSchemaValidator.java` - Validates JSON responses against schema.
  - `XMLSchemaValidator.java` - Validates XML responses against XSDs.
  - `SoapXMLRequest.java` - Handles SOAP requests.
  - `TestOnLocalAPI.java` - Test examples on local API.
  - `TestsExample.java` - Sample tests for reference.
- `src/test/resources` - Test resources.
- `pom.xml` - Maven dependencies and build configuration.

## Tools & Dependencies

- Java 17
- Maven
- REST Assured
- JUnit/TestNG (depending on the tests)

## How to Run

1. Clone the repository.
2. Open the project in your IDE.
3. Run tests from `src/test/java` using your preferred test runner.
