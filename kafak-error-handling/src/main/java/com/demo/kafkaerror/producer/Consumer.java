package com.demo.kafkaerror.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	
	@RetryableTopic(attempts = "2")
	@KafkaListener(topics = "kafka-error-handling-demo", groupId = "foo")
	public void listen(String in, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.OFFSET) long offset) {

		this.logger.info("Received: {} from {} offset {}", in, topic, offset);
		if (in.startsWith("fail")) {
			throw new RuntimeException("failed");
		}
	}

	@DltHandler
	public void listenDlt(String in, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.OFFSET) long offset) {

		this.logger.info("DLT Received: {} from {} offset {}", in, topic, offset);
	}

}
