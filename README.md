# REST Assured Automation

This project contains **API automation tests** implemented using **REST Assured in Java**.  
It is designed to demonstrate practical API testing concepts such as **CRUD operations**, **schema validation**, **SOAP services**, and **local API testing**, following a clean and easy-to-understand structure.

The project serves as a hands-on reference for learning and practicing **real-world API automation scenarios**.

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

Project structure screenshots are available inside the repository under the **Project_Structure/** folder.

## Tools & Dependencies

- Java 17
- Maven
- REST Assured
- JUnit/TestNG (depending on the tests)

## Execution Video  
▶️ [Click here to watch the execution video](https://drive.google.com/file/d/1X3JahE9LEYkxCfvm7uCdWGv8nG_Gfs3l/view?usp=sharing)  

---

## How to Run

1. Clone the repository.
2. Open the project in your IDE.
3. Run tests from `src/test/java` using your preferred test runner.
