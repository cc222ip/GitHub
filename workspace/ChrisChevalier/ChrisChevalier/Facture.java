import java.util.ArrayList;

/**
 * Stocke les factures éditées.
 * @author Chris_Chevalier
 */
public class Facture {
	String num;
	ListeDAchats list;
	
	/*
	 * Constructeur de facture.
	 * @param num
	 */
	public Facture(String num, ListeDAchats list) {
		this.num = num;
		this.list = list;
	}
	
	/**
	 * Méthode permettant de mettre à jour la liste d'achat via une facture.
	 * @param ref
	 * @param nbArt
	 * @throws Except
	 */
	public void acheter(String ref, int nbArt) throws Except {
		Achat a = new Achat(ref, nbArt);
		list.ajouter(a);
	}
	
	/**
	 * Méthode qui affiche différents détails importants de la facture.
	 */
	public void afficheDetails() {
		System.out.println("N° de facture : " + this.num);
		list.affiche();
	}
}