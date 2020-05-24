package com.kafka.producer.rest.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {

	
	@Bean
	public ProducerFactory<String, User> producerFactory(){
		
	}
}
