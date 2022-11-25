package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;

public class Empire {

	    //@FXML
	    //private Label info;
	    @FXML
	    private TableColumn<BusinessLogic.EntAss.Empire, Integer> colStaffCNIC;

	    @FXML
	    private TableColumn<BusinessLogic.EntAss.Empire, Integer> colStaffDuty;

	    @FXML
	    private TableColumn<BusinessLogic.EntAss.Empire, String> colStaffName;

	    @FXML
	    private TableColumn<BusinessLogic.EntAss.Empire, Double> colStaffSalary;

	    @FXML
	    private TableColumn<BusinessLogic.EntAss.Empire, String> colStaffType;

	    @FXML
	    private Button staffAdd;

	    @FXML
	    private Button staffBack;

	    @FXML
	    private TextField staffCNIC;

	    @FXML
	    private Button staffDelete;

	    @FXML
	    private TextField staffDuty;

	    @FXML
	    private TextField staffName;

	    @FXML
	    private TextField staffSalary;

	    @FXML
	    private Button staffSalaryM;

	    @FXML
	    private TextField staffType;

	    @FXML
	    private Button staffUpdate;

	    @FXML
	    private TableView<BusinessLogic.EntAss.Empire> table;
	    
	    public void showTable(ActionEvent Event) throws SQLException {
	    	Main m=new Main();
			ArrayList<BusinessLogic.EntAss.Empire> stu = m.getEntAssRegsister().getEmpires();
	    	

			final ObservableList<BusinessLogic.EntAss.Empire> data = FXCollections.observableArrayList(stu);
	        colStaffCNIC.setCellValueFactory(new PropertyValueFactory<BusinessLogic.EntAss.Empire, Integer>("CNIC"));
	        colStaffName.setCellValueFactory(new PropertyValueFactory<BusinessLogic.EntAss.Empire, String>("name"));
	        colStaffType.setCellValueFactory(new PropertyValueFactory<BusinessLogic.EntAss.Empire, String>("Type"));
	        colStaffSalary.setCellValueFactory(new PropertyValueFactory<BusinessLogic.EntAss.Empire, Double>("fee"));
	        colStaffDuty.setCellValueFactory(new PropertyValueFactory<BusinessLogic.EntAss.Empire, Integer>("Pnumber"));
	        table.setItems(data);
			
	    }
	    
	    public void getSelectedRow(ActionEvent Event) {
	    	if(table.getSelectionModel() != null) {
	    	 TableViewSelectionModel<BusinessLogic.EntAss.Empire> b=table.getSelectionModel();
	    	 staffDuty.setText(b.getSelectedItem().getPnumber().toString());
	    	 staffName.setText(b.getSelectedItem().getName());
	    	 staffType.setText(b.getSelectedItem().getType());
	    	 staffCNIC.setText(b.getSelectedItem().getCNIC().toString());
	    	 staffSalary.setText(b.getSelectedItem().getFee().toString());
	    	}
	    	 
	    	 
	    }
	    
	    public void addBill(ActionEvent Event) throws IOException, SQLException {
	    	Main m=new Main();
	    	if(staffName.getText().isEmpty() || staffCNIC.getText().isEmpty()||staffType.getText().isEmpty())

	    	{
	    		//info.setText("Enter Data in all fields");
	    	}
	    	else {
	    		Integer roll=Integer.parseInt(staffCNIC.getText());
	    		Double payment=Double.parseDouble(staffSalary.getText());
	    		Integer phone=Integer.parseInt(staffDuty.getText());
	    		Main.getEntAssRegsister().addEntAss(roll, staffName.getText(), phone, staffType.getText(), payment);
	    		m.changeScene("Empire.fxml");
	    	}
	    	
	    }
	    
	    public void removeBill(ActionEvent Event) throws IOException, SQLException {
	    	Main m=new Main();
	    	if(staffName.getText().isEmpty() || staffCNIC.getText().isEmpty()||staffType.getText().isEmpty())

	    	{
	    		//info.setText("Enter Data in all fields");
	    	}
	    	else {
	    		Integer roll=Integer.parseInt(staffCNIC.getText());
	    		Double payment=Double.parseDouble(staffSalary.getText());
	    		Integer phone=Integer.parseInt(staffDuty.getText());
	    		Main.getEntAssRegsister().removeEntAss(phone, staffType.getText());
	    		m.changeScene("Empire.fxml");
	    	}
	    	
	    }
	    
	    public void updateBill(ActionEvent Event) throws SQLException, IOException {
	    	Main m=new Main();
	    	if(staffName.getText().isEmpty() || staffCNIC.getText().isEmpty()||staffType.getText().isEmpty())

	    	{
	    		//info.setText("Enter Data in all fields");
	    	}
	    	else {
	    		Integer roll=Integer.parseInt(staffCNIC.getText());
	    		Double payment=Double.parseDouble(staffSalary.getText());
	    		Integer phone=Integer.parseInt(staffDuty.getText());
	    		Main.getEntAssRegsister().updateEntAss(roll, staffName.getText(), phone, staffType.getText(), payment);
	    		m.changeScene("Empire.fxml");
	    	} 	
	    }

}
