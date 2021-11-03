FROM maven:3.8.3-openjdk-17-slim
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn clean -f pom.xml
RUN mvn -B package -f pom.xml -DskipTests

FROM openjdk:17-alpine
COPY /workspace/target/*.jar /workspace/lead-service.jar
ENTRYPOINT ["java","-jar","/workspace/lead-service.jar"]
EXPOSE 8100
