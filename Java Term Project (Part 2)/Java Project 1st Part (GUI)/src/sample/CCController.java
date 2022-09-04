package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;

public class CCController {

    PlayerList pList = new PlayerList();
    List<Player> playerList = pList.getList();
    @FXML
    public TextField userClubName;
    @FXML
    public TextField userCountryName;
    @FXML
    public Button Button;
    @FXML
    public Button Button2;

    private Main main;

    public CCController() throws Exception {
    }

    @FXML
    void showPlayersInfo(ActionEvent event) {

        String userClName = userClubName.getText();
        String userCnName = userCountryName.getText();
         try {
             List<Player> plrList = pList.getSameCountryClubList(userCnName,userClName);
             boolean ans = plrList.isEmpty();
             if (ans == false) {
                 main.showCCPlayersInfoPageOld(userCnName,userClName);
             }else{
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("ERROR !!");
                a.setContentText("No such player with this country and club");
                a.showAndWait();
                main.showCCInputPage();
             }

        } catch (Exception e) {
           e.printStackTrace();
        }

    }



    void setMain(Main main) {
        this.main = main;
    }

    public void backPlayerMenu(ActionEvent actionEvent) throws Exception {
        main.showPlayerMenuPage();
    }
}
