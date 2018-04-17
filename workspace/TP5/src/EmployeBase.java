abstract class EmployeBase {
	protected String nom;
	protected int sal;
	protected int prime;
	protected int nbHeures;
	protected int tauxHoraire;
	protected int caTotal;
	protected int txHSup;
	
	/**
	 * Fonction qui calcul le salaire d'un employé.
	 */
	abstract int salaire();
}
