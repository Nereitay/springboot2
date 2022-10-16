package es.kiwi.service.impl;

import es.kiwi.model.SMSCode;
import es.kiwi.service.SMSCodeService;
import es.kiwi.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("smsCodeService")
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    @Override
//    @Cacheable(value = "smsCode", key = "#tel")
    @CachePut(value = "smsCode", key = "#tel")
    public String sendCodeToSMS(String tel) {
        return codeUtils.generator(tel);
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        //取出内存中的验证码与传递过来的验证码比对，如果相同，返回true
        String code = smsCode.getCode();
        String cashCode = codeUtils.get(smsCode.getTel());
        return code.equals(cashCode);
    }


}
