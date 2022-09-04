package sample;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;



public class PlayerList {
    private List<Player> playerList;
    private List<Player> plrList = new ArrayList();
    private List<Player> plrList1 = new ArrayList();
   // private HashMap <String, Integer> playerCount;
    private HashMap <String, Integer> plrCnt = new HashMap<>();
    //private HashMap <String, Integer> = new HashMap();

    private Main main;

    private String clname;
    private String countryname;
    private String clubname;
    private String cname;
    private String posname;
    private Double minrange;
    private Double maxrange;
    private String clname1;
    private double maxSalary;
    private String clname2;
    private int maxAge;
    private String clname3;
    private double maxHeight;
    private String clname4;
    private  double totalSalary = 0;
    private int searchIndex;
    FileIO f = new FileIO();
    Input in = new Input();
    PlrController plc = new PlrController();

    public PlayerList(){

    }

     void setMain(Main main) {
        this.main = main;
    }

    public List<Player> getList() throws Exception{

        playerList = f.readFromFile();
        return playerList;
    }


    public List<Player> getSameClubList() throws Exception{
        clname = in.getString();
        //List<Player> plrList = new ArrayList();
        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (clname.equalsIgnoreCase(p.getClub())) {
                plrList.add(p);
                //searchIndex = 0;
            }
        }
        return plrList;
    }

    public List<Player> getSameCountryClubList(String Country, String Club) throws Exception{
        int searchIndex = -1;
        countryname = Country;
        clubname = Club;

        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (p.getCountry().equalsIgnoreCase(countryname) && p.getClub().equalsIgnoreCase(clubname)) {
                plrList.add(p);
                searchIndex = 0;
            }

        }
        cname = "ANY";
        if(cname.equalsIgnoreCase(clubname)){
            for (int i = 0; i < playerList.size(); i++) {
                Player p = playerList.get(i);
                if (p.getCountry().equalsIgnoreCase(countryname)) {
                    //System.out.println(p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight() + "," + p.getClub() + "," + p.getPosition() + "," + p.getNumber() + "," + p.getWeeklysalary());
                    plrList.add(p);
                    searchIndex = 0;
                }
            }
        }
        if ( searchIndex == -1) {
            //System.out.println("No such player with this country and club");
           /* Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("ERROR !!");
            a.setContentText("No such player with this country and club");
            a.showAndWait();*/

        }
        return plrList;
    }
    public List<Player> getSamePosList(String position) throws Exception{
        int searchIndex = -1;
        posname = position;
        String pos1 = "Goalkeeper";
        String pos2 = "Defender";
        String pos3 = "Midfielder";
        String pos4 = "Forward";
        if (posname.equalsIgnoreCase(pos1) || posname.equalsIgnoreCase(pos2)|| posname.equalsIgnoreCase(pos3)|| posname.equalsIgnoreCase(pos4)) {
            for (int i = 0; i < playerList.size(); i++) {
                Player p = playerList.get(i);
                if (p.getPosition().equalsIgnoreCase(posname)) {
                    plrList.add(p);
                    searchIndex = 0;
                }
            }
        }

        if ( searchIndex == -1) {

            /*Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("ERROR !!");
            a.setContentText("No such player with this position");
            a.showAndWait();*/
        }
        return plrList;
    }

    public List<Player> getRangeSalaryList(double max,double min) throws Exception{
        int searchIndex = -1;
        minrange = min;
        maxrange = max;
        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if ((p.getWeeklysalary() >= minrange) && (p.getWeeklysalary() <= maxrange)) {
                plrList.add(p);
                searchIndex = 0;
            }
        }
        if ( searchIndex == -1) {

            /*Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("ERROR !!");
            a.setContentText("No such player with this weekly salary range");
            a.showAndWait();*/
        }
        return plrList;
    }

    public HashMap < String, Integer> getPlayerCount() throws Exception{
        int count = 0;
        int searchind = -1;

        for (int i = 0; i < playerList.size(); i++) {
            Player p1 = playerList.get(i);
            for ( int m = i-1; m>=0 ; m--){
                Player p3 = playerList.get(m);
                if (p1.getCountry().equalsIgnoreCase(p3.getCountry()))
                    searchind = 0;
            }
            if(searchind != 0) {
                for (int j = 0; j < playerList.size(); j++) {
                    Player p2 = playerList.get(j);
                    if (p1.getCountry().equalsIgnoreCase(p2.getCountry())) {
                        count++;
                    }
                }
                plrCnt.put(p1.getCountry(), count);
                count = 0;

            }
            searchind = -1;
        }
        return plrCnt;
    }
    public List<Player> getMaxSalaryClubList(String club){

        int searchIndex = -1;
        clname1 = club;
        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (p.getClub().equalsIgnoreCase(clname1)) {
                plrList1.add(p);
                searchIndex = 0;
            }
        }
        if ( searchIndex == -1) {

           /* Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("ERROR !!");
            a.setContentText("No such club with this name");
            a.showAndWait();*/
        }
        else if ( searchIndex == 0) {
            Player x = plrList1.get(0);
            maxSalary = x.getWeeklysalary();
            for (int j = 1; j < plrList1.size(); j++) {
                Player pl = plrList1.get(j);
                if (pl.getWeeklysalary() > maxSalary) {
                    maxSalary = pl.getWeeklysalary();
                }
            }
            for (int i = 0; i < plrList1.size(); i++) {
                Player pl = plrList1.get(i);
                if (pl.getWeeklysalary() == maxSalary) {
                    plrList.add(pl);
                }
            }
        }
        return plrList;
    }
    public List<Player> getMaxAgeClubList(String club){

        int searchIndex = -1;
        clname2 = club;
       // List<Player> plrList = new ArrayList();
        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (p.getClub().equalsIgnoreCase(clname2)) {
                plrList1.add(p);
                searchIndex = 0;
            }
        }
        if ( searchIndex == -1) {
            /*Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("ERROR !!");
            a.setContentText("No such club with this name");
            a.showAndWait();*/
        }
        else if ( searchIndex == 0) {
            Player m = plrList1.get(0);
            maxAge = m.getAge();
            for (int j = 1; j < plrList1.size(); j++) {
                Player pl = plrList1.get(j);
                if (pl.getAge() > maxAge) {
                    maxAge = pl.getAge();
                }
            }
            for (int i = 0; i < plrList1.size(); i++) {
                Player pl = plrList1.get(i);
                if (pl.getAge() == maxAge) {
                    plrList.add(pl);
                }
            }
        }
        return plrList;
    }

    public List<Player> getMaxHeightClubList(String club){

        int searchIndex = -1;
        clname3 = club;
        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (p.getClub().equalsIgnoreCase(clname3)) {
                plrList1.add(p);
                searchIndex = 0;
            }
        }
        if ( searchIndex == -1) {
            /*Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("ERROR !!");
            a.setContentText("No such club with this name");
            a.showAndWait();*/
        }
        else if ( searchIndex == 0) {
            Player n = plrList1.get(0);
             maxHeight = n.getHeight();
            for (int j = 1; j < plrList1.size(); j++) {
                Player pl = plrList1.get(j);
                if (pl.getHeight() > maxHeight) {
                    maxHeight = pl.getHeight();
                }
            }
            for (int i = 0; i < plrList1.size(); i++) {
                Player pl = plrList1.get(i);
                if (pl.getHeight() == maxHeight) {
                    plrList.add(pl);
                }
            }
        }
        return plrList;
    }

    public double getTotalSalaryClub(String club){

        int searchIndex = -1;
        clname4 = club;

        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (p.getClub().equalsIgnoreCase(clname4)) {
                plrList.add(p);
                searchIndex = 0;
            }
        }
        if ( searchIndex == -1) {
           /* Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("ERROR !!");
            a.setContentText("No such club with this name");
            a.showAndWait();*/
            totalSalary = 0;
        }
        else if ( searchIndex == 0) {

            for (int j = 0; j < plrList.size(); j++) {
                Player pl = plrList.get(j);
                totalSalary = totalSalary + pl.getWeeklysalary();
            }
            totalSalary = (totalSalary / 7) * 365;
        }
        return totalSalary;
    }

    public void clearList() {
        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (clname4.equalsIgnoreCase(p.getClub())) {
                plrList.remove(p);
            }
        }
        totalSalary = 0;
    }

    public void clearMaxHeightClubList() {
        for (int i = 0; i < plrList1.size(); i++) {
            Player pl = plrList1.get(i);
            if (pl.getHeight() == maxHeight) {
                plrList.remove(pl);
            }
        }

        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (p.getClub().equalsIgnoreCase(clname3)) {
                plrList1.remove(p);
            }
        }
    }

    public void clearMaxAgeClubList() {
        for (int i = 0; i < plrList1.size(); i++) {
            Player pl = plrList1.get(i);
            if (pl.getAge() == maxAge) {
                plrList.remove(pl);
            }
        }

        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (p.getClub().equalsIgnoreCase(clname2)) {
                plrList1.remove(p);
            }
        }
    }
    public void clearMaxSalaryClubList() {
            for (int i = 0; i < plrList1.size(); i++) {
                Player pl = plrList1.get(i);
                if (pl.getWeeklysalary() == maxSalary) {
                    plrList.remove(pl);
                }
            }

            for (int i = 0; i < playerList.size(); i++) {
               Player p = playerList.get(i);
                if (p.getClub().equalsIgnoreCase(clname1)) {
                plrList1.remove(p);
               }
            }
    }

      public void clearListCC() {
        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (p.getCountry().equalsIgnoreCase(countryname) && p.getClub().equalsIgnoreCase(clubname)) {
                plrList.remove(p);
            }
            if (p.getCountry().equalsIgnoreCase(countryname) && cname.equalsIgnoreCase(clubname)) {
                plrList.remove(p);
            }
        }
    }

    public void clearListPos() {
        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (p.getPosition().equalsIgnoreCase(posname)) {
                plrList.remove(p);
            }
        }
    }
    public void clearListSalary() {
        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if ((p.getWeeklysalary() >= minrange) && (p.getWeeklysalary() <= maxrange)) {
                plrList.remove(p);
            }
        }
    }

    public int addPlayer(String player,String country, int playerAge, double playerHeight,String club, String position, int number, double wSalary) throws Exception {

        String pname = player;
        String cname = country;
        int age = playerAge;
        double height = playerHeight;
        String clname = club;
        String posname = position;
        int num = number;
        double salary = wSalary;

        List<Player> plrList = new ArrayList();
        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (p.getClub().equalsIgnoreCase(clname)) {
                plrList.add(p);
            }
        }

        int searchindex = -1;
        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (p.getName().equalsIgnoreCase(pname))
                searchindex = 1;
        }

        if (searchindex == -1) {
            String pos1 = "Goalkeeper";
            String pos2 = "Defender";
            String pos3 = "Midfielder";
            String pos4 = "Forward";
            if (posname.equalsIgnoreCase(pos1) || posname.equalsIgnoreCase(pos2)|| posname.equalsIgnoreCase(pos3)|| posname.equalsIgnoreCase(pos4)) {
                if (plrList.size() == 7) {

                   searchindex = 2;
                  /*  Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setHeaderText("ERROR !!");
                    a.setContentText("This club has already 7 players");
                    a.showAndWait();*/

                } else if (plrList.size() <= 7) {

                    Player p = new Player();
                    p.setName(pname);
                    p.setCountry(cname);
                    p.setAge(age);
                    p.setHeight(height);
                    p.setClub(clname);
                    p.setPosition(posname);
                    p.setNumber(num);
                    p.setWeeklysalary(salary);

                    playerList.add(p);
                    f.writeToFile(playerList);
                }
            }
            else{
                 searchindex = 3;
               /* Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("ERROR !!");
                a.setContentText("Please give input a correct position");
                a.showAndWait();*/

            }
        }
        else{

           /* Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("ERROR !!");
            a.setContentText("This player is already in the database");
            a.showAndWait();*/
        }
        return searchindex;
    }

    public int getSearchIndex(){
        if ( plrList.size() != 0 )
            searchIndex = 0;
        else
            searchIndex = -1;

        return searchIndex;
    }


}

class Player{
    private String name;
    private String country;
    private int age;
    private double height;
    private String club;
    private String position;
    private int number;
    private double weeklysalary;
    private Player plr;
   // FileIO f = new FileIO();
    Input in = new Input();
    PlrController pc = new PlrController();
    PlayerList pList = new PlayerList();
    public Player() {
    }

    public Player getPlayerByName(String name) throws Exception{
        List<Player> playerList = pList.getList();
        String pname;
        int searchIndex = -1;
        //System.out.print("Enter Player Name: ");
       // pname = in.getString();
        pname = name;
        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if (p.getName().equalsIgnoreCase(pname)) {
                plr = p;
               searchIndex = 0;
                break;
            }

        }
        if ( searchIndex == -1) {
            //System.out.println("No such player with this name");
        }
        return plr;
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
