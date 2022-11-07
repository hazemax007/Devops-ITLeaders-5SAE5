FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD 192.168.40.10:8081/repository/maven-releases/achat-1.0.jar achat.jar
ENTRYPOINT ["java","-jar","achat.jar"]
