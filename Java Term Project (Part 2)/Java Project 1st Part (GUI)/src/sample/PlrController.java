package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class PlrController {

    private Main main;
    String playerName;

    @FXML
    public Button Button;

    @FXML
    public TextField userPlayerName;

    @FXML
    void showPlayerInfo(ActionEvent event) throws Exception {

        String userName = userPlayerName.getText();
        Player pl = new Player();
        Player p = pl.getPlayerByName(userName);
        if ( p == null ) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("ERROR !!");
            a.setContentText("No such player with this name");
            a.showAndWait();
            main.showPlayerInputPage();
        }
        else {
            String plname = p.getName();
            String cname = p.getCountry();
            int age = p.getAge();
            double height = p.getHeight();
            String clname = p.getClub();
            String posname = p.getPosition();
            int nmbr = p.getNumber();
            double salary = p.getWeeklysalary();

            main.showPlayerInfoPage(plname, cname, age, height, clname, posname, nmbr, salary);

        }
    }

    public void backPlayerMenu(ActionEvent actionEvent) throws Exception {
        main.showPlayerMenuPage();
    }
    void setMain(Main main) {
        this.main = main;
    }

    public void setText(String name){ playerName = name; }

    public String getText(){
        return playerName;
    }


}
