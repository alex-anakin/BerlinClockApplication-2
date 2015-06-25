package ua.anakin.model;

import javafx.scene.Node;
import ua.anakin.ui.BlinkingRectangle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShapesLine {

    private Map<Integer, BlinkingRectangle> shapes = new HashMap<>();

    public ShapesLine(int size, StateColors stateColors) {
        for (int i = 0; i < size; i++) {
            shapes.put(i, new BlinkingRectangle(stateColors, size));
        }
    }

    public ShapesLine(int size, StateColors stateColors, int delimiter, StateColors delimiterColor) {
        for (int i = 0; i < size; i++) {
            StateColors color = (i + 1) % delimiter == 0 ? delimiterColor : stateColors;
            shapes.put(i, new BlinkingRectangle(color, size));
        }
    }

    public Collection<? extends Node> getShapes() {
        return shapes.values();
    }

    public void showTimeField(int enabledQty) {

        for (int i = 0; i < shapes.size(); i++) {
            if (i < enabledQty) {
                shapes.get(i).enable();
            } else {
                shapes.get(i).disable();
            }
        }
    }
}