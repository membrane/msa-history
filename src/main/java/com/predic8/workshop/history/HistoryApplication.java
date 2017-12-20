package com.predic8.workshop.history;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@EnableKafka
@EnableDiscoveryClient
@SpringBootApplication
public class HistoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(HistoryApplication.class, args);
	}
}