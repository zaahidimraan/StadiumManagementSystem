package DBHandling;

import BusinessLogic.Bill.BillDetail;
import BusinessLogic.Staff.Salary;
import BusinessLogic.Staff.Staff;

import java.sql.*;
import java.util.ArrayList;

public class staffDB {
    private String usrname = "root";
    private String pass = "zaheer47983";
    Connection con; // connection object



    public staffDB() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HorizonStadium", usrname, pass);
            System.out.println("Connection made to DB");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

    public ArrayList<Staff> getstaffs() throws SQLException {
        return getstaffArray();
    }

    public ArrayList<Staff> getstaffArray() throws SQLException {


        ArrayList<Staff> arr = new ArrayList<Staff>();
        Statement stm;
        String query="SELECT * FROM Staff";
        stm=con.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while(rs.next()) {
            Staff temp = new Staff(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6));
            arr.add(temp);
        }

        return arr;
    }

    public void addstaff(Staff staff) throws SQLException {


        String query="insert into Staff VALUES("+staff.getCNIC()+",'"+staff.getName()+"','"+staff.getType()+"',"+staff.getSalary()+",'"
                +staff.getDuty()+"','"+staff.getPassword()+"')";


        Statement stm=con.createStatement();
        stm.executeUpdate(query);
    }

    public void removestaff(Integer staffID) throws SQLException {
        String query = "delete from Staff where S_CNIC = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, staffID);

        // execute the preparedstatement
        preparedStmt.execute();
    }

    public void updatestaff(Staff staff) throws SQLException {
        String query = "delete from Staff where S_CNIC = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, staff.getCNIC());

        // execute the preparedstatement
        preparedStmt.execute();

        String query1="insert into Staff VALUES("+staff.getCNIC()+",'"+staff.getName()+"','"+staff.getType()+"',"+staff.getSalary()+",'"
                +staff.getDuty()+"','"+staff.getPassword()+"')";


        Statement stm=con.createStatement();
        stm.executeUpdate(query1);
    }

    // Salary Management
    public ArrayList<Salary> getSalaryArray(Integer CNIC) throws SQLException {


        ArrayList<Salary> arr = new ArrayList<Salary>();
        Statement stm;
        String query="SELECT * FROM Salary";
        stm=con.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while(rs.next()) {
        	if(rs.getInt(1)==CNIC.intValue())
        		arr.add(new Salary(rs.getBoolean(2),rs.getDouble(3),rs.getInt(1),rs.getString(4),rs.getString(5)));
             
        }

        return arr;
    }

    public void addsSalary(Salary staff) throws SQLException {
    	int temp=0;
    	if(staff.getStatus())
    		temp=1;
    	else
    		temp=0;

        String query="insert into Salary VALUES("+staff.getCNIC()+",'"+temp+"','"+staff.getPayement()+"','"+staff.getMonth()+"','"
                +staff.getDate()+"')";
        Statement stm=con.createStatement();
        stm.executeUpdate(query);
    }

    public void removeSalary(Integer staffID,String month) throws SQLException {
        String query = "delete from Salary where S_CNIC = ? and SL_date = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, staffID);
        preparedStmt.setString(2, month);

        // execute the preparedstatement
        preparedStmt.execute();
    }

    public void updateSalary(Salary staff) throws SQLException {
        String query = "delete from Salary where S_CNIC = ? and SL_month=?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, staff.getCNIC());
        preparedStmt.setString(2, staff.getMonth());

        // execute the preparedstatement
        preparedStmt.execute();
        int temp=0;
    	if(staff.getStatus())
    		temp=1;
    	else
    		temp=0;

        String query1="insert into salary VALUES("+staff.getCNIC()+","+temp+","+staff.getPayement()+",'"+staff.getMonth()+"','"
                +staff.getDate()+"')";
        Statement stm=con.createStatement();
        stm.executeUpdate(query1);
    }

}
