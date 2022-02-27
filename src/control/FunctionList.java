package control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FunctionList {
	@FXML
    private Button BTTN_DELETE;

    @FXML
    private Button BTTN_EDIT;

    @FXML
    private TableColumn<?, ?> TVCOLUMN_DATE;

    @FXML
    private TableColumn<?, ?> TVCOLUMN_DURATION;

    @FXML
    private TableColumn<?, ?> TVCOLUMN_NAME;

    @FXML
    private TableColumn<?, ?> TVCOLUMN_ROOM;

    @FXML
    private TableView<?> TV_FUNCTIONS;
}
