import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


/**
 * Created by ${DPudov} on 01.04.2016.
 */
public class ResultWindowController {
    @FXML
    Label resultLabel;
    @FXML
    ImageView resultImage;
    @FXML
    Button replayButton;
    private int rightSolvedCount;
    private String name;

    @FXML
    public void initialize() {
        replayButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
            public void handle(Event event) {
                try {
                    replay();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        setUpResults(rightSolvedCount, name);
    }


    public void setUpResults(int rightSolvedCount, String name) {
        this.name = name;
        this.rightSolvedCount = rightSolvedCount;
        if (rightSolvedCount == 10 || rightSolvedCount == 9) {
            resultLabel.setText(name + ", ты неверо€тно крут! " + rightSolvedCount + "/10");
            resultImage.setImage(new Image("drawable/top_result.gif"));
        } else if (rightSolvedCount == 8 || rightSolvedCount == 7) {
            resultLabel.setText(name + "! /n Ќеплохо, но есть над чем поработать. " + rightSolvedCount + "/10");
            resultImage.setImage(new Image("drawable/applodismenty.gif"));
        } else if (rightSolvedCount == 6 || rightSolvedCount == 5) {
            resultLabel.setText(name + "! “ы " + "был " + "на грани фола. Ќужно больше тренировок! " + rightSolvedCount + "/10");
            resultImage.setImage(new Image("drawable/pulpfictiondance1.gif"));
        } else if (rightSolvedCount < 5) {
            resultLabel.setText(name + ", у мен€ дл€ теб€ плохие новости. “ы не справилс€ с заданием:( " + rightSolvedCount + "/10");
            resultImage.setImage(new Image("drawable/schwach.gif"));
        }

    }

    private void replay() throws IOException {
        new MainWindowClone();
        resultImage.getScene().getWindow().hide();
    }
}
