package betterTicTacToe;

import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application {

	public static void main(String[]args) {
		launch(args);
		
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
	      Gui gui = new Gui (primaryStage,800,600);
	      gui.setStage(primaryStage); 
		
	}
	
/*	public void stop() {
		
	}
	
	*/
	
	
	
	
	
}
