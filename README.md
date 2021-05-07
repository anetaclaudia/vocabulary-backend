# Test assignment for Telia Software Development Internship
The assignment is to build a small web-application for an Estonian-English dictionary. 
The application's back-end is built with Spring Boot, database is H2, front-end is built with Angular. 
The application's front-end is available [here](https://github.com/anetaclaudia/vocabulary-frontend) 

## Functionalities
- User can add words and the definitions in both languages. I decided to add definitions because one word can have different meanings, such as "tulp", which can mean a column and a flower.
- User can find matches for their input by the given language. In example, when user wants to find English meaning for word "tulp", they have to select the language which the word derives from.
    - Search output also includes fuzzy matches - in example, when user tries to find matches for word "kulp", but they actually meant "tulp", search results include words that differ from original string up to 2 characters.
    - Search output is sorted - words, which have 0 differences compared to input, are displayed first.
- User can't submit empty forms or forms, which inputs are made out of whitespaces. There's a custom validation in front-end for that.
- Application also has Swagger added to it. To access it, run the application and open browser at following address: <http://localhost:10000/api/swagger-ui/>

## Prerequisites for running the application
- Make sure you have [Docker Desktop](https://www.docker.com/products/docker-desktop) installed on your device.

## Running the application locally
1. Open Docker Desktop and proceed with following steps.
2. Download or clone the project.
3. Open terminal and switch into `vocabulary-backend` directory.
4. In the directory, run `docker-compose up`. To check, if application is running, open your browser and go to <http://localhost:10000/api/swagger-ui/>.

## Technologies used
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Swagger UI](https://swagger.io/tools/swagger-ui/)
- [H2](https://www.h2database.com/html/main.html)
- [Gradle](https://gradle.org/)
- [JUnit](https://junit.org/junit5/)
- [Docker](https://www.docker.com/)
- [Angular](https://angular.io/)
- [Bootstrap](https://getbootstrap.com/docs/4.6/getting-started/introduction/)
