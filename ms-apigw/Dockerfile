FROM alpine:latest

RUN apk add --no-cache openjdk17

ENV JAR_DIR ms-apigw-0.0.1.jar

COPY $JAR_DIR /app/

CMD java -jar /app/$JAR_DIR