package cc222ip_assign1;

import java.util.Random;
import java.util.Stack;

/**
 * @author Chris_Chevalier
 *
 */
public class Deck {

	private Stack<Card> stack = new Stack<Card>();

	public Deck() {
		for(Card.suite s : Card.suite.values()) {
			for(Card.rank r : Card.rank.values()) {
				Card c = new Card(s, r);
				stack.push(c);
			}   
	    }
	}
	
	public void shuffle() {
		if(stack.size() != 52) {
			System.out.println("The deck must have 52 cards to shuffle.");
			return;
		}
		Random rand = new Random();
		int r;
		
		Stack<Card> stack2 = new Stack<Card>();
		while(!stack.isEmpty()) {
			r = rand.nextInt(stack.size());
			stack2.push(stack.elementAt(r));
			stack.remove(r);
		}	
		stack = stack2;
	}
	
	public void display() {
		for(int i = 0; i < stack.size(); i++) {
			System.out.println(stack.elementAt(i));
		}
	}
	
	/**
	 * @return
	 */
	public Card handOutNextCard() {
		return stack.pop();
	}
	
	/**
	 * @return
	 */
	public int deckSize() {
		return stack.size();
	}
	
	/**
	 * @return
	 */
	public boolean isEmpty() {
		if(stack.isEmpty())
			return true;
		return false;
	}
}
