package sample;
import java.util.HashMap;
import java.util.List;

public class Output {

    public Output(){

    }

    public void printInfo(Player p) {
        System.out.println(p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight() + "," + p.getClub() + "," + p.getPosition() + "," + p.getNumber() + "," + p.getWeeklysalary());
    }

    public void printListInfo(List<Player> plrList) {
        for (Player s : plrList) {
            System.out.println(s.getName() + "," + s.getCountry() + "," + s.getAge() + "," + s.getHeight() + "," + s.getClub() + "," + s.getPosition() + "," + s.getNumber() + "," + s.getWeeklysalary());
        }
    }

    public void printPLayerCountInfo(HashMap <String, Integer> playerCount) {
        for (String name: playerCount.keySet()) {
            String key = name.toString();
            String value = playerCount.get(name).toString();
            System.out.println(key + " " + value);
        }
    }

    public void printSalaryInfo(double totalSalary) {
        System.out.println("The total yearly salary of all players of this club " + totalSalary);
    }
}
