package o3;

import java.util.Scanner;

public class NimProgram {
	private Nim nim;
	
	void init() {
		nim = new Nim();
	}
	
	void run() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println(nim.toString());
			
			System.out.print(">\t");
			String token = scanner.next();

			if (token.equals("remove")) {
				System.out.print(">\t");
				int number = Integer.parseInt(scanner.next());				
				System.out.print(">\t");
				int targetPile = Integer.parseInt(scanner.next());
				
				nim.removePieces(number, targetPile);
			}
			else if (token.equals("valid")) {
				System.out.print(">\t");
				int number = Integer.parseInt(scanner.next());				
				System.out.print(">\t");
				int targetPile = Integer.parseInt(scanner.next());
				
				System.out.println(nim.isValidMove(number, targetPile));
			}	
			else if (token.equals("over")) {
				System.out.println(nim.isGameOver());
			}
			else if(token.equals("break")) {
				break;
			}
		}
		scanner.close();
	}
	
	public static void main(String[] args) {
		NimProgram nimp = new NimProgram();
		nimp.init();
		nimp.run();
	}
}