FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD http://192.168.40.10:8081/repository/maven-releases/achat/achat-1.0.jar achat.jar
ENTRYPOINT ["java","-jar","achat.jar"]
