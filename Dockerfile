# Dockerfile

#java version 17
FROM docker.arvancloud.ir/openjdk

#Working directory
WORKDIR /challenge

#copy my app jar file to the container
COPY build/libs/challenge-1.0-SNAPSHOT.jar challenge.jar

# application will run on this port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "challenge.jar"]