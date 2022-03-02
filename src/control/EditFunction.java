package control;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.CinemaData;
import model.Function;

public class EditFunction implements Initializable {
	@FXML
    private Button BTTN_SAVE_CHANGES;

    @FXML
    private DatePicker DP_DATE;

    @FXML
    private TextField TXT_DURATION;

    @FXML
    private TextField TXT_FILM_NAME;

    @FXML
    private TextField TXT_HOUR;
    
    private Function selectedFunction;
    private FunctionList functionListAux;
    
    public EditFunction(Function selectedFunction, FunctionList functionListAux) {
    	this.selectedFunction = selectedFunction;
    	this.functionListAux = functionListAux;
    }

    @FXML
    void saveChanges(ActionEvent event) throws ParseException, IOException {
    	CinemaData cinema = new CinemaData();
    	
    	String newDate = DP_DATE.getValue().toString();
    	Date date = new SimpleDateFormat("yyyy-MM-dd").parse(newDate);
    	double newDuration = Double.parseDouble(TXT_DURATION.getText());
    	String newFilmName = TXT_FILM_NAME.getText();
    	String newHour = TXT_HOUR.getText();
    	
    	int index = cinema.searchFunctionToReplace(selectedFunction);
    	CinemaData.functions.get(index).setDate(date);
    	CinemaData.functions.get(index).setFilmDuration(newDuration);
    	CinemaData.functions.get(index).setFilmName(newFilmName);
    	CinemaData.functions.get(index).setHour(newHour);
    	
    	Stage stageAux = (Stage) BTTN_SAVE_CHANGES.getScene().getWindow();
    	stageAux.close();
    	functionListAux.rechargeTheList();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TXT_DURATION.setText(selectedFunction.getFilmDuration() + "");
		TXT_FILM_NAME.setText(selectedFunction.getFilmName());
		TXT_HOUR.setText(selectedFunction.getHour());
	}
}
