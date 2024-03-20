package com.comeup.springcomeup.infrashtructure.mq;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
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
public class KafkaConsumerService {

    @KafkaListener(topics = "demo-topic")
    public void consumer(ConsumerRecord<?, ?> record) {
        log.info("[kafka消费消息] KafkaConsumerService consumer record: {} timestamp: {}", JSONUtil.toJsonStr(record.value()), LocalDateTime.now());
    }



}
