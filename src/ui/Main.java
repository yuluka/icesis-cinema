package ui;

import control.Login;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CinemaData;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		CinemaData.loadData();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("login-window.fxml"));
		loader.setController(new Login());
		Parent root = loader.load();
		
		Stage stage = new Stage();
		Scene sc = new Scene(root);
		stage.setScene(sc);
		stage.show();
	}
}
