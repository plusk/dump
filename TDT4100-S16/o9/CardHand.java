package o9;

public class CardHand extends CardContainerImpl {

	public CardHand(int n) {
		super(n);
	}
	public void addCard(Card card)throws IllegalStateException{
		if(getCardCount() < getMaxCardCount()){
			cards.add(card);
		}
		else {
			throw new IllegalStateException("You have reached the maximum amount of cards!");
		}
	}
	public Card play(int n){
		Card tempCard = getCard(n);
		cards.remove(n);
		return tempCard;
	}
}
