# For Java 8, try this
FROM openjdk:8-jdk-alpine

EXPOSE 8089
# Refer to Maven build -> finalName
ARG JAR_FILE=target/achat-1.0.jar 

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} achat.jar

#execute a command-line inside the container:to install the dependencies in pom.xml.
RUN mvn clean install

#run script mvn spring-boot:run after the image is built.
CMD mvn spring-boot:run

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","achat.jar"]