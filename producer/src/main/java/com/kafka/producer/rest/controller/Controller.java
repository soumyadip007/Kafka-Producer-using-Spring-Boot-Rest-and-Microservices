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

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate1;
	
	public static final String Topic1="Kafka_Object";
	
	
	@GetMapping("trigger-object")
	public String TriggerObject() {
		
		kafkaTemplate.send(Topic1, new User("Soumya", "Java", 190000));
		
		return "Kafka Message Produced";
	}
	
	
	@GetMapping("trigger-String")
	public String TriggerString() {
		
		kafkaTemplate1.send(Topic1, "Trigerring Stirng");
		
		return "Kafka Message Produced";
	}
}
