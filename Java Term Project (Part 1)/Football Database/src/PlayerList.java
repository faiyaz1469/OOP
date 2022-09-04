import java.util.ArrayList;
import java.util.List;

class Player {
    private String name;
    private String country;
    private int age;
    private double height;
    private String club;
    private String position;
    private int number;
    private double weeklysalary;

    public Player() {
    }

    public Player(String name, String country, int age, double height, String club, String position, int number, double weeklysalary) {
        this.name = name;
        this.country = country;
        this.age = age;
        this.height = height;
        this.club = club;
        this.position = position;
        this.number = number;
        this.weeklysalary = weeklysalary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getClub() {
        return club;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getWeeklysalary(){
        return weeklysalary;
    }

    public void setWeeklysalary(double weeklysalary){
        this.weeklysalary = weeklysalary;
    }
}

public class PlayerList {

    public static void main(String[] args) {
        List<Player> playerList = new ArrayList();

    }
}
