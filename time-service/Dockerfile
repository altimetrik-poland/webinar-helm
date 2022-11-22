FROM openjdk:17-alpine

RUN addgroup -S spring && adduser -S spring -G spring
RUN mkdir /app

USER spring:spring

ARG JAR_FILE
ADD ${JAR_FILE} /app/application.jar

WORKDIR /app
CMD ["java","-jar","/app/application.jar"]