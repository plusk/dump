package o6;

public interface CardContainer extends Iterable<Card>{
	public int getCardCount();
	public Card getCard(int n);
}
