
/**
 * Classe stockant les différents articles
 * @author Chris_Chevalier
 */
public class Article {
	String ref;
	double prix;
	
	/**
	 * Constructeur de la classe article.
	 * @param ref
	 * @param prix
	 */
	public Article(String ref, double prix) throws Except {
		if(prix < 0) {
			throw new Except("Double", "ATTENTION ! Le prix d'un article doit être supérieur à zéro !");
		}
		this.ref = ref;
		this.prix = prix;
	}
	
	/**
	 * Accesseur du prix d'un article.
	 * @return
	 */
	public double getPrix() {
		return this.prix;
	}
	
	/**
	 * Accesseur de la référence d'un article.
	 * @return
	 */
	public String getReference() {
		return this.ref;
	}
}
