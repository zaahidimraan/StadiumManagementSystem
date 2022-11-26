package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.SQLException;

import BusinessLogic.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;

public class StaffManage {

    @FXML
    private TableView<BusinessLogic.Staff.Staff> billTable;
    @FXML
    private Label info;

    @FXML
    private Button Add;

    @FXML
    private Button Back;
    @FXML
    private Button show;
    @FXML
    private Button Delete;

    @FXML
    private Button Update;

    @FXML
    private TextField billPayment;

    @FXML
    private TextField billRefNo;

    @FXML
    private TextField billStatus;

    @FXML
    private TextField billType;

    @FXML
    private TableColumn<BusinessLogic.Staff.Staff, String> colBillStatus;

    @FXML
    private TableColumn<BusinessLogic.Staff.Staff, String> colBillType;

    @FXML
    private TableColumn<BusinessLogic.Staff.Staff, String> colDueDate;

    @FXML
    private TableColumn<BusinessLogic.Staff.Staff, Double> colPayment;

    @FXML
    private TableColumn<BusinessLogic.Staff.Staff, String> colPersonID;

    @FXML
    private TableColumn<BusinessLogic.Staff.Staff, Integer> colRefNo;

    @FXML
    private TextField dueDate;
    @FXML
    private TextField personID;
    @FXML
    private Button Edit;
 
    
    public void BillTable(ActionEvent Event) throws SQLException {
    	Main m=new Main();
    	ArrayList<BusinessLogic.Staff.Staff> stu = m.getStaffRegsister().getStaffArrayList();
    	

		final ObservableList<BusinessLogic.Staff.Staff> data = FXCollections.observableArrayList(stu);
        colRefNo.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Staff.Staff, Integer>("CNIC"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Staff.Staff, String>("name"));
        colBillType.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Staff.Staff, String>("type"));
        colPersonID.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Staff.Staff,String>("duty"));
        colPayment.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Staff.Staff,Double>("salary"));
        colBillStatus.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Staff.Staff,String>("password"));
		
        billTable.setItems(data);
		
    }
    
    public void getSelectedRow(ActionEvent Event) {
    	if(billTable.getSelectionModel() != null) {
    	 TableViewSelectionModel<BusinessLogic.Staff.Staff> b=billTable.getSelectionModel();
    	 dueDate.setText(b.getSelectedItem().getName());
    	 personID.setText(b.getSelectedItem().getDuty());
    	 billType.setText(b.getSelectedItem().getType());
    	 billStatus.setText(b.getSelectedItem().getPassword());
    	 billRefNo.setText(b.getSelectedItem().getCNIC().toString());
    	 billPayment.setText(b.getSelectedItem().getSalary().toString());
    	}
    }
    
    public void addBill(ActionEvent Event) throws IOException, SQLException {
    	Main m=new Main();
    	if(billRefNo.getText().isEmpty() || billPayment.getText().isEmpty()||billStatus.getText().isEmpty())

    	{
    		info.setText("Enter Data in all fields");
    	}
    	else {
    		Integer roll=Integer.parseInt(billRefNo.getText());
    		Double payment=Double.parseDouble(billPayment.getText());
    		
    		Main.getStaffRegsister().addPerson(roll, dueDate.getText(), billType.getText(), payment, personID.getText(), billStatus.getText());
    		this.BillTable(Event);
    	}
    	
    }
    
    public void removeBill(ActionEvent Event) throws IOException, SQLException {
    	Main m=new Main();
    	if(billRefNo.getText().isEmpty() || billPayment.getText().isEmpty()||billStatus.getText().isEmpty())

    	{
    		info.setText("Enter Data in all fields");
    	}
    	else {
    		Integer roll=Integer.parseInt(billRefNo.getText());
    		Main.getStaffRegsister().removePerson(roll, billType.getText());
    		this.BillTable(Event);
    	}
    	
    }
    
    public void updateBill(ActionEvent Event) throws SQLException, IOException {
    	Main m=new Main();
    	if(billRefNo.getText().isEmpty() || billPayment.getText().isEmpty()||billStatus.getText().isEmpty())

    	{
    		info.setText("Enter Data in all fields");
    	}
    	else {
    		Integer roll=Integer.parseInt(billRefNo.getText());
    		Double payment=Double.parseDouble(billPayment.getText());
    		
    		Main.getStaffRegsister().updatePerson(roll, dueDate.getText(), billType.getText(), payment, personID.getText(), billStatus.getText());
    		this.BillTable(Event);
    	}    	
    }
    
    public void BackPage(ActionEvent Event) throws IOException {
   	 Main m=new Main();
    	m.changeScene("Home.fxml");
   }
    
    public void SalaryPage(ActionEvent Event) throws IOException, SQLException {
      	 Main m=new Main();
       	m.changeScene("SalaryStaff.fxml");
      }

}
