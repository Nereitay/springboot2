package es.kiwi.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CodeUtils {

    private String[] patch = {"000000", "00000", "0000", "000", "00", "0", ""};

    public String generator (String tel) {
        int hash = tel.hashCode();
        int encryption = 20221015;
        long result = hash ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;

        long code = Math.abs(result % 1000000);
        String codeStr = String.valueOf(code);

        return patch[codeStr.length()] + codeStr;
    }

    @Cacheable(value = "smsCode", key = "#tel")
    public String get(String tel) {
        return null;
    }

}
