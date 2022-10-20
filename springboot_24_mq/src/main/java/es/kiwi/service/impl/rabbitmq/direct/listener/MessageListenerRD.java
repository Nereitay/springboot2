package es.kiwi.service.impl.rabbitmq.direct.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListenerRD {

    @RabbitListener(queues = {"direct_queue"})
    public void receiver(String id) {
        System.out.println("已完成短信发送业务(rabbitmq direct)， id: " + id);
    }
}
