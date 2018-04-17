
/**
 * Classe permettant de gérer les exceptions.
 * @author Chris_Chevalier
 */
public class Except extends Exception {
	String type;
	/**
	 * Constructeur d'Except - Renvoi un message d'erreur si besoin.
	 * @param type
	 * @param msg
	 */
	public Except(String type, String msg) {
		super(type + " - " + msg);
		this.type = type;
	}
}
