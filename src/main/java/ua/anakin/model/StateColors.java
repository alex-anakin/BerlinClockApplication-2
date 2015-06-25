package ua.anakin.model;

import javafx.scene.paint.Color;

public enum StateColors {

    SECONDS_COLORS(Color.YELLOW, Color.OLIVE),
    HOURS_COLORS(Color.RED, Color.ROSYBROWN),
    MINUTES_COLORS(Color.RED, Color.ROSYBROWN);

    private Color enabledColor;
    private Color disabledColor;

    StateColors(Color enabledColor, Color disabledColor) {
        this.enabledColor = enabledColor;
        this.disabledColor = disabledColor;
    }

    public Color getDisabledColor() {
        return disabledColor;
    }

    public Color getEnabledColor() {
        return enabledColor;
    }

}
