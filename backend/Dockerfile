FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar","/app.jar", "--spring.profiles.active=prod", "--spring.config.location=classpath:/,file:/app/config/application-prod.properties"]
