FROM openjdk:18


ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar


EXPOSE 3000

CMD ["java", "-jar", "app.jar"]
