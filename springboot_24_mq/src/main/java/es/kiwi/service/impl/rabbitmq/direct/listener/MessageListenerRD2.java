package es.kiwi.service.impl.rabbitmq.direct.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListenerRD2 {

    @RabbitListener(queues = {"direct_queue"}) //两个监听器处理同一个队列，会轮询处理
    public void receiver(String id) {
        System.out.println("已完成短信发送业务(rabbitmq direct two)， id: " + id);
    }
}
