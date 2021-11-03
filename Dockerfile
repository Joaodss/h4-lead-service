FROM openjdk:17-jdk-slim
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -B package --file pom.xml -DskipTests

FROM openjdk:17-alpine
COPY --from=build /workspace/target/*jar-with-dependencies.jar lead-service.jar
ENTRYPOINT ["java","-jar","discovery-service.jar"]
EXPOSE 8100
