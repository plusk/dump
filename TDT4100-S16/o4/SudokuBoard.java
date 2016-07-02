package o4;

import java.util.Random;

public class SudokuBoard {
	private String strBoard;
	public SudokuCell[][] arrBoard;
	
	// check the length of the board string
	private void checkBoard(String inputBoard) throws IllegalArgumentException {
		if(inputBoard.length() < 81) {
			throw new IllegalArgumentException("That board is too small!");
		}
		else if(inputBoard.length() > 81) {
			throw new IllegalArgumentException("That board is too big!");
		}
	}
	
	// constructor with input
	public SudokuBoard(String inputBoard) {
		checkBoard(inputBoard);
		this.strBoard = inputBoard;
		arrBoard = toArray();
	}
	
	// constructor, if no input given, use random one of example boards, no need to validate those
	public SudokuBoard() {
		String[] startBoards = {
			".....2..38.273.45....6..87.9.8..5367..6...1..4513..9.8.84..3....79.512.62..8.....",
			".68.257.3..........71..39..61.35.2...8.....4...3.64.95..76..58..........8.653.42.",
			".....59.4.8..9.6.5..6....3..3.7.145...8.4.7...742.6.9..6....3..8.1.6..7.3.98.....",
			"...6...513....2..66...3..89..4.2.6...3.418.2...8.7.1..59..6...38..3....241...9..."
		};
		Random r = new Random();
		this.strBoard = startBoards[r.nextInt(4)];
		arrBoard = toArray();
	}
	
	// turn the board into a 2d array of cells-objects
	private SudokuCell[][] toArray() {
		SudokuCell[][] arrBoard = new SudokuCell[9][9];
		for(int i = 0; i < strBoard.length(); i++){
			int col = i % 9;
			int row = i / 9;
			
			if(strBoard.substring(i, i+1).equals(".")){
				arrBoard[col][row] = new SudokuCell(col, row, " "+strBoard.substring(i, i+1)+" ");
			}
			else {
				arrBoard[col][row] = new SudokuCell(col, row, "("+strBoard.substring(i, i+1)+")");
			}
			
		}
		return arrBoard;
	}
	// reset board, remove all stars
	private void resetBoard() {
		for (int col = 0; col < 9; col++) {
			for (int row = 0; row < 9; row++) {
				String strVal = arrBoard[col][row].getValue();
				if(strVal.substring(2).equals("*")){
					arrBoard[col][row].setValue(strVal.substring(0, 2)+" ");
				}
			}
		}
	}
	
	// check for conflicts in columns
	private void conCol() {
		for (int col = 0; col < 9; col++) {
			boolean[] valCol = new boolean[9];
			boolean[] dupCol = new boolean[9];
			
			for (int row = 0; row < 9; row++) {
				String strVal = arrBoard[col][row].getValue();
				
				if(strVal.substring(2).equals(")")){
					int intVal = Integer.parseInt(strVal.substring(1, 2));
					valCol[intVal-1] = true;
				}
			}
			for (int row = 0; row < 9; row++) {
				String strVal = arrBoard[col][row].getValue();
				
				if(!(strVal.substring(2).equals(")") || strVal.substring(1, 2).equals("."))){
					int intVal = Integer.parseInt(strVal.substring(1, 2));
					if(valCol[intVal-1] == false){
						valCol[intVal-1] = true;
					}
					else {
						dupCol[intVal-1] = true;
						for (int y = 0; y < 9; y++) {
							String curVal = arrBoard[col][y].getValue().substring(1);
							if(!(curVal.substring(1).equals(")") || curVal.substring(0, 1).equals("."))){
								arrBoard[col][y].setValue(strVal.substring(0, 2)+"*");
							}
						}
					}
				}
			}
		}
	}
	
	// check for conflicts in rows
	private void conRow() {
		for (int row = 0; row < 9; row++) {
			boolean[] valRow = new boolean[9];
			boolean[] dupRow = new boolean[9];
			
			for (int col = 0; col < 9; col++) {
				String strVal = arrBoard[col][row].getValue();
				
				if(strVal.substring(2).equals(")")){
					int intVal = Integer.parseInt(strVal.substring(1, 2));
					valRow[intVal-1] = true;
				}
			}
			for (int col = 0; col < 9; col++) {
				String strVal = arrBoard[col][row].getValue();
				
				if(!(strVal.substring(2).equals(")") || strVal.substring(1, 2).equals("."))){
					int intVal = Integer.parseInt(strVal.substring(1, 2));
					if(valRow[intVal-1] == false){
						valRow[intVal-1] = true;
					}
					else {
						dupRow[intVal-1] = true;
						for (int x = 0; x < 9; x++) {
							String curVal = arrBoard[x][row].getValue().substring(1);
							if(!(curVal.substring(1).equals(")") || curVal.substring(0, 1).equals("."))){
								arrBoard[x][row].setValue(strVal.substring(0, 2)+"*");
							}
						}
					}
				}
			}
		}
	}
	
	// check for conflicts in box
	private void conBox() {
		for (int col = 0; col < 9; col++) {
			for (int row = 0; row < 9; row++) {
				String strVal = arrBoard[col][row].getValue();
				
				int limRow = 0;
				int limCol = 0;
				if (row <= 2){
					limRow = 0;
				}
				else if (row <= 5){
					limRow = 3;
				}
				else if (row <= 8){
					limRow = 6;
				}
				if (col <= 2){
					limCol = 0;
				}
				else if (col <= 5){
					limCol = 3;
				}
				else if (col <= 8){
					limCol = 6;
				}
				for (int a = limRow; a < limRow + 3; a++) {
					for (int b = limCol; b < limCol + 3; b++) {
						String boxVal = arrBoard[a][b].getValue();
						if(!boxVal.equals(" . ")){
							if(!strVal.substring(2).equals(")")){
								if (strVal.substring(1,2).equals(boxVal.substring(1,2))) {
									if(b != col && a != row){
										arrBoard[col][row].setValue(strVal.substring(0,2)+"*");
										System.out.println("strVal.substring(1,2) = " + strVal.substring(1,2) + " equals  boxVal.substring(1,2): " + boxVal.substring(1,2));
										System.out.println("Star put at row= " + row +" col = " + col + " value = " + strVal);
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	// check board for conflicts
	private void validateBoard() {
		resetBoard();
		conCol();
		conRow();
		conBox();
	}
	
	// turn board into a string that can be printed out
	public String toString() {
		validateBoard();
		String board = "\n    ";
		String horSep = "  |             |             |             |\n";
		String verSep = "  +-------------+-------------+-------------+\n";
		String strRow = "";
		
		for (int xIndex = 1; xIndex <= 9; xIndex++){
			if(xIndex % 3 == 0){
				board += " " + xIndex + " ";
				board += "   ";
			}
			else{
				board += " " + xIndex + " ";
				board += " ";
			}
		}
		board += "\n";

		for (int row = 1; row <= 9; row++){
			if(row-1 == 0){
				board += verSep;
			}
			else if((row - 1) % 3 == 0){
				board += horSep;
				board += verSep;
			}
			board += horSep;
			strRow = Integer.toString(row);
			strRow += " ";

			for (int col = 0; col < 9; col++){
				if(col % 3 == 0){
					strRow += "| ";
				}
				strRow += arrBoard[col][row-1].getValue();
				strRow += " ";
			}
			strRow += "|";
			board += strRow+"\n";
		}
		board += horSep;
		board += verSep;
		return board;
	}
}
