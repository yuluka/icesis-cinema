package control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewerList {
	@FXML
    private Button BTTN_DELETE;

    @FXML
    private TableColumn<?, ?> TVCOLUMN_ID;

    @FXML
    private TableColumn<?, ?> TVCOLUMN_NAME;

    @FXML
    private TableView<?> TV_VIEWERS;
}
