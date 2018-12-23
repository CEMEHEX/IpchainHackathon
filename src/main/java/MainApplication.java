import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MainApplication extends Application {

    private final static String FXML_MAIN_PATH = "main.fxml";

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(FXML_MAIN_PATH));

        Scene startScene = new Scene(root, 1024, 720);
        stage.setTitle("ОИС Алгоритмы");
        stage.setScene(startScene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
