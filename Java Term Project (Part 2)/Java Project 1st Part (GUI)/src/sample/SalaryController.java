package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;

public class SalaryController {
    @FXML
    public Button Button2;

    PlayerList pList = new PlayerList();
    List<Player> playerList = pList.getList();

    @FXML
    public TextField userMinRange;
    @FXML
    public Button Button;
    @FXML
    public TextField userMaxRange;

    private Main main;

    public SalaryController() throws Exception {
    }

    public void showSalaryInfo(ActionEvent actionEvent) {
        double maxRange = Double.parseDouble(userMaxRange.getText());
        double minRange = Double.parseDouble(userMinRange.getText());

        try {
            List<Player> plrList = pList.getRangeSalaryList(maxRange,minRange);
            boolean ans = plrList.isEmpty();
            if (ans == false) {
                main.showSalaryInfoPage(maxRange,minRange);
            }else{
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("ERROR !!");
                a.setContentText("No such player with this weekly salary range");
                a.showAndWait();
                main.showRangeInputPage();
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
