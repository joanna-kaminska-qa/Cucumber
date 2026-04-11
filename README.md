# API Automation Testing with Cucumber & RestAssured

![Java](https://img.shields.io/badge/Java-21-007396?style=flat&logo=openjdk&logoColor=white)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-23D96C?style=flat&logo=cucumber&logoColor=white)
![RestAssured](https://img.shields.io/badge/Rest--Assured-Testing-orange?style=flat)
![Gradle](https://img.shields.io/badge/Gradle-Build-02303A?style=flat&logo=gradle&logoColor=white)
![Allure](https://img.shields.io/badge/Allure-Reporting-blueviolet?style=flat&logo=allure)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen?style=flat)
![License: MIT](https://img.shields.io/badge/License-MIT-purple?style=flat)

A professional API automation framework for testing **JSONPlaceholder** using modern BDD techniques and clean code principles.

## Key Features
* **Advanced Data Mapping**:
    * **DataTable to POJO**: Automatic transformation of Gherkin tables into Java objects using `@DataTableType`.
    * **External JSON Loading**: Loading test data from external files using **Jackson Databind**.
* **Professional Reporting**: Interactive **Allure Reports** with full HTTP request/response logging.
* **Clean Architecture**:
    * **ConfigLoader**: Centralized environment configuration.
    * **Request Specification Hooks**: Reusable and clean API setup.
    * **POJO Mapping**: Full deserialization of JSON responses into dedicated Java classes.
* **BDD Excellence**: Use of Scenario Outlines, DocStrings, and State Management between steps.

## Technologies
* **Java 21** & **Gradle**
* **Cucumber** (BDD)
* **RestAssured** (API Testing)
* **Jackson** (JSON Serialization/Deserialization)
* **Allure Report** (Visualization)
* **Hamcrest** (Fluent Assertions)

## Reporting
The project uses **Allure Report** to visualize test results. To generate and view the report:

1. Run tests: `./gradlew clean test`
2. Generate report: `./gradlew allureReport`
3. Open in browser: `./gradlew allureServe`

## Running Tests
To execute all tests and generate raw results, run:
`./gradlew test`

## License
This project is licensed under the **MIT License**.

## Author
**Joanna Kamińska** GitHub: [https://github.com/joanna-kaminska-qa](https://github.com/joanna-kaminska-qa)