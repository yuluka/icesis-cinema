package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.CinemaData;
import model.User;

public class UserList implements Initializable{
	@FXML
	private ImageView BTTN_BACK;
	
	@FXML
    private Button BTTN_EDIT;

    @FXML
    private Button BTTN_REMOVE;
    
    @FXML
    private AnchorPane MAIN_PANE;

    @FXML
    private TableColumn<User, String> TVCOLUMN_ID;

    @FXML
    private TableColumn<User, String> TVCOLUMN_NAME;

    @FXML
    private TableView<User> TV_USERS;
    
    private User selectedUser;

    @FXML
    void back(MouseEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/main-functions-window.fxml"));
    	loader.setController(new MainFunctionsWindow());
    	Parent root = loader.load();
    	
    	MAIN_PANE.getChildren().setAll(root);
    	MAIN_PANE.setPrefSize(600, 400);
    	MAIN_PANE.getScene().getWindow().sizeToScene();
    }
    
    @FXML
    void editUser(ActionEvent event) throws IOException {
    	try {
    		if (!selectedUser.equals(null)) {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/editUser-window.fxml"));
    	    	loader.setController(new EditUser(selectedUser, this));
    	    	Parent root = loader.load();
    	    	
    	    	Stage stage = new Stage();
    	    	Scene scene = new Scene(root);
    	    	stage.setScene(scene);
    	    	stage.show();
			}
    	}catch (NullPointerException e) {
			
		}
    }

    @FXML
    void removeUser(ActionEvent event) {
    	try {
    		CinemaData.users.remove(selectedUser);
    		CinemaData.saveUsers();
    		updateTVInfo();
    	}catch (NullPointerException e) {
			
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<User> users = FXCollections.observableList(CinemaData.users);
		
		TVCOLUMN_NAME.setCellValueFactory(new PropertyValueFactory<User,String>("userName"));
		TVCOLUMN_ID.setCellValueFactory(new PropertyValueFactory<User,String>("userID"));
		
		TV_USERS.setItems(users);
		
		TV_USERS.setOnMouseClicked(event ->{
			selectedUser = TV_USERS.getSelectionModel().getSelectedItem();
		});
	}
	
	public void updateTVInfo() {
		ObservableList<User> users = FXCollections.observableList(CinemaData.users);
		
		TVCOLUMN_NAME.setCellValueFactory(new PropertyValueFactory<User,String>("userName"));
		TVCOLUMN_ID.setCellValueFactory(new PropertyValueFactory<User,String>("userID"));
		
		TV_USERS.setItems(users);
	}
	
	public void rechargeTheList() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/usersList-window.fxml"));
    	loader.setController(new UserList());
    	Parent root = loader.load();
    	
    	MAIN_PANE.getChildren().setAll(root);
    	MAIN_PANE.getScene().getWindow().sizeToScene();
	}
}
