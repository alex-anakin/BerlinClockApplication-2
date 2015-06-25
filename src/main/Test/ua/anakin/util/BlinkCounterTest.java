package ua.anakin.util;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class BlinkCounterTest {

    @Test
    public void testGetFiveHoursQty() throws Exception {
        BlinkCounter testClass = new BlinkCounter();
        int expectedValue = testClass.getCalendar().get(Calendar.HOUR_OF_DAY) / testClass.DIVISOR;
        int returnedValue = testClass.getFiveHoursQty();
        assertEquals(expectedValue, returnedValue);
    }

    @Test
    public void testGetOneHourQty() throws Exception {
        BlinkCounter testClass = new BlinkCounter();
        int expectedValue = testClass.getCalendar().get(Calendar.HOUR_OF_DAY) % testClass.DIVISOR;
        int returnedValue = testClass.getOneHourQty();
        assertEquals(expectedValue, returnedValue);
    }

    @Test
    public void testGetFiveMinutesQty() throws Exception {
        BlinkCounter testClass = new BlinkCounter();
        int expectedValue = testClass.getCalendar().get(Calendar.MINUTE) / testClass.DIVISOR;
        int returnedValue = testClass.getFiveMinutesQty();
        assertEquals(expectedValue, returnedValue);
    }

    @Test
    public void testGetOneMinuteQty() throws Exception {
        BlinkCounter testClass = new BlinkCounter();
        int expectedValue = testClass.getCalendar().get(Calendar.MINUTE) % testClass.DIVISOR;
        int returnedValue = testClass.getOneMinuteQty();
        assertEquals(expectedValue, returnedValue);
    }
}