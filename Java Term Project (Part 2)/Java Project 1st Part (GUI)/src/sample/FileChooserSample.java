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

import java.util.List;

public class FileChooserSample extends Application {
    FileIO f = new FileIO();
    Input in = new Input();
    Output out = new Output();
    PlayerList pList = new PlayerList();
    Player plar = new Player();
    List<Player> playerList = pList.getList();

    private TableView<Person> table = new TableView<Person>();
    private final ObservableList<Person> data =
            FXCollections.observableArrayList();
    final HBox hb = new HBox();

    public FileChooserSample() throws Exception {
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

        TableColumn playerNameCol = new TableColumn("Name");
        playerNameCol.setMinWidth(90);
        playerNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("playerName"));

        TableColumn countryNameCol = new TableColumn("Country");
        countryNameCol.setMinWidth(80);
        countryNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("countryName"));

        TableColumn ageCol = new TableColumn("Age");
        ageCol.setMinWidth(40);
        ageCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));

        TableColumn heightCol = new TableColumn("Height");
        heightCol.setMinWidth(50);
        heightCol.setCellValueFactory(new PropertyValueFactory<Person, Double>("height"));

        TableColumn clubNameCol = new TableColumn("Club");
        clubNameCol.setMinWidth(120);
        clubNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("clubName"));

        TableColumn positionCol = new TableColumn("Position");
        positionCol.setMinWidth(60);
        positionCol.setCellValueFactory(new PropertyValueFactory<Person, String>("position"));

        TableColumn numberCol = new TableColumn("Number");
        numberCol.setMinWidth(40);
        numberCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("number"));

        TableColumn salaryCol = new TableColumn("Weekly Salary");
        salaryCol.setMinWidth(100);
        salaryCol.setCellValueFactory(new PropertyValueFactory<Person, Double>("salary"));

        table.setItems(data);
        table.getColumns().addAll(playerNameCol, countryNameCol, ageCol, heightCol, clubNameCol, positionCol, numberCol, salaryCol);


        PlayerList plr = new PlayerList();
        List<Player> plrList = pList.getSameCountryClubList("germany", "any");
        // Player pl = new Player();
        //Player p = plrList.get(0);
        for (int i = 0; i < plrList.size(); i++) {
            Player p = plrList.get(i);
            data.add(new Person(p.getName(), p.getCountry(), p.getAge(), p.getHeight(), p.getClub(), p.getPosition(), p.getNumber(), p.getWeeklysalary()));

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

    public static class Person {

        private final SimpleStringProperty playerName;
        private final SimpleStringProperty countryName;
        private final SimpleIntegerProperty age;
        private final SimpleDoubleProperty height;
        private final SimpleStringProperty clubName;
        private final SimpleStringProperty position;
        private final SimpleIntegerProperty number;
        private final SimpleDoubleProperty salary;

        //private final Button button;

        Person(String playerName, String countryName, Integer age, Double height, String clubName, String position, Integer number, Double salary) {
            this.playerName = new SimpleStringProperty(playerName);
            this.countryName = new SimpleStringProperty(countryName);
            this.age = new SimpleIntegerProperty(age);
            this.height = new SimpleDoubleProperty(height);
            this.clubName = new SimpleStringProperty(clubName);
            this.position = new SimpleStringProperty(position);
            this.number = new SimpleIntegerProperty(number);
            this.salary = new SimpleDoubleProperty(salary);
       /* this.button = new Button("Click");
        button.setOnAction( e -> {
                    System.out.println(getFirstName() + " " + getLastName() + " " + getEmail());
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText(getFirstName() + " " + getLastName() + " " + getEmail());
                    a.showAndWait();
                }
        );*/
        }

        public String getPlayerName() {
            return playerName.get();
        }

        public void setPlayerName(String fName) {
            playerName.set(fName);
        }

        public String getCountryName() {
            return countryName.get();
        }

        public void setCountryName(String fName) {
            countryName.set(fName);
        }

        public Integer getAge() {
            return age.get();
        }

        public void setAge(int fName) {
            age.set(fName);
        }

        public Double getHeight() {
            return height.get();
        }

        public void setHeight(double fName) {
            height.set(fName);
        }

        public String getClubName() {
            return clubName.get();
        }

        public void setClubName(String fName) {
            clubName.set(fName);
        }

        public String getPosition() {
            return position.get();
        }

        public void setPosition(String fName) {
            position.set(fName);
        }

        public Integer getNumber() {
            return number.get();
        }

        public void setNumber(int fName) {
            number.set(fName);
        }

        public Double getSalary() {
            return salary.get();
        }

        public void setSalary(double fName) {
            salary.set(fName);
        }

        public String toString() {
            return playerName + ", " + countryName + ", " + age + ", " + height + ", " + clubName + ", " + position + ", " + number + ", " + salary;
        }

    }
}