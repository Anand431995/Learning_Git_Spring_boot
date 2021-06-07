FROM openjdk:11
EXPOSE 8080
ADD target/spring-image-docker-new.jar spring-image-docker-new.jar
#ADD target/drive-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java" , "-jar" , "/spring-image-docker-new.jar"]
