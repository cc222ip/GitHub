class Triangle extends Polygon { // Un triangle est une sorte de polygone.
	public Triangle(double a, double b, double c) throws ExceptionFig {
		super(3); // Appelle le constructeur de la classe mère (Polygon) avec '3' en "nbSides".
		if(a <= 0 || b <= 0 || c <= 0) // Vérifie la conformité des donnéees passées en argument.
			throw new ExceptionFig("Triangle", "Les côtés d'un triangle doivent être supérieure à 0."); // Affiche un message en cas de non conformité.

		this.t[0] = a; // Initialise les cases du tableau de la classe Polygon avec les valeurs des côtés du triangle.
		this.t[1] = b;
		this.t[2] = c;
	}
}
