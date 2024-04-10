package com.wanzi.infrastructure.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * 功能描述:
 *
 * @author: qiu wanzi
 * @date: 2024年4月10日 0010
 * @version: 1.0
 */
@Component
public class RedisMessageConsumer implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(message.getChannel());
        String messageBody = new String(message.getBody());
        // 在这里处理接收到的消息
        System.out.println("Received message: " + messageBody + " from channel: " + channel);
    }
}
