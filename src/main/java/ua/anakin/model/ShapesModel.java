package ua.anakin.model;

import ua.anakin.service.SchedulerService;
import ua.anakin.ui.BlinkingCircle;
import ua.anakin.util.BlinkCounter;

import java.util.Calendar;

public class ShapesModel {

    private SchedulerService schedulerService = new SchedulerService();

    private BlinkingCircle secondShape = new BlinkingCircle(StateColors.SECONDS_COLORS);
    private ShapesLine fiveHoursLine = new ShapesLine(4, StateColors.HOURS_COLORS);
    private ShapesLine oneHoursLine = new ShapesLine(4, StateColors.HOURS_COLORS);
    private ShapesLine fiveMinutesLine = new ShapesLine(11, StateColors.SECONDS_COLORS, 3, StateColors.MINUTES_COLORS);
    private ShapesLine oneMinutesLine = new ShapesLine(4, StateColors.SECONDS_COLORS);

    public ShapesModel() {
        showTime();
        initScheduler();
    }

    private void showTime() {
        BlinkCounter blinkCounter = new BlinkCounter();
        fiveHoursLine.showTimeField(blinkCounter.getFiveHoursQty());
        oneHoursLine.showTimeField(blinkCounter.getOneHourQty());
        fiveMinutesLine.showTimeField(blinkCounter.getFiveMinutesQty());
        oneMinutesLine.showTimeField(blinkCounter.getOneMinuteQty());
    }

    private void initScheduler() {

        schedulerService.scheduleUITask(SchedulerService.ONE_SECOND, new Runnable() {
            @Override
            public void run() {
                secondShape.reverse();
            }
        });

        schedulerService.scheduleUITask((60 - Calendar.getInstance().get(Calendar.SECOND)) * SchedulerService.ONE_SECOND,
                /*wait til the end of current minute*/
                SchedulerService.ONE_MINUTE,
                new Runnable() {
                    @Override
                    public void run() {
                        ShapesModel.this.showTime();
                    }
                });
    }

    public BlinkingCircle getSecondShape() {
        return secondShape;
    }

    public SchedulerService getSchedulerService() {
        return schedulerService;
    }

    public ShapesLine getFiveHoursLine() {
        return fiveHoursLine;
    }

    public ShapesLine getOneHoursLine() {
        return oneHoursLine;
    }

    public ShapesLine getFiveMinutesLine() {
        return fiveMinutesLine;
    }

    public ShapesLine getOneMinutesLine() {
        return oneMinutesLine;
    }
}
