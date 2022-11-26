package BusinessLogic.Match;

import java.util.ArrayList;

public class Match {
    private String matchID;
    private String matchType;
    private String matchDate;
    private String startIme;

    private String team1;
    private String team2;
    private ArrayList<SeatingArea> seatingAreas=new ArrayList<SeatingArea>();

    public Match(String matchID, String matchType, String matchDate, String startIme,String team1,String team2) {
        this.matchID = matchID;
        this.matchType = matchType;
        this.matchDate = matchDate;
        this.startIme = startIme;
        this.team1=team1;
        this.team2=team2;

        seatingAreas.add(new SeatingArea("A",20));
        seatingAreas.add(new SeatingArea("B",20));
        seatingAreas.add(new SeatingArea("C",20));

    }

    public String getMatchID() {
        return matchID;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getStartIme() {
        return startIme;
    }

    public void setStartIme(String startIme) {
        this.startIme = startIme;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public ArrayList<SeatingArea> getSeatingAreas() {
        return seatingAreas;
    }

    public void setSeatingAreas(ArrayList<SeatingArea> seatingAreas) {
        this.seatingAreas = seatingAreas;
    }
}
