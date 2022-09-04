import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        FileIO f = new FileIO();
        List<Player> playerList = f.readFromFile();
        while (true) {
            System.out.println("Main Menu: ");
            System.out.println("(1) Search Players");
            System.out.println("(2) Search Clubs");
            System.out.println("(3) Add Player");
            System.out.println("(4) Exit System");
            int ch;
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Main Menu Option: ");
            ch = sc.nextInt();
            if (ch == 1) {
                while (true) {
                    System.out.println("Player Searching Options:\n" +
                            "(1) By Player Name\n" +
                            "(2) By Club and Country\n" +
                            "(3) By Position\n" +
                            "(4) By Salary Range\n" +
                            "(5) Country-wise player count\n" +
                            "(6) Back to Main Menu");
                    int ch1;
                    System.out.print("Enter Player Searching Option: ");
                    ch1 = sc.nextInt();
                    if (ch1 == 1){
                        String pname;
                        int searchIndex = -1;
                        sc = new Scanner(System.in);
                        System.out.print("Enter Player Name: ");
                        pname = sc.nextLine();
                        for (int i = 0; i < playerList.size(); i++) {
                            Player p = playerList.get(i);
                            if (p.getName().equalsIgnoreCase(pname)) {
                                System.out.println(p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight() + "," + p.getClub() + "," + p.getPosition() + "," + p.getNumber() + "," + p.getWeeklysalary());
                                searchIndex = 0;
                                break;
                            }

                        }
                        if ( searchIndex == -1) {
                            System.out.println("No such player with this name");
                        }

                    }
                    else if( ch1 == 2){
                        String countryname;
                        String clubname;
                        int searchIndex = -1;
                        sc = new Scanner(System.in);
                        System.out.print("Enter Country Name: ");
                        countryname = sc.nextLine();
                        System.out.print("Enter Club Name: ");
                        clubname = sc.nextLine();
                        for (int i = 0; i < playerList.size(); i++) {
                            Player p = playerList.get(i);
                            if (p.getCountry().equalsIgnoreCase(countryname) && p.getClub().equalsIgnoreCase(clubname)) {
                                System.out.println(p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight() + "," + p.getClub() + "," + p.getPosition() + "," + p.getNumber() + "," + p.getWeeklysalary());
                                searchIndex = 0;
                            }

                        }
                        String cname = "ANY";
                        if(cname.equalsIgnoreCase(clubname)){
                        for (int i = 0; i < playerList.size(); i++) {
                            Player p = playerList.get(i);
                            if (p.getCountry().equalsIgnoreCase(countryname)) {
                                System.out.println(p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight() + "," + p.getClub() + "," + p.getPosition() + "," + p.getNumber() + "," + p.getWeeklysalary());
                                searchIndex = 0;
                            }
                         }
                        }

                        if ( searchIndex == -1) {
                            System.out.println("No such player with this country and club");
                        }

                    }
                    else if( ch1 == 3){
                        String posname;
                        int searchIndex = -1;
                        sc = new Scanner(System.in);
                        System.out.print("Enter Position Name: ");
                        posname = sc.nextLine();
                        for (int i = 0; i < playerList.size(); i++) {
                            Player p = playerList.get(i);
                            if (p.getPosition().equalsIgnoreCase(posname)) {
                                System.out.println(p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight() + "," + p.getClub() + "," + p.getPosition() + "," + p.getNumber() + "," + p.getWeeklysalary());
                                searchIndex = 0;
                            }
                        }

                        if ( searchIndex == -1) {
                            System.out.println("No such player with this position");
                        }
                    }
                    else if( ch1 == 4){
                        Double minrange;
                        Double maxrange;
                        int searchIndex = -1;
                        sc = new Scanner(System.in);
                        System.out.print("Enter Minimum Salary Range: ");
                        minrange = sc.nextDouble();
                        System.out.print("Enter Maximum Salary Range: ");
                        maxrange = sc.nextDouble();
                        for (int i = 0; i < playerList.size(); i++) {
                            Player p = playerList.get(i);
                            if ((p.getWeeklysalary() >= minrange) && (p.getWeeklysalary() <= maxrange)) {
                                System.out.println(p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight() + "," + p.getClub() + "," + p.getPosition() + "," + p.getNumber() + "," + p.getWeeklysalary());
                                searchIndex = 0;
                            }
                        }
                        if ( searchIndex == -1) {
                            System.out.println("No such player with this weekly salary range");
                        }
                    }
                    else if( ch1 == 5){
                        int count = 0;
                        List<Player> plrList = new ArrayList();
                        for (int i = 0; i < playerList.size(); i++) {
                            Player p = playerList.get(i);
                                plrList.add(p);
                            }

                        for ( int k =0; k < playerList.size(); k++) {
                            for (int i = 0; i < plrList.size(); i++) {
                                Player p1 = plrList.get(i);
                                for (int j = 0; j < plrList.size(); j++) {
                                    Player p2 = plrList.get(j);
                                    if (p1.getCountry().equalsIgnoreCase(p2.getCountry())) {
                                        count++;
                                        plrList.remove(j);
                                    }
                                }
                                System.out.println(p1.getCountry() + " " + count);
                                count = 0;
                            }

                            if (plrList.size() == 0){
                                break;
                            }
                        }
                    }
                    else if( ch1 == 6){
                       break;
                    }
                    else{
                        System.out.println("Error! Please type a value from 1 to 6");
                    }
                }
            } else if (ch == 2) {
                while (true) {
                    System.out.println("Club Searching Options:\n" +
                            "(1) Player(s) with the maximum salary of a club\n" +
                            "(2) Player(s) with the maximum age of a club\n" +
                            "(3) Player(s) with the maximum height of a club\n" +
                            "(4) Total yearly salary of a club\n" +
                            "(5) Back to Main Menu");
                    int ch2;
                    System.out.print("Enter Club Searching Option: ");
                    ch2 = sc.nextInt();
                    if (ch2 == 1){
                        String clname;
                        int searchIndex = -1;
                        sc = new Scanner(System.in);
                        System.out.print("Enter Club Name: ");
                        clname = sc.nextLine();
                        List<Player> plrList = new ArrayList();
                        for (int i = 0; i < playerList.size(); i++) {
                            Player p = playerList.get(i);
                            if (p.getClub().equalsIgnoreCase(clname)) {
                                plrList.add(p);
                                searchIndex = 0;
                            }
                        }
                        if ( searchIndex == -1) {
                            System.out.println("No such club with this name");
                        }
                        else if ( searchIndex == 0) {
                            Player x = plrList.get(0);
                            double maxSalary = x.getWeeklysalary();
                            for (int j = 1; j < plrList.size(); j++) {
                                Player pl = plrList.get(j);
                                if (pl.getWeeklysalary() > maxSalary) {
                                    maxSalary = pl.getWeeklysalary();
                                }
                            }
                            for (int i = 0; i < plrList.size(); i++) {
                                Player pl = plrList.get(i);
                                if (pl.getWeeklysalary() == maxSalary) {
                                    System.out.println(pl.getName() + "," + pl.getCountry() + "," + pl.getAge() + "," + pl.getHeight() + "," + pl.getClub() + "," + pl.getPosition() + "," + pl.getNumber() + "," + pl.getWeeklysalary());
                                }
                            }
                        }
                    }
                    else if( ch2 == 2){
                        String clname;
                        int searchIndex = -1;
                        sc = new Scanner(System.in);
                        System.out.print("Enter Club Name: ");
                        clname = sc.nextLine();
                        List<Player> plrList = new ArrayList();
                        for (int i = 0; i < playerList.size(); i++) {
                            Player p = playerList.get(i);
                            if (p.getClub().equalsIgnoreCase(clname)) {
                                plrList.add(p);
                                searchIndex = 0;
                            }
                        }
                        if ( searchIndex == -1) {
                            System.out.println("No such club with this name");
                        }
                        else if ( searchIndex == 0) {
                            Player m = plrList.get(0);
                            int maxAge = m.getAge();
                            for (int j = 1; j < plrList.size(); j++) {
                                Player pl = plrList.get(j);
                                if (pl.getAge() > maxAge) {
                                    maxAge = pl.getAge();
                                }
                            }
                            for (int i = 0; i < plrList.size(); i++) {
                                Player pl = plrList.get(i);
                                if (pl.getAge() == maxAge) {
                                    System.out.println(pl.getName() + "," + pl.getCountry() + "," + pl.getAge() + "," + pl.getHeight() + "," + pl.getClub() + "," + pl.getPosition() + "," + pl.getNumber() + "," + pl.getWeeklysalary());
                                }
                            }
                        }
                    }
                    else if( ch2 == 3){
                        String clname;
                        int searchIndex = -1;
                        sc = new Scanner(System.in);
                        System.out.print("Enter Club Name: ");
                        clname = sc.nextLine();
                        List<Player> plrList = new ArrayList();
                        for (int i = 0; i < playerList.size(); i++) {
                            Player p = playerList.get(i);
                            if (p.getClub().equalsIgnoreCase(clname)) {
                                plrList.add(p);
                                searchIndex = 0;
                            }
                        }
                        if ( searchIndex == -1) {
                            System.out.println("No such club with this name");
                        }
                        else if ( searchIndex == 0) {
                            Player n = plrList.get(0);
                            double maxHeight = n.getHeight();
                            for (int j = 1; j < plrList.size(); j++) {
                                Player pl = plrList.get(j);
                                if (pl.getHeight() > maxHeight) {
                                    maxHeight = pl.getHeight();
                                }
                            }
                            for (int i = 0; i < plrList.size(); i++) {
                                Player pl = plrList.get(i);
                                if (pl.getHeight() == maxHeight) {
                                    System.out.println(pl.getName() + "," + pl.getCountry() + "," + pl.getAge() + "," + pl.getHeight() + "," + pl.getClub() + "," + pl.getPosition() + "," + pl.getNumber() + "," + pl.getWeeklysalary());
                                }
                            }
                        }
                    }
                    else if( ch2 == 4){
                        String clname;
                        int searchIndex = -1;
                        sc = new Scanner(System.in);
                        System.out.print("Enter Club Name: ");
                        clname = sc.nextLine();
                        List<Player> plrList = new ArrayList();
                        for (int i = 0; i < playerList.size(); i++) {
                            Player p = playerList.get(i);
                            if (p.getClub().equalsIgnoreCase(clname)) {
                                plrList.add(p);
                                searchIndex = 0;
                            }
                        }
                        if ( searchIndex == -1) {
                            System.out.println("No such club with this name");
                        }
                        else if ( searchIndex == 0) {
                            double totalSalary = 0;
                            for (int j = 0; j < plrList.size(); j++) {
                                Player pl = plrList.get(j);
                              totalSalary = totalSalary + pl.getWeeklysalary();
                            }
                            totalSalary = (totalSalary / 7) * 365;
                            System.out.println("The total yearly salary of all players of this club " + totalSalary);
                        }
                    }
                    else if( ch2 == 5){
                        break;
                    }
                    else{
                        System.out.println("Error! Please type a value from 1 to 5");
                    }
                }
            } else if (ch == 3) {
                sc = new Scanner(System.in);
                System.out.print("Enter Name: ");
                String pname = sc.nextLine();
                System.out.print("Enter Country: ");
                String cname = sc.nextLine();
                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                System.out.print("Enter Height: ");
                double height = sc.nextDouble();
                sc = new Scanner(System.in);
                System.out.print("Enter Club: ");
                String clname = sc.nextLine();
                System.out.print("Enter Position: ");
                String posname = sc.nextLine();
                System.out.print("Enter Number: ");
                int num = sc.nextInt();
                System.out.print("Enter WeeklySalary: ");
                double salary = sc.nextDouble();

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
                        searchindex = i;
                }

                if (searchindex == -1) {

                    if (plrList.size() == 7) {
                        System.out.println("This club has already 7 players");
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

                    }
                }
                else{
                    System.out.println("This player is already in the database");
                }
            }
            else if (ch == 4) {
                f.writeToFile(playerList);
                /*for (Player s : playerList) {
                    System.out.println(s.getName() + "," + s.getCountry() + "," + s.getAge() + "," + s.getHeight() + "," + s.getClub() + "," + s.getPosition() + "," + s.getNumber() + "," + s.getWeeklysalary());
                }*/
                break;
            }
            else{
                System.out.println("Error! Please type a value from 1 to 4");
            }
        }
    }
}
