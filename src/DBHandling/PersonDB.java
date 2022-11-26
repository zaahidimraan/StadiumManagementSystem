package DBHandling;

import java.util.ArrayList;
import java.sql.*;
import BusinessLogic.*;
import BusinessLogic.Bill.BillDetail;
import BusinessLogic.Person.Person;

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
    public ArrayList<Person> getPersons() throws SQLException {
        return getPersonArray();
    }

    public ArrayList<Person> getPersonArray() throws SQLException {


        ArrayList<Person> arr = new ArrayList<Person>();
        Statement stm;
        String query="SELECT * FROM Person";
        stm=con.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while(rs.next()) {
            Person temp = new Person(rs.getInt(1),rs.getString(2));
            arr.add(temp);
        }

        return arr;
    }

    public void addPerson(Person bill) throws SQLException {

        String query="insert into Person VALUES("+bill.getCNIC()+",'"+bill.getName()+"')";
        Statement stm=con.createStatement();
        stm.executeUpdate(query);
    }

    public void removePerson(Person PersonID) throws SQLException {
        String query = "delete from Person where V_CNIC = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, PersonID.getCNIC());

        // execute the preparedstatement
        preparedStmt.execute();
    }

    public void updatePerson(Person person) throws SQLException {
        String query = "delete from Person where V_CNIC = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, person.getCNIC());

        // execute the preparedstatement
        preparedStmt.execute();

        String query1="insert into Person VALUES("+person.getCNIC()+",'"+person.getName()+"')";
        Statement stm=con.createStatement();
        stm.executeUpdate(query1);
    }

}
