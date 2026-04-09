# API Automation Testing with Cucumber & RestAssured

![Java](https://img.shields.io/badge/Java-21-blue?style=flat&logo=openjdk&logoColor=white)
![Cucumber](https://img.shields.io/badge/Cucumber-Automation-green?style=flat&logo=cucumber)
![RestAssured](https://img.shields.io/badge/RestAssured-5.4.0-orange)
![License: MIT](https://img.shields.io/badge/License-MIT-purple)
![Status](https://img.shields.io/badge/Status-In_Progress-yellow?style=flat)

A project for API automation testing (JSONPlaceholder) using modern BDD techniques.

## Technologies
* **Java 21**
* **Cucumber** (BDD Framework)
* **RestAssured** (API Testing Library)
* **Hamcrest** (Matching Objects/Assertions)
* **Gradle** (Build Tool)

## Key Features
* **State Management**: Persisting API responses across multiple steps.
* **Scenario Outlines**: Batch testing with data tables.
* **DocStrings**: Sending raw JSON bodies directly from `.feature` files.
* **POJO Mapping**: Deserializing JSON responses into `User` objects.

## Running Tests
To execute all tests, run:
`./gradlew test`

## License

This project is licensed under the **MIT License**.  
See the LICENSE file for details.


## Authors

Created by:

**Joanna Kamińska**  
GitHub: [https://github.com/joanna-kaminska-qa](https://github.com/joanna-kaminska-qa)
