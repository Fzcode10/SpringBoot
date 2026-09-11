package com.example.SpringBootApplicationDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootApplicationDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringBootApplicationDemoApplication.class, args);

//		PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);
//		paymentGateway.print();

	}

}
