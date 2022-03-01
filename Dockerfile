FROM maven:3.8.4-openjdk-17 as build

WORKDIR /code
COPY . /code/
RUN mvn clean package
RUN mv target/mspr-1.0-SNAPSHOT-jar-with-dependencies.jar /code/app.jar

FROM openjdk:17-alpine
WORKDIR /code
COPY --from=build /code/app.jar /code/app.jar
CMD ["java", "-jar", "/code/app.jar"]
