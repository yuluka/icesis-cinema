package control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.CinemaData;

public class Register {
	@FXML
    private Button BTTN_REGISTER;

    @FXML
    private TextField TXT_ID;

    @FXML
    private TextField TXT_NAME;
    
    private CinemaData cinema = new CinemaData();
    
    @FXML
    void registerUser(ActionEvent event) throws IOException{
    	String name = TXT_NAME.getText();
    	String id = TXT_ID.getText();
    	
    	cinema.registerUser(name, id);
    	
    	TXT_ID.clear();
    	TXT_NAME.clear();
    	goToLogin();
    	//Poner un try-catch que capture una excepción de que no se puede registrar el user.
    }
    
    public void goToLogin() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/login-window.fxml"));
		loader.setController(new Login());
		Parent root = loader.load();
		
		Stage stage = new Stage();
		Scene sc = new Scene(root);
		stage.setScene(sc);
		stage.show();
		
		Stage aux = (Stage) BTTN_REGISTER.getScene().getWindow();
		aux.close();
	}
}
