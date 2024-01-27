FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
COPY . .
RUN mvn clean package -DskipTests -Pprod

FROM eclipse-temurin:17-jre-alpine
COPY --from=build /target/*.jar compstore.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","compstore.jar"]