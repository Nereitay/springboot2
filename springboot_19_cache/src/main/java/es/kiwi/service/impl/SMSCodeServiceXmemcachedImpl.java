package es.kiwi.service.impl;

import es.kiwi.model.SMSCode;
import es.kiwi.service.SMSCodeService;
import es.kiwi.utils.CodeUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service("smsCodeServiceXmemcached")
public class SMSCodeServiceXmemcachedImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    @Autowired
    private MemcachedClient memcachedClient;

    @Override
    public String sendCodeToSMS(String tel) {
        String code = codeUtils.generator(tel);

        try {
            memcachedClient.set(tel, 10, code);
        } catch (TimeoutException | MemcachedException | InterruptedException e) {
            e.printStackTrace();
        }

        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = null;
        try {
            code = memcachedClient.get(smsCode.getTel()).toString();

        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            e.printStackTrace();
        }

        return smsCode.getCode().equals(code);

    }


}
