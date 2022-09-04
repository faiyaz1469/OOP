package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.List;

public class PlayerCountTableController {

    PlayerList pList = new PlayerList();
    List<Player> playerList = pList.getList();
    Scene scene = new Scene(new Group());

    private TableView<FileChooserSample2.Count> table = new TableView<FileChooserSample2.Count>();
    private final ObservableList<FileChooserSample2.Count> data =
            FXCollections.observableArrayList();

    @FXML
    public TableView tableView;

    final HBox hb = new HBox();

    private boolean init = true;

    @FXML
    public javafx.scene.control.Button Button;

    private Main main;

    public PlayerCountTableController() throws Exception {
    }


    private void initializeColumns() {

        TableColumn<Person, String> countryNameCol = new TableColumn<>("Country");
        countryNameCol.setMinWidth(80);
        countryNameCol.setCellValueFactory(new PropertyValueFactory<>("countryName"));

        TableColumn<Person, Integer> numberCol = new TableColumn<>("Number");
        numberCol.setMinWidth(40);
        numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));

        tableView.getColumns().addAll(countryNameCol, numberCol);
    }


    public void load() throws Exception {
        if (init) {
            initializeColumns();
            init = false;
        }

        //List<Player> plrList = pList.getMaxHeightClubList();
        HashMap <String, Integer> playerCount = pList.getPlayerCount();

        for (String name: playerCount.keySet()) {
            String key = name.toString();
            //String value = playerCount.get(name).toString();
            Integer value = Integer.valueOf(playerCount.get(name).toString());
            //System.out.println(key + " " + value);

            data.add(new FileChooserSample2.Count(key, value));

            hb.setSpacing(3);
            final VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(10, 0, 0, 10));
            vbox.getChildren().addAll(table, hb);

            ((Group) scene.getRoot()).getChildren().addAll(vbox);

            //System.out.println(key + "," + value);

        }

        tableView.setEditable(true);
        tableView.setItems(data);

    }


    @FXML
    public void backPLayersMenu(ActionEvent actionEvent) throws Exception {
        main.showPlayerMenuPage();
    }

    void setMain(Main main) {
        this.main = main;
    }
}

