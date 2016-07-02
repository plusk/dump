package o9;

public class Card implements Comparable<Card>{
	private char suit;
	private int face;
	
	private Card card;
	
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
	public int getSuitValue(char suit) throws IllegalArgumentException{
		if(suit == 'S') return 0;
		else if(suit == 'H') return 1;
		else if(suit == 'D') return 2;
		else if(suit == 'C') return 3;
		else throw new IllegalArgumentException("That is not a valid suit.");
	}
	public int getFace(){
		return this.face;
	}
	public String toString() {
		return this.suit+Integer.toString(this.face);
	}
	@Override
	public int compareTo(Card comp) {
		int CardVal = card.getSuitValue(getSuit());
		int CompVal = comp.getSuitValue(getSuit());
		int cardFace = card.getFace();
		int compFace = comp.getFace();
		
		if(CardVal < CompVal) {
			return 1;
		}
		else if(CardVal > CompVal) {
			return -1;
		}
		else {
			if(cardFace > compFace) {
				return 1;
			}
			else if(cardFace < compFace) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
}
