package cc222ip_assign1;

public class Card {
	
	public enum suite {
		  Heart,
		  Diamond,
		  Spade,
		  Club;
	}
	
	public enum rank {
		  Ace,
		  Two,
		  Three,
		  Four,
		  Five,
		  Six,
		  Seven,
		  Eight,
		  Nine,
		  Ten,
		  Jack,
		  Queen,
		  King;
	}
	private suite s;
	private rank r;
	
	public Card(suite ss,rank rr) {
		s = ss;
		r = rr;
	}
	
	public String toString() {
		return r + " of " + s;
	}
}
