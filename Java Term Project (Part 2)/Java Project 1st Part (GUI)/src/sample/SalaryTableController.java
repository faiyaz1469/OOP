package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class SalaryTableController {

    FileIO f = new FileIO();
    Input in = new Input();
    Output out = new Output();
    PlayerList pList = new PlayerList();
    Player plar = new Player();
    List<Player> playerList = pList.getList();

    Scene scene = new Scene(new Group());

    final HBox hb = new HBox();

    private boolean init = true;

    private TableView<FileChooserSample.Person> table = new TableView<FileChooserSample.Person>();
    private final ObservableList<FileChooserSample.Person> data =
            FXCollections.observableArrayList();

    private Main main;

    @FXML
    public Button Button;
    @FXML
    public TableView tableView;

    public SalaryTableController() throws Exception {
    }

    private void initializeColumns() {
        TableColumn<Person, String> playerNameCol = new TableColumn<>("Name");
        playerNameCol.setMinWidth(110);
        playerNameCol.setCellValueFactory(new PropertyValueFactory<>("playerName"));

        TableColumn<Person, String> countryNameCol = new TableColumn<>("Country");
        countryNameCol.setMinWidth(80);
        countryNameCol.setCellValueFactory(new PropertyValueFactory<>("countryName"));

        TableColumn<Person, Integer> ageCol = new TableColumn<>("Age");
        ageCol.setMinWidth(40);
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn <Person, Double> heightCol = new TableColumn<>("Height");
        heightCol.setMinWidth(50);
        heightCol.setCellValueFactory(new PropertyValueFactory<>("height"));

        TableColumn<Person, String> clubNameCol = new TableColumn<>("Club");
        clubNameCol.setMinWidth(120);
        clubNameCol.setCellValueFactory(new PropertyValueFactory<>("clubName"));

        TableColumn<Person, String> positionCol = new TableColumn<>("Position");
        positionCol.setMinWidth(60);
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));

        TableColumn<Person, Integer> numberCol = new TableColumn<>("Number");
        numberCol.setMinWidth(40);
        numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));

        TableColumn <Person, Double> salaryCol = new TableColumn<>("Weekly Salary");
        salaryCol.setMinWidth(100);
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));

        tableView.getColumns().addAll(playerNameCol, countryNameCol, ageCol, heightCol, clubNameCol, positionCol, numberCol, salaryCol);


    }

    public void load(double max, double min) throws Exception {
        if (init) {
            initializeColumns();
            init = false;
        }

        List<Player> plrList = pList.getRangeSalaryList(max,min);
        for (int i = 0; i < plrList.size(); i++) {
            Player p = plrList.get(i);

            data.add(new FileChooserSample.Person(p.getName(), p.getCountry(), p.getAge(), p.getHeight(), p.getClub(), p.getPosition(), p.getNumber(), p.getWeeklysalary()));

            hb.setSpacing(3);
            final VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(10, 0, 0, 10));
            vbox.getChildren().addAll(table, hb);

            ((Group) scene.getRoot()).getChildren().addAll(vbox);

            //System.out.println(p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight() + "," + p.getClub() + "," + p.getPosition() + "," + p.getNumber() + "," + p.getWeeklysalary());

        }

        tableView.setEditable(true);
        tableView.setItems(data);

    }

    public void backPLayersMenu(ActionEvent actionEvent) throws Exception {
        main.showRangeInputPage();
    }

    void setMain(Main main) {
        this.main = main;
    }
}

