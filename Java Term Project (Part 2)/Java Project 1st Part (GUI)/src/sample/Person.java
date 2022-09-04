package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class Person {
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
    public void setPlayerName(String fName) { playerName.set(fName); }

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
        return playerName + ", " + countryName + ", " + age + ", " + height + ", " + clubName+ ", " + position + ", " + number + ", " + salary;
    }

    /*public Button getButton() {
        return button;
    }*/


}

