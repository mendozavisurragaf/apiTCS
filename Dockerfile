FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/ApiTest-1.jar
ADD ${JAR_FILE} ApiTest-1.jar
ENTRYPOINT ["java","-jar","/ApiTest-1.jar"]