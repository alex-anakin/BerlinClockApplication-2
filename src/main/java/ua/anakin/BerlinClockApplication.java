package ua.anakin;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ua.anakin.model.ShapesModel;

import java.util.Collection;

public class BerlinClockApplication extends Application {

    private Parent root;
    private ShapesModel shapesModel;

    @Override
    public void start(Stage stage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("../../fxml/berlin_clock.fxml"));
        shapesModel = new ShapesModel();

        initUI();
        Scene scene = new Scene(root);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                shapesModel.getSchedulerService().stopScheduledTasks();
                Platform.exit();
                System.exit(0);
            }
        });
        stage.setTitle("Berlin Clock");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        shapesModel.getSchedulerService().stopScheduledTasks();
    }

    private void initUI() {
        addChild("#secondLine", shapesModel.getSecondShape());
        addAllChildren("#fiveHoursLine", shapesModel.getFiveHoursLine().getShapes());
        addAllChildren("#oneHoursLine", shapesModel.getOneHoursLine().getShapes());
        addAllChildren("#fiveMinuteLine", shapesModel.getFiveMinutesLine().getShapes());
        addAllChildren("#oneMinuteLine", shapesModel.getOneMinutesLine().getShapes());
    }

    private void addChild(String parentId, Shape child) {
        ((Pane) root.lookup(parentId)).getChildren().add(child);
    }

    private void addAllChildren(String parentId, Collection<? extends Node> children) {
        ((Pane) root.lookup(parentId)).getChildren().addAll(children);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
