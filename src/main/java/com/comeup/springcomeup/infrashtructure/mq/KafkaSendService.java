package com.comeup.springcomeup.infrashtructure.mq;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 功能描述:
 *
 * @author: qiu wanzi
 * @date: 2024年3月20日 0020
 * @version: 1.0
 */
@Service
@Slf4j
public class KafkaSendService {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendDemo(String message) {
        log.info("[kafka发送消息] KafkaSendService sendDemo message: {} timestamp: {}", JSONUtil.toJsonStr(message), LocalDateTime.now());
        kafkaTemplate.send("demo-topic",0, "", message);
    }





}
