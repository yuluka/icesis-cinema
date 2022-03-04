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
    void editFunction(ActionEvent event) throws IOException{
    	try {
    		if(!function.equals(null)) {
        		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/editFunction-window.fxml"));
            	loader.setController(new EditFunction(function,this));
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
    void removeFunction(ActionEvent event) {
    	try {
        	CinemaData.functions.remove(function);
        	updateTVInfo();
		} catch (NullPointerException e) {
			
		}
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
	
	public void rechargeTheList() throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/functionList-window.fxml"));
    	loader.setController(new FunctionList());
    	Parent root = loader.load();
    	
    	MAIN_PANE.getChildren().setAll(root);
    	MAIN_PANE.getScene().getWindow().sizeToScene();
	}
}
