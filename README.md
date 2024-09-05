
# QA UI Automation Hypertextual

The QA UI Automation Hypertextual project provides a robust framework for automated UI testing using Selenium WebDriver with Cucumber for behavior-driven development (BDD). This project leverages the Page Object Model (POM) design pattern to create scalable and maintainable test automation solutions.


## Features

- Selenium WebDriver: For interacting with web elements.
- Cucumber: For writing BDD-style tests.
- Page Object Model (POM): For maintaining clear and manageable code.
- TestNG: For test management and reporting.
- Cross-Browser Testing: Support for Chrome, Firefox, Edge, and Safari.
- Custom DriverManager: For dynamic WebDriver setup.
- Listeners: For logging and reporting test results.


## Getting Started

### Prerequisites

- Java 11+: Ensure you have Java 11 or higher installed.
- Maven: For dependency management and project build.

### Setup

#### 1. Clone the Repository

```
git clone https://github.com/yourusername/qa-ui-automation-hypertextual.git
cd qa-ui-automation-hypertextual

```

#### 2. Install Dependencies
```
mvn install
```

#### 3. Configure Browser

Ensure that Chrome, Edge, Firefox, Safari browsers are available in your laptop. Chrome is set by default.

#### 4. Run Test
- Execute tests using Maven:
```
mvn test

```
- Execute the `SmokeTest.xml`


## Project Structure

- `src/main/java:` Contains the main source code including Page Objects, utility classes, and the custom DriverManager.
- `src/test/java:` Contains test definitions, step definitions, and test runners.
- `src/test/resources:` Contains feature files for Cucumber and configuration files.
## Writing Tests
- `Feature Files:` Define your test scenarios using Gherkin syntax in .feature files located in `src/test/resources/features`.
- `Step Definitions:` Implement the steps defined in the feature files in classes located in `src/test/java/stepdefinitions`.
- `Page Objects:` Create classes for each page of your application in `src/main/java/pages` following the Page Object Model.
  
## Reporting
They have not been implemented yet, but the structure was left in the Listeners class to implement the reports in the future.
## Contact

For any questions or feedback, please reach out to `fakeemail@gmail.com`
