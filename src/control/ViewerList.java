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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.CinemaData;
import model.Viewer;

public class ViewerList implements Initializable {
	@FXML
    private ImageView BTTN_BACK;

    @FXML
    private Button BTTN_DELETE;

    @FXML
    private AnchorPane MAIN_PANE;

    @FXML
    private TableColumn<Viewer, String> TVCOLUMN_ID;

    @FXML
    private TableColumn<Viewer, String> TVCOLUMN_NAME;

    @FXML
    private TableView<Viewer> TV_VIEWERS;
    
    private Viewer selectedViewer;

    @FXML
    void removeViewer(ActionEvent event) {
    	try {
    		CinemaData.viewers.remove(selectedViewer);
    		updateTVInfo();    		
    		CinemaData.removeViewer(selectedViewer);
    	}catch (NullPointerException e) {
			
		}
    	
    	CinemaData.saveViewers();
    	CinemaData.saveFunctions();
    }
    
    @FXML
    void back(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/main-functions-window.fxml"));
    	loader.setController(new MainFunctionsWindow());
    	Parent root = loader.load();
    	
    	MAIN_PANE.getChildren().setAll(root);
    	MAIN_PANE.setPrefSize(600, 400);
    	MAIN_PANE.getScene().getWindow().sizeToScene();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Viewer> viewers = FXCollections.observableList(CinemaData.viewers);
		
		TVCOLUMN_NAME.setCellValueFactory(new PropertyValueFactory<Viewer, String>("name"));
		TVCOLUMN_ID.setCellValueFactory(new PropertyValueFactory<Viewer, String>("id"));
		
		TV_VIEWERS.setItems(viewers);
		
		TV_VIEWERS.setOnMouseClicked(event ->{
			selectedViewer = TV_VIEWERS.getSelectionModel().getSelectedItem();
		});
	}
	
	public void updateTVInfo() {
		ObservableList<Viewer> viewers = FXCollections.observableList(CinemaData.viewers);
		
		TVCOLUMN_NAME.setCellValueFactory(new PropertyValueFactory<Viewer, String>("name"));
		TVCOLUMN_ID.setCellValueFactory(new PropertyValueFactory<Viewer, String>("id"));
		
		TV_VIEWERS.setItems(viewers);
	}
}
