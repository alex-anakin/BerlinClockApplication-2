package ua.anakin.ui;

import javafx.scene.shape.Circle;
import ua.anakin.model.StateColors;

public class BlinkingCircle extends Circle implements BlinkingShape {

    private Blinker blinker;

    public BlinkingCircle(StateColors stateColors) {
        super();
        this.setRadius(20);
        this.blinker = new Blinker(this, stateColors);
        blinker.reverse();
    }

    @Override
    public void enable() {
        this.blinker.enable();
    }

    @Override
    public void disable() {
        this.blinker.disable();
    }

    @Override
    public void reverse() {
        this.blinker.reverse();
    }
}
