package o8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class SudokuProgram {
	
	String token;
	
	private SudokuBoard sb;
	
	Stack<SudokuAction> stkUndo = new Stack<SudokuAction>();
	Stack<SudokuAction> stkRedo = new Stack<SudokuAction>();
	
	void init() {
		sb = new SudokuBoard();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Do you wish to load a board?");
		
		while(true) {
			System.out.println("> ");
			String token = scan.next();
			
			if (token.equals("yes")) {
				load();
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
	private void set(int x, int y, String val){
		sb.arrBoard[x][y].setValue(val);
	}
	private void undo(){
		if (stkUndo.empty()){
			System.out.println("You have nothing to undo.");
		}
		else {
			SudokuAction sa = stkUndo.pop();
			set(sa.getX(), sa.getY(), sa.getValOld());
			stkRedo.push(sa);
		}
	}
	private void redo(){
		if (stkRedo.empty()){
			System.out.println("You have nothing to redo.");
		}
		else {
			SudokuAction sa = stkRedo.pop();
			set(sa.getX(), sa.getY(), sa.getValNew());
			stkUndo.push(sa);
		}
	}
	private void save() {
		try
		{
			PrintWriter outFile = new PrintWriter("src/o8/test.txt");
			outFile.println(sb.save());
			outFile.close();
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Error: file 'src/o8/test.txt' could not be opened for writing.");
			System.exit(1);
		}
	}
	private void load() {
		Scanner in;
		try{
			in = new Scanner(new FileReader("src/o8/test.txt"));
			sb = new SudokuBoard(in.nextLine());
			in.close();
		}
		catch (FileNotFoundException e){
			System.err.println("Error: file 'src/o8/test.txt' could not be opened. Does it exist?");
			System.exit(1);
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
			else if(token.equals("undo")) {
				undo();
			}
			else if(token.equals("redo")) {
				redo();
			}
			else if(token.equals("save")) {
				save();
			}
			else if(token.equals("load")) {
				load();
			}
			else {
				checkCoordinate(token);
				int x = Integer.parseInt(token)-1;
				
				System.out.println("Input a Y-coordinate (1-9)");
				System.out.print("> ");
				token = scan.next();
				
				if (token.equals("break")) {
					break;
				}
				else if(token.equals("undo")) {
					undo();
				}
				else if(token.equals("redo")) {
					redo();
				}
				else if(token.equals("save")) {
					save();
				}
				else if(token.equals("load")) {
					load();
				}
				else {
					checkCoordinate(token);
					int y = Integer.parseInt(token)-1;
					
					System.out.println("Input a value (1-9)");
					System.out.print("> ");
					token = scan.next();
					
					if (token.equals("break")) {
						break;
					}
					else if(token.equals("undo")) {
						undo();
					}
					else if(token.equals("redo")) {
						redo();
					}
					else if(token.equals("save")) {
						save();
					}
					else if(token.equals("load")) {
						load();
					}
					else {
						if(!sb.arrBoard[x][y].getValue().substring(2).equals(")")){
							String val = " "+token+" ";
							stkUndo.push(new SudokuAction(x, y, sb.arrBoard[x][y].getValue(), val));
							set(x, y, val);
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