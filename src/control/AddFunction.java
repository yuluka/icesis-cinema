package control;

import java.io.IOException;
import java.text.ParseException;
import exceptions.ExistingFunctionException;
import exceptions.NoInfoAddFunctionException;
import exceptions.OccupiedRoomException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.CinemaData;

public class AddFunction {
	@FXML
    private Button BTTN_ADD;

	 @FXML
	 private ImageView BTTN_BACK;
	
	@FXML
    private AnchorPane MAIN_ADD_FUNCTION_PANE;
	 
	@FXML
    private RadioButton RDBTTN_MEDIUM_ROOM;

    @FXML
    private RadioButton RDBTTN_SMALL_ROOM;

    @FXML
    private DatePicker DP_DATE;
    
    @FXML
    private TextField TXT_DURATION_FILM;
    
    @FXML
    private TextField TXT_HOUR_FILM;

    @FXML
    private TextField TXT_NAME_FILM;
    
    private Alert alert = new Alert(AlertType.ERROR);
    private Alert alertAux;

	@FXML
    void addFunction(ActionEvent event) throws ParseException {
    	try {
    		String date = DP_DATE.getValue().toString();
    		String hour = TXT_HOUR_FILM.getText();
        	String filmName = TXT_NAME_FILM.getText();
        	double filmDuration = Double.parseDouble(TXT_DURATION_FILM.getText());
        	int room = 0;
        	
        	if(RDBTTN_MEDIUM_ROOM.isSelected()) {
        		room = 1;
        	}else if(RDBTTN_SMALL_ROOM.isSelected()){
        		room = 2;
        	}
        	
        	CinemaData.addFunction(date, hour, filmName, filmDuration, room);
        	alertAux = new Alert(AlertType.INFORMATION);
        	alertAux.setTitle("Agregado correctamente");
        	alertAux.setHeaderText("�Funci�n agregada correctamente!");
        	alertAux.setContentText("La funci�n ha sido agregada correctamente.");
        	alertAux.show();
    	}catch (NoInfoAddFunctionException e) {
			alert.setTitle("Error de informaci�n inncompleta");
			alert.setHeaderText("�Informaci�n incompleta!");
			alert.setContentText("No has llenado toda la informaci�n necesaria para "
					+ "agendar esta funci�n. Intenta nuevamente.");
			alert.show();
		}catch (NumberFormatException e){
    		alert.setTitle("Error de duraci�n inv�lida");
    		alert.setHeaderText("�Duraci�n inv�lida!");
    		alert.setContentText("La duraci�n que escribiste es inv�lida o no est� "
    				+ "en un valor num�rico. Intenta nuevamente.");
    		alert.show();
    	}catch (ExistingFunctionException e) {
    		alert.setTitle("Error de funci�n existente");
    		alert.setHeaderText("�La funci�n ya existe!");
    		alert.setContentText("La funci�n que est�s intentando crear ya ha sido"
    				+ " creada previamente. Intenta nuevamente.");
    		alert.show();
    	}catch (OccupiedRoomException e) {
    		alert.setTitle("Error de sala ocupada");
    		alert.setHeaderText("�La sala est� ocupada!");
    		alert.setContentText("La sala a la que est�s intentando agregar la funci�n"
    				+ " ya est� ocupada en esta fecha y hora. Intenta nuevamente.");
    		alert.show();
		}catch (NullPointerException e) {
			alert.setTitle("Error de fecha inv�lida");
    		alert.setHeaderText("�Fecha inv�lida!");
    		alert.setContentText("No has escrito una fecha a�n. Intenta nuevamente.");
    		alert.show();
		}
    	
    	RDBTTN_MEDIUM_ROOM.setSelected(false);
    	RDBTTN_SMALL_ROOM.setSelected(false);
    	DP_DATE.setValue(null);
    	TXT_DURATION_FILM.clear();
    	TXT_HOUR_FILM.clear();
    	TXT_NAME_FILM.clear();
    }
    
    @FXML
    void back(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/main-functions-window.fxml"));
    	loader.setController(new MainFunctionsWindow());
    	Parent root = loader.load();
    	
    	//MAIN_ADD_FUNCTION_PANE.getScene().getWindow().setHeight(0);
    	//MAIN_ADD_FUNCTION_PANE.getScene().getWindow().setWidth(0);
    	MAIN_ADD_FUNCTION_PANE.getScene().getWindow().sizeToScene();
    	MAIN_ADD_FUNCTION_PANE.getChildren().setAll(root);
    }

}
