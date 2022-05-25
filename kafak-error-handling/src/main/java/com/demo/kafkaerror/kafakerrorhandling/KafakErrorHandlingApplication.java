package com.demo.kafkaerror.kafakerrorhandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.demo.kafkaerror.producer.Sender;

@SpringBootApplication
@ComponentScan(basePackages="com")
public class KafakErrorHandlingApplication {

	public static void main(String[] args) {
        System.out.println("App starting" );
		SpringApplication.run(KafakErrorHandlingApplication.class, args);
        System.out.println("App started" );

	}

}
