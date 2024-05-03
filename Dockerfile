FROM openjdk:17
ADD target/demo01-1.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]