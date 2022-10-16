package es.kiwi;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Java方式
 */
public class TimerTaskApp {

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer task running...");
            }
        };
        timer.schedule(task, 0, 2000);
    }
}
