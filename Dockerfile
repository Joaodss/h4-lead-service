FROM maven:3.8.3-openjdk-17-slim
RUN mvn -B clean --file pom.xml
RUN mvn -B package --file pom.xml -DskipTests

FROM openjdk:17-alpine
COPY /target/*.jar lead-service.jar
ENTRYPOINT ["java","-jar","lead-service.jar"]
EXPOSE 8100
