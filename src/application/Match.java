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

public class Match {

    @FXML
    private TableView<BusinessLogic.Match.Match> MatchTable;
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
    private TextField MatchRefNo;

    @FXML
    private TextField MatchType;


    @FXML
    private TableColumn<BusinessLogic.Match.Match, String> colMatchType;

    @FXML
    private TableColumn<BusinessLogic.Match.Match, String> colDueDate;


    @FXML
    private TableColumn<BusinessLogic.Match.Match, String> colPersonID;

    @FXML
    private TableColumn<BusinessLogic.Match.Match, String> colRefNo;
    @FXML
    private TableColumn<BusinessLogic.Match.Match, String> colteam1;

    @FXML
    private TableColumn<BusinessLogic.Match.Match, String> colteam2;
    
    @FXML
    private TextField team1;

    @FXML
    private TextField team2;

    @FXML
    private TextField dueDate;
    @FXML
    private TextField personID;
    @FXML
    private Button Edit;
    
    public void MatchTable(ActionEvent Event) throws SQLException {
    	Main m=new Main();
    	ArrayList<BusinessLogic.Match.Match> stu = m.getMatchRegsister().getMatches();
    	

		final ObservableList<BusinessLogic.Match.Match> data = FXCollections.observableArrayList(stu);
        colRefNo.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Match.Match, String>("matchID"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Match.Match, String>("matchDate"));
        colMatchType.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Match.Match, String>("matchType"));
        colPersonID.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Match.Match,String>("startIme"));
        colteam1.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Match.Match, String>("team1"));
        colteam2.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Match.Match,String>("team2"));
		
        MatchTable.setItems(data);
		
    }
    
    public void getSelectedRow(ActionEvent Event) {
    	if(MatchTable.getSelectionModel() != null) {
    	 TableViewSelectionModel<BusinessLogic.Match.Match> b=MatchTable.getSelectionModel();
    	 dueDate.setText(b.getSelectedItem().getMatchDate());
    	 personID.setText(b.getSelectedItem().getStartIme());
    	 MatchType.setText(b.getSelectedItem().getMatchType());
    	 MatchRefNo.setText(b.getSelectedItem().getMatchID());
    	 team1.setText(b.getSelectedItem().getTeam1());
    	 team2.setText(b.getSelectedItem().getTeam2());    	 
    	}
    }
    
    public void addMatch(ActionEvent Event) throws IOException, SQLException {
    	Main m=new Main();
    	if(MatchRefNo.getText().isEmpty())

    	{
    		info.setText("Enter Data in all fields");
    	}
    	else {
    		Main.getMatchRegsister().addMatch(MatchRefNo.getText(),MatchType.getText(),dueDate.getText(),personID.getText(),team1.getText(),team2.getText());
    		this.MatchTable(Event);
    	}
    	
    }
    
    public void removeMatch(ActionEvent Event) throws IOException, SQLException {
    	Main m=new Main();
    	if(MatchRefNo.getText().isEmpty() )

    	{
    		info.setText("Enter Data in all fields");
    	}
    	else {
    		Main.getMatchRegsister().removeMatch(MatchRefNo.getText());
    		this.MatchTable(Event);
    	}
    	
    }
    
    public void updateMatch(ActionEvent Event) throws SQLException, IOException {
    	Main m=new Main();
    	if(MatchRefNo.getText().isEmpty())

    	{
    		info.setText("Enter Data in all fields");
    	}
    	else {
    		Main.getMatchRegsister().updateMatch(MatchRefNo.getText(),MatchType.getText(),dueDate.getText(),personID.getText(),team1.getText(),team2.getText());
    		this.MatchTable(Event);
    	}    	
    }
    
    public void BackHome(ActionEvent Event) throws IOException {
    	Main m=new Main();
    	m.changeScene("Home.fxml");
    }

}
