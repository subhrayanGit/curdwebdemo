FROM openjdk:8

ADD target/crud-web-demo-0.0.1-SNAPSHOT.war crud-web-demo-0.0.1-SNAPSHOT.war

EXPOSE 8081

ENTRYPOINT ["java","-war","crud-web-demo-0.0.1-SNAPSHOT.war"]