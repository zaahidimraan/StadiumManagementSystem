package application;

import java.awt.Label;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

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

}
