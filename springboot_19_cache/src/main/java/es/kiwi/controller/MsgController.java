package es.kiwi.controller;

import es.kiwi.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private MsgService msgService;

    @GetMapping("/{tel}")
    public String get(@PathVariable String tel) {
        return msgService.get(tel);
    }

    @PostMapping
    public boolean check(String tel, String code) {
        return msgService.check(tel, code);
    }
}
