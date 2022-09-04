package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.List;

public class PlayerController {

    FileIO f = new FileIO();
    Input in = new Input();
    Output out = new Output();
    PlayerList pList = new PlayerList();
    Player plar = new Player();
    //List<Player> playerList = pList.getList();
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
    public Button Button5;
    @FXML
    public Button Button6;


    @FXML
    void searchPlayerByName(ActionEvent event) throws Exception {

        main.showPlayerInputPage();

    }

    @FXML
    void searchPlayerByClC(ActionEvent event) throws IOException {
        main.showCCInputPage();

    }

    @FXML
    void searchPlayerByPos(ActionEvent event) throws Exception {
        main.showPosInputPage();
    }

    @FXML
    void searchPlayerBySalary(ActionEvent event) throws IOException {
          main.showRangeInputPage();
    }

    @FXML
    void playerCount(ActionEvent event) throws Exception {
          main.showPlayerCountInfo();
    }

    @FXML
    void backToMenu(ActionEvent event) {
        try {
            main.showMainMenuPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    void setMain(Main main) {
        this.main = main;
    }
}
