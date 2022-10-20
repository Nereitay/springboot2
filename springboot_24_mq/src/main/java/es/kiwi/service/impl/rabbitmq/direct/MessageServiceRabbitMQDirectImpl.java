package es.kiwi.service.impl.rabbitmq.direct;

import es.kiwi.service.MessageService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageServiceRabbitMQDirect")
public class MessageServiceRabbitMQDirectImpl implements MessageService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("带发送短信的订单已纳入处理队列(rabbitmq direct)， id: " + id);
        amqpTemplate.convertAndSend("directExchange", "direct", id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
