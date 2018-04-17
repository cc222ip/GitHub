import java.util.ArrayList;

/**
 * Classe test - Utilisé pour effecter divers tests sur l'application.
 * @author Chris_Chevalier
 */
public class Test {
	public static void main(String[] args) {
		Article ordi = null;
		Article pc = null;
		Achat a = null;
		Achat b = null;
		ListeDAchats list = null;
		Facture fact = null;
		ArrayList<Achat> l = new ArrayList<Achat>(100); // Capacité de 100 achats.
		try {
			ordi = new Article("Ordinateur", 399.99);
			pc = new Article("PC", 599.99);
			a = new Achat(ordi.ref, 1);
			b = new Achat(pc.ref, 2);
			list = new ListeDAchats(l);
			list.ajouter(a);
			list.ajouter(b);
			fact = new Facture("001", list);
			fact.afficheDetails();
		}
		catch(Except e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}
}
