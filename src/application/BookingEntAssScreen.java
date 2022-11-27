package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.EntAss.BookingAss;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookingEntAssScreen {

	 @FXML
	    private Button Add;

	    @FXML
	    private Button Back;

	    @FXML
	    private TextField CNIC;

	    @FXML
	    private Button Delete;

	    @FXML
	    private Button Edit;

	    @FXML
	    private Button Update;

	    @FXML
	    private TextField billPayment;

	    @FXML
	    private TextField billRefNo;

	    @FXML
	    private TableView<BookingAss> billTable;

	    @FXML
	    private TextField cnic;

	    @FXML
	    private TableColumn<BookingAss, String> colBillType;

	    @FXML
	    private TableColumn<BookingAss, Integer> colCNIC;

	    @FXML
	    private TableColumn<BookingAss, String> colDueDate;

	    @FXML
	    private TableColumn<BookingAss, String> colRefNo;

	    @FXML
	    private TextField dueDate;

	    @FXML
	    private Label info;

	    @FXML
	    private Button show;


    @FXML
    public void BillTable(ActionEvent Event) throws SQLException {
    	Main m=new Main();
    	
    	ArrayList<BookingAss> stu = m.getEntAssRegsister().getBookingList(m.getEntAssRegsister().getEntAssID());
    	

		final ObservableList<BookingAss> data = FXCollections.observableArrayList(stu);
        colRefNo.setCellValueFactory(new PropertyValueFactory<BookingAss, String>("M_ID"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<BookingAss, String>("date"));
        colBillType.setCellValueFactory(new PropertyValueFactory<BookingAss, String>("time"));
        colCNIC.setCellValueFactory(new PropertyValueFactory<BookingAss,Integer>("CNIC"));
		
        billTable.setItems(data);
		
    }
    
    public void getSelectedRow(ActionEvent Event) {
    	if(billTable.getSelectionModel() != null) {
    	 TableViewSelectionModel<BookingAss> b=billTable.getSelectionModel();
    	 dueDate.setText(b.getSelectedItem().getDate());
    	 billRefNo.setText(b.getSelectedItem().getM_ID());
    	 billPayment.setText(b.getSelectedItem().getTime());
    	}
    }
    
    public void addBill(ActionEvent Event) throws IOException, SQLException {
    	Main m=new Main();
    	if(billRefNo.getText().isEmpty() || billPayment.getText().isEmpty())

    	{
    		info.setText("Enter Data in all fields");
    	}
    	else {
    		//Integer roll=Integer.parseInt(CNIC.getText());
    		Main.getEntAssRegsister().addBooking(m.getEntAssRegsister().getEntAssID(),billRefNo.getText() ,dueDate.getText() , billPayment.getText());;
    		this.BillTable(Event);
    	}
    	this.BillTable(Event);
    }
    @FXML
    void removeBill(ActionEvent Event) throws SQLException {
    	Main m=new Main();
    	if(billRefNo.getText().isEmpty() || billPayment.getText().isEmpty())

    	{
    		info.setText("Enter Data in all fields");
    	}
    	else {
    		//Integer roll=Integer.parseInt(CNIC.getText());
    		Main.getEntAssRegsister().removeBooking(m.getEntAssRegsister().getEntAssID(),billRefNo.getText());;
    		this.BillTable(Event);
    	}
    	this.BillTable(Event);
    }

    @FXML
    void updateBill(ActionEvent event) {

    }
    public void BackHome(ActionEvent Event) throws IOException {
    	Main m=new Main();
    	m.changeScene("Home.fxml");
    }
}
