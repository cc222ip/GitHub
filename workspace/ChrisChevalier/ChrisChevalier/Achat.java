
/**
 * Classe stockant les achats.
 * @author Chris_Chevalier
 */
public class Achat {
	Article a;
	String refArt;
	int nbArt;
	
	/**
	 * Constructeur de la classe Achat.
	 * @param refArt
	 * @param nbArt
	 */
	public Achat(String refArt, int nbArt) throws Except {
		if(nbArt < 0) {
			throw new Except("Int", "ATTENTION ! Le nombre d'articles doit être supérieur à zéro !");
		}
		this.refArt = refArt;
		this.nbArt = nbArt;
	}
	
	/**
	 * Accesseur du nombre d'articles achetés.
	 * @return
	 */
	public int getNbArt() {
		return this.nbArt;
	}
	
	
	/**
	 * Accesseur de l'article acheté.
	 * @return
	 */
	public Article getArt() {
		return this.a;
	}
}
