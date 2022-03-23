package com.kafkaExample.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkaExample.consumer.consumerService;
import com.kafkaExample.model.Employee;
import com.kafkaExample.repo.EmpRepo;

import lombok.extern.slf4j.Slf4j;


@Component
//@Service
@Slf4j
public class Consumer {
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
    consumerService consumerService;
	
//	@Autowired
//	EmpRepo employeeRepository;
	
	@KafkaListener(topics="java_in_use_topic")
	public void consumeFromTopic(Employee record) throws JsonMappingException, JsonProcessingException {
		 
		log.info("Consumer record" + record);
		consumerService.process(record);
		//System.out.println(e.toString());
		//employeeRepository.save(emp);
		
	}

}
