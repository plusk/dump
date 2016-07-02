package o6;

import java.util.ArrayList;
import java.util.Comparator;

public class CardComparator implements Comparator<Card>{
	boolean ace;
	char trump;
	
	public CardComparator(boolean ace, char trump) throws IllegalArgumentException{
		this.ace = ace;
		if(trump == ' '){
			this.trump = 'S';
		}
		else if(trump == 'S' || trump == 'H' || trump == 'D' || trump == 'C'){
			this.trump = trump;
		}
		else{
			throw new IllegalArgumentException("That is not a valid suit.");
		}
	}
	@Override
	public int compare(Card c1, Card c2) {		
		ArrayList<Character> suits= new ArrayList<Character>();
		suits.add('S');
		suits.add('H');
		suits.add('D');
		suits.add('C');
		suits.add(0, suits.remove(suits.indexOf(trump)));
		
		int c1Val = suits.indexOf(c1.getSuit());
		int c2Val = suits.indexOf(c2.getSuit());
		
		int c1Face = c1.getFace();
		int c2Face = c2.getFace();
		
		if(ace && c1Face == 1){
			c1Face = 14;
		}
		if(ace && c2Face == 1){
			c2Face = 14;
		}
		
		if(c1Val < c2Val) {
			return 1;
		}
		else if(c1Val > c2Val) {
			return -1;
		}
		else {
			if(c1Face > c2Face ) {
				return 1;
			}
			else if(c1Face < c2Face) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
	
}
