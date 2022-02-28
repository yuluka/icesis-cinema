package control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AddViewer {
	@FXML
    private Button BTTN_ADD;
	
	@FXML
    private ImageView BTTN_BACK;

    @FXML
    private TextField TXT_ID;

    @FXML
    private TextField TXT_NAME;
    
    @FXML
    private AnchorPane MAIN_PANE;

    @FXML
    void addViewer(ActionEvent event) {
    	
    }
    
    @FXML
    void back(MouseEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/main-functions-window.fxml"));
    	loader.setController(new MainFunctionsWindow());
    	Parent root = loader.load();
    	
    	MAIN_PANE.getScene().getWindow().sizeToScene();
    	MAIN_PANE.getChildren().setAll(root);
    }
}
