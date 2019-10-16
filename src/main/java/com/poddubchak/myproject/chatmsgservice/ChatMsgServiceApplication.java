package com.poddubchak.myproject.chatmsgservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan("com.poddubchak.microservicies.model.chatmsg")
public class ChatMsgServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatMsgServiceApplication.class, args);
	}

}
