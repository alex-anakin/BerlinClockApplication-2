package ua.anakin.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class BlinkCounter {

    private final Calendar calendar;

    //value of DIVISOR is determined by the design of Berlin clock
    public final int DIVISOR = 5;

    public BlinkCounter() {
        calendar = GregorianCalendar.getInstance();
    }

    public int getFiveHoursQty() {
        return calendar.get(Calendar.HOUR_OF_DAY) / DIVISOR;
    }

    public int getOneHourQty() {
        return calendar.get(Calendar.HOUR_OF_DAY) % DIVISOR;
    }

    public int getFiveMinutesQty() {
        return calendar.get(Calendar.MINUTE) / DIVISOR;
    }

    public int getOneMinuteQty() {
        return calendar.get(Calendar.MINUTE) % DIVISOR;
    }

    public Calendar getCalendar() {
        return calendar;
    }
}