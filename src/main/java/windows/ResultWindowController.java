package windows;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Created by ${DPudov} on 01.04.2016.
 */
public class ResultWindowController {
    @FXML
    Label resultLabel;
    @FXML
    Button replayButton;

    @FXML
    public void initialize() {
        replay();
    }

    private void replay() {
        //TODO: make some usability to replay this again
    }
}
