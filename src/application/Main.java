package application;
	
import javafx.application.Application;

import java.io.IOException;
import java.sql.SQLException;

import BusinessLogic.Bill.BillHandler;
import BusinessLogic.EntAss.EntAssRegsisterBL;
import BusinessLogic.Match.MatchRegsister;
import BusinessLogic.Person.PersonRegsister;
import BusinessLogic.Staff.StaffRegsisterA;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.fxml.*;

public class Main extends Application {
	private static Stage stg;
	private static BillHandler billHandler=new BillHandler();
	private static EntAssRegsisterBL entAssRegsister=new EntAssRegsisterBL();
	private static MatchRegsister matchRegsister=new MatchRegsister();
	private static StaffRegsisterA staffRegsister=new StaffRegsisterA();
	private static PersonRegsister personRegsister=new PersonRegsister();
	@Override
	public void start(Stage primaryStage) {
		try {
			this.stg = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(root, 900, 600);
			primaryStage.setTitle("Horizon Stadium");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException {
	    
		launch(args);
	}

	public static BillHandler getBillHandler() {
		return billHandler;
	}

	public static EntAssRegsisterBL getEntAssRegsister() {
		return entAssRegsister;
	}

	public static MatchRegsister getMatchRegsister() {
		return matchRegsister;
	}

	public static StaffRegsisterA getStaffRegsister() {
		return staffRegsister;
	}
	
	
	public static PersonRegsister getPersonRegsister() {
		return personRegsister;
	}

	public static void setPersonRegsister(PersonRegsister personRegsister) {
		Main.personRegsister = personRegsister;
	}

	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}


}
