package es.kiwi.service.impl.activemq;

import es.kiwi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service("messageServiceActiveMQ")
public class MessageServiceActiveMQImpl implements MessageService {

    @Autowired
    private JmsMessagingTemplate messagingTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("带发送短信的订单已纳入处理队列， id: " + id);
        messagingTemplate.convertAndSend("order.queue.id", id);
    }

    @Override
    public String doMessage() {
        String id = messagingTemplate.receiveAndConvert("order.queue.id", String.class);
        System.out.println("已完成短信发送业务， id: " + id);
        return id;
    }
}
