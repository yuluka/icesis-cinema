package control;

import javafx.fxml.FXML;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
    void addUser(MouseEvent event) {

    }

    @FXML
    void addViewer(MouseEvent event) {

    }

    @FXML
    void createFunction(MouseEvent event) {

    }

    @FXML
    void seeFunctions(MouseEvent event) {

    }

    @FXML
    void seeViewers(MouseEvent event) {

    }
    
    @FXML
    void showTooltipFunction(MouseEvent event) {
    	Tooltip t = new Tooltip("Agregar función");
    	Tooltip.install(BTTN_ADD_FUNCTION, t);
    }
    
    @FXML
    void showTooltipFunctionHistorial(MouseEvent event) {
    	Tooltip t = new Tooltip("Ver el historial de funciones");
    	Tooltip.install(BTTN_SEE_FUNCTIONS, t);
    }

    @FXML
    void showTooltipUser(MouseEvent event) {
    	Tooltip t = new Tooltip("Opciones de usuario");
    	Tooltip.install(BTTN_ADD_USER, t);
    }

    @FXML
    void showTooltipViewer(MouseEvent event) {
    	Tooltip t = new Tooltip("Agregar espectador");
    	Tooltip.install(BTTN_ADD_VIEWER, t);
    }

    @FXML
    void showTooltipViewersHistorial(MouseEvent event) {
    	Tooltip t = new Tooltip("Ver el historial de espectadores");
    	Tooltip.install(BTTN_SEE_VIEWER, t);
    }
}
