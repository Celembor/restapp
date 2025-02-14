FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21.0.6_7-jdk-ubi9-minimal

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY --from=build /app/${JAR_FILE} restapp.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/restapp.jar"]