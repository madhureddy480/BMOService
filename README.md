# Getting Started

### System Requirements

* JDK 21 or higher
* Gradle 8.1
* Eclipse (to further enhance the project)


### Setup
Local workspace setup:

* Clone the repo
* Import project as Gradle project
* Goto BMOServiceApplication.java and run the class as a Java application. This will run the Springboot application on port: 8080 default.

### Functionality

* Application exposes "/api/employees/{id}" endpoint. 
* Application has H2 database embedded with Employee table and few records
* To test: try http://localhost:8080/api/employees/31
* change default port in application.properties if required.
