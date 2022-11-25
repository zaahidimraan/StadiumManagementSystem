package application;

import java.util.ArrayList;

import BusinessLogic.Bill.BillDetail;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import java.io.IOException;

import BusinessLogic.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableView;

public class Bill {

    @FXML
    private TableView<BillDetail> billTable;

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
    
    public void BillTable(ActionEvent Event) {
    	ArrayList<BillDetail> stu = new ArrayList<BillDetail>();

			final ObservableList<BillDetail> data = FXCollections.observableArrayList(stu);
            colRefNo.setCellValueFactory(new PropertyValueFactory<BillDetail, Integer>("billRefNo"));
            colDueDate.setCellValueFactory(new PropertyValueFactory<BillDetail, String>("billDate"));
            colBillType.setCellValueFactory(new PropertyValueFactory<BillDetail, String>("billType"));
            colPersonID.setCellValueFactory(new PropertyValueFactory<BillDetail,Integer>("personID"));
            colPayment.setCellValueFactory(new PropertyValueFactory<BillDetail,Double>("payment"));
            colBillStatus.setCellValueFactory(new PropertyValueFactory<BillDetail,Boolean>("billStatus"));
			billTable.setItems(data);
		
    }

}
