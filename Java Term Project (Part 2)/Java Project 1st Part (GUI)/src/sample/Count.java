package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class Count {

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

