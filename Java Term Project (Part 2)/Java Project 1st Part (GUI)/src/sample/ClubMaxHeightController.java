package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;

public class ClubMaxHeightController {
    @FXML
    public TextField userClubName;
    @FXML
    public Button Button;
    @FXML
    public Button Button2;

    private Main main;

    PlayerList pList = new PlayerList();
    List<Player> playerList = pList.getList();

    public ClubMaxHeightController() throws Exception {
    }

    @FXML
    public void showClubMaxHeightPlayersInfo(ActionEvent actionEvent) throws Exception {
        String userClName = userClubName.getText();
        List<Player> plrList = pList.getMaxHeightClubList(userClName);
        boolean ans = plrList.isEmpty();
        if (ans == false) {
            main.showClubMaxHeightPlayerInfoPage(userClName);
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("ERROR !!");
            a.setContentText("No such club with this name");
            a.showAndWait();
            main.showClubInputPage3();
        }
    }

    void setMain(Main main) {
        this.main = main;
    }

    public void backClubMenu(ActionEvent actionEvent) throws Exception {
        main.showClubMenuPage();
    }
}
