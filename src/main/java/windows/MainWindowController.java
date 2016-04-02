package windows;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


public class MainWindowController {
    @FXML
    private Button startButton;

    @FXML
    public void initialize() {

        startButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                startButton.getScene().getWindow().hide();
                try {
                    new TestWindow();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
