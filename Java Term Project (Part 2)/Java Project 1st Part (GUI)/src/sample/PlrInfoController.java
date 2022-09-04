package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PlrInfoController {

    @FXML
    public Button Button;

    private Main main;

    @FXML
    private Label msg1;

    @FXML
    private Label msg2;

    @FXML
    private Label msg3;

    @FXML
    private Label msg4;

    @FXML
    private Label msg5;

    @FXML
    private Label msg6;

    @FXML
    private Label msg7;

    @FXML
    private Label msg8;

    public void init(String plname,String cname, int age, double height, String clname, String posname, int nmbr, double salary) {
        msg1.setText(plname);
        msg2.setText(cname);
        msg3.setText(String.valueOf(age));
        msg4.setText(String.valueOf(height));
        msg5.setText(clname);
        msg6.setText(posname);
        msg7.setText(String.valueOf(nmbr));
        msg8.setText(String.valueOf(salary));

    }

    @FXML
    void logoutAction(ActionEvent event) {
        try {
            main.showPlayerInputPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void setMain(Main main) {
        this.main = main;
    }
}
