import java.util.ArrayList;

/**
 * Classe constituant la liste des achats.
 * @author Chris_Chevalier
 */
public class ListeDAchats extends ArrayList<Achat> {
	ArrayList<Achat> list = new ArrayList<Achat>(100); // Capacité de 100 achats.
	
	public ListeDAchats(ArrayList<Achat> list) {
		this.list = list;
	}
	
	/**
	 * Permet d'ajouter un achat à la liste d'achats.
	 * @param a
	 */
	public void ajouter(Achat a) {
		list.add(a);
	}
	
	/**
	 * Méthode qui affiche le contenu d'une liste d'achats.
	 */
	public void affiche() {
		for(int i = 0; i < this.list.size(); i++) {
			System.out.println(list.get(i).refArt + " * " + list.get(i).nbArt);
		}
	}
}