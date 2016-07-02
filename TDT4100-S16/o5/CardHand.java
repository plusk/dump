package o5;

import java.util.ArrayList;

public class CardHand {
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public int getCardCount() {
		return cards.size();
	}
	public Card getCard(int n) throws IllegalArgumentException{
		if(n >= 0 && n < getCardCount()){
			return cards.get(n); // could be problem
		}
		else{
			throw new IllegalArgumentException("That is not a card in this deck");
		}
	}
	public void addCard(Card card){
		cards.add(card);
	}
	public Card play(int n){
		Card tempCard = getCard(n);
		cards.remove(n);
		return tempCard;
	}
}
