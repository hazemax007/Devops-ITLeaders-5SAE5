FROM openjdk:11-jdk-alpine
EXPOSE 8090
ADD target/achat-1.0.jar achat.jar
ENTRYPOINT ["java","-jar","achat.jar"]