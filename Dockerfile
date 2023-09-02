FROM openjdk:8

ADD target/spring-boot-2-hello-world-1.0.2-SNAPSHOT.jar spring-boot-2-hello-world-1.0.2-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","spring-boot-2-hello-world-1.0.2-SNAPSHOT"]