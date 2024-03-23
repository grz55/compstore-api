FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
ARG MAVEN_PROFILE=dev-postgres
COPY . .
RUN mvn clean package -DskipTests -P${MAVEN_PROFILE}

FROM eclipse-temurin:17-jre-alpine
COPY --from=build /target/*.jar compstore.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","compstore.jar"]