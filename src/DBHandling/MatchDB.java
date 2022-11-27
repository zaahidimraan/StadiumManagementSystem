package DBHandling;

import BusinessLogic.Match.Match;

import java.sql.*;
import java.util.ArrayList;

public class MatchDB {
    private String usrname = "root";
    private String pass = "zaheer47983";
    Connection con; // connection object



    public MatchDB() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HorizonStadium", usrname, pass);
            System.out.println("Connection made to DB");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

    public ArrayList<Match> getMatchs() throws SQLException {
        return getMatchArray();
    }

    public ArrayList<Match> getMatchArray() throws SQLException {


        ArrayList<Match> arr = new ArrayList<Match>();
        Statement stm;
        String query="SELECT * FROM MatchDetail";
        stm=con.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while(rs.next()) {
            Match temp = new Match(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            arr.add(temp);
        }

        return arr;
    }

    public void addMatch(Match match) throws SQLException {

        String query="insert into MatchDetail VALUES('"+match.getMatchID()+"','"+match.getMatchType()+"','"+match.getMatchDate()+"','"+match.getStartIme()+"','"+match.getTeam1()+"','"+match.getTeam2()+"');";
        Statement stm=con.createStatement();
        stm.executeUpdate(query);
    }

    public void removeMatch(String MatchID) throws SQLException {
        String query = "delete from MatchDetail where M_ID = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(1, MatchID);

        // execute the preparedstatement
        preparedStmt.execute();
    }

    public void updateMatch(Match match) throws SQLException {
        String query = "delete from MatchDetail where M_ID = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(1, match.getMatchID());

        // execute the preparedstatement
        preparedStmt.execute();

        String query1="insert into MatchDetail VALUES('"+match.getMatchID()+"','"+match.getMatchType()+"','"+match.getMatchDate()+"','"+match.getStartIme()+"','"+match.getTeam1()+"','"+match.getTeam2()+"')";
        Statement stm=con.createStatement();
        stm.executeUpdate(query1);
    }

}
