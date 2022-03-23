package com.kafkaExample.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkaExample.model.Employee;
import com.kafkaExample.repo.EmpRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class consumerService {
	
	@Autowired
    ObjectMapper objectMapper;
	
	@Autowired
    private EmpRepo empRepo;
	
	public void process(Employee record) throws JsonProcessingException {
        //Employee employee = objectMapper.readValue(record.value(), Employee.class); // value is where producer writes the event
        log.info("emp event" + record);
        empRepo.save(record);
    }

}
