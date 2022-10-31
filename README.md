# Sample Spring Boot Artemis JMS demo

Demonstrates a Spring Boot app producing and consuming messages from Apache ActiveMQ Artemis JMS queues.

## How to run with maven

1. Copy `./src/resources/application.properties` to `./src/resources/application-local.properties` and add your Artemis connection settings.
2. Run the Spring Boot app: `./mvnw spring-boot:run -Dspring-boot.run.profiles=local`
3. Type a message when prompted.
4. Verify message is received on Artemis queue (ex. using web console).

## How to build and run as a standalone JAR

1. Build Spring Boot JAR with Maven: `./mvnw clean package`
2. Run JAR: `java -jar target/jms-demo-0.0.1-SNAPSHOT.jar`