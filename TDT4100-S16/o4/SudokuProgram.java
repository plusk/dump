package o4;

import java.util.Scanner;

public class SudokuProgram {
	
	String token;
	
	private SudokuBoard sb;
	
	void init() {
		sb = new SudokuBoard();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Do you wish to import a board?");
		
		while(true) {
			System.out.println("> ");
			String token = scan.next();
			
			if (token.equals("yes")) {
				System.out.print("Enter a board string: ");
				sb = new SudokuBoard(scan.next());
				break;
			}
			else if(token.equals("no")) {
				System.out.println("In that case, we'll make one for you!");
				sb = new SudokuBoard();
				break;
			}
		}
	}
	
	private void checkCoordinate(String coordinate) throws IllegalArgumentException {
		try {
			int intValue = Integer.parseInt(coordinate);
			if(intValue > 9 || intValue < 1) {
				throw new IllegalArgumentException(coordinate + " is not an integer between 1 and 9");
			}
		}
		catch (NumberFormatException e){
			throw new IllegalArgumentException(coordinate + " is not a an integer");
		}
	}
	
	void run() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println(sb.toString());
			
			System.out.println("Input an X-coordinate (1-9)");	
			System.out.print("> ");
			token = scan.next();

			if (token.equals("break")) {
				break;
			}
			else {
				checkCoordinate(token);
				int xcoor = Integer.parseInt(token);
				
				System.out.println("Input a Y-coordinate (1-9)");	
				System.out.print("> ");
				token = scan.next();
				
				if (token.equals("break")) {
					break;
				}
				else {
					checkCoordinate(token);
					int ycoor = Integer.parseInt(token);
					
					System.out.println("Input a value (1-9)");
					System.out.print("> ");
					token = scan.next();
					
					if (token.equals("break")) {
						break;
					}
					else {
						if(!sb.arrBoard[xcoor-1][ycoor-1].getValue().substring(2).equals(")")){
							sb.arrBoard[xcoor-1][ycoor-1].setValue(" "+token+" ");
						}
						else {
							System.out.println("You're not allowed to change the base board!");
						}
					}
				}
			}
		}
		scan.close();
	}
	
	public static void main(String[] args) {
		SudokuProgram sp = new SudokuProgram();
		sp.init();
		sp.run();
	}
}