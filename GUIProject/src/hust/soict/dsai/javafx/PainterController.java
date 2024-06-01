package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;
    private Color color = Color.BLACK;

    @FXML
    void clearButtonPressed(ActionEvent actionEvent) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void changeBlack(){
        color = Color.BLACK;
    }

    @FXML
    void changeWhite(){
        color = Color.WHITE;
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent mouseEvent) {
        Circle newCicle = new Circle(mouseEvent.getX(), mouseEvent.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCicle);
    }
}
