package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.Staff.Salary;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;

public class SalaryStaff {

    @FXML
    private Button Edit;

    @FXML
    private TableView<Salary> Salarytable;

    @FXML
    private TableColumn<Salary, String> colMonth;

    @FXML
    private TableColumn<Salary, Integer> colStaffCNIC;

    @FXML
    private TableColumn<Salary, Double> colStaffSalary;

    @FXML
    private TableColumn<Salary, Boolean> colStatus;
    @FXML
    private TableColumn<Salary, String> colDate;

    @FXML
    private TextField date;

    @FXML
    private TextField month;

    @FXML
    private TextField salary;

    @FXML
    private Button staffAdd;

    @FXML
    private Button staffBack;

    @FXML
    private TextField staffCNIC;
    @FXML
    private TextField cnic;

    @FXML
    private Button staffDelete;

    @FXML
    private Button staffUpdate;

    @FXML
    private RadioButton status;

    @FXML
    private Button table;
    
    public void Salarytable(ActionEvent Event) throws SQLException {
    	Main m=new Main();
    	Integer value=Integer.valueOf(Integer.parseInt(cnic.getText()));
    	ArrayList<Salary> stu = m.getStaffRegsister().getSalaryArray(value);
    	

		final ObservableList<Salary> data = FXCollections.observableArrayList(stu);
        colStaffCNIC.setCellValueFactory(new PropertyValueFactory<Salary, Integer>("CNIC"));
        colDate.setCellValueFactory(new PropertyValueFactory<Salary, String>("date"));
        colStaffSalary.setCellValueFactory(new PropertyValueFactory<Salary, Double>("payement"));
        colMonth.setCellValueFactory(new PropertyValueFactory<Salary,String>("month"));
        colStatus.setCellValueFactory(new PropertyValueFactory<Salary,Boolean>("Status"));
		
        Salarytable.setItems(data);
		
    }
    
    public void getSelectedRow(ActionEvent Event) {
    	if(Salarytable.getSelectionModel() != null) {
    	 TableViewSelectionModel<Salary> b=Salarytable.getSelectionModel();
    	 staffCNIC.setText(b.getSelectedItem().getCNIC().toString());
    	 month.setText(b.getSelectedItem().getMonth());
    	 date.setText(b.getSelectedItem().getDate());
    	 if(b.getSelectedItem().getStatus())
    		 status.setSelected(true);
    	 else
    		 status.setSelected(false);
    	 salary.setText(b.getSelectedItem().getPayement().toString());
    	}
    }
    
    public void addBill(ActionEvent Event) throws IOException, SQLException {
    	Main m=new Main();
    	if(staffCNIC.getText().isEmpty() || salary.getText().isEmpty()||month.getText().isEmpty())

    	{
    		month.setText("Enter Data in all fields");
    	}
    	else {
    		Integer roll=Integer.parseInt(staffCNIC.getText());
    		Double payment=Double.parseDouble(salary.getText());
    		Boolean status1=status.isSelected();
    		Main.getStaffRegsister().addSalary(status1, payment, roll, date.getText(), month.getText());;
    		this.Salarytable(Event);
    	}
    	
    }
    
    public void removeBill(ActionEvent Event) throws IOException, SQLException {
    	Main m=new Main();
    	if(staffCNIC.getText().isEmpty() || salary.getText().isEmpty()||month.getText().isEmpty())
    	{
    		month.setText("Enter Data in all fields");
    	}
    	else {
    		Integer roll=Integer.parseInt(staffCNIC.getText());
    		Double payment=Double.parseDouble(salary.getText());
    		Boolean status1=status.isSelected();
    		Main.getStaffRegsister().removeSalary(roll, month.getText());;
    		this.Salarytable(Event);
    	}
    	
    }
    
    public void updateBill(ActionEvent Event) throws SQLException, IOException {
    	Main m=new Main();
    	if(staffCNIC.getText().isEmpty() || salary.getText().isEmpty()||month.getText().isEmpty())
    	{
    		month.setText("Enter Data in all fields");
    	}
    	else {
    		Integer roll=Integer.parseInt(staffCNIC.getText());
    		Double payment=Double.parseDouble(salary.getText());
    		Boolean status1=status.isSelected();
    		Main.getStaffRegsister().updateSalary(status1, payment, roll, date.getText(), month.getText());;
    		this.Salarytable(Event);
    	}    	
    }
    
    public void BackHome(ActionEvent Event) throws IOException {
    	Main m=new Main();
    	m.changeScene("Home.fxml");
    }

}
