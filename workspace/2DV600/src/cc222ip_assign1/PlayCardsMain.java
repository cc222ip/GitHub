package cc222ip_assign1;

/**
 * @author Chris_Chevalier
 *
 */
public class PlayCardsMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Deck d = new Deck();
		d.shuffle();
		System.out.println("You've drawn: " + d.handOutNextCard());
		System.out.println("You've drawn: " + d.handOutNextCard());
		System.out.println("List of remaining card : ");
		d.display();
		System.out.println("Number of remaining cards: " + d.deckSize());
	}
}
