FROM openjdk:18-jdk-alpine as build
USER 0
WORKDIR /workspace/app
ARG MODULE
ARG MODULE_COMPONENT="${MODULE}-component"
ARG DEPENDENCY=/workspace/app/${MODULE}/${MODULE_COMPONENT}/target/dependency

COPY . .
COPY ${MODULE} ${MODULE}

RUN chmod +x ./mvnw && \
    ./mvnw clean test package -am -pl ${MODULE} && \
    mkdir -p ${DEPENDENCY} && \
    ls /workspace/app/${MODULE}/${MODULE_COMPONENT}/target/ && \
    (cd ${DEPENDENCY}; jar -xf ../*.jar)

RUN ls ${DEPENDENCY}

FROM openjdk:18-jdk-alpine
VOLUME /tmp
ARG MODULE
ARG MODULE_COMPONENT="${MODULE}-component"
ARG DEPENDENCY=/workspace/app/${MODULE}/${MODULE_COMPONENT}/target/dependency

COPY --from=build ${DEPENDENCY}/org /app/org
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
USER 1001
ENTRYPOINT ["java","-cp","app:app/org/*","org.ploigos.Application"]
