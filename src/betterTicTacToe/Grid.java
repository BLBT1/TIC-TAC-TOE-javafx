package betterTicTacToe;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Grid extends GridPane {
	private int turn;
	private String whoTurn;
	private boolean isOver = false;
	List<List<String>> symbols;
	List<String> row0;
	List<String> row1;
	List<String> row2;
	private int winType = 0;

	public Grid() {
		Cell[][] CellArray = new Cell[3][3];
		row0 = new ArrayList<String>();
		row1 = new ArrayList<String>();
		row2 = new ArrayList<String>();
		symbols = new ArrayList<List<String>>();
		for (int i = 0; i < 3; i++) {
			row0.add("");
			row1.add("");
			row2.add("");
		}
		symbols.add(row0);
		symbols.add(row1);
		symbols.add(row2);
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
					if (isOver) {
						return;
					}
					if (turn % 2 == 0) {
						Text sign = CellArray[innerRow][innerCol].drawX();
						this.add(sign, innerRow, innerCol);
						GridPane.setHalignment(sign, HPos.CENTER);
						GridPane.setValignment(sign, VPos.CENTER);
						if (innerCol == 0) {
							row0.set(innerRow, "X");
						} else if (innerCol == 1) {
							row1.set(innerRow, "X");
						} else if (innerCol == 2) {
							row2.set(innerRow, "X");
						}
						turn++;
						System.out.println(symbols);
						isOver = !checkWin();
						if (isOver) {
							System.out.println("Grid is over ");
							if (winType == 1) {
//								Line line = new Line(CellArray[0][0].getX(),(CellArray[0][0].getY()+CellArray[0][0].getWidth()/2),CellArray[0][2].getX(),(CellArray[0][0].getY()+CellArray[0][0].getWidth()/2)); 
//				                this.add(line,1,1);
								CellArray[0][0].setFill(Color.CHARTREUSE);
								CellArray[1][0].setFill(Color.CHARTREUSE);
								CellArray[2][0].setFill(Color.CHARTREUSE);
							}
							if (winType == 2) {
//								Line line = new Line(CellArray[0][0].getX(),(CellArray[1][0].getY()+CellArray[0][0].getWidth()/2),CellArray[0][2].getX(),(CellArray[1][0].getY()+CellArray[0][0].getWidth()/2));	
//								this.add(line,1,1);
								CellArray[0][1].setFill(Color.CHARTREUSE);
								CellArray[1][1].setFill(Color.CHARTREUSE);
								CellArray[2][1].setFill(Color.CHARTREUSE);
							}
							if (winType == 3) {
								CellArray[0][2].setFill(Color.CHARTREUSE);
								CellArray[1][2].setFill(Color.CHARTREUSE);
								CellArray[2][2].setFill(Color.CHARTREUSE);
//								Line line = new Line(CellArray[0][0].getX(),(CellArray[2][0].getY()+CellArray[0][0].getWidth()/2),CellArray[0][2].getX(),(CellArray[2][0].getY()+CellArray[0][0].getWidth()/2));					
//								this.add(line,1,1);
							}
							if (winType == 4) {
//								Line line = new Line(CellArray[0][0].getX()+CellArray[0][0].getWidth()/2,CellArray[0][0].getY(),CellArray[0][0].getX()+CellArray[0][0].getWidth()/2,CellArray[0][2].getY());
//								this.add(line,1,1);
								CellArray[0][0].setFill(Color.CHARTREUSE);
								CellArray[0][1].setFill(Color.CHARTREUSE);
								CellArray[0][2].setFill(Color.CHARTREUSE);
							}
							if (winType == 5) {
//								Line line = new Line(CellArray[0][1].getX()+CellArray[0][0].getWidth()/2,CellArray[0][0].getY(),CellArray[0][1].getX()+CellArray[0][0].getWidth()/2,CellArray[0][2].getY());
//								this.add(line,1,1);
								CellArray[1][0].setFill(Color.CHARTREUSE);
								CellArray[1][1].setFill(Color.CHARTREUSE);
								CellArray[1][2].setFill(Color.CHARTREUSE);
							}
							if (winType == 6) {
//								Line line = new Line(CellArray[0][2].getX()+CellArray[0][0].getWidth()/2,CellArray[0][0].getY(),CellArray[0][2].getX()+CellArray[0][0].getWidth()/2,CellArray[0][2].getY());	
//								this.add(line,1,1);
								CellArray[2][0].setFill(Color.CHARTREUSE);
								CellArray[2][1].setFill(Color.CHARTREUSE);
								CellArray[2][2].setFill(Color.CHARTREUSE);
							}
							if (winType == 7) {
//								Line line= new Line(CellArray[0][0].getX(),CellArray[0][0].getY(),CellArray[2][2].getX(),CellArray[2][2].getY());
//								this.add(line,1,1);
								CellArray[0][0].setFill(Color.CHARTREUSE);
								CellArray[1][1].setFill(Color.CHARTREUSE);
								CellArray[2][2].setFill(Color.CHARTREUSE);
							}
							if (winType == 8) {
//								Line line= new Line(CellArray[0][2].getX(),CellArray[0][2].getY(),CellArray[2][0].getX(),CellArray[2][0].getY());
//								this.add(line,1,1);
								CellArray[0][2].setFill(Color.CHARTREUSE);
								CellArray[1][1].setFill(Color.CHARTREUSE);
								CellArray[2][0].setFill(Color.CHARTREUSE);
							}
						}

						// whoTurn= "X";
					} else {
						Text sign = CellArray[innerRow][innerCol].drawO();

						this.add(sign, innerRow, innerCol);
						GridPane.setHalignment(sign, HPos.CENTER);
						GridPane.setValignment(sign, VPos.CENTER);
						if (innerCol == 0) {
							row0.set(innerRow, "O");
						} else if (innerCol == 1) {
							row1.set(innerRow, "O");
						} else if (innerCol == 2) {
							row2.set(innerRow, "O");
						}
						turn++;
						System.out.println(symbols);
						// whoTurn = "O";
						isOver = !checkWin();
						if (isOver) {
							System.out.println("Grid is over ");
							if (winType == 1) {
//								Line line = new Line(CellArray[0][0].getX(),(CellArray[0][0].getY()+CellArray[0][0].getWidth()/2),CellArray[0][2].getX(),(CellArray[0][0].getY()+CellArray[0][0].getWidth()/2)); 
//				                this.add(line,1,1);
								CellArray[0][0].setFill(Color.CHARTREUSE);
								CellArray[1][0].setFill(Color.CHARTREUSE);
								CellArray[2][0].setFill(Color.CHARTREUSE);
							}
							if (winType == 2) {
//								Line line = new Line(CellArray[0][0].getX(),(CellArray[1][0].getY()+CellArray[0][0].getWidth()/2),CellArray[0][2].getX(),(CellArray[1][0].getY()+CellArray[0][0].getWidth()/2));	
//								this.add(line,1,1);
								CellArray[0][1].setFill(Color.CHARTREUSE);
								CellArray[1][1].setFill(Color.CHARTREUSE);
								CellArray[2][1].setFill(Color.CHARTREUSE);
							}
							if (winType == 3) {
								CellArray[0][2].setFill(Color.CHARTREUSE);
								CellArray[1][2].setFill(Color.CHARTREUSE);
								CellArray[2][2].setFill(Color.CHARTREUSE);
//								Line line = new Line(CellArray[0][0].getX(),(CellArray[2][0].getY()+CellArray[0][0].getWidth()/2),CellArray[0][2].getX(),(CellArray[2][0].getY()+CellArray[0][0].getWidth()/2));					
//								this.add(line,1,1);
							}
							if (winType == 4) {
//								Line line = new Line(CellArray[0][0].getX()+CellArray[0][0].getWidth()/2,CellArray[0][0].getY(),CellArray[0][0].getX()+CellArray[0][0].getWidth()/2,CellArray[0][2].getY());
//								this.add(line,1,1);
								CellArray[0][0].setFill(Color.CHARTREUSE);
								CellArray[0][1].setFill(Color.CHARTREUSE);
								CellArray[0][2].setFill(Color.CHARTREUSE);
							}
							if (winType == 5) {
//								Line line = new Line(CellArray[0][1].getX()+CellArray[0][0].getWidth()/2,CellArray[0][0].getY(),CellArray[0][1].getX()+CellArray[0][0].getWidth()/2,CellArray[0][2].getY());
//								this.add(line,1,1);
								CellArray[1][0].setFill(Color.CHARTREUSE);
								CellArray[1][1].setFill(Color.CHARTREUSE);
								CellArray[1][2].setFill(Color.CHARTREUSE);
							}
							if (winType == 6) {
//								Line line = new Line(CellArray[0][2].getX()+CellArray[0][0].getWidth()/2,CellArray[0][0].getY(),CellArray[0][2].getX()+CellArray[0][0].getWidth()/2,CellArray[0][2].getY());	
//								this.add(line,1,1);
								CellArray[2][0].setFill(Color.CHARTREUSE);
								CellArray[2][1].setFill(Color.CHARTREUSE);
								CellArray[2][2].setFill(Color.CHARTREUSE);
							}
							if (winType == 7) {
//								Line line= new Line(CellArray[0][0].getX(),CellArray[0][0].getY(),CellArray[2][2].getX(),CellArray[2][2].getY());
//								this.add(line,1,1);
								CellArray[0][0].setFill(Color.CHARTREUSE);
								CellArray[1][1].setFill(Color.CHARTREUSE);
								CellArray[2][2].setFill(Color.CHARTREUSE);
							}
							if (winType == 8) {
//								Line line= new Line(CellArray[0][2].getX(),CellArray[0][2].getY(),CellArray[2][0].getX(),CellArray[2][0].getY());
//								this.add(line,1,1);
								CellArray[0][2].setFill(Color.CHARTREUSE);
								CellArray[1][1].setFill(Color.CHARTREUSE);
								CellArray[2][0].setFill(Color.CHARTREUSE);
							}
						}

					}
				});

			}
		}

	}

	public String getTurn() {
		return whoTurn;
	}

	public boolean getIsOver() {
		return isOver;
	}

	public boolean checkWin() {
		boolean gameOver = true;
		// winning situation for X
		if (symbols.get(0).get(0) == "X" && symbols.get(0).get(1) == "X" && symbols.get(0).get(2) == "X") {
			gameOver = false;
			winType = 1;
		}
		if (symbols.get(1).get(0) == "X" && symbols.get(1).get(1) == "X" && symbols.get(1).get(2) == "X") {
			gameOver = false;
			winType = 2;
		}
		if (symbols.get(2).get(0) == "X" && symbols.get(2).get(1) == "X" && symbols.get(2).get(2) == "X") {
			gameOver = false;
			winType = 3;
		}
		if (symbols.get(0).get(0) == "X" && symbols.get(1).get(0) == "X" && symbols.get(2).get(0) == "X") {
			gameOver = false;
			winType = 4;
		}
		if (symbols.get(0).get(1) == "X" && symbols.get(1).get(1) == "X" && symbols.get(2).get(1) == "X") {
			gameOver = false;
			winType = 5;
		}
		if (symbols.get(0).get(2) == "X" && symbols.get(1).get(2) == "X" && symbols.get(2).get(2) == "X") {
			gameOver = false;
			winType = 6;
		}
		if (symbols.get(0).get(0) == "X" && symbols.get(1).get(1) == "X" && symbols.get(2).get(2) == "X") {
			gameOver = false;
			winType = 7;
		}
		if (symbols.get(0).get(2) == "X" && symbols.get(1).get(1) == "X" && symbols.get(2).get(0) == "X") {
			gameOver = false;
			winType = 8;
		}

		// Winning situation for O
		if (symbols.get(0).get(0) == "O" && symbols.get(0).get(1) == "O" && symbols.get(0).get(2) == "O") {
			gameOver = false;
			winType = 1;
		}
		if (symbols.get(1).get(0) == "O" && symbols.get(1).get(1) == "O" && symbols.get(1).get(2) == "O") {
			gameOver = false;
			winType = 2;
		}
		if (symbols.get(2).get(0) == "O" && symbols.get(2).get(1) == "O" && symbols.get(2).get(2) == "O") {
			gameOver = false;
			winType = 3;
		}
		if (symbols.get(0).get(0) == "O" && symbols.get(1).get(0) == "O" && symbols.get(2).get(0) == "O") {
			gameOver = false;
			winType = 4;
		}
		if (symbols.get(0).get(1) == "O" && symbols.get(1).get(1) == "O" && symbols.get(2).get(1) == "O") {
			gameOver = false;
			winType = 5;
		}
		if (symbols.get(0).get(2) == "O" && symbols.get(1).get(2) == "O" && symbols.get(2).get(2) == "O") {
			gameOver = false;
			winType = 6;
		}
		if (symbols.get(0).get(0) == "O" && symbols.get(1).get(1) == "O" && symbols.get(2).get(2) == "O") {
			gameOver = false;
			winType = 7;
		}
		if (symbols.get(0).get(2) == "O" && symbols.get(1).get(1) == "O" && symbols.get(2).get(0) == "O") {
			gameOver = false;
			winType = 8;
		}

		return gameOver;

	}

}
