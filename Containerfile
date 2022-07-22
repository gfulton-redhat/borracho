FROM openjdk:18-jdk-alpine as build
USER 0
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY data-clean .
COPY data-analysis .
COPY data-collect .
COPY data-evaluate .
COPY data-extract .
COPY data-metadata .
COPY data-prepare .
COPY data-query .
COPY data-split .
COPY data-storage .
COPY data-transform .
COPY data-validate .

RUN chmod +x ./mvnw && ./mvnw clean test package
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:18-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
USER 1001
ENTRYPOINT ["java","-cp","app:app/lib/*","com.redhat.examples.Application"]
