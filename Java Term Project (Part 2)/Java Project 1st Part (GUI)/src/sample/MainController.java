package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;


public class MainController {

    private Main main;

    @FXML
    public Button Button1;

    @FXML
    public Button Button2;

    @FXML
    public Button Button3;

    @FXML
    public Button Button4;

    @FXML
    void searchPlayers(ActionEvent event) throws Exception {

                main.showPlayerMenuPage();
    }

    @FXML
    void searchClubs(ActionEvent event) throws Exception {

             main.showClubMenuPage();
    }

    @FXML
    void addPlayer(ActionEvent event) throws IOException {
              main.showPLayerInfoInputPage();

    }

    @FXML
    void exitSystem(ActionEvent event) throws Exception {

               main.closeMainMenuPage();

    }

    void setMain(Main main) {
        this.main = main;
    }

}
