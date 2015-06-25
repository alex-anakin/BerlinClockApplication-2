package ua.anakin.service;

import javafx.application.Platform;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SchedulerService {

    private static final int DEFAULT_DELAY = 0;
    public static final long ONE_SECOND = 1000;
    public static final long ONE_MINUTE = 60 * ONE_SECOND;

    private Timer timer = new Timer();
    private List<TimerTask> tasks = new LinkedList<>();


    public void scheduleUITask(long delay, long period, final Runnable runnable) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(runnable);
            }
        };
        tasks.add(task);
        timer.schedule(task, delay, period);
    }

    public void scheduleUITask(long period, final Runnable runnable) {
        scheduleUITask(DEFAULT_DELAY, period, runnable);
    }

    public void stopScheduledTasks() {
        for (TimerTask task : tasks) {
            task.cancel();
        }
    }
}
