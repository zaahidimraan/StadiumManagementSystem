package application;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Payment {

    @FXML
    private Button back;

    @FXML
    private TextField cnic;

    @FXML
    private TextField foodid;

    @FXML
    private Button main;

    @FXML
    private TextField matchid;

    @FXML
    private RadioButton paid;

    @FXML
    private Button pay;

    @FXML
    private TextField payment;

    @FXML
    private TextField seatnumber;

    @FXML
    private TextField seattype;

    @FXML
    private Button show;


    
    public void showDetail(ActionEvent Event) throws SQLException {
      Main m=new Main();
      BusinessLogic.Person.Person pay=m.getPersonRegsister().getPayment();	
      cnic.setText(pay.getCNIC().toString());
      matchid.setText(pay.getSeat().getM_ID());
      seattype.setText(pay.getSeat().getSeatType());
      seatnumber.setText(pay.getSeat().getSeatNumber().toString());
      foodid.setText(pay.getSeat().getOrderFood().getFoodID().toString());
      payment.setText(pay.getSeat().getPayment().getPaymentMethod());
      if(pay.getSeat().getPayment().getPaymentStatus())
 		 paid.setSelected(true);
 	 else
 		 paid.setSelected(false);
      
    		  
    }
    
    public void Pay(ActionEvent Event) throws SQLException, IOException {
    	Main m=new Main();
        BusinessLogic.Person.Person pay=m.getPersonRegsister().getPayment();	
    	if(paid.isSelected()) {
    	   m.getPersonRegsister().updatePayment(paid.isSelected(), payment.getText());
          m.changeScene("BookTicket.fxml");
    	 }
    	else
    		payment.setText("Pay First");
    	
    }
    
    public void Back(ActionEvent Event) throws IOException {
    	Main m=new Main();
    	m.changeScene("BookTicket.fxml");
    }

}
