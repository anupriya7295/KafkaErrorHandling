package com.demo.kafkaerror.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Sender {
	
	@Autowired
	KafkaSender kafkaSender;

	@PostMapping("/send/{message}")
	public void sendFoo(@PathVariable String message) {
		kafkaSender.send(message);

	}

}

