package com.apress.messaging;

import com.apress.messaging.config.JMSProperties;
import com.apress.messaging.jms.SimpleSender;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SenderApplication.class, args);
	}

	@Bean
	CommandLineRunner simple(JMSProperties props, SimpleSender sender) {
		return args -> {
			sender.sendMessage(props.getQueue(), "Hello, World!");
		};
	}
}
