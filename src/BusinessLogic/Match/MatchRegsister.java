package BusinessLogic.Match;

import DBHandling.MatchDB;

import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.Staff.Staff;

public class MatchRegsister {

    private ArrayList<Match> matches=new ArrayList<Match>();

    public ArrayList<Match> getMatches() throws SQLException {
    	MatchDB db=new MatchDB();
    	matches=db.getMatchs();
        return matches;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    public void addMatch(String matchID, String matchType, String matchDate, String startIme,String team1,String team2) throws SQLException {
        matches.add(new Match(matchID,matchType,matchDate,startIme,team1,team2));
        MatchDB db=new MatchDB();
        db.addMatch(new Match(matchID,matchType,matchDate,startIme,team1,team2));

    }

    public void removeMatch(String matchID) throws SQLException {

        for(int i=0;i<matches.size();i++){
            if(matchID.equals(matches.get(i).getMatchID())){
                matches.remove(i);
                MatchDB db=new MatchDB();
                db.removeMatch(matchID);
                i=matches.size();
            }
        }

    }

    public void updateMatch(String matchID, String matchType, String matchDate, String startIme,String team1,String team2) throws SQLException {
        for(int i=0;i<matches.size();i++){
            if(matchID.equals(matches.get(i).getMatchID())){
                matches.get(i).setMatchDate(matchDate);
                matches.get(i).setMatchType(matchType);
                matches.get(i).setStartIme(startIme);
                matches.get(i).setTeam1(team1);
                matches.get(i).setTeam2(team2);
                MatchDB db=new MatchDB();
                db.updateMatch(new Match(matchID,matchType,matchDate,startIme,team1,team2));
                i=matches.size();
            }
        }
    }

	

}
