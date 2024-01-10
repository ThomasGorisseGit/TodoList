FROM openjdk:17-jdk-alpine
ARG JAR_FILE=backend/target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar","/app.jar", "--spring.profiles.active=prod", "--spring.config.location=classpath:/,file:/home/ubuntu/application-prod.properties"]