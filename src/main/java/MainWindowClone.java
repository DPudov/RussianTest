import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by ${DPudov} on 04.04.2016.
 */
public class MainWindowClone {
    public MainWindowClone() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/main_scene.fxml"));
        GridPane titledPane = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(titledPane);
        stage.setTitle("Тест по русскому");
        stage.setScene(scene);
        stage.show();
    }
}
