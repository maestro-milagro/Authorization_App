FROM openjdk:17-oracle

EXPOSE 8085:8085

COPY target/demo-0.0.1-SNAPSHOT.jar myapp.jar

ENTRYPOINT ["java","-jar","/myapp.jar"]