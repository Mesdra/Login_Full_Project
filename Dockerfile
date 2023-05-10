ARG BUILD_IMAGE=maven:3.8.3-openjdk-17
ARG RUNTIME_IMAGE=openjdk:17-jdk-slim

###  pull maven dependencies  ###

FROM ${BUILD_IMAGE} as dependencies
COPY pom.xml ./
RUN mvn -B dependency:go-offline

###  build  ###
FROM dependencies as build

ARG PROFILE_PROP=dev
COPY src ./src
RUN mvn -B clean package \
       -Dspring.profiles.active=${PROFILE_PROP}

### run ###
FROM ${RUNTIME_IMAGE}

COPY --from=build /target/web-api.jar /app/service.jar
CMD ["java", "-jar", "/app/service.jar"]

#######################################################