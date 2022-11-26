package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Home {

    @FXML
    private Button bookticket;

    @FXML
    private TextField login;

    @FXML
    private TableColumn<?, ?> matchdate;

    @FXML
    private TableColumn<?, ?> matchid;

    @FXML
    private TableColumn<?, ?> matchtime;

    @FXML
    private TableColumn<?, ?> matchtype;

    @FXML
    private TextField password;

    @FXML
    private Button show;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> team1;

    @FXML
    private TableColumn<?, ?> team2;

}