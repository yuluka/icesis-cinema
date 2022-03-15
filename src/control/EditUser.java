package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.CinemaData;
import model.User;

public class EditUser implements Initializable{
    @FXML
    private Button BTTN_SAVE_CHANGES;

    @FXML
    private TextField TXT_ID;

    @FXML
    private TextField TXT_NAME;

    private User selectedUser;
    private UserList userList;
    
    public EditUser(User selectedUser, UserList userList) {
		this.selectedUser = selectedUser;
		this.userList = userList;
	}

	@FXML
    void saveChanges(ActionEvent event) throws IOException {
		String name = TXT_NAME.getText();
    	String id = TXT_ID.getText();
    	
    	CinemaData.searchUserToReplace(selectedUser, id, name);
    	
    	Stage stage = (Stage) BTTN_SAVE_CHANGES.getScene().getWindow();
    	stage.close();
    	
    	userList.rechargeTheList();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TXT_ID.setText(selectedUser.getUserID());
		TXT_NAME.setText(selectedUser.getUserName());
	}
}
