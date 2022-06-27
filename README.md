# development-books
An app to get the best discounted price for the choosen set of books.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.ram.developmentbooks.DevelopmentbooksApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Swagger endpoint

-http://localhost:8080/swagger-ui.html
- Sample Request Json
{
  "itemsInCart": [
    {
      "book": {
        "name": "Clean Code",
        "retailPrice": 50
      },
      "quantity": 2
    },
    {
      "book": {
        "name": "Clean Coder",
        "retailPrice": 50
      },
      "quantity": 2
    },
    {
      "book": {
        "name": "Clean Architecture",
        "retailPrice": 50
      },
      "quantity": 2
    },
    {
      "book": {
        "name": "Test Driven Development by Example",
        "retailPrice": 50
      },
      "quantity": 1
    },
    {
      "book": {
        "name": "Working effectively with Legacy Code",
        "retailPrice": 50
      },
      "quantity": 1
    }
  ]
}

Sample Curl cmd
```shell
curl -X 'POST' \
  'http://localhost:8080/price' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "itemsInCart": [
    {
      "book": {
        "name": "Clean Code",
        "retailPrice": 50
      },
      "quantity": 2
    },
    {
      "book": {
        "name": "Clean Coder",
        "retailPrice": 50
      },
      "quantity": 2
    },
    {
      "book": {
        "name": "Clean Architecture",
        "retailPrice": 50
      },
      "quantity": 2
    },
    {
      "book": {
        "name": "Test Driven Development by Example",
        "retailPrice": 50
      },
      "quantity": 1
    },
    {
      "book": {
        "name": "Working effectively with Legacy Code",
        "retailPrice": 50
      },
      "quantity": 1
    }
  ]
}'
```

### Steps Went Through

Created the Basic Structure of the Springboot application with neccessary dependancies
Started writing tests for the given problem statement in PriceServiceTest
started solving the tests by adding the Implementation code for the PriceService
Issues faced while creating the cobination of books to get the best discount
Added a Deep Copy of the collections used and also used copyonwrite array list
After all test are success started writing tests for the controller and solved by adding the code in Price Controller
Added the RestAdvice Controller and Swagger


