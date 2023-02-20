FROM gradle:7.4.1 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:8-jre-slim
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/phone-book-system-0.0.1-SNAPSHOT-plain.jar /app/
RUN bash -c 'touch /app/phone-book-system-0.0.1-SNAPSHOT-plain.jar'
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/phone-book-system-0.0.1-SNAPSHOT-plain.jar"]