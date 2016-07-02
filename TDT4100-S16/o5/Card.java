package o5;

public class Card {
	private char suit;
	private int face;
	
	public Card(char suit, int face) throws IllegalArgumentException{
		if(suit == 'S' || suit == 'H' || suit == 'D' || suit == 'C'){
			if(face <= 13 && face >= 1) {
				this.suit = suit;
				this.face = face;
			}
			else {
				throw new IllegalArgumentException("That is not a valid face.");
			}
		}
		else {
			throw new IllegalArgumentException("That is not a valid suit.");
		}
	}
	public char getSuit(){
		return this.suit;
	}
	public int getFace(){
		return this.face;
	}
	public String toString() {
		return this.suit+Integer.toString(this.face);
	}
}
