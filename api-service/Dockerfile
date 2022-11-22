FROM openjdk:17-alpine

RUN echo "networkaddress.cache.ttl=0" >> /opt/openjdk-17/conf/security/java.security

RUN addgroup -S spring && adduser -S spring -G spring
RUN mkdir /app

USER spring:spring

ARG JAR_FILE
ADD ${JAR_FILE} /app/application.jar

WORKDIR /app
CMD ["java", "-jar", "/app/application.jar"]