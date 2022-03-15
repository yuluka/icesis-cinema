package control;

import java.io.IOException;

import exceptions.AlreadyExistingUserException;
import exceptions.NoInfoRegisterUserException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.CinemaData;

public class Register {
	@FXML
    private Button BTTN_REGISTER;
	
   @FXML
   private ImageView BTTN_BACK;

    @FXML
    private TextField TXT_ID;

    @FXML
    private TextField TXT_NAME;
    
    private Alert alert;
    
    /**Llama al método para registrar un usuario, en CinemaData, y atrapa la exception en caso de que ya 
    exista el usuario y lanza un alert para decirle al usuario*/
    @FXML
    void registerUser(ActionEvent event) throws IOException{
    	try {
    		String name = TXT_NAME.getText();
        	String id = TXT_ID.getText();
    		
    		CinemaData.registerUser(name, id);
        	
        	TXT_ID.clear();
        	TXT_NAME.clear();
        	goToLogin();
		} catch (AlreadyExistingUserException e) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de usuario existente");
			alert.setHeaderText("¡Este usuario ya existe!");
			alert.setContentText("El usuario que estás intentando registrar ya ha sido registrado"
					+ " previamente. Intenta nuevamente.");
			alert.show();
			
			TXT_ID.clear();
        	TXT_NAME.clear();
		} catch (NoInfoRegisterUserException e) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de información de usuario");
			alert.setHeaderText("¡Alguna información no ha sido llenada!");
			alert.setContentText("No has escrito bien alguno, o ambos, de los datos necesarios para crear"
					+ " un usuario. Intenta nuevamente.");
			alert.show();
			
			TXT_ID.clear();
        	TXT_NAME.clear();
		}
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
    
    @FXML
    void backToLogin(MouseEvent event) throws IOException {
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
    
  /** Buscar como usar el tooltip.
   public void test() {
	   if(BTTN_BACK.getOnMouseMoved() != null) {
		   Tooltip t = new Tooltip("Atrás");
		   Tooltip.install(BTTN_BACK, t);
	   }
    }*/
}
