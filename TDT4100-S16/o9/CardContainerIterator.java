package o9;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card>{
	private CardContainer cc;
	private int index = 0;
	
	public CardContainerIterator(CardContainer cc) {
		this.cc = cc;
	}

	@Override
	public boolean hasNext() {
		return index < this.cc.getCardCount();
	}
	
	@Override
	public Card next(){
		Card card = this.cc.getCard(index);
		index++;
		return card;
	}
}
