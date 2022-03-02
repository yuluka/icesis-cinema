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
import model.Function;

public class FunctionList implements Initializable{
	@FXML
    private ImageView BTTN_BACK;

    @FXML
    private Button BTTN_DELETE;

    @FXML
    private Button BTTN_EDIT;

    @FXML
    private AnchorPane MAIN_PANE;

    @FXML
    private TableColumn<Function, String> TVCOLUMN_DATE;
    
    @FXML
    private TableColumn<Function, String> TVCOLUMN_HOUR;

    @FXML
    private TableColumn<Function, Double> TVCOLUMN_DURATION;

    @FXML
    private TableColumn<Function, String> TVCOLUMN_NAME;

    @FXML
    private TableColumn<Function, String> TVCOLUMN_ROOM;

    @FXML
    private TableView<Function> TV_FUNCTIONS;
    
    private Function function;
    
    @FXML
    void editFunction(ActionEvent event) {
    	
    }

    @FXML
    void removeFunction(ActionEvent event) {
    	CinemaData.functions.remove(function);
    	updateTVInfo();
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
		ObservableList<Function> functions = FXCollections.observableList(CinemaData.functions);
		
		TVCOLUMN_NAME.setCellValueFactory(new PropertyValueFactory<Function,String>("filmName"));
		TVCOLUMN_DURATION.setCellValueFactory(new PropertyValueFactory<Function,Double>("filmDuration"));
		TVCOLUMN_ROOM.setCellValueFactory(new PropertyValueFactory<Function,String>("roomStr"));
		TVCOLUMN_DATE.setCellValueFactory(new PropertyValueFactory<Function,String>("dateStr"));
		TVCOLUMN_HOUR.setCellValueFactory(new PropertyValueFactory<Function, String>("hour"));
		
		TV_FUNCTIONS.setItems(functions);
		
		TV_FUNCTIONS.setOnMouseClicked(event ->{
			function = TV_FUNCTIONS.getSelectionModel().getSelectedItem();
		});
	}
	
	public void updateTVInfo() {
		ObservableList<Function> functions = FXCollections.observableList(CinemaData.functions);
		
		TVCOLUMN_NAME.setCellValueFactory(new PropertyValueFactory<Function,String>("filmName"));
		TVCOLUMN_DURATION.setCellValueFactory(new PropertyValueFactory<Function,Double>("filmDuration"));
		TVCOLUMN_ROOM.setCellValueFactory(new PropertyValueFactory<Function,String>("roomStr"));
		TVCOLUMN_DATE.setCellValueFactory(new PropertyValueFactory<Function,String>("dateStr"));
		
		TV_FUNCTIONS.setItems(functions);
	}
}
