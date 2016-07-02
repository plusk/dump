package o6;

import java.util.ArrayList;
import java.util.Iterator;

public class CardDeck implements CardContainer {
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public CardDeck(int n){
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
	public Iterator<Card> iterator(){
		return cards.iterator();
	}
}