package com.hisign.kafka_demo.sender;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hisign.kafka_demo.vo.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@Slf4j
public class KafkaSender {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private Gson gson = new GsonBuilder().create();

	//发送消息方法
	public void send() {
		Message message = new Message();
		message.setId(System.currentTimeMillis());
		message.setMsg(UUID.randomUUID().toString());
		message.setSendTime(new Date());
		log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
		kafkaTemplate.send("zhisheng", gson.toJson(message));
		Message message1 = new Message();
		message1.setId(System.currentTimeMillis());
		message1.setMsg("huangjuan");
		message1.setSendTime(new Date());
		kafkaTemplate.send("test_111", 3 ,gson.toJson(message1));
	}
}
