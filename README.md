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

## Runs on port:
8080

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
