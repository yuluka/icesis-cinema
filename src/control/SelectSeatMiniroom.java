package control;

import javax.swing.text.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Viewer;

public class SelectSeatMiniroom {
	@FXML
    private Button BTTN_NEXT;

    @FXML
    private ImageView IMGV_SEAT1;

    @FXML
    private ImageView IMGV_SEAT10;

    @FXML
    private ImageView IMGV_SEAT11;

    @FXML
    private ImageView IMGV_SEAT12;

    @FXML
    private ImageView IMGV_SEAT13;

    @FXML
    private ImageView IMGV_SEAT14;

    @FXML
    private ImageView IMGV_SEAT15;

    @FXML
    private ImageView IMGV_SEAT16;

    @FXML
    private ImageView IMGV_SEAT17;

    @FXML
    private ImageView IMGV_SEAT18;

    @FXML
    private ImageView IMGV_SEAT19;

    @FXML
    private ImageView IMGV_SEAT2;

    @FXML
    private ImageView IMGV_SEAT20;

    @FXML
    private ImageView IMGV_SEAT21;

    @FXML
    private ImageView IMGV_SEAT22;

    @FXML
    private ImageView IMGV_SEAT23;

    @FXML
    private ImageView IMGV_SEAT24;

    @FXML
    private ImageView IMGV_SEAT25;

    @FXML
    private ImageView IMGV_SEAT26;

    @FXML
    private ImageView IMGV_SEAT27;

    @FXML
    private ImageView IMGV_SEAT28;

    @FXML
    private ImageView IMGV_SEAT3;

    @FXML
    private ImageView IMGV_SEAT4;

    @FXML
    private ImageView IMGV_SEAT5;

    @FXML
    private ImageView IMGV_SEAT6;

    @FXML
    private ImageView IMGV_SEAT7;

    @FXML
    private ImageView IMGV_SEAT8;

    @FXML
    private ImageView IMGV_SEAT9;

    @FXML
    private AnchorPane MAIN_PANE;
    
    private Viewer newViewer;
    
    public SelectSeatMiniroom(Viewer newViewer) {
		this.newViewer = newViewer;
	}

	@FXML
    void saveViewerSelections(ActionEvent event) {

    }
}
