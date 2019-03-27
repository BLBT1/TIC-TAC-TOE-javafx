package betterTicTacToe;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Grid extends GridPane {
	private int turn;
	private String whoTurn; 
	private boolean isOver;

	public Grid() {
		Cell[][] CellArray = new Cell[3][3];
		turn = 0;
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				CellArray[row][col] = new Cell(140, 140);
				CellArray[row][col].setFill(Color.WHITE);
				CellArray[row][col].setStroke(Color.BLACK);
				CellArray[row][col].setStrokeWidth(3);
				this.add(CellArray[row][col], row, col);
				setAlignment(Pos.CENTER);
				final int innerRow = row;
				final int innerCol = col;

				CellArray[row][col].setOnMouseClicked(e -> {
					if (turn % 2 == 0) {
						Text sign = CellArray[innerRow][innerCol].drawX();

						this.add(sign, innerRow, innerCol);
						GridPane.setHalignment(sign, HPos.CENTER);
						GridPane.setValignment(sign, VPos.CENTER);
						turn++;
						whoTurn= "X";
					} else {
						Text sign = CellArray[innerRow][innerCol].drawO();

						this.add(sign, innerRow, innerCol);
						GridPane.setHalignment(sign, HPos.CENTER);
						GridPane.setValignment(sign, VPos.CENTER);
						turn++;
						whoTurn = "O";
					}
				});

			}
		}

	}

	public String getTurn() {
		return whoTurn;
	}

}
