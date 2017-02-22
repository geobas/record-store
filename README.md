# A sample project written in Spring Boot & AngularJS

A Vinyl Record Store to CRUD records.

## To get this application up and running:
- `git clone git@github.com:geobas/record-store.git`
- Open the *application.properties* file and set your own configurations.

### Prerequisites
- Java 8
- Maven > 3.0

## Test profile
- Start application with the following command line argument `spring.profiles.active=test`

## Prod profile
- Create a database named `record_shop` either on MySQL or MariaDB server
- Start application with the following command line argument `spring.profiles.active=prod`