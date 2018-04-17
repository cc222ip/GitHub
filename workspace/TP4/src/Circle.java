class Circle implements GeomFig {
	private double rayon;

	public Circle(double r) throws ExceptionFig {
		if(r <= 0) // Test la conformité du paramètre.
			throw new ExceptionFig("Circle", "Le rayon d'un cercle doit être supérieur à 0."); // Affiche un message en cas de non conformité.

		this.rayon = r; // Renseigne l'attribut "rayon" avec l'attribut conforme.
	}

	public double perimeter() { // Fonction de "GeomFig".
		return 2 * Math.PI * rayon; // Retourne le périmètre du cercle.
	}
}