package betterTicTacToe;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Cell extends Rectangle {
//	private EventHandler<MouseEvent> eventHandler;
	private String symbol;
	
		public Cell(int width, int height) {
		super(width, height);
	   
		symbol = "";
	}

	public Text drawX() {
		symbol = "X";
		Text x = new Text();
		x.setText(symbol);
		x.setFont(Font.font("Comic Sans MS", 100));
		return x;

	}

	public Text drawO() {
		symbol = "O";
		Text o = new Text();
		o.setText(symbol);
		o.setFont(Font.font("Comic Sans MS", 100));
		return o;
	}

	public String getSymbol() {

		return symbol;

	}
	
	
}