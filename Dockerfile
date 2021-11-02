FROM openjdk:17-alpine
COPY target/lead-service-*.jar lead-service/lead-service.jar
WORKDIR lead-service
CMD ["java","-jar","lead-service.jar"]
