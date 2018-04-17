class Square extends Polygon { // Le carré est une sorte de polygone.
	public Square(double a) throws ExceptionFig {
		super(1); // Appelle le constructeur de la classe mère (Polygon) avec '1' en "nbSides".
		if(a <= 0) // Vérifie la conformité des donnéees passées en argument.
			throw new ExceptionFig("Square", "La taille d'un carré doit être supérieure à 0."); // Affiche un message en cas de non conformité.

		this.t[0] = a; // Initialise la case '0' du tableau de la classe Polygon avec la valeura des côtés du carré.
	}

	public double perimeter() throws ExceptionFig { // Surcharge de la classe Square.
		return this.t[0] * 4;
	}
}