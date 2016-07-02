package o9;

import o9.Card;

public interface CardContainer extends Iterable<Card>{
	public int getCardCount();
	public Card getCard(int n);
}
