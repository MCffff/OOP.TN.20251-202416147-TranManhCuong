package painter_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	@FXML
    private Pane drawingAreaPane;
	private int value = -1;
	@FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
	@FXML
	void penButtonPressed(ActionEvent event1) {
		value = 1;
		
	}
	@FXML
	void eraserButtonPressed(ActionEvent event1) {
		value = 0;
	}
	
	@FXML
    void drawingAreaMouseDragged(MouseEvent event) {
		if (value == 1) {
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
    	drawingAreaPane.getChildren().add(newCircle);
		}
		else if (value == 0) {
			Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
	    	drawingAreaPane.getChildren().add(newCircle);
		}
    }

}
