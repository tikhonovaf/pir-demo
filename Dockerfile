FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/pir_demo.jar
WORKDIR /opt/app
COPY ${JAR_FILE} pir_demo.jar
ENTRYPOINT ["java","-jar","pir_demo.jar"]