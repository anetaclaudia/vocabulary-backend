# Test assignment for Telia Software Development Internship
The assignment is to build a small web-application for an Estonian-English dictionary. 
The application's back-end is built with Spring Boot, front-end is built with Angular. 
The application's front-end is available [here](https://github.com/anetaclaudia/vocabulary-frontend) 

## Functionalities
- User can add words and the definitions in both languages. I decided to add definitions because one word can have different meanings, such as "tulp", which can mean a column and a flower.
- User can find matches for their input by the given language. In example, when user wants to find English meaning for word "tulp", they have to select the language which the word derives from.
    - User can find fuzzy matches - in example, when user tries to find matches for word "kulp", but they actually meant "tulp", search results include words that differ from original string up to 2 characters.

## Prerequisites for running the application
(i need to add docker, then i can finish this part)

Application also has Swagger added to it. To access it, run the application and open browser at following address: <http://localhost:8080/api/swagger-ui/>

## Technologies used
- [Spring Boot](https://spring.io/projects/spring-boot)
- [H2](https://www.h2database.com/html/main.html)
- [Gradle](https://gradle.org/)
- [JUnit](https://junit.org/junit5/)
- [Angular](https://angular.io/)
- [Bootstrap](https://getbootstrap.com/docs/4.6/getting-started/introduction/)
