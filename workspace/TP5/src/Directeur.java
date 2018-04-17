/**
 * Un directeur est une sorte d'employé.
 */
public class Directeur extends EmployeBase {
	private Directeur() {
		
	}
	
	/**
	 * Pour qu'il n'y ait qu'un directeur à la fois (Singleton) :
	 */
	private static Directeur dir;
	
	private static Directeur getInstance() {
		if(dir == null) {
			dir = new Directeur();
		}
		return dir;
	}

	int salaire() {
		sal += 0.004 * caTotal;
		return sal;
	}
}
