package es.kiwi.controller;

import es.kiwi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msg")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageService messageServiceActiveMQ;

    @Autowired
    private MessageService messageServiceRabbitMQDirect;



    @GetMapping
    public String doMessage() {
//        String id = messageService.doMessage();
//        String id = messageServiceActiveMQ.doMessage();
        String id = messageServiceRabbitMQDirect.doMessage();
        return id;
    }
}
