FROM openjdk:11

LABEL maintainer="heron.lee@kakaocorp.com"

EXPOSE 10625

ARG JAR_FILE=build/libs/docker-spring-boot-example-1.0-SNAPSHOT.jar

ADD ${JAR_FILE} docker-spring-boot-run-test.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=local", "-jar", "/docker-spring-boot-run-test.jar"]
