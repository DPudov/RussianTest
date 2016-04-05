import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


public class MainWindowController {
    public javafx.scene.control.TextArea editYName;
    @FXML
    private Button startButton;
    @FXML
    RadioButton radioM;
    @FXML
    RadioButton radioG;
    ToggleGroup toggleGroup = new ToggleGroup();
    boolean sex;

    @FXML
    public void initialize() {
        radioM.setToggleGroup(toggleGroup);
        radioG.setToggleGroup(toggleGroup);

        startButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                String name = editYName.getText();
                if (name == null || name.equals("")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Внимание!");
                    alert.setHeaderText("Вы не ввели имя!");
                    alert.setContentText("Если не хотите вводить имя, то вводите нехотя :)");
                    alert.show();
                } else {
                    if (toggleGroup.getSelectedToggle() != null) {
                        RadioButton rb = (RadioButton) toggleGroup.getSelectedToggle();
                        sex = rb.getText().equals("М");
                        try {
                            new TestWindow(editYName.getText(), sex);
                            startButton.getScene().getWindow().hide();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}
