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
    public Pane MAIN_PANE;
    
	@FXML
    void addUser(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/register-window.fxml"));
		loader.setController(new Register());
		Parent root = loader.load();
		
		Scene sc = new Scene(root);
		Stage st = new Stage();
		st.setScene(sc);
		st.show();
		
		Stage aux = (Stage) MAIN_PANE.getScene().getWindow();
		aux.close();
	}

    @FXML
    void addViewer(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/addViewer-window.fxml"));
    	loader.setController(new AddViewer());
    	Parent root = (Parent) loader.load();
    	
    	MAIN_PANE.getChildren().setAll(root);
    	MAIN_PANE.getScene().getWindow().sizeToScene();
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
    	MAIN_PANE.getScene().getWindow().sizeToScene();
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
    void seeFunctions(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/functionList-window.fxml"));
    	loader.setController(new FunctionList());
    	Parent root = loader.load();
    	
    	MAIN_PANE.getChildren().setAll(root);
    	MAIN_PANE.getScene().getWindow().sizeToScene();
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
    void seeMediumRoom(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/seatListMediumroom-window.fxml"));
    	loader.setController(new SeeMediumroom());
    	Parent root = loader.load();
    	
    	MAIN_PANE.getChildren().setAll(root);
    	MAIN_PANE.getScene().getWindow().sizeToScene();
    }

    @FXML
    void seeSmallRoom(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/seatListMiniroom-window.fxml"));
    	loader.setController(new SeeMiniroom());
    	Parent root = loader.load();
    	
    	MAIN_PANE.getChildren().setAll(root);
    	MAIN_PANE.getScene().getWindow().sizeToScene();
    }

    @FXML
    void seeViewers(ActionEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/viewersList-window.fxml"));
    	loader.setController(new ViewerList());
    	Parent root = loader.load();
    	
    	MAIN_PANE.getChildren().setAll(root);
    	MAIN_PANE.getScene().getWindow().sizeToScene();
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
