package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EntAssRegsister {

    @FXML
    private Button commentator;

    @FXML
    private Button empire;

    @FXML
    void EmpireScreen(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("Empire.fxml");

    }

    @FXML
    void commentatorScreen(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("Commentator.fxml");
    	
    }

}
