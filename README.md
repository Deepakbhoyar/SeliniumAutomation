# Selenium Automation Project

This project automates web application testing using Selenium WebDriver, TestNG, and Maven.

## Features

- Cross-browser testing (Chrome, Firefox)
- Page Object Model structure
- Screenshot capture on test execution
- Logging and reporting
- TestNG listener integration

## Prerequisites

- Java 11 or higher
- Maven 3.8+
- Chrome/Firefox browsers installed

## Setup

1. **Clone the repository**
2. **Install dependencies**
3. **Configure test settings**
    - Edit `src/test/resources/configfiles/config.properties` to set browser and test URL.

## Running Tests

Execute all TestNG tests: mvn test
Or run a specific suite: mmvn test -DsuiteXmlFile=testing.xml

## Project Structure

- `src/main/java/com/pages/` — Page Object classes
- `src/main/java/com/utilities/` — Utilities (logging, screenshots, etc.)
- `src/test/java/com/testCases/` — Test classes
- `src/test/java/com/baseTestCase/` — Base test setup/teardown
- `src/test/java/com/listeners/` — TestNG listeners
- `screenshots/` — Saved screenshots

## Reporting

TestNG and ReportNG generate test reports after execution. Check the `target/surefire-reports` directory.

## License

MIT License
