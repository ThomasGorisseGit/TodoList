FROM openjdk:17-jdk-alpine
RUN ls /var
RUN ls /tmp
RUN ls /home


RUN pwd
VOLUME /tmp
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar","/app.jar", "--spring.profiles.active=prod", "--spring.config.location=classpath:/,file:/home/ubuntu/application-prod.properties"]
