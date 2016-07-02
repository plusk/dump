package o9;

import java.util.ArrayList;

public class CardDeck extends CardContainerImpl {
	
	public CardDeck(int n){
		super(52);
		
		int i;
		for (i = 0; i < n; i++) {
			cards.add(new Card('S', i+1));
		}
		for (i = 0; i < n; i++) {
			cards.add(new Card('H', i+1));
		}
		for (i = 0; i < n; i++) {
			cards.add(new Card('D', i+1));
		}
		for (i = 0; i < n; i++) {
			cards.add(new Card('C', i+1));
		}
	}
	public void deal(CardHand hand, int n){
		int topIndex = getCardCount()-1;
		for (int i = topIndex; i > topIndex-n; i--) { // could be problem
			hand.addCard(getCard(i));
			cards.remove(i);
		}
	}
	public void shufflePerfectly(){
		ArrayList<Card> tempCards = new ArrayList<Card>();
		for (int i = 0; i < getCardCount()/2; i++) {
			
			tempCards.add(getCard(i));
			tempCards.add(getCard(i+getCardCount()/2));
		}
		cards = tempCards;
	}
}