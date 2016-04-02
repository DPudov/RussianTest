package windows;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import windows.ResultWindow;
import tasks.Task;

import java.io.IOException;


/**
 * Created by ${DPudov} on 01.04.2016.
 */
public class TestWindowController {
    @FXML
    ChoiceBox userChoiceBox;
    @FXML
    Label textOfTheTask;
    @FXML
    Label labelTask;
    @FXML
    Button checkButton;
    @FXML
    Label labelForChecked;


    @FXML
    public void initialize() {
        final Task task = new Task();
        userChoiceBox.getItems().addAll("1", "2", "3");
        checkButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                String result = String.valueOf(userChoiceBox.getValue());
                if (result.equals("1")) {
                    task.setRightSolved(true);
                } else {
                    task.setRightSolved(false);
                }
                if (!checkButton.getText().equals("Далее")) {
                    checkButton.setText("Далее");
                    if (task.rightSolved) {
                        labelForChecked.setText("Верно!");
                    } else {
                        labelForChecked.setText("Неверно!");
                    }

                } else {
                    checkButton.setText("Проверить");
                    labelForChecked.setText("");
                    checkButton.getScene().getWindow().hide();
                    try {
                        new ResultWindow();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
