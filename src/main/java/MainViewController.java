import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import static ast.ResponseGeneratorKt.generateAstJsonResponse;

public class MainViewController {

    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private TextArea pseudocodeTextArea;

    public void onSendClicked(MouseEvent mouseEvent) {
        String description = descriptionTextArea.getText();
        String pseudocode = pseudocodeTextArea.getText();

        String jsonAst = generateAstJsonResponse(pseudocode);
        //api.sendblablabla(description, pseudocode
        System.out.println(String.format("description: %s\npseudocode: %s\n", description, pseudocode));
    }
}
