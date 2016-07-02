package o9;

import java.util.Scanner;

public class ObservableHighscoreListProgram implements ObservableListListener {
	
	public static ObservableHighscoreList hsl;
	public static Scanner scanner;
	
	static void init(){
		ObservableHighscoreListProgram hslp = new ObservableHighscoreListProgram();
		
		scanner = new Scanner(System.in);
		int maxSize;
		while(true){
			System.out.println("Input a maxSize: ");
			maxSize = scanner.nextInt();
			break;
		}
		hsl = new ObservableHighscoreList(maxSize);
		hsl.addObservableListListener(hslp);
	}
	
	static void run(){
		scanner = new Scanner(System.in);
		while(true){
			System.out.println();
			System.out.println("Add a result: ");
			int result = scanner.nextInt();
			hsl.addResult(result);
		}
	}
	
	@Override
	public void listChanged(ObservableList list, int index) {
		String output = "[";
		for (int i = 0; i < list.size(); i++) {
			output += list.getElement(i);
			if(i != list.size()-1){
				output += ", ";
			}
		}
		output += "]";
		System.out.println();
		System.out.println("List: " + output);
		System.out.println("Changed index: " + index);
	}
	
	public static void main(String[] args) {
		init();
		run();
	}
	
}
