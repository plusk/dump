package o6;

import java.util.ArrayList;
import java.util.Iterator;

public class CardHand implements CardContainer {
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
	public Iterator<Card> iterator(){
		return cards.iterator();
	}
}
