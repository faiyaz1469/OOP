package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;

public class PosController {

    PlayerList pList = new PlayerList();
    List<Player> playerList = pList.getList();
    @FXML
    public Button Button;
    @FXML
    public Button Button2;
    @FXML
    public TextField userPosName;

    private Main main;

    public PosController() throws Exception {
    }

    @FXML
    public void showPosPlayersInfo(ActionEvent actionEvent) throws Exception {
        String userPsName = userPosName.getText();
        List<Player> plrList = pList.getSamePosList(userPsName);
        boolean ans = plrList.isEmpty();
        if (ans == false) {
            main.showPosPlayerInfoPage(userPsName);
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("ERROR !!");
            a.setContentText("No such player with this position");
            a.showAndWait();
            main.showPosInputPage();
        }
    }

    void setMain(Main main) {
        this.main = main;
    }

    public void backPlayerMenu(ActionEvent actionEvent) throws Exception {
        main.showPlayerMenuPage();
    }
}
