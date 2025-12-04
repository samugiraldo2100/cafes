# ---- build ----
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
# Copia desde el root del repo
COPY turnos-service/pom.xml ./turnos-service/pom.xml
RUN mvn -q -f turnos-service/pom.xml -DskipTests dependency:go-offline
COPY turnos-service/src ./turnos-service/src
RUN mvn -q -f turnos-service/pom.xml -DskipTests clean package

# ---- run ----
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/turnos-service/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
