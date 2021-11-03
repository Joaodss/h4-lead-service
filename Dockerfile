FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} lead-service.jar
ENTRYPOINT ["java","-jar","/discovery-service.jar"]
EXPOSE 8100
