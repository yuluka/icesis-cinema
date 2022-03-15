package control;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.CinemaData;
import model.Function;
import model.Seat;
import model.Viewer;

public class SelectSeatMediumroom implements Initializable {
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
    private ImageView IMGV_SEAT29;

    @FXML
    private ImageView IMGV_SEAT3;

    @FXML
    private ImageView IMGV_SEAT30;

    @FXML
    private ImageView IMGV_SEAT31;

    @FXML
    private ImageView IMGV_SEAT32;

    @FXML
    private ImageView IMGV_SEAT33;

    @FXML
    private ImageView IMGV_SEAT34;

    @FXML
    private ImageView IMGV_SEAT35;

    @FXML
    private ImageView IMGV_SEAT36;

    @FXML
    private ImageView IMGV_SEAT37;

    @FXML
    private ImageView IMGV_SEAT38;

    @FXML
    private ImageView IMGV_SEAT39;

    @FXML
    private ImageView IMGV_SEAT4;

    @FXML
    private ImageView IMGV_SEAT40;

    @FXML
    private ImageView IMGV_SEAT41;

    @FXML
    private ImageView IMGV_SEAT42;

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
    private Function newFunction;
    private ArrayList<ImageView> seatsImages;
    private ArrayList<Seat> functionSeats;
    
    public SelectSeatMediumroom(Viewer newViewer, Function newFunction) {
		this.newViewer = newViewer;
		this.newFunction = newFunction;
	}
   
    public void saveViewerSelections(ImageView imgV) throws IOException {
    	String[] parts = imgV.getId().split("T");
    	int numSelection = Integer.parseInt(parts[1]);
    	
    	for (int i = 0; i < functionSeats.size(); i++) {
			if(functionSeats.get(i).getNumber() == numSelection) {
				functionSeats.get(i).setOccupied(true);
				functionSeats.get(i).setViewer(newViewer);
			}
		}
    	
    	goToMainWindow();
    }
    
    public void goToMainWindow() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/main-window.fxml"));
		loader.setController(new MainWindow());
		Parent root = loader.load();
		
		Stage stage = new Stage();
		Scene sc = new Scene(root);
		stage.setScene(sc);
		stage.show();
		
		Stage aux = (Stage) IMGV_SEAT1.getScene().getWindow();
		aux.close();
	}
    
    @FXML
    void selectSeat(MouseEvent event) throws IOException {
    	ImageView imgV = (ImageView) event.getSource();
    	File f = new File("images/blue circle.png");
    	Image img = new Image(f.toURI().toString());
    	imgV.setImage(img);
    	
    	saveViewerSelections(imgV);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		newFunction = CinemaData.searchFunction(newFunction);
		
		functionSeats = newFunction.getRoomA().getSeats();
		fillSeatsImages();
		
		for (int i = 0; i < functionSeats.size(); i++) {
			if(functionSeats.get(i).isOccupied()) {
				int seatNumber = functionSeats.get(i).getNumber();
				
				String[] parts = seatsImages.get(i).getId().split("T");
				int numAux = Integer.parseInt(parts[1]);
				
				if(seatNumber == numAux) {
					File f = new File("images/blue circle.png");
					seatsImages.get(i).setImage(new Image(f.toURI().toString()));
					seatsImages.get(i).setDisable(true);
				}
			}
		}
	}
	
	public void fillSeatsImages() {
		seatsImages = new ArrayList<>();
		
		seatsImages.add(IMGV_SEAT1);
		seatsImages.add(IMGV_SEAT2);
		seatsImages.add(IMGV_SEAT3);
		seatsImages.add(IMGV_SEAT4);
		seatsImages.add(IMGV_SEAT5);
		seatsImages.add(IMGV_SEAT6);
		seatsImages.add(IMGV_SEAT7);
		seatsImages.add(IMGV_SEAT8);
		seatsImages.add(IMGV_SEAT9);
		seatsImages.add(IMGV_SEAT10);
		seatsImages.add(IMGV_SEAT11);
		seatsImages.add(IMGV_SEAT12);
		seatsImages.add(IMGV_SEAT13);
		seatsImages.add(IMGV_SEAT14);
		seatsImages.add(IMGV_SEAT15);
		seatsImages.add(IMGV_SEAT16);
		seatsImages.add(IMGV_SEAT17);
		seatsImages.add(IMGV_SEAT18);
		seatsImages.add(IMGV_SEAT19);
		seatsImages.add(IMGV_SEAT20);
		seatsImages.add(IMGV_SEAT21);
		seatsImages.add(IMGV_SEAT22);
		seatsImages.add(IMGV_SEAT23);
		seatsImages.add(IMGV_SEAT24);
		seatsImages.add(IMGV_SEAT25);
		seatsImages.add(IMGV_SEAT26);
		seatsImages.add(IMGV_SEAT27);
		seatsImages.add(IMGV_SEAT28);
		seatsImages.add(IMGV_SEAT29);
		seatsImages.add(IMGV_SEAT30);
		seatsImages.add(IMGV_SEAT31);
		seatsImages.add(IMGV_SEAT32);
		seatsImages.add(IMGV_SEAT33);
		seatsImages.add(IMGV_SEAT34);
		seatsImages.add(IMGV_SEAT35);
		seatsImages.add(IMGV_SEAT36);
		seatsImages.add(IMGV_SEAT37);
		seatsImages.add(IMGV_SEAT38);
		seatsImages.add(IMGV_SEAT39);
		seatsImages.add(IMGV_SEAT40);
		seatsImages.add(IMGV_SEAT41);
		seatsImages.add(IMGV_SEAT42);
	}
}
