package com.wanzi.infrastructure.redis;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * 功能描述:
 *
 * @author: qiu wanzi
 * @date: 2024年4月10日 0010
 * @version: 1.0
 */
public class MessageSubscriber {

    private final RedisMessageListenerContainer listenerContainer;

    public MessageSubscriber(RedisConnectionFactory connectionFactory, RedisMessageConsumer messageListener) {
        this.listenerContainer = new RedisMessageListenerContainer();
        this.listenerContainer.setConnectionFactory(connectionFactory);
        this.listenerContainer.addMessageListener(messageListener, new ChannelTopic("redis-topic-demo"));
        this.listenerContainer.afterPropertiesSet();
        this.listenerContainer.start();
    }

}
