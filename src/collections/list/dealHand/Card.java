package collections.list.dealHand;

public class Card {
	
	Suit suit;
	Rank rank;

	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}
	
}
