package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AddConfirmationController {
    @FXML
    public Label msg1;
    @FXML
    public Button Button;

    private Main main;

    public void init(String player) {
        msg1.setText(player);
    }

    @FXML
    public void backMainMenu(ActionEvent actionEvent) throws Exception {
        main.showMainMenuPage();
    }

    void setMain(Main main) {
        this.main = main;
    }


}
