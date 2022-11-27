package DBHandling;

import BusinessLogic.Bill.BillDetail;
import BusinessLogic.EntAss.BookingAss;
import BusinessLogic.EntAss.Commentator;
import BusinessLogic.EntAss.Empire;

import java.sql.*;
import java.util.ArrayList;

public class EntAssDB {
    private String usrname = "root";
    private String pass = "zaheer47983";
    Connection con; // connection object



    public EntAssDB() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HorizonStadium", usrname, pass);
            System.out.println("Connection made to DB");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

    public ArrayList<Commentator> getCommentatorArray(String type) throws SQLException {

          ArrayList<Commentator> arr = new ArrayList<Commentator>();
          Statement stm;
          String query = "SELECT * FROM EntAss";
          stm = con.createStatement();
          ResultSet rs = stm.executeQuery(query);

          while (rs.next()) {
        	  if(type.equals(rs.getString(4)))
        		  arr.add(new Commentator(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getDouble(5)));
              
          }

          return arr;

    }

    public ArrayList<Empire> getEmpireArray(String type) throws SQLException {

        ArrayList<Empire> arr = new ArrayList<Empire>();
        Statement stm;
        String query = "SELECT * FROM EntAss";
        stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while (rs.next()) {
        	if(type.equals(rs.getString(4)))
              arr.add(new Empire(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getDouble(5)));
            
        }

        return arr;

    }

    public void addCommentator(Commentator commentator) throws SQLException {

        String query="insert into EntAss VALUES("+commentator.getCNIC()+",'"+commentator.getName()+"','"+commentator.getPnumber()+"','"+commentator.getType()+"','"+commentator.getFee()+"')";
        Statement stm=con.createStatement();
        stm.executeUpdate(query);
    }

    public void addEmpire(Empire empire) throws SQLException {

        String query="insert into EntAss VALUES("+empire.getCNIC()+",'"+empire.getName()+"','"+empire.getPnumber()+"','"+empire.getType()+"','"+empire.getFee()+"')";
        Statement stm=con.createStatement();
        stm.executeUpdate(query);
    }

    public void removePerson(Integer CNIC) throws SQLException {
        String query = "delete from EntAss where A_CNIC = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, CNIC);

        // execute the preparedstatement
        preparedStmt.execute();
    }

    public void updateCommentator(Commentator commentator) throws SQLException {
        String query = "delete from EntAss where A_CNIC = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, commentator.getCNIC());

        // execute the preparedstatement
        preparedStmt.execute();

        String query1="insert into EntAss VALUES("+commentator.getCNIC()+",'"+commentator.getName()+"','"+commentator.getPnumber()+"','"+commentator.getType()+"','"+commentator.getFee()+"')";
        Statement stm=con.createStatement();
        stm.executeUpdate(query1);
    }

    public void updateEmpire(Empire empire) throws SQLException {
        String query = "delete from EntAss where A_CNIC = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, empire.getCNIC());

        // execute the preparedstatement
        preparedStmt.execute();
        String query1="insert into EntAss VALUES("+empire.getCNIC()+",'"+empire.getName()+"','"+empire.getPnumber()+"','"+empire.getType()+"','"+empire.getFee()+"')";
        Statement stm=con.createStatement();
        stm.executeUpdate(query1);
    }

    public ArrayList<BookingAss> getBookingEnt(Integer CNIC) throws SQLException {
        ArrayList<BookingAss> arr = new ArrayList<BookingAss>();
        Statement stm;
        String query = "SELECT * FROM A_BookingDetail";
        stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while (rs.next()) {
            if(CNIC==rs.getInt(1))
                arr.add(new BookingAss(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));

        }

        return arr;
    }

    public void addBooking(Integer CNIC,String M_ID,String date,String time) throws SQLException {
        String query="insert into A_BookingDetail VALUES("+CNIC+",'"+M_ID+"','"+date+"','"+time+"')";
        Statement stm=con.createStatement();
        stm.executeUpdate(query);
    }
    
    public void removrBooking(Integer CNIC,String M_ID) throws SQLException {
        String query = "delete from A_BookingDetail where A_CNIC = ?  and M_ID = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, CNIC);
        preparedStmt.setString(2, M_ID);
        // execute the preparedstatement
        preparedStmt.execute();
    }
}
