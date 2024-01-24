# compstore-api
CompStore web store backend

## Owners:
@grz55
@pawelNu

## Technology stack:

#### Main
- Java 17
- Spring Boot
- Hibernate

#### DB
- PostgreSQL
- H2

#### Tools/libs
- Liquibase
- Lombok
- Spotless

#### Containers
- Docker

## Runs on port:
8080

## Scripts:
Create postgres db in Docker container: `scripts/postgres/create_run_container.bat`

## Other repos:

Frontend: https://github.com/pawelNu/compstore-ui

## Code standards

- Boolean attributes names end with `Flag`
- Always use UUID Generator (https://www.uuidgenerator.net/version4) for UUID generation
- Pay attention to SonarLint suggestions
- Before merging to `master`: `mvn spotless:apply` in order to maintain code formatting and minimizing merge conflicts

## Commit prefixes:

- feat(task_no): The new feature you're adding to a particular application
- fix(task_no): A bug fix
- style(task_no): Feature and updates related to styling
- refactor(task_no): Refactoring a specific section of the codebase
- test(task_no): Everything related to testing
- docs(task_no): Everything related to documentation
- chore(task_no): Regular code maintenance. [ You can also use emojis to represent commit types]

## Useful commands

- Building docker image locally: `docker build -t compstore-api .`
- Running docker image locally: `docker run --name compstore-api -p 8080:8080 compstore-api`