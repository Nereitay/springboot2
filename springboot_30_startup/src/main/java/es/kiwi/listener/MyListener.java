package es.kiwi.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Spring监听机制
 */
public class MyListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("=====================================");
        System.out.println(event.getSource());
        System.out.println(event.getClass());
        System.out.println(event.getTimestamp());
    }
}

/*public class MyListener implements ApplicationListener<ApplicationStartingEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("=====================================");
        System.out.println(event.getSource());
        System.out.println(event.getClass());
        System.out.println(event.getTimestamp());
    }

}*/
