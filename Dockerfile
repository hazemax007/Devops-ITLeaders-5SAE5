FROM openjdk:11

# Refer to Maven build -> finalName
ARG JAR_FILE=target/achat-1.0.jar

# cd /opt/app
WORKDIR /src/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} achat.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","/achat.jar"]

EXPOSE 8089