package ua.anakin.ui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import ua.anakin.model.StateColors;

public class Blinker {

    private StateColors stateColors;
    private Shape shape;
    private Color currentColor;


    public Blinker(Shape shape, StateColors stateColors) {
        this.shape = shape;
        this.stateColors = stateColors;
    }

    public void fill(){
        this.shape.setFill(this.currentColor);
    }

    public void enable() {
        this.currentColor = stateColors.getEnabledColor();
        fill();
    }

    public void disable(){
        this.currentColor = stateColors.getDisabledColor();
        fill();
    }

    public void reverse(){
        this.currentColor = isEnabled()?stateColors.getDisabledColor():stateColors.getEnabledColor();
        fill();
    }

    public boolean isEnabled(){
        return currentColor == stateColors.getEnabledColor();
    }

}
