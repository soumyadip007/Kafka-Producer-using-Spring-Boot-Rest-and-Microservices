package com.kafka.producer.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.entity.User;


@RestController
@RequestMapping("kafka")
public class Controller {

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	public static final String Topic="Kafka_Spring";
	
	@GetMapping("trigger")
	public String Trigger() {
		
		kafkaTemplate.sendOffsetsToTransaction(Topic,"Hello");
		
		return "Kafka Message Produced";
	}
	
}