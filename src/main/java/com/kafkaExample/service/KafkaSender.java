package com.kafkaExample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafkaExample.model.Employee;

@Service
public class KafkaSender {
	
	@Autowired
	private KafkaTemplate<String, Employee> kafkaTemplate;
	
	String kafkaTopic = "java_in_use_topic";
	
	public void send(Employee employee) {
	    
	    kafkaTemplate.send(kafkaTopic, employee);
	}
}
