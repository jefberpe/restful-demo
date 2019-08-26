# Spring Boot RESTful Services

This simple project was created to demonstrate how to implement an easy 
RESTful solution using Spring Boot with JOOQ. 

## Technology Stack

* [Java 1.8](http://www.oracle.com/technetwork/java/javase/downloads)
* [Spring](https://spring.io/docs)
* [Spring Boot](http://projects.spring.io/spring-boot)
* [PostgreSQL](https://www.postgresql.org)
* [JOOQ](https://www.jooq.org)
* [Flyway](https://flywaydb.org)
* [Swagger](http://swagger.io)
* [Gradle](https://gradle.org)

## Project Structure
This project follows the project structure suggested by Gradle and required by Spring Boot.

## Pre-requisites
Some prerequisites to start up the RESTful API server are:
* Install and start up PostgreSQL server.
* `psql -U postgres -c 'CREATE DATABASE libraries;'` to create the database.

## How to use Flyway?
The most important functionalities with Flyway are:
* `gradle flywayClean` cleans up and removes any previous migration in the DB schema (Note: this is only for development and test environments)
* `gradle flywayMigrate` runs the migrations to build the DB schema.

## How to build the application?
To build the application you can do the following steps:
* `gradle clean` to delete any previous distribution.
* `gradle build` to build a new application distribution.

## How to generate JOOQ models?
To use JOOQ code generator you can do this:
* `gradle clean build -PgenerateJooq` to clean, build and generate JOOQ models.

## Start up RESTful API server
To start up the server there are several options:
* `java -jar build/libs/demo1-<version>.jar` to start up the server.
* `gradlew bootRun` to start up the server in debug mode.

## RESTful API Documentation with Swagger
* To see the RESTful API documentation you can access this url `http://localhost:8080/swagger-ui.html`

