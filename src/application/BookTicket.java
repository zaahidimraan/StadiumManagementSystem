package application;

import java.awt.Label;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.Person.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookTicket {


    @FXML
    private TextField fname;

    @FXML
    private TextField fname1;
    @FXML
    private TextField foodid;
    @FXML
    private TextField seatno;

    @FXML
    private TextField seatingarea;

    @FXML
    private Button register;

    @FXML
    private Button register1;

    @FXML
    private Button register21;

    @FXML
    private Button register211;

    @FXML
    private Button register2111;

    @FXML
    private Button register2112;

    @FXML
    private Button register2113;

    @FXML
    private Button register2114;

    @FXML
    private Button register2115;

    @FXML
    private Button register21151;

    @FXML
    private TableColumn<BusinessLogic.Person.Person, Integer> tableCNIC;

    @FXML
    private TableColumn<BusinessLogic.Person.Person, String> tableName;

    @FXML
    private TableColumn<BusinessLogic.Person.Person, Integer> tableSeatNumber;

    @FXML
    private TableColumn<BusinessLogic.Person.Person, String> tableSeatingArea;
    @FXML
    private TableColumn<BusinessLogic.Person.Person, Integer> colFood;
    @FXML
    private TableColumn<BusinessLogic.Person.Person, Double> colPrice;
    @FXML
    private TableView<BusinessLogic.Person.Person> billTable;
    
    public void BillTable(ActionEvent Event) throws SQLException {
    	Main m=new Main();
    	ArrayList<BusinessLogic.Person.Person> stu = m.getPersonRegsister().getPersonArrayList(Integer.valueOf(Integer.parseInt(fname.getText())));
    	

		final ObservableList<BusinessLogic.Person.Person> data = FXCollections.observableArrayList(stu);
        tableCNIC.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Person.Person, Integer>("CNIC"));
        tableName.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Person.Person, String>("name"));
        tableSeatNumber.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Person.Person, Integer>("seatNumber"));
        tableSeatingArea.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Person.Person, String>("seatType"));
        colFood.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Person.Person, Integer>("FID"));
        colPrice.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Person.Person, Double>("seatPrice"));
        billTable.setItems(data);
		
    }
    
    public void getSelectedRow(ActionEvent Event) {
    	if(billTable.getSelectionModel() != null) {
    	 TableViewSelectionModel<Person> b=billTable.getSelectionModel();
    	 fname.setText(b.getSelectedItem().getCNIC().toString());
    	 fname1.setText(b.getSelectedItem().getName());
    	 seatingarea.setText(b.getSelectedItem().getSeatType());
    	 foodid.setText(b.getSelectedItem().getFID().toString());
    	 seatno.setText(b.getSelectedItem().getSeatNumber().toString());
    	 
    	}
    }
    
    public void addBill(ActionEvent Event) throws IOException, SQLException {
    	Main m=new Main();
        String CNIC=fname.getText();
        Integer cnic=Integer.valueOf(Integer.parseInt(CNIC));
        String name=fname1.getText();
        Integer foodid1=Integer.valueOf(Integer.parseInt(foodid.getText()));
        Integer seatno1=Integer.valueOf(Integer.parseInt(seatno.getText()));
    	m.getPersonRegsister().addPerson(cnic, name,seatno1,seatingarea.getText(),foodid1);
    	this.BillTable(Event);
    }
    
    
    
    public void removeBill(ActionEvent Event) throws IOException, SQLException {
    	Main m=new Main();
        String CNIC=fname.getText();
        Integer cnic=Integer.valueOf(Integer.parseInt(CNIC));
        String name=fname1.getText();
    	m.getPersonRegsister().removePerson(cnic, seatingarea.getText());
    	this.BillTable(Event);
    }
    
    public void screenPayment(ActionEvent EVent) throws IOException {
        String CNIC=fname.getText();
        Integer cnic=Integer.valueOf(Integer.parseInt(CNIC));
        String name=fname1.getText();
        Integer foodid1=Integer.valueOf(Integer.parseInt(foodid.getText()));
        Integer seatno1=Integer.valueOf(Integer.parseInt(seatno.getText()));
        Main m=new Main();
        m.getPersonRegsister().setIndex(cnic, name,seatno1,seatingarea.getText(),foodid1);
        System.out.println(m.getPersonRegsister().getIndex());
        m.changeScene("Payment.fxml");
    }
    public void BackHome(ActionEvent Event) throws IOException {
    	Main m=new Main();
    	m.changeScene("Home.fxml");
    }


}
