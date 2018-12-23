import bone.ApiClient;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


import java.io.FileInputStream;

import static ast.AstVisualizerKt.invokeVisualizer;

import static ast.ResponseGeneratorKt.generateAstJsonResponse;

public class MainViewController {

    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private TextArea pseudocodeTextArea;
    @FXML
    private TextField algoNameTextField;
    @FXML
    private ImageView visImageView;
    @FXML
    private CheckBox visCheckBox;

    public void onSendClicked(MouseEvent mouseEvent) {
        String description = descriptionTextArea.getText();
        String pseudocode = pseudocodeTextArea.getText();
        String algoName = algoNameTextField.getText();

        String jsonAst = generateAstJsonResponse(pseudocode);
        String objID = ApiClient.sendAstWithDescription(algoName, jsonAst, description);
        System.out.println(String.format("description: %s\npseudocode: %s\n", description, pseudocode));
    }

    public void onCodeKeyTyped(KeyEvent keyEvent) {
        if(visCheckBox.isSelected()) {
            try {
                invokeVisualizer(pseudocodeTextArea.getText());
                try (FileInputStream inputStream = new FileInputStream("src/main/resources/graph.png")) {
                    Image astImg = new Image(inputStream);
                    visImageView.setImage(astImg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
