FROM openjdk:17-jdk-alpine
COPY target/auth-0.0.1-SNAPSHOT.jar auth-0.0.1-SNAPSHOT.jar
ENV JAVA_OPTS=""
EXPOSE 8080
CMD exec java -jar auth-0.0.1-SNAPSHOT.jar
