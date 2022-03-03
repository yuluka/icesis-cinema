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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.CinemaData;
import model.Function;
import model.Viewer;

public class SelectFunction implements Initializable {
	
	@FXML
    private Button BTTN_NEXT;

    @FXML
    private AnchorPane MAIN_PANE;

    @FXML
    private TableColumn<Function, String> TVCOLUMN_DATE;

    @FXML
    private TableColumn<Function, Double> TVCOLUMN_DURATION;

    @FXML
    private TableColumn<Function, String> TVCOLUMN_HOUR;

    @FXML
    private TableColumn<Function, String> TVCOLUMN_NAME;

    @FXML
    private TableColumn<Function, String> TVCOLUMN_ROOM;

    @FXML
    private TableView<Function> TV_FUNCTIONS;
    
    private Function selectedFunction;

    private Viewer newViewer;
    
    public SelectFunction(Viewer newViewer) {
		this.newViewer = newViewer;
	}

	@FXML
    void goToSelectSeat(ActionEvent event) throws IOException {
    	try {
    		FXMLLoader loader;
    		
    		if(selectedFunction.getRoom() == 1) {
        		loader = new FXMLLoader(getClass().getResource("../ui/selectSeatMediumroom-window.fxml"));
        		loader.setController(new SelectSeatMediumroom(newViewer));
    		}else {
    			loader = new FXMLLoader(getClass().getResource("../ui/selectSeatMiniroom-window.fxml"));
        		loader.setController(new SelectSeatMiniroom(newViewer));
        	}
    		
    		Parent root = loader.load();
    		Stage stage = new Stage();
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    		
    		Stage stAux = (Stage) BTTN_NEXT.getScene().getWindow();
    		stAux.close();
    	}catch (NullPointerException e) {
			
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Function> functions = FXCollections.observableList(CinemaData.functions);
		
		TVCOLUMN_NAME.setCellValueFactory(new PropertyValueFactory<Function,String>("filmName"));
		TVCOLUMN_DURATION.setCellValueFactory(new PropertyValueFactory<Function,Double>("filmDuration"));
		TVCOLUMN_ROOM.setCellValueFactory(new PropertyValueFactory<Function,String>("roomStr"));
		TVCOLUMN_DATE.setCellValueFactory(new PropertyValueFactory<Function,String>("dateStr"));
		
		TV_FUNCTIONS.setItems(functions);
		
		TV_FUNCTIONS.setOnMouseClicked(event ->{
			selectedFunction = TV_FUNCTIONS.getSelectionModel().getSelectedItem();
		});
	}
}
