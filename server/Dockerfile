FROM ubuntu:latest
LABEL authors="Yoon"
FROM gradle:8.8-jdk17 AS build
FROM openjdk:17-jdk
EXPOSE 8080
COPY build/libs/priend-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]