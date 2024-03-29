package org.example;

import java.util.TimerTask;

public class BotTimerTask extends TimerTask {
    HTTP http = new HTTP();

    @Override
    public void run() {
//        http.getAllActualVacancies();
    }
    //  timer.schedule(botTimerTask, 1800000, 1800000); every half hour
}
