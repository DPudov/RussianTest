import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


public class MainWindowController {
    public javafx.scene.control.TextArea editYName;
    @FXML
    private Button startButton;


    @FXML
    public void initialize() {
        startButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                String name = editYName.getText();
                if (name == null || name.equals("")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("��������!");
                    alert.setHeaderText("�� �� ����� ���!");
                    alert.setContentText("���� �� ������ ������� ���, �� ������� ������ :)");
                    alert.show();
                } else {
                    try {
                        new TestWindow(editYName.getText());
                        startButton.getScene().getWindow().hide();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
