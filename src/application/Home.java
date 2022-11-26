package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogic.Staff.Staff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;

public class Home {

    @FXML
    private Button bookticket;

    @FXML
    private TextField login;

    @FXML
    private TableColumn<BusinessLogic.Match.Match,String> matchdate;

    @FXML
    private TableColumn<BusinessLogic.Match.Match,String> matchid;

    @FXML
    private TableColumn<BusinessLogic.Match.Match,String> matchtime;

    @FXML
    private TableColumn<BusinessLogic.Match.Match,String> matchtype;
    @FXML
    private TableColumn<BusinessLogic.Match.Match,String> colteam1;

    @FXML
    private TableColumn<BusinessLogic.Match.Match,String> colteam2;

    @FXML
    private TextField password;

    @FXML
    private Button show;

    @FXML
    private TableView<BusinessLogic.Match.Match> table;
    
    public void MatchTable(ActionEvent Event) throws SQLException {
    	Main m=new Main();
    	ArrayList<BusinessLogic.Match.Match> stu = m.getMatchRegsister().getMatches();
    	

		final ObservableList<BusinessLogic.Match.Match> data = FXCollections.observableArrayList(stu);
        matchid.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Match.Match, String>("matchID"));
        matchdate.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Match.Match, String>("matchDate"));
        matchtype.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Match.Match, String>("matchType"));
        matchtime.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Match.Match,String>("startIme"));
        colteam1.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Match.Match, String>("team1"));
        colteam2.setCellValueFactory(new PropertyValueFactory<BusinessLogic.Match.Match,String>("team2"));
       
		
        table.setItems(data);
		
    }
    
    public void getSelectedRow(ActionEvent Event) throws IOException {
    	if(table.getSelectionModel() != null) {
    	 TableViewSelectionModel<BusinessLogic.Match.Match> b=table.getSelectionModel();
    	 Main m=new Main();
    	 m.getPersonRegsister().setM_ID(b.getSelectedItem().getMatchID());
    	 m.changeScene("BookTicket.fxml");
    	 
    	}
    }
    
    public void LoginUser(ActionEvent Event) throws IOException, NumberFormatException, SQLException {
    	Main m=new Main();
    	String CNIC=login.getText(); 
    	Staff sm=m.getStaffRegsister().getLogin(Integer.valueOf(Integer.parseInt(CNIC)),password.getText());
    	if(sm!=null) {
    		if(sm.getType().equals("Admin"))
    			m.changeScene("adminpage.fxml");
    		else
    			m.changeScene("staffpage.fxml");
    	}
    	else {
    		login.setText("Wrong Entry");
    	}
    }
    
	public void EntAssPage(ActionEvent Event) throws IOException {
    	Main m=new Main();
    	m.changeScene("EntAssRegsister.fxml");
    	
    }
    
    public void BillPage(ActionEvent Event) throws IOException {
    	Main m=new Main();
    	m.changeScene("Bill.fxml");
    	
    	
    }
    
    public void StaffPage(ActionEvent Event) throws IOException {
    	Main m=new Main();
    	m.changeScene("StaffManage.fxml");
    	
    	
    }
    
    public void MatchPage(ActionEvent Event) throws IOException {
    	Main m=new Main();
    	m.changeScene("Match.fxml");
    	
    	
    }
    
     public void BackPage(ActionEvent Event) throws IOException {
    	 Main m=new Main();
     	m.changeScene("Home.fxml");
     	
    }

}