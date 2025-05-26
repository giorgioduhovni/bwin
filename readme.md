# Selenium + Java Test Automation Framework

## Overview

This project is a Selenium-based test automation framework written in Java. It is designed originally under Windows for default Chrome. The Framework should detect if any other Operational System is used Linux/macOS.
The default browser is Chrome. Chrome uses maximize settings, but there are also option for desktop resolution (commented in the initChrome) and mobile option (commented in the initChrome) Test fail for the mobile option, since the elements are changing the DOM. 
## Technologies Used

- Java
- Selenium WebDriver
- JUnit
- Maven
- ChromeDriver
- Page Object Model (POM) Design Pattern
- ExtentReports / Allure for reporting

## Prerequisites

Make sure you have the following installed:

- Java JDK 17 or later
- Maven 
- Chrome browser (current latest version Version 136.0.7103.114)
- ChromeDriver 
- IDE (such as IntelliJ IDEA or Eclipse)

## Getting Started

1. **Clone the repository:**

   ```bash
   git clone https://github.com/giorgioduhovni/bwin
   cd your-repo
   
2. Run Tests from BwinTestJunit