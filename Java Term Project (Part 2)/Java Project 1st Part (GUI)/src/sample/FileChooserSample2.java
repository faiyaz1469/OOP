package sample;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.*;

import java.util.HashMap;
import java.util.List;

public class FileChooserSample2 extends Application {
    FileIO f = new FileIO();
    Input in = new Input();
    Output out = new Output();
    PlayerList pList = new PlayerList();
    Player plar = new Player();
    List<Player> playerList = pList.getList();

    private TableView <Count> table = new TableView<Count>();
    private final ObservableList<Count> data =
            FXCollections.observableArrayList();
    final HBox hb = new HBox();

    public FileChooserSample2() throws Exception {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(657);
        stage.setHeight(436);

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn countryNameCol = new TableColumn("Country");
        countryNameCol.setMinWidth(80);
        countryNameCol.setCellValueFactory(new PropertyValueFactory<Count, String>("countryName"));

        TableColumn numberCol = new TableColumn("Number");
        numberCol.setMinWidth(40);
        numberCol.setCellValueFactory(new PropertyValueFactory<Count, Integer>("number"));

        table.setItems(data);
        table.getColumns().addAll(countryNameCol, numberCol);


        //PlayerList plr = new PlayerList();
        //List<Player> plrList = pList.getSameCountryClubList("germany", "any");

        HashMap<String, Integer> playerCount = pList.getPlayerCount();

        for (String name: playerCount.keySet()) {
            String key = name.toString();
            Integer value = Integer.valueOf(playerCount.get(name).toString());

            data.add(new Count(key, value));

            hb.setSpacing(3);

            final VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(10, 0, 0, 10));
            vbox.getChildren().addAll(label, table, hb);

            ((Group) scene.getRoot()).getChildren().addAll(vbox);

            stage.setScene(scene);
            stage.show();
        }
    }

    public static class Count {

        private final SimpleStringProperty countryName;
        private final SimpleIntegerProperty number;

        Count(String countryName, Integer number) {

            this.countryName = new SimpleStringProperty(countryName);
            this.number = new SimpleIntegerProperty(number);

        }

        public String getCountryName() {
            return countryName.get();
        }

        public void setCountryName(String fName) {
            countryName.set(fName);
        }

        public Integer getNumber() {
            return number.get();
        }

        public void setNumber(int fName) {
            number.set(fName);
        }

        public String toString() {
            return countryName + ", " + number;
        }

    }
}