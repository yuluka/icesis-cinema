package control;

import java.io.IOException;

import exceptions.NoInfoAddViewerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.CinemaData;
import model.Viewer;

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
    
    private Alert alert = new Alert(AlertType.ERROR);

    @FXML
    void addViewer(ActionEvent event) throws IOException {
    	try {
    		String name = TXT_NAME.getText();
        	String id = TXT_ID.getText();
        	
        	CinemaData cinema = new CinemaData();
        	cinema.addViewer(name, id);
        	
        	TXT_ID.clear();
        	TXT_NAME.clear();
        	
        	goToSelectFunction(new Viewer(name,id));
		}catch (NoInfoAddViewerException e) {
			alert.setTitle("Error de información incompleta");
			alert.setHeaderText("¡Información incompleta!");
			alert.setContentText("No has llenado toda la información necesaria para "
					+ "agregar a este espectador. Intenta nuevamente.");
			alert.show();
		}
    }
    
    public void goToSelectFunction(Viewer newViewer) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/selectFunction-window.fxml"));
		loader.setController(new SelectFunction(newViewer));
		Parent root = loader.load();
		
		Stage stage = new Stage();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		Stage stageAux = (Stage) BTTN_ADD.getScene().getWindow();
		stageAux.close();
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
