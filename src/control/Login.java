package control;

import java.io.IOException;

import exceptions.NoInfoLoginUserException;
import exceptions.NonExistingUserException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.CinemaData;

public class Login {
	@FXML
    private Button BTTN_LOGIN;

    @FXML
    private Button BTTN_REGISTER;

    @FXML
    private TextField TXT_ID;
    
    @FXML
    private ImageView BTTN_BACK;
    
    private Alert alert;
    
    private CinemaData cinema = new CinemaData();

    @FXML
    void gotToRegisterUser(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/register-window.fxml"));
		loader.setController(new Register());
		Parent root = loader.load();
		
		Stage stage = new Stage();
		Scene sc = new Scene(root);
		stage.setScene(sc);
		stage.show();
		
		Stage aux = (Stage) BTTN_LOGIN.getScene().getWindow();
		aux.close();
    }

    
    /**Llama al método que busca si ya existe un user con el id ingresado. En caso de que sí exista,
    pasa a la siguiente pantalla y se cierra la actual. En caso de que no exista, se lanza una
    excepción*/
    @FXML
    void login(ActionEvent event) throws IOException {
    	String id = TXT_ID.getText();
    	
    	try {
			if(cinema.searchUser(id)) {
				goToMainWindow();
				TXT_ID.clear();
			}
		} catch (NonExistingUserException e) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de usuario existente");
			alert.setHeaderText("¡Este usuario no existe!");
			alert.setContentText("El usuario con el que estás intentando ingresar no existe. Intenta"
					+ " nuevamente.");
			alert.show();
			
			TXT_ID.clear();
		} catch (NoInfoLoginUserException e) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de información de usuario");
			alert.setHeaderText("¡No ha llenado la información del usuario!");
			alert.setContentText("Estás intetando ingresar con un usuario sin información. Intenta"
					+ " nuevamente.");
			alert.show();
			
			TXT_ID.clear();
		}
    }
    
    public void goToMainWindow() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/main-window.fxml"));
		loader.setController(new MainWindow());
		Parent root = loader.load();
		
		Stage stage = new Stage();
		Scene sc = new Scene(root);
		stage.setScene(sc);
		stage.show();
		
		Stage aux = (Stage) BTTN_LOGIN.getScene().getWindow();
		aux.close();
	}
    
    @FXML
    void back(MouseEvent event) throws IOException {
    	goToMainWindow();
    }
}
