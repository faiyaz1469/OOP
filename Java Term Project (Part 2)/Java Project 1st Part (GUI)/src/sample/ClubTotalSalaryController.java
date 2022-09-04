package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;

public class ClubTotalSalaryController {
    @FXML
    public TextField userClubName;
    @FXML
    public Button Button;
    @FXML
    public Button Button2;

    private Main main;

    PlayerList pList = new PlayerList();
    List<Player> playerList = pList.getList();

    public ClubTotalSalaryController() throws Exception {
    }


    @FXML
    public void showClubTotalSalaryPlayersInfo(ActionEvent actionEvent) throws Exception {
        String userClName = userClubName.getText();
        double totSal = pList.getTotalSalaryClub(userClName);
        if (totSal != 0) {
            main.showClubTotalSalaryPlayerInfoPage(userClName);
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("ERROR !!");
            a.setContentText("No such club with this name");
            a.showAndWait();
            main.showClubInputPage4();
        }
    }

    void setMain(Main main) {
        this.main = main;
    }

    public void backClubMenu(ActionEvent actionEvent) throws Exception {
        main.showClubMenuPage();
    }
}
