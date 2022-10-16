package es.kiwi.service;

import es.kiwi.model.SMSCode;

public interface SMSCodeService {

    String sendCodeToSMS(String tel);
    boolean checkCode(SMSCode smsCode);
}
