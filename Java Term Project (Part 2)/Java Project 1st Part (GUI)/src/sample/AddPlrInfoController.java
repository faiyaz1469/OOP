package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AddPlrInfoController {

    private Main main;
    PlayerList pList = new PlayerList();
    List<Player> playerList = pList.getList();
    @FXML
    public Button Button;
    @FXML
    public TextField userPlayerName;
    @FXML
    public TextField userCountryName;
    @FXML
    public TextField userAge;
    @FXML
    public TextField userHeight;
    @FXML
    public TextField userClub;
    @FXML
    public TextField userPosition;
    @FXML
    public TextField userNumber;
    @FXML
    public TextField userSalary;

    public AddPlrInfoController() throws Exception {
    }

    public void addPlayer(ActionEvent actionEvent) throws Exception {

        String userPlName = userPlayerName.getText();
        String userCnName = userCountryName.getText();
        int userPlAge = Integer.parseInt(userAge.getText());
        double userPlHeight = Double.parseDouble(userHeight.getText());
        String userClName = userClub.getText();
        String userPos = userPosition.getText();
        int userNum = Integer.parseInt(userNumber.getText());
        double userWSalary = Double.parseDouble(userSalary.getText());

        PlayerList plr = new PlayerList();
        int check = pList.addPlayer(userPlName,userCnName,userPlAge,userPlHeight,userClName,userPos,userNum,userWSalary);

        if ( check == -1 ){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setHeaderText(userPlName);
            a.setContentText("This Player has been added to the file.");
            a.showAndWait();
            main.showPLayerInfoInputPage();
        }
        else if( check == 1){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("ERROR !!");
            a.setContentText("This player is already in the database");
            a.showAndWait();
        }
        else if( check == 2){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("ERROR !!");
            a.setContentText("This club has already 7 players");
            a.showAndWait();
        }
        else if( check == 3){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("ERROR !!");
            a.setContentText("Please input a correct position");
            a.showAndWait();
        }

    }
    public void backMainMenu(ActionEvent actionEvent) throws Exception {
        main.showMainMenuPage();
    }

    void setMain(Main main) {
        this.main = main;
    }


}
