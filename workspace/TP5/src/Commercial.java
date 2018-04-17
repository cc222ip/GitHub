/**
 *  Un commercial est une sorte d'employé.
 */
public class Commercial extends EmployeBase {
	/**
	 * Chiffre d'affaire réalisé par le commercial.
	 */
	protected static int ca;
	
	int salaire() {
		sal += (ca * 0.01) ; // Calcul du salaire avec ajout de 1% du CA réalisé par le commercial.
		return sal;
	}
	
	/**
	 * Calcul le cumul des CA réalisés par les différents commerciaux.
	 */
	public int cumulCA() {
		caTotal += ca;
		return caTotal;
	}
	
}
