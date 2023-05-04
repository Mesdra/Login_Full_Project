FROM maven:3.8.3-openjdk-17
WORKDIR /home/app
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dspring.profiles.active=dev
RUN mv /home/app/target/web-api.jar /home/web-api.jar
RUN rm -R /home/app
EXPOSE 8080
CMD ["java","-jar","/home/web-api.jar"]