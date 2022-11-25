package BusinessLogic.Match;

import java.util.ArrayList;

public class Match {
    private String matchID;
    private String matchType;
    private String matchDate;
    private String startIme;

    private Team team1;
    private Team team2;
    private ArrayList<SeatingArea> seatingAreas=new ArrayList<SeatingArea>();

    public Match(String matchID, String matchType, String matchDate, String startIme) {
        this.matchID = matchID;
        this.matchType = matchType;
        this.matchDate = matchDate;
        this.startIme = startIme;


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
}
