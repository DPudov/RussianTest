import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by ${DPudov} on 01.04.2016.
 */
public class ResultWindow {
    ResultWindowController resultWindowController;
    public ResultWindow(int rightSolvedCount, String name) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/result_scene.fxml"));
        GridPane titledPane = loader.load();
        resultWindowController = loader.getController();
        resultWindowController.setUpResults(rightSolvedCount, name);
        Stage stage = new Stage();
        Scene scene = new Scene(titledPane);
        stage.setTitle("Результаты");
        stage.setScene(scene);
        stage.show();
    }
}
