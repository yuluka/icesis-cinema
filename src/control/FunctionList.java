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

public class FunctionList {
	@FXML
    private ImageView BTTN_BACK;

    @FXML
    private Button BTTN_DELETE;

    @FXML
    private Button BTTN_EDIT;

    @FXML
    private AnchorPane MAIN_PANE;

    @FXML
    private TableColumn<?, ?> TVCOLUMN_DATE;

    @FXML
    private TableColumn<?, ?> TVCOLUMN_DURATION;

    @FXML
    private TableColumn<?, ?> TVCOLUMN_NAME;

    @FXML
    private TableColumn<?, ?> TVCOLUMN_ROOM;

    @FXML
    private TableView<?> TV_FUNCTIONS;

    @FXML
    void back(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/main-functions-window.fxml"));
    	loader.setController(new MainFunctionsWindow());
    	Parent root = loader.load();
    	
    	MAIN_PANE.getChildren().setAll(root);
    	MAIN_PANE.setPrefSize(600, 400);
    	MAIN_PANE.getScene().getWindow().sizeToScene();
    }
}
