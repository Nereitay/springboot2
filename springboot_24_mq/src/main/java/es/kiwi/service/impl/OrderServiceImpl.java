package es.kiwi.service.impl;

import es.kiwi.service.MessageService;
import es.kiwi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageService messageServiceActiveMQ;

    @Autowired
    private MessageService messageServiceRabbitMQDirect;

    @Autowired
    private MessageService messageServiceRabbitMQTopic;

    @Override
    public void order(String id) {
        System.out.println("订单处理开始");
        //短信信息处理
//        messageService.sendMessage(id);
//        messageServiceActiveMQ.sendMessage(id);
//        messageServiceRabbitMQDirect.sendMessage(id);
        messageServiceRabbitMQTopic.sendMessage(id);
        System.out.println("订单处理结束");
    }
}
