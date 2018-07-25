package com.hisign.kafka_demo.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@EnableKafka
public class Listener {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());


	@KafkaListener(topics = {"test"})
	public void listen(ConsumerRecord<?, ?> record) {
		logger.info("kafka的key: " + record.key());
		logger.info("kafka的value: " + record.value().toString());
	}

}
