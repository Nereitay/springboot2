package es.kiwi.service.impl;

import es.kiwi.model.SMSCode;
import es.kiwi.service.SMSCodeService;
import es.kiwi.utils.CodeUtils;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("smsCodeService")
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    @Autowired
    private CacheChannel cacheChannel;

    @Override
    public String sendCodeToSMS(String tel) {
        String code = codeUtils.generator(tel);
        cacheChannel.set("sms", tel, code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = cacheChannel.get("sms", smsCode.getTel()).asString();
        return smsCode.getCode().equals(code);
    }


}
