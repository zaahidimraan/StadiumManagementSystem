package application;

import java.util.ArrayList;

import BusinessLogic.Bill.BillDetail;
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

public class Bill {

    @FXML
    private TableView<BillDetail> billTable;
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
    private RadioButton billStatus;

    @FXML
    private TextField billType;

    @FXML
    private TableColumn<BillDetail, Boolean> colBillStatus;

    @FXML
    private TableColumn<BillDetail, String> colBillType;

    @FXML
    private TableColumn<BillDetail, String> colDueDate;

    @FXML
    private TableColumn<BillDetail, Double> colPayment;

    @FXML
    private TableColumn<BillDetail, Integer> colPersonID;

    @FXML
    private TableColumn<BillDetail, Integer> colRefNo;

    @FXML
    private TextField dueDate;
    @FXML
    private TextField personID;
    @FXML
    private Button Edit;
    
    public void BillTable(ActionEvent Event) throws SQLException {
    	Main m=new Main();
    	ArrayList<BillDetail> stu = m.getBillHandler().getBillArrayList();;
    	

		final ObservableList<BillDetail> data = FXCollections.observableArrayList(stu);
        colRefNo.setCellValueFactory(new PropertyValueFactory<BillDetail, Integer>("billRefNo"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<BillDetail, String>("billDate"));
        colBillType.setCellValueFactory(new PropertyValueFactory<BillDetail, String>("billType"));
        colPersonID.setCellValueFactory(new PropertyValueFactory<BillDetail,Integer>("personID"));
        colPayment.setCellValueFactory(new PropertyValueFactory<BillDetail,Double>("payment"));
        colBillStatus.setCellValueFactory(new PropertyValueFactory<BillDetail,Boolean>("billStatus"));
		
        billTable.setItems(data);
		
    }
    
    public void getSelectedRow(ActionEvent Event) {
    	if(billTable.getSelectionModel() != null) {
    	 TableViewSelectionModel<BillDetail> b=billTable.getSelectionModel();
    	 dueDate.setText(b.getSelectedItem().getBillDate());
    	 personID.setText(b.getSelectedItem().getPersonID().toString());
    	 billType.setText(b.getSelectedItem().getBillType());
    	 if(b.getSelectedItem().getBillStatus())
    		 billStatus.setSelected(true);
    	 else
    		 billStatus.setSelected(false);
    	 billRefNo.setText(b.getSelectedItem().getBillRefNo().toString());
    	 billPayment.setText(b.getSelectedItem().getPayment().toString());
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
    		Integer person=Integer.parseInt(personID.getText());
    		Boolean status=billStatus.isSelected();
    		Main.getBillHandler().addBill(roll, dueDate.getText(), billType.getText(), person, payment, status);
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
    		Double payment=Double.parseDouble(billPayment.getText());
    		Integer person=Integer.parseInt(personID.getText());
    		Boolean status=billStatus.isSelected();
    		Main.getBillHandler().removeBill(roll);
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
    		Integer person=Integer.parseInt(personID.getText());
    		Boolean status=billStatus.isSelected();
    		Main.getBillHandler().updateBill(roll, dueDate.getText(), billType.getText(), person, payment, status);
    		this.BillTable(Event);
    	}    	
    }
    
    public void BackHome(ActionEvent Event) throws IOException {
    	Main m=new Main();
    	m.changeScene("Home.fxml");
    }

}
