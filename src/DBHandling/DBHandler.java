package DBHandling;

import java.util.ArrayList;
import java.sql.*;
import BusinessLogic.*;

public class DBHandler {
	private String usrname = "root";
	private String pass = "zaheer47983";
	Connection con; // connection object

	public DBHandler() { // default constructor

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/University", usrname, pass);
			System.out.println("Connection made to DB");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection failed!");
			e.printStackTrace();
		}

	}
}
