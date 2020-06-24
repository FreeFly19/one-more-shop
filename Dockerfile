FROM gradle:jdk11 as builder

WORKDIR /app

COPY . /app

RUN gradle build -x test

FROM openjdk:11-jre

COPY --from=builder /app/build/libs/one-more-shop-with-ml-blackjack-and-sluts-0.0.1-SNAPSHOT.jar /tmp/

ENTRYPOINT ["java", "-jar", "/tmp/one-more-shop-with-ml-blackjack-and-sluts-0.0.1-SNAPSHOT.jar"]