FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app
COPY target/demo-transaction-*.jar app.jar
COPY wait-for-postgres.sh .

ENTRYPOINT ["java","-jar","app.jar", "--spring.profiles.active=demo"]