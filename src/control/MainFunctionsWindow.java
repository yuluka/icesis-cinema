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
    private ImageView BTTN_SEE_FUNCTIONS;

    @FXML
    private ImageView BTTN_SEE_VIEWER;
    
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
    	
    	MAIN_FUNCTIONS_PANE.getScene().getWindow().sizeToScene();
    	MAIN_FUNCTIONS_PANE.getChildren().setAll(root);
    }

    @FXML
    void createFunction(MouseEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/addFunction-window.fxml"));
    	loader.setController(new AddFunction());
    	Parent root = (Parent) loader.load();
    	
    	MAIN_FUNCTIONS_PANE.getScene().getWindow().sizeToScene();
    	MAIN_FUNCTIONS_PANE.getChildren().setAll(root);
    }

    @FXML
    void seeFunctions(MouseEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/functionList-window.fxml"));
    	loader.setController(new FunctionList());
    	Parent root = (Parent) loader.load();
    	
    	MAIN_FUNCTIONS_PANE.getScene().getWindow().sizeToScene();
    	MAIN_FUNCTIONS_PANE.getChildren().setAll(root);	
    }

    @FXML
    void seeViewers(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/viewersList-window.fxml"));
    	loader.setController(new ViewerList());
    	Parent root = (Parent) loader.load();
    	
    	MAIN_FUNCTIONS_PANE.getScene().getWindow().sizeToScene();
    	MAIN_FUNCTIONS_PANE.getChildren().setAll(root);
    }
    
    @FXML
    void showTooltipFunction(MouseEvent event) {
    	Tooltip t = new Tooltip("Agregar función");
    	Tooltip.install(BTTN_ADD_FUNCTION, t);
    }
    
    @FXML
    void showTooltipFunctionHistorial(MouseEvent event) {
    	Tooltip t = new Tooltip("Ver funciones agendadas");
    	Tooltip.install(BTTN_SEE_FUNCTIONS, t);
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
    void showTooltipViewersHistorial(MouseEvent event) {
    	Tooltip t = new Tooltip("Ver espectadores registrados");
    	Tooltip.install(BTTN_SEE_VIEWER, t);
    }
}
