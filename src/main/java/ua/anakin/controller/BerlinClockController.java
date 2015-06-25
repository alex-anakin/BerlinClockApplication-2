package ua.anakin.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class BerlinClockController {

    @FXML
    protected void handleCloseButtonAction() {
        Platform.exit();
        System.exit(0);
    }

}
