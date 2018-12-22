import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import static ast.AstVisualizerKt.invokeVisualizer;

public class MainViewController {

    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private TextArea pseudocodeTextArea;

    public void onSendClicked(MouseEvent mouseEvent) {
        String description = descriptionTextArea.getText();
        String pseudocode = pseudocodeTextArea.getText();
        //api.sendblablabla(description, pseudocode
        System.out.println(String.format("description: %s\npseudocode: %s\n", description, pseudocode));
    }

    public void onVisualizeAST(MouseEvent mouseEvent) {
        String code = pseudocodeTextArea.getText();
        invokeVisualizer(code);
    }
}
