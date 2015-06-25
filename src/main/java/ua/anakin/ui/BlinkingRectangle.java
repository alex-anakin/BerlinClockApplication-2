package ua.anakin.ui;


import javafx.scene.shape.Rectangle;
import ua.anakin.model.StateColors;

public class BlinkingRectangle extends Rectangle implements BlinkingShape {

    public static final int H_GAP = 5;
    public static final int DEFAULT_WIDTH = 220;
    public static final int DEFAULT_HEIGHT = 30;
    private Blinker blinker;

    public BlinkingRectangle(StateColors stateColors, int qty) {
        super();
        this.setWidth((DEFAULT_WIDTH - qty * H_GAP) / qty);
        this.setHeight(DEFAULT_HEIGHT);
        this.blinker = new Blinker(this, stateColors);
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
