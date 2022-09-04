package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.List;

public class ClTotalSalaryController {

    @FXML
    public Button Button;

    private Main main;

    @FXML
    public Label msg;

    PlayerList pList = new PlayerList();
    List<Player> playerList = pList.getList();

    public ClTotalSalaryController() throws Exception {
    }

    public void init(String clName) throws IOException {

          double totSal = pList.getTotalSalaryClub(clName);
          if (totSal != 0) {
              msg.setText(String.valueOf(totSal));
          }

    }

    @FXML
    public void backClubMenu(ActionEvent actionEvent) throws Exception {
        main.showClubInputPage4();
    }

    void setMain(Main main) {
        this.main = main;
    }
}
