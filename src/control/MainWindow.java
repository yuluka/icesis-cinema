package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
		//FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/"));
    }

    @FXML
    void addViewer(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/addViewer-window.fxml"));
    	loader.setController(new AddViewer());
    	Parent root = (Parent) loader.load();
    	
    	MAIN_PANE.getChildren().setAll(root);
    }

    @FXML
    void changeUser(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/changeUser-window.fxml"));
    	loader.setController(new Login());
    	Parent root = loader.load();
    	
    	Scene sc = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(sc);
    	stage.show();
    	
    	Stage aux = (Stage) MAIN_PANE.getScene().getWindow();
    	aux.close();
    }

    @FXML
    void createFunction(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/addFunction-window.fxml"));
    	loader.setController(new AddFunction());
    	Parent root = (Parent) loader.load();
    	
    	MAIN_PANE.getChildren().setAll(root);
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/login-window.fxml"));
    	loader.setController(new Login());
    	Parent root = loader.load();
    	
    	Scene sc = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(sc);
    	stage.show();
    	
    	Stage aux = (Stage) MAIN_PANE.getScene().getWindow();
    	aux.close();
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
    void seeFunctions(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/functionList-window.fxml"));
    	loader.setController(new FunctionList());
    	Parent root = loader.load();
    	
    	MAIN_PANE.getChildren().setAll(root);
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
    void seeViewers(ActionEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/viewersList-window.fxml"));
    	loader.setController(new ViewerList());
    	Parent root = loader.load();
    	
    	MAIN_PANE.getChildren().setAll(root);
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
			e.printStackTrace();
		}
	}
}
