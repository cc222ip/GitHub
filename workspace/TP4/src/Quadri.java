class Quadri extends Polygon { // Le quadrilatère est une sorte de polygone.
	public Quadri(double a, double b, double c, double d) throws ExceptionFig {

		super(4); // Appelle le constructeur de la classe mère (Polygon) avec '4' en "nbSides".
		if(a <= 0 || b <= 0 || c <= 0 || d <= 0) // Vérifie la conformité des donnéees passées en argument.
			throw new ExceptionFig("Quadri", "Les côtés d'un quadrilatère doivent être supérieurs à 0."); // Affiche un message en cas de non conformité.

		this.t[0] = a; // Initialise les cases du tableau de la classe Polygon avec les valeurs des côtés du quadrilatère.
		this.t[1] = b;
		this.t[2] = c;
		this.t[3] = d;
	}
}