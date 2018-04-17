class Rectangle extends Polygon {
    public Rectangle(double larg, double longueur) throws ExceptionFig {
    	super(4); // Appelle le constructeur de la classe mère (Polygon) avec '4' en "nbSides".
    	if(larg <= 0 || longueur <= 0) // Vérifie la conformité des donnéees passées en argument.
    		throw new ExceptionFig("Rectangle", "La largeur et la longueur d'un rectangle doivent être supérieures à 0."); // Affiche un message en cas de non conformité.
    	
    	this.t[0] = this.t[1] = larg; // Initialise les cases du tableau de la classe Polygon avec les valeurs des côtés du rectangle.
    	this.t[2] = this.t[3] = longueur;
    }
}