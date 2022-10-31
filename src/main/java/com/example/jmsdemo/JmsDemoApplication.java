package com.example.jmsdemo;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;


@SpringBootApplication
@EnableJms
public class JmsDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(JmsDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JmsDemoApplication.class, args);
	}

	@Value("${app.queue.name}")
	String queueName;

	@Value ("${spring.artemis.broker-url}")
	String brokerURL;

	@Bean
	CommandLineRunner start(JmsTemplate template) {
		return args -> {
			log.info("JmsDemoApplication - CommandLineRunner started...");
			log.info("Connected to Artemis brokers: " + brokerURL);
			
			Scanner scanner = new Scanner(System.in);

			while (true) {	
				System.out.print("Enter a message to send or type 'quit' to exit: ");
				String message = scanner.next();
				if (!"quit".equals(message)) {
					template.convertAndSend(queueName, message);
				} else {
					break;
				}
			}
			
			scanner.close();
		};
	}

}
