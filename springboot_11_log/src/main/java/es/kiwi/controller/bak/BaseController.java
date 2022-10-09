package es.kiwi.controller.bak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {

    private Class clazz;

    public static Logger log;

    public BaseController() {
        clazz = this.getClass();
        log = LoggerFactory.getLogger(clazz);
    }

}
