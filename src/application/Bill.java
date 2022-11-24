package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class Bill {

	 @FXML
	    private TableColumn<?, ?> colStaffCNIC;

	    @FXML
	    private TableColumn<?, ?> colStaffDuty;

	    @FXML
	    private TableColumn<?, ?> colStaffName;

	    @FXML
	    private TableColumn<?, ?> colStaffSalary;

	    @FXML
	    private TableColumn<?, ?> colStaffType;

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

}
