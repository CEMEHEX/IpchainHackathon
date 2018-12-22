import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

import static ast.AstVisualizerKt.invokeVisualizer;

public class MainApplication extends Application {

    private final static String FXML_MAIN_PATH = "main.fxml";
    private final static String FXML_VISUALIZATION_PATH = "visualization.fxml";

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(FXML_MAIN_PATH));

        Scene startScene = new Scene(root, 1200, 800);
        Button visualizeAstButton = (Button) startScene.lookup("#visualizeAstBtn");

        // TODO make image scalable
        visualizeAstButton.setOnMouseClicked((mouseEvent) -> {
            try {
                Parent visAstRoot = FXMLLoader.load(getClass().getResource(FXML_VISUALIZATION_PATH));
                Stage newWindow = new Stage();
                Scene astVisualizationScene = new Scene(visAstRoot, 1200, 800);

                TextArea codeTextArea = (TextArea) startScene.lookup("#pseudocodeTextArea");
                String code = codeTextArea.getText();

                invokeVisualizer(code);

                ImageView astImgView = (ImageView) astVisualizationScene.lookup("#astImg");
                try (FileInputStream inputStream = new FileInputStream("src/main/resources/graph.png")) {
                    Image astImg = new Image(inputStream);
                    astImgView.setImage(astImg);
                }

                newWindow.setScene(astVisualizationScene);
                newWindow.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        stage.setTitle("Sample text");
        stage.setScene(startScene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
