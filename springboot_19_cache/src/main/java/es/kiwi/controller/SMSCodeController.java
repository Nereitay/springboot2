package es.kiwi.controller;

import es.kiwi.model.SMSCode;
import es.kiwi.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    private SMSCodeService smsCodeService;

    @Autowired
    private SMSCodeService smsCodeServiceXmemcached;

    @GetMapping
    public String getCode(String tel) {
//        return smsCodeService.sendCodeToSMS(tel);
        return smsCodeServiceXmemcached.sendCodeToSMS(tel);

    }

    @PostMapping
    public boolean checkCode(SMSCode smsCode) {

//        return smsCodeService.checkCode(smsCode);
        return smsCodeServiceXmemcached.checkCode(smsCode);
    }
}
