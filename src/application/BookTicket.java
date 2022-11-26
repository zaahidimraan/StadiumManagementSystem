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
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookTicket {

    @FXML
    private MenuButton seatingArea;

    @FXML
    private MenuButton orderFood;
    @FXML
    private TextField fname;

    @FXML
    private TextField fname1;

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
    private TableColumn<BusinessLogic.Person.seatDetail, Integer> tableSeatNumber;

    @FXML
    private TableColumn<BusinessLogic.Person.seatDetail, String> tableSeatingArea;
    @FXML
    private TableView<BusinessLogic.Person.Person> billTable;
    
    public void BillTable(ActionEvent Event) throws SQLException {
    	Main m=new Main();
    	ArrayList<Person> stu = m.getPersonRegsister().getPersonArrayList();
    	

		final ObservableList<Person> data = FXCollections.observableArrayList(stu);
        tableCNIC.setCellValueFactory(new PropertyValueFactory<Person, Integer>("CNIC"));
        tableName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
		
        billTable.setItems(data);
		
    }
    
    public void getSelectedRow(ActionEvent Event) {
    	if(billTable.getSelectionModel() != null) {
    	 TableViewSelectionModel<Person> b=billTable.getSelectionModel();
    	 fname.setText(b.getSelectedItem().getCNIC().toString());
    	 fname1.setText(b.getSelectedItem().getName());
    	 
    	}
    }
    
    public void addBill(ActionEvent Event) throws IOException, SQLException {
    	Main m=new Main();
        String CNIC=fname.getText();
        Integer cnic=Integer.valueOf(Integer.parseInt(CNIC));
        String name=fname1.getText();
    	m.getPersonRegsister().addPerson(cnic, name);
    }
    
    public void updateBill(ActionEvent Event) throws IOException, SQLException {
    	Main m=new Main();
        String CNIC=fname.getText();
        Integer cnic=Integer.valueOf(Integer.parseInt(CNIC));
        String name=fname1.getText();
    	m.getPersonRegsister().removePerson(cnic, name);
    }
    
    public void removeBill(ActionEvent Event) throws IOException, SQLException {
    	Main m=new Main();
        String CNIC=fname.getText();
        Integer cnic=Integer.valueOf(Integer.parseInt(CNIC));
        String name=fname1.getText();
    	m.getPersonRegsister().updatePerson(cnic, name);
    }

}
