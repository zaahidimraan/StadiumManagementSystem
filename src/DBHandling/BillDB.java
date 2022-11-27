package DBHandling;

import BusinessLogic.Bill.BillDetail;

import java.sql.*;
import java.util.ArrayList;

public class BillDB {
    private String usrname = "root";
    private String pass = "zaheer47983";
    Connection con; // connection object
    


    public BillDB() {
    	try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HorizonStadium", usrname, pass);
            System.out.println("Connection made to DB");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
	}

	public ArrayList<BillDetail> getBills() throws SQLException {
        return getBillArray();
    }

    public ArrayList<BillDetail> getBillArray() throws SQLException {
    	
    	
        ArrayList<BillDetail> arr = new ArrayList<BillDetail>();
        Statement stm;
        String query="SELECT * FROM Bill";
        stm=con.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while(rs.next()) {
            BillDetail temp = new BillDetail(rs.getInt(1),rs.getString(4),rs.getString(3),rs.getInt(5),rs.getDouble(6),rs.getBoolean(2));
            arr.add(temp);
        }

        return arr;
    }

    public void addBill(BillDetail bill) throws SQLException {
    	int temp=0;
    	if(bill.getBillStatus())
    		temp=1;
    	else
    		temp=0;
    	
        String query="insert into Bill VALUES("+bill.getBillRefNo()+","+temp+",'"+bill.getBillType()+"','"+bill.getBillDate()+"',"
        +bill.getPersonID()+","+bill.getPayment()+")";


        Statement stm=con.createStatement();
        stm.executeUpdate(query);
    }

    public void removeBill(Integer billID) throws SQLException {
        String query = "delete from Bill where B_ID = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, billID);

        // execute the preparedstatement
        preparedStmt.execute();
    }

    public void updateBill(BillDetail bill) throws SQLException {
        String query = "delete from Bill where B_ID = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, bill.getBillRefNo());

        // execute the preparedstatement
        preparedStmt.execute();

    	int temp=0;
    	if(bill.getBillStatus())
    		temp=1;
    	else
    		temp=0;
    	
        String query1="insert into Bill VALUES("+bill.getBillRefNo()+","+temp+",'"+bill.getBillType()+"','"+bill.getBillDate()+"',"
        +bill.getPersonID()+","+bill.getPayment()+")";


        Statement stm=con.createStatement();
        stm.executeUpdate(query1);
    }

}
