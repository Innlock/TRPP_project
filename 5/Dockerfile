FROM gradle:7.4.2-jdk11
COPY . /gradle/project
# вместо . надо путь на root
WORKDIR /gradle/project
EXPOSE 8080
ENTRYPOINT ["gradle"]
CMD ["bootRun"]

#FROM openjdk:14-jdk-alpine
##RUN addgroup -S spring && adduser -S spring -G spring
##USER spring:spring
##COPY . /gradle/project
#COPY build/libs/demo-0.0.1-SNAPSHOT.jar home/spring/application.jar
#EXPOSE 8080
#CMD ["java", "-jar", "/home/spring/application.jar"]

