FROM openjdk:8

ADD target/crud-web-demo-0.0.1-SNAPSHOT.jar crud-web-demo-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","crud-web-demo-0.0.1-SNAPSHOT.jar"]