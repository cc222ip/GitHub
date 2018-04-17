class Polygon implements GeomFig {
	protected double t[] ; // Les classes filles peuvent utiliser ce tableau T.

	public Polygon(int n) throws ExceptionFig {
		if(n <= 0) // Test la conformité du paramètre.
			throw new ExceptionFig("Polygon", "Le nombre de côté d'un polygone doit être supérieur à 0."); // Affiche un message en cas de non conformité.

		t = new double[n]; // Création du tableau de la taille du nombre de côtés du polygone.
	}

	public double perimeter() throws ExceptionFig { // Fonction de "GeomFig".
		double p = 0; // Stocke le paramètre du polygone.
		if(t == null) // Test la conformité du paramètre.
			throw new ExceptionFig("Tableau", "L'objet créé est nul."); // Affiche un message en cas de non conformité.

		for(int i = 0; i < t.length; i++) { // Stocke les valeurs des côtés du polygone dans le tabeau 't'.
			p += t[i];
		}
		return p;
	}
}