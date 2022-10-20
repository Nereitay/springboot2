package es.kiwi.service.impl.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MessageListenerA {

    @JmsListener(destination = "order.queue.id")
    @SendTo("order.next.queue.id") //将返回值发送到下一个队列
    public String receive(String id) {
        System.out.println("已完成短信发送业务， id: " + id);
        return "new : " + id;
    }
}
