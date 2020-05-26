package com.kafka.producer.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.entity.User;


@RestController
@RequestMapping("/kafka-producer")
public class Controller {

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate1;
	
	public static final String Topic1="Kafka_Object";
	
	public static final String Topic2="Kafka_String";
	
	
	@GetMapping("/trigger-object")
	public String TriggerObject() {
		
		kafkaTemplate.send(Topic1, new User("Soumya", "Java", 190000));
		
		return "Kafka Object Message Produced";
	}
	
	
	@GetMapping("/test")
	public String TriggerString() {
		
		kafkaTemplate1.send(Topic2, "Hey! This is kafka");
		
		return "Kafka String Message Produced";
	}
}
