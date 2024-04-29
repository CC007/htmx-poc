# HTMX PoC

This is a Spring-boot (Java) project to explore the use of HTMX as a frontend library.

## How to run
Before building, make sure you have Java 21 or newer installed (with the JAVA_HOME and PATH variable set and updated respectively).

The project can be built and run using the supplied maven wrapper:

```bash
# navigate to the htmx-poc-server folder
cd htmx-poc-server

# build the project with the maven wrapper
mvnw clean install

# Run the application
mvnw spring-boot:run
```
After a couple of seconds, the application should be running at `localhost:8080`
