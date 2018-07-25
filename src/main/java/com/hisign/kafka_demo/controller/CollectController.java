package com.hisign.kafka_demo.controller;

import com.hisign.kafka_demo.vo.CommonResponse;
import com.hisign.kafka_demo.vo.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/kafka")
public class CollectController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private KafkaTemplate kafkaTemplate;

	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public CommonResponse sendKafka(HttpServletRequest request, HttpServletResponse response) {
		try {
			String message = request.getParameter("message");
			logger.info("kafka的消息={}", message);
			kafkaTemplate.send("test", "key", message);
			logger.info("发送kafka成功.");
			return new CommonResponse(ResultCode.SUCCESS, "发送kafka成功");
		} catch (Exception e) {
			logger.error("发送kafka失败", e);
			return new CommonResponse(ResultCode.EXCEPTION, "发送kafka失败");
		}
	}


}
