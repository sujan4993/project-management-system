from openjdk:8-jdk-alpine
volume /tmp
add target/demo-0.0.1-SNAPSHOT.jar app.jar
entrypoint ["java",["jar"],"/app.jar"]
