package control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AddFunction {
	@FXML
    private Button BTTN_ADD;

	 @FXML
	 private ImageView BTTN_BACK;
	
	@FXML
    private AnchorPane MAIN_ADD_FUNCTION_PANE;
	 
	@FXML
    private RadioButton RDBTTN_MEDIUM_ROOM;

    @FXML
    private RadioButton RDBTTN_SMALL_ROOM;

    @FXML
    private DatePicker DP_DATE;
    
    @FXML
    private TextField TXT_DURATION_FILM;

    @FXML
    private TextField TXT_NAME_FILM;

    @FXML
    void addFunction(ActionEvent event) {
    	
    }
    
    @FXML
    void back(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/main-functions-window.fxml"));
    	loader.setController(new MainFunctionsWindow());
    	Parent root = loader.load();
    	
    	MAIN_ADD_FUNCTION_PANE.getScene().getWindow().sizeToScene();
    	MAIN_ADD_FUNCTION_PANE.getChildren().setAll(root);
    }
}
