package com.kafkaExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaExample.model.Employee;
import com.kafkaExample.service.KafkaSender;



@RestController
@RequestMapping(value = "/javainuse-kafka/")
public class ApacheKafkaWebController {

	@Autowired
	KafkaSender kafkaSender;

	@PostMapping(value = "/producer")
	public String producer(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("city") String city) {
		Employee e = new Employee();
		e.setId(id);
		e.setFirstname(name);
		e.setCity(city);
		kafkaSender.send(e);

		return "Message sent to the Kafka Topic java_in_use_topic Successfully";
	}

}
