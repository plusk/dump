package o9;

import java.util.ArrayList;
import java.util.Iterator;

public class CardContainerImpl implements CardContainer {

	protected ArrayList<Card> cards = new ArrayList<Card>();
	private int maxCardCount;
	
	public CardContainerImpl(int n){
		this.maxCardCount = n;
	}
	
	public int getMaxCardCount() {
		return this.maxCardCount;
	}
	
	@Override
	public Iterator<Card> iterator() {
		// TODO Auto-generated method stub
		return cards.iterator();
	}
	
	@Override
	public int getCardCount() {
		return cards.size();
	}

	@Override
	public Card getCard(int n) throws IllegalArgumentException{
		if(n >= 0 && n < getCardCount()){
			return cards.get(n); // could be problem
		}
		else{
			throw new IllegalArgumentException("That is not a card in this deck");
		}
	}
}
