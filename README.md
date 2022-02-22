# Spring WebFlux Demo project

This project was built to show in a simple way, the difference between a synchronous and blocking call to the api, and an asynchronous one.

To run the project you need to have Java 11 and JAVA_HOME set on your environment variables, then you can use either:

On Linux

    ./mvnw spring-boot:run

On Windows

    .\mvnw spring-boot:run

Then, you can call the synchronous and asynchronous versions of the api. See in the terminal the objects being built, and on the client (browser or postman), how the response is handled.

For the synchronous endpoint:

    http://localhost:8080/items/sync

Note that it'll wait until all the items are created so it can send a response.

For the synchronous endpoint:

    http://localhost:8080/items/async

Note that it starts to respond as soon as the first item is created.