package o3;

public class Nim {

	private int[] pile = new int[3];
	
	public Nim(int pileSize) {
		this.pile[0] = pileSize;
		this.pile[1] = pileSize;
		this.pile[2] = pileSize;
	}
	public Nim() {
		this.pile[0] = 10;
		this.pile[1] = 10;
		this.pile[2] = 10;
	}
	
	private void checkTargetPile(int targetPile) throws IllegalArgumentException{
		if(targetPile > 2 || targetPile < 0) {
			throw new IllegalArgumentException("The targetPile does not exist!");
		}
	}
	private void checkNumbers(int number, int targetPile) throws IllegalArgumentException{
		if(number < 1 || number > this.pile[targetPile]) {
			System.out.println("checking numbers throws illegalArgument ");
			throw new IllegalArgumentException("Number is too small or too big.");
		}
	}
	
	public void removePieces(int number, int targetPile) throws IllegalStateException {
		if (!isGameOver()) {
			System.out.println("In remove pieces: number = " + number + " targetpile = " + targetPile);
			if(isValidMove(number, targetPile)) {
				this.pile[targetPile] -= number;
			}		
		}
		else {
			throw new IllegalStateException("The game is already over!");
		}
	}

	public boolean isValidMove(int number, int targetPile) {
		if(!isGameOver()) {
			try {
				checkTargetPile(targetPile);
				checkNumbers(number, targetPile);
				System.out.println("isValidMove returns true");
				return true;
			}
			catch (IllegalArgumentException e){
				System.out.println("caught an illegalargumentexception");
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public int getPile(int targetPile){
		checkTargetPile(targetPile);
		return this.pile[targetPile];
	}
	public boolean isGameOver() {	
		for (int i = 0; i < this.pile.length; i++) {
			if (this.pile[i] == 0){
				return true;
			}
		}
		return false;
	}
	public String toString() {	
		return "Pile0: "+this.pile[0]+"\nPile1: "+this.pile[1]+"\nPile2: "+this.pile[2];
	}
}