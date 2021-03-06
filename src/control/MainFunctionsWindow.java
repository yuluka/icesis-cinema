package control;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainFunctionsWindow {
	@FXML
    private ImageView BTTN_ADD_FUNCTION;

    @FXML
    private ImageView BTTN_ADD_USER;

    @FXML
    private ImageView BTTN_ADD_VIEWER;
    
    @FXML
    private ImageView BTTN_SEE_MEDIUMROOM;

    @FXML
    private ImageView BTTN_SEE_MINIROOM;
    
    @FXML
    private Pane MAIN_FUNCTIONS_PANE;
    
    @FXML
    void addUser(MouseEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/register-window.fxml"));
    	loader.setController(new Register());
    	Parent root = loader.load();
    	
    	Scene sc = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(sc);
    	stage.show();
    	
    	Stage aux = (Stage) BTTN_ADD_USER.getScene().getWindow();
    	aux.close();
    }

    @FXML
    void addViewer(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/addViewer-window.fxml"));
    	loader.setController(new AddViewer());
    	Parent root = (Parent) loader.load();
    	
    	MAIN_FUNCTIONS_PANE.getChildren().setAll(root);
    	//MAIN_FUNCTIONS_PANE.setPrefSize(600, 400);
    	MAIN_FUNCTIONS_PANE.getScene().getWindow().sizeToScene();
    }

    @FXML
    void createFunction(MouseEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/addFunction-window.fxml"));
    	loader.setController(new AddFunction());
    	Parent root = (Parent) loader.load();
    	
    	MAIN_FUNCTIONS_PANE.getChildren().setAll(root);
    	//MAIN_FUNCTIONS_PANE.setPrefSize(600, 400);
    	MAIN_FUNCTIONS_PANE.getScene().getWindow().sizeToScene();
    }

    @FXML
    void seeMiniroom(MouseEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/seatListMiniroom-window.fxml"));
    	loader.setController(new SeeMiniroom());
    	Parent root = (Parent) loader.load();
    	
    	//MAIN_FUNCTIONS_PANE.getScene().getWindow().setWidth(926);
    	//MAIN_FUNCTIONS_PANE.getScene().getWindow().setHeight(439);
    	MAIN_FUNCTIONS_PANE.getChildren().setAll(root);	
    	//MAIN_FUNCTIONS_PANE.setPrefSize(926, 439);
    	MAIN_FUNCTIONS_PANE.getScene().getWindow().sizeToScene();
    }

    @FXML
    void seeMediumroom(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/seatListMediumroom-window.fxml"));
    	loader.setController(new SeeMediumroom());
    	Parent root = (Parent) loader.load();
    	
    	//MAIN_FUNCTIONS_PANE.getScene().getWindow().setWidth(718);
    	//MAIN_FUNCTIONS_PANE.getScene().getWindow().setHeight(400);
    	MAIN_FUNCTIONS_PANE.getChildren().setAll(root);
    	//MAIN_FUNCTIONS_PANE.setPrefSize(718, 400);
    	MAIN_FUNCTIONS_PANE.getScene().getWindow().sizeToScene();
    }
    
    @FXML
    void showTooltipFunction(MouseEvent event) {
    	Tooltip t = new Tooltip("Agregar funci?n");
    	Tooltip.install(BTTN_ADD_FUNCTION, t);
    }
    
    @FXML
    void showTooltipMediumRoom (MouseEvent event) {
    	Tooltip t = new Tooltip("Ver la sala mediana");
    	Tooltip.install(BTTN_SEE_MEDIUMROOM, t);
    }

    @FXML
    void showTooltipUser(MouseEvent event) {
    	Tooltip t = new Tooltip("Agregar usuario");
    	Tooltip.install(BTTN_ADD_USER, t);
    }

    @FXML
    void showTooltipViewer(MouseEvent event) {
    	Tooltip t = new Tooltip("Agregar espectador");
    	Tooltip.install(BTTN_ADD_VIEWER, t);
    }

    @FXML
    void showTooltipMiniRoom (MouseEvent event) {
    	Tooltip t = new Tooltip("Ver la sala peque?a");
    	Tooltip.install(BTTN_SEE_MINIROOM, t);
    }
}
