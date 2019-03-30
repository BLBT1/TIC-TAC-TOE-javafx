package betterTicTacToe;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gui {
	private int width, height;
//	private Player p1, p2;
	private Stage primarystage;
	private Button[] buttonArray;
	Grid border;
	private boolean gameOver = false;
//	BorderPane b;

	public Gui(Stage primaryStage, int width, int height) {
		this.width = width;
		this.height = height;
		this.primarystage = primaryStage;
		border = new Grid();
		// gameOver();
	}

	public void setStage(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Tic Tac Toe");
		primaryStage.setResizable(false);

		BorderPane b = new BorderPane();
		HBox hbox = addHBox();
//		GridPane grid = addGridPane();
		b.setTop(hbox);
		b.setCenter(border);
		Scene scene = new Scene(b, width, height);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public HBox addHBox() {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);
		hbox.setStyle("-fx-background-color: #336699;");

//		Text round = new Text(border.getTurn() + "'s turn");
//		round.setFont(Font.font("Comic Sans MS", 50));

		Text title = new Text("Tic Tac Toe");
		title.setFont(Font.font("Comic Sans MS", 75));
		hbox.setSpacing(20);

		// Setting the margin to the nodes
//		hbox.setMargin(round, new Insets(20, 20, 20, 20));
		// hbox.setMargin(title, new Insets(10, 20, 50, 50));

		// retrieving the observable list of the HBox
		ObservableList list = hbox.getChildren();
		list.addAll(title);
		return hbox;
	}
//	public 

	public void switchToOver(Stage primaryStage) throws Exception {
		StackPane endingPane = new StackPane();
		Text endingText = new Text(" Game is over!");
		endingText.setFont(Font.font("Comic Sans MS", 200));
		endingPane.setMargin(endingText, new Insets(50, 50, 50, 50));
		Scene endingScene = new Scene(endingPane);
		primaryStage.setScene(endingScene);

	}

	/*
	 * public void gameOver() { // return border.getIsOver(); if(border.getIsOver())
	 * { System.out.println("over");
	 * 
	 * gameOver = border.getIsOver(); }}
	 * 
	 */
	/*
	 * public boolean gameOver1() { if(border.getIsOver()) {
	 * System.out.println("over");} return border.getIsOver(); }
	 */
}
