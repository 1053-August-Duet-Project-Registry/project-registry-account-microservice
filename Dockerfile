FROM maven:3.6.3-jdk-11-slim as builder
WORKDIR /app
COPY . .
RUN mvn clean package spring-boot:repackage -DskipTests=true
RUN cp target/app.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8081
ENV JAVA_MEM_OPTS="-Xms512m -Xmx512m"
ENV JAVA_OPTS="${JAVA_OPTS} -XX:+UnlockExperimentalVMOptions -XX:+UseZGC"
ENV JAVA_OPTS="${JAVA_OPTS} ${JAVA_MEM_OPTS}"
ENV JAVA_OPTS="${JAVA_OPTS} -Dspring.profiles.active=default"
WORKDIR /app
ARG DEPENDENCY=/app
COPY --from=builder $DEPENDENCY/dependencies/ ./
# 'RUN true' is required between COPY commands because Docker decided not to solve the known
# issue because this is an easy work-around: https://github.com/moby/moby/issues/37965
#   (yeah, we think it's dumb too, but it works)
RUN true
COPY --from=builder $DEPENDENCY/snapshot-dependencies/ ./
RUN true
COPY --from=builder $DEPENDENCY/spring-boot-loader/ ./
RUN true
COPY --from=builder $DEPENDENCY/application/ ./
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom org.springframework.boot.loader.JarLauncher"]

