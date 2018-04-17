package cc222ip_assign1;

/**
 * @author Chris_Chevalier
 *
 */
public class Play123Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Play123Main game = new Play123Main();
	
		if(game.play123())
			System.out.println("You win !");
		else
			System.out.println("You loose...");
		
		int c = 0;
		int vCount = 0;
		while(c < 10000) {
			if(game.play123()) {
				vCount++;
			}
			c++;
		}
		float prob = (vCount / 10000.f) * 100;
		System.out.println("Probability (%) that you win the game: " +  prob + "%");
	}
	
	/**
	 * @return
	 */
	public boolean play123() {
		Deck d = new Deck();
		d.shuffle();
		int count = 1;
		while(!d.isEmpty()) {
			Card t = d.handOutNextCard();
			if(count == 4)
				count = 1;
			if(t.toString().contains("Ace") && count == 1)
				return false;
			else if(t.toString().contains("Two") && count == 2)
				return false;
			else if(t.toString().contains("Three") && count == 3)
				return false;
			count++;
		}
		return true;
	}
}
