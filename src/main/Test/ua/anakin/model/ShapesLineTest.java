package ua.anakin.model;

import org.junit.Test;
import ua.anakin.util.BlinkCounter;

import java.util.Calendar;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ShapesLineTest {

    @Test
    public void testShowTimeField() throws Exception {
        int testQty = 1;
        ShapesLine mockedShapesLine = mock(ShapesLine.class);
        mockedShapesLine.showTimeField(testQty);
        verify(mockedShapesLine, times(1)).showTimeField(testQty);
    }

    @Test
    public void testShowTimeFieldGetShape() throws Exception {
        int constructorSize = 4;
        int testQty = 2;
        ShapesLine testClass = new ShapesLine(constructorSize, StateColors.HOURS_COLORS);
        int expectedValue = 4;
        testClass.showTimeField(testQty);
        int returnedValue = testClass.getShapes().size();
        assertEquals(expectedValue, returnedValue);
    }
}