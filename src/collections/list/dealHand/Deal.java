package collections.list.dealHand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deal {
	public static void main(String[] args) {
		
		int numHands = 4;
		int cardsPerHand = 5;
		
		List<Card> deck = new ArrayList<>();
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(s, r));
			}
		}
		
		Collections.shuffle(deck);
		
		for (int i = 0; i < numHands; i++) {
			System.out.println(dealHand(deck, cardsPerHand));
		}
		
		System.out.println("Cards left in the deck: " + deck.size());
	}
	
	public static <E> List<E> dealHand(List<E> deck, int n) {
		int deckSize = deck.size();
		List<E> handView = deck.subList(deckSize - n, deckSize);
		List<E> hand = new ArrayList<>(handView);
		handView.clear();
		return hand;
	}
}
