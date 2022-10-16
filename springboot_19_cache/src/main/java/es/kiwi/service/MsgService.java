package es.kiwi.service;

public interface MsgService {

    String get(String tel);

    boolean check(String tel, String code);
}
