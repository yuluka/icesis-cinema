package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class MainWindow implements Initializable{
    @FXML
    private Pane MAIN_PANE;
    
    public void chargeThings() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/main-functions-window.fxml"));
		loader.setController(new MainFunctionsWindow());
		Parent root = loader.load();
		
		MAIN_PANE.getChildren().setAll(root);
    }

	@FXML
    void addUser(ActionEvent event) {

    }

    @FXML
    void addViewer(ActionEvent event) {

    }

    @FXML
    void changeUser(ActionEvent event) {

    }

    @FXML
    void createFunction(ActionEvent event) {
    	
    }

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void removeFunction(ActionEvent event) {

    }

    @FXML
    void removeUser(ActionEvent event) {

    }

    @FXML
    void removeViewer(ActionEvent event) {

    }

    @FXML
    void seeFunctions(ActionEvent event) {

    }

    @FXML
    void seeHistorialFunctions(ActionEvent event) {

    }

    @FXML
    void seeHistorialViewers(ActionEvent event) {

    }

    @FXML
    void seeUsers(ActionEvent event) {

    }

    @FXML
    void seeViewers(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/main-functions-window.fxml"));
			loader.setController(new MainFunctionsWindow());
			Parent root;
			root = loader.load();
			MAIN_PANE.getChildren().setAll(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
