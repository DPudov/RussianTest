package windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by ${DPudov} on 01.04.2016.
 */
public class ResultWindow {
    public ResultWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/result_scene.fxml"));
        GridPane titledPane = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(titledPane);
        stage.setTitle("Результаты");
        stage.setScene(scene);
        stage.show();
    }
}
