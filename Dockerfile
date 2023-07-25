FROM openjdk:17-oracle

EXPOSE 8085

COPY target/demo-0.0.1-SNAPSHOT.jar AuthorApp.jar

CMD ["java", "-jar", "AuthorApp.jar"]