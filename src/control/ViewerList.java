package control;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ViewerList {
	@FXML
    private ImageView BTTN_BACK;

    @FXML
    private Button BTTN_DELETE;

    @FXML
    private AnchorPane MAIN_PANE;

    @FXML
    private TableColumn<?, ?> TVCOLUMN_ID;

    @FXML
    private TableColumn<?, ?> TVCOLUMN_NAME;

    @FXML
    private TableView<?> TV_VIEWERS;

    @FXML
    void back(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/main-functions-window.fxml"));
    	loader.setController(new MainFunctionsWindow());
    	Parent root = loader.load();
    	
    	MAIN_PANE.getScene().getWindow().sizeToScene();
    	MAIN_PANE.getChildren().setAll(root);
    }
}
