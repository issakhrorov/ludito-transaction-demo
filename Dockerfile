FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app
COPY build/libs/demo-transaction-*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar", "--spring.profiles.active=demo"]