package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class ClubController {
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

    private Main main;

    @FXML
    public void searchPlayerWithMaxSalary(ActionEvent actionEvent) throws IOException {
        main.showClubInputPage();
    }

    @FXML
    public void searchPlayerWithMaxAge(ActionEvent actionEvent) throws IOException {
        main.showClubInputPage2();
    }

    @FXML
    public void searchPlayerWithMaxHeight(ActionEvent actionEvent) throws IOException {
        main.showClubInputPage3();
    }

    @FXML
    public void totalYearlySalary(ActionEvent actionEvent) throws IOException {
        main.showClubInputPage4();
    }

    @FXML
    public void backToMenu(ActionEvent actionEvent) {
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
