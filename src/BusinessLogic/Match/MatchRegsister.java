package BusinessLogic.Match;

import java.util.ArrayList;

public class MatchRegsister {

    private ArrayList<Match> matches=new ArrayList<Match>();

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    public void addMatch(String matchID, String matchType, String matchDate, String startIme){
        matches.add(new Match(matchID,matchType,matchDate,startIme));

    }

    public void removeMatch(String matchID){

        for(int i=0;i<matches.size();i++){
            if(matchID==matches.get(i).getMatchID()){
                matches.remove(i);
                i=matches.size();
            }
        }

    }

    public void updateMatch(String matchID, String matchType, String matchDate, String startIme){
        for(int i=0;i<matches.size();i++){
            if(matchID==matches.get(i).getMatchID()){
                matches.get(i).setMatchDate(matchDate);
                matches.get(i).setMatchType(matchType);
                matches.get(i).setStartIme(startIme);
                i=matches.size();
            }
        }
    }

}
