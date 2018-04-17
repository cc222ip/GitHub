class TP4 {
	public static void main(String[] args) throws ExceptionFig {
		Circle c = null; // Déclare les différentes figures avec une initialisation à "null".
		Quadri q = null;
		Rectangle r = null;
		Square s = null;
		Triangle t = null;
		try {
			c = new Circle(3); // Création des figures à l'aide de leur constructeur avec des attributs choisis arbitrairement.
			q = new Quadri(1, 2, 3, 4);
			r = new Rectangle(3, 4);
			s = new Square(3);
			t = new Triangle(2, 3, 4);
		}
		catch(ExceptionFig ef) { // En cas de non conformité des attributs.
			System.out.println(ef.getMessage()); // Affiche un message d'erreur.
			System.exit(-1); // Quitte le programme.
		}
		System.out.println("- Périmètre du cercle = "+ c.perimeter());
		System.out.println("- Périmètre du quadrilatère = "+ q.perimeter());
		System.out.println("- Périmètre du rectangle = "+ r.perimeter());
		System.out.println("- Périmètre du carré = "+ s.perimeter());
		System.out.println("- Périmètre du triangle = "+ t.perimeter());
	}
}