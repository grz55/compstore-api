FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
COPY --from=build /target/compstore-0.0.1-SNAPSHOT.jar compstore.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","compstore.jar"]