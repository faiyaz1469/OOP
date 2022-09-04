import java.util.Scanner;

public class League {
    private Match[] matches;
    private int matchCount;
    private int clubCount;
    // add your variables here, if required
    private String name;
    private Club[] clubs;

    public League() {
        // assume a league can have at most 5 clubs, add code for initialization accordingly
        clubCount = 0;
        matchCount = 0;
        this.clubs = new Club[5];
    }

    public void printClubs(){
        System.out.println("Clubs:");
        // print the name of the clubs of this league, each one on a line
        for (int i=0; i<clubCount; i++)
        {
            System.out.println( clubs[i].getName());
        }
    }

    public void printLeagueInfo(){
        System.out.println("League : " + name);
        printClubs();
    }


    public void scheduleMatches(){
        matchCount = (clubCount*(clubCount-1));
        matches = new Match[matchCount];
        int matchNo = 0;
        for (int i=0; i<clubCount; i++){
            for (int j=0; j<clubCount; j++){
                // check the constructor of the Match class and add your code here
                // note that there will be two matches between club A and club B
                // in the first match, club A will play as the home team and in the second match, as the away team
              if ( i != j) {
                  matches[matchNo] = new Match(matchNo, clubs[i], clubs[j]);
                  matchNo++;
              }

            }
        }
    }

    public void simulateMatches(){
        for (int i=0; i<matchCount; i++){
            matches[i].play();
        }
    }

    public void showStandings(){
        // sort the clubs in descending order of points
        // note that, the sequence in which clubs were added to the league, should be unchanged
        // check the given sample output for clarification
        // (carefully observe the output of showStandings() followed by printLeagueInfo() method calls
        // you can use additional arrays if needed
        System.out.println("Sl. - Club - Points");

        int [] total = new int[clubCount];
        for (int i = 0; i < clubCount ; i++) {
               total[i]=0;
            for ( int j = 0; j < matchCount ; j++) {
                   matches[j].points();
                if( matches[j].getHomeTeam() == clubs[i] || matches[j].getAwayTeam() == clubs[i]) {
                    total[i] = total[i] + clubs[i].getPoint();
               }
            }
        }

        Club []temporary = new Club[clubCount];
        for ( int i=0;  i < clubCount; i++)
        {
            temporary[i] = clubs[i];
        }

        Club tmp;
        int temp;

        for (int i = 0; i < clubCount; i++) {
            for (int j = i+1; j < clubCount; j++) {
                if ( total[i] < total[j]) {
                    temp = total[i];
                    tmp = clubs[i];
                    total[i] = total[j];
                    clubs[i] = clubs[j];
                    total[j] = temp;
                    clubs[j] = tmp;
                }
            }
        }
        // print the clubs in descending order of points
        for (int i = 0; i < clubCount; i++) {
            System.out.println(i+1 + ". " + clubs[i].getName() + " " + total[i]);
        }

        for ( int i=0;  i < clubCount; i++)
        {
            clubs[i]=temporary[i];
        }
    }
    // add your methods here, if required
    public void setName(String name)
    {
        this.name = name;
    }
    public void addClub(Club c) {
        clubs[clubCount] = c;
        clubCount++;
    }
    public void printMatches(){
        for (int i=0; i<matchCount; i++){
            matches[i].showResult();
        }
    }
    public void removeClub(Club c){
       Club []newclubs = new Club[clubCount - 1];
       for(int i = 0; i < clubCount; i++){
            if(clubs[i].getId() == c.getId()) {
                for (int index = 0; index < i; index++) {
                    newclubs[index] = clubs[index];
                }
            }
                for(int j = i; j < clubCount - 1; j++){
                    newclubs[j] = clubs[j+1];
                }
                break;
       }
       for ( int i=0;  i < clubCount-1; i++)
       {
           clubs[i]= newclubs[i];
       }
        clubCount= clubCount-1;
    }
}


