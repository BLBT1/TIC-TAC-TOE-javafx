package betterTicTacToe;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Cell extends Rectangle {
//	private EventHandler<MouseEvent> eventHandler;

	public Cell(int width, int height) {
		super(width, height);
	}

	public Text drawX() {
		Text x = new Text();
		x.setText("x");
		x.setFont(Font.font("Comic Sans MS", 100));
		return x;

	}

	public Text drawO() {
		Text o = new Text();
		o.setText("O");
		o.setFont(Font.font("Comic Sans MS", 100));
		return o;
	}

	
}
