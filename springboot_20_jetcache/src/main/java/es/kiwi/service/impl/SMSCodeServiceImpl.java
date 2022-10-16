package es.kiwi.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import es.kiwi.model.SMSCode;
import es.kiwi.service.SMSCodeService;
import es.kiwi.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("smsCodeService")
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

//    @CreateCache(area = "sms", name = "jetCache_", expire = 3600, timeUnit = TimeUnit.SECONDS) //remote
    @CreateCache(name = "jetCache_", expire = 3600, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.LOCAL)//默认用远程
    private Cache<String, String> jetCache;

    @Override
    public String sendCodeToSMS(String tel) {
        String code = codeUtils.generator(tel);
        jetCache.put(tel, code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = jetCache.get(smsCode.getTel());
        return smsCode.getCode().equals(code);
    }


}
