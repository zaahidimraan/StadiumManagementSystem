package application;
	
import javafx.application.Application;

import BusinessLogic.Bill.BillHandler;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.fxml.*;

public class Main extends Application {
	private static Stage stg;
	private static BillHandler billHandler=new BillHandler();
	@Override
	public void start(Stage primaryStage) {
		try {
			this.stg = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("Bill.fxml"));
			Scene scene = new Scene(root, 900, 600);
			primaryStage.setTitle("Bill Detail");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
