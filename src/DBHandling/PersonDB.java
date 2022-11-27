package DBHandling;

import java.util.ArrayList;
import java.sql.*;
import BusinessLogic.*;
import BusinessLogic.Bill.BillDetail;
import BusinessLogic.Person.OrderFood;
import BusinessLogic.Person.Payment;
import BusinessLogic.Person.Person;
import BusinessLogic.Person.seatDetail;

public class PersonDB {
    private String usrname = "root";
    private String pass = "zaheer47983";
    Connection con; // connection object

    public PersonDB() { // default constructor

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HorizonStadium", usrname, pass);
            System.out.println("Connection made to DB");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Connection failed!");
            e.printStackTrace();
        }

    }
    public ArrayList<Person> getPersons(String MID,Integer CNIC) throws SQLException {
        return getPersonArray(MID,CNIC);
    }

    public ArrayList<Person> getPersonArray(String M_ID,Integer CNIC) throws SQLException {


        ArrayList<Person> arr = new ArrayList<Person>();
        Statement stm;
        String query="SELECT * FROM Person";
        stm=con.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while(rs.next()) {
        	if((M_ID.equals(rs.getString(5)))&&(CNIC==rs.getInt(1))) {
            Person temp =null;
            temp = new Person(rs.getInt(1),rs.getString(2));
             if(rs.getString(4).equals("A")) {
                if(rs.getInt(6)==1)
                 temp.setSeat(rs.getInt(3), rs.getString(4), 1500.0, rs.getString(5), rs.getInt(6),1000.0);
                else if(rs.getInt(6)==2)
                    temp.setSeat(rs.getInt(3), rs.getString(4), 1500.0, rs.getString(5), rs.getInt(6),800.0);
                else if (rs.getInt(6)==3) {
                    temp.setSeat(rs.getInt(3), rs.getString(4), 1500.0, rs.getString(5), rs.getInt(6),500.0);
                }
             }
             else if(rs.getString(4).equals("B")){
                if(rs.getInt(6)==1)
                    temp.setSeat(rs.getInt(3), rs.getString(4), 1000.0, rs.getString(5), rs.getInt(6),1000.0);
                else if(rs.getInt(6)==2)
                    temp.setSeat(rs.getInt(3), rs.getString(4), 1000.0, rs.getString(5), rs.getInt(6),800.0);
                else if (rs.getInt(6)==3) {
                    temp.setSeat(rs.getInt(3), rs.getString(4), 1000.0, rs.getString(5), rs.getInt(6),500.0);
                }
             }
             else if(rs.getString(4).equals("C")){
                if(rs.getInt(6)==1)
                    temp.setSeat(rs.getInt(3), rs.getString(4), 500.0, rs.getString(5), rs.getInt(6),1000.0);
                else if(rs.getInt(6)==2)
                    temp.setSeat(rs.getInt(3), rs.getString(4), 500.0, rs.getString(5), rs.getInt(6),800.0);
                else if (rs.getInt(6)==3) {
                    temp.setSeat(rs.getInt(3), rs.getString(4), 500.0, rs.getString(5), rs.getInt(6),500.0);
                }
             }

             arr.add(temp);

         }

        }

        return arr;
    }

    public void addPerson(Person bill) throws SQLException {

        String query="insert into Person VALUES("+bill.getCNIC()+",'"+bill.getName()+"','"+bill.getSeat().getSeatNumber()+"','"+bill.getSeat().getSeatType()+"'" +
                ",'"+bill.getSeat().getM_ID()+"','"+bill.getSeat().getOrderFood().getFoodID()+"')";
        Statement stm=con.createStatement();
        stm.executeUpdate(query);

        String query1="insert into PersonPaymentDetail VALUES("+bill.getCNIC()+",'"+bill.getSeat().getM_ID()+"','"+bill.getSeat().getPayment().getPayment()+"',"+1+",'Nothing')";
        Statement stm1=con.createStatement();
        stm.executeUpdate(query1);
    }

    public void removePerson(Integer CNIC,String seatingareaa,String MID) throws SQLException {

        String query1 = "delete from Person where V_CNIC = ? and M_ID =?";
        PreparedStatement preparedStmt1 = con.prepareStatement(query1);
        preparedStmt1.setInt(1, CNIC);
        preparedStmt1.setString(2, MID);
        // execute the preparedstatement
        preparedStmt1.execute();

        String query = "delete from Person where V_CNIC = ?  and SA_type= ? and M_ID =?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, CNIC);
        preparedStmt.setString(2, seatingareaa);
        preparedStmt.setString(3, MID);
        // execute the preparedstatement
        preparedStmt.execute();
    }

    public Person getPayment(Person person) throws SQLException {
        Statement stm;
        String query="SELECT * FROM PersonPaymentDetail";
        stm=con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        String M_ID=person.getSeat().getM_ID();
        Integer CNIC=person.getCNIC();
        while(rs.next()) {
        	
            if((M_ID.equals(rs.getString(2)))&&(CNIC==rs.getInt(1))) {
            	person.getSeat().setPayment(new Payment(rs.getDouble(3),rs.getBoolean(4),rs.getString(5)));	
               return (person);
            }

        }

        return null;
    }

    public void updatePayment(Person bill) throws SQLException {
        this.removePerson(bill.getCNIC(),bill.getSeat().getSeatType(),bill.getSeat().getM_ID());
        this.addPerson(bill);

    }

}
