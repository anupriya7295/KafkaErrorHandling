package com.demo.kafkaerror.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	String kafkaTopic = "kafka-error-handling-demo";
	
	public void send(String message) {
	    
	    this.kafkaTemplate.send(kafkaTopic, message);
	}

}
