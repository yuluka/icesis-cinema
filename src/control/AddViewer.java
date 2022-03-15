package control;

import java.io.IOException;

import exceptions.AlreadyExistingViewerException;
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
        	
        	CinemaData.addViewer(name, id);
        	
        	goToSelectFunction(new Viewer(name,id));
		} catch (NoInfoAddViewerException e) {
			alert.setTitle("Error de informaci�n incompleta");
			alert.setHeaderText("�Informaci�n incompleta!");
			alert.setContentText("No has llenado toda la informaci�n necesaria para "
					+ "agregar a este espectador. Intenta nuevamente.");
			alert.show();
		} catch (AlreadyExistingViewerException e) {
			alert.setTitle("Error de espectador existente");
			alert.setHeaderText("�Informaci�n de espectador err�nea!");
			alert.setContentText("El espectador que est�s tratando de registrar ya ha sido "
					+ "registrado bajo otro nombre. Intenta nuevamente.");
			alert.show();
		}
    	
    	TXT_ID.clear();
    	TXT_NAME.clear();
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
