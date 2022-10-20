package es.kiwi.service.impl.rabbitmq.topic.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListenerRT {

    @RabbitListener(queues = {"topic_queue"})
    public void receiver(String id) {
        System.out.println("已完成短信发送业务(rabbitmq topic 1)， id: " + id);
    }

    @RabbitListener(queues = {"topic_queue2"})
    public void receiver2(String id) {
        System.out.println("已完成短信发送业务(rabbitmq topic 2)， id: " + id);
    }
}
