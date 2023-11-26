FROM openjdk:17

ENV PORT 3232

#ENV CONFIG_URL "http://host.docker.internal:8888"
#ENV NAME_CONFIG "paymentsparking"
#ENV PROFILE_CONFIG "lopdev"

ENV JWT_URI "http://host.docker.internal:8080/realms/parking/protocol/openid-connect/certs"
ENV JWT_ISSUER "http://host.docker.internal:8080/realms/parking"
ENV KEYCLOAK_TOKEN "ZgBAyWoHLGK7nJjQnLPvjYPrfbYibFy3"

ENV BD_URL "jdbc:postgresql://host.docker.internal:5432/parqueo"
ENV BD_USER "usertest"
ENV BD_PASS "123456"

ENV EUREKA_URL "http://host.docker.internal:8714/eureka/"

COPY target/pagos-0.0.1-SNAPSHOT.jar java-app.jar
ENTRYPOINT ["java", "-jar", "java-app.jar"]