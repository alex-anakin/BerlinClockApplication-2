package ua.anakin.model;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ShapesModelTest {

    @Test
    public void testShowTime() {
        ShapesModel mockedShapesModel = mock(ShapesModel.class);
        mockedShapesModel.showTime();
        verify(mockedShapesModel, times(1)).showTime();
    }

    @Test
    public void testInitScheduler() {
        ShapesModel mockedShapesModel = mock(ShapesModel.class);
        mockedShapesModel.initScheduler();
        verify(mockedShapesModel, times(1)).initScheduler();
    }
}