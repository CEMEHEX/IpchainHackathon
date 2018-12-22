import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class Controller {

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
}
