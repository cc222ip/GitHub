/**
 * <i>La classe TP2 correspond aux question posées dans le TP2.</i>
 * @author Chris_Chevalier
 * @version 1.0
 */
class TP2 {
    /**
     * Fonction principal de la classe TP2.
     * @param args
     */
    public static void main(String[] args) {
        // Vector :
        Vector vec = new Vector(); // Premier vecteur créé

        vec.initialize(args);
        System.out.print("- Vecteur initialisé depuis le terminal : ");
        vec.display();
        System.out.println();

        vec.multiply(args);
        System.out.print("- Multiplication des composantes par le 1er argument : ");
        vec.display();
        System.out.println();

        Vector v1 = new Vector(1, 2, 3); // Deuxième vecteur créé
        System.out.print("- Création du vecteur v1 : ");
        v1.display();
        System.out.println();

        Vector v2 = new Vector(5, 6, 4); // Troisième vecteur créé
        System.out.print("- Création du vecteur v2 : ");
        v2.display();
        System.out.println();

        Vector som = v1.somme(v2); // Quatrième vecteur créé
        System.out.println("- Somme de v1 et v2 : " + som);
        System.out.println();

        int mul = v1.mult(v2);
        System.out.println("- Multiplication de v1 par v2 : " + mul);
        System.out.println();

        System.out.println("- Nombre de vecteurs créés : " + v1.nbVector());
        System.out.println();

        System.out.print("- v1 en chaîne de caractères : ");
        System.out.println(v1.toString());
        System.out.println();

        // PairVect :
        PairVect v = new PairVect(1, 2, 4, 5, 3, 6);
        PairVect w = new PairVect(v1, v2);

        System.out.println("- Affichage du premier PairVect (v) : ");
        v.displayV1();
        v.displayV2();
        System.out.println();

        System.out.println("- Affichage du second PairVect (w) composé de v1 et v2 : ");
        w.displayV1();
        w.displayV2();
        System.out.println();

        v1.initialize(6);
        w.displayV1();
    }
}

/**
 * <u>Classe Vecteur</u> : Elle permet de créer des vecteurs à 3 composantes.
 * @author Chris_Chevalier
 */
class Vector {
    // Composantes :
    private int a;
    private int b;
    private int c;
    private static int count = 0;

    public void initialize(String [] args) { // Attribue des valeurs aux composantes
        this.a = Integer.valueOf(args[0]);
        this.b = Integer.valueOf(args[1]);
        this.c = Integer.valueOf(args[2]);
    }

    public void initialize(int val) { // Attribue des valeurs aux composantes
        this.a = val;
        this.b = val;
        this.c = val;
    }

    public void multiply(String [] args) { // Multiplie les composantes par une valeur fournie en argument
        this.a = this.a * Integer.valueOf(args[0]);
        this.b = this.b * Integer.valueOf(args[0]);
        this.c = this.c * Integer.valueOf(args[0]);
    }

    public void display() { // Affiche les composantes du vecteur
        System.out.println(a + " " + b + " " + c);
    }

    public Vector(String [] args) { // Constructeur remplaçant la méthode initialize
        this.a = Integer.valueOf(args[0]);
        this.b = Integer.valueOf(args[1]);
        this.c = Integer.valueOf(args[2]);
        count++;
    }

    public Vector() { // Constructeur sans arguments initialisant chaque composante à 0
        this.a = 0;
        this.b = 0;
        this.c = 0;
        count++;
    }

    public Vector(int x, int y, int z) { // Constructeur avec 3 arguments représentant les composants
        this.a = x;
        this.b = y;
        this.c = z;
        count++;
    }

    public int mult(Vector v2) { // Multiplie 2 vecteurs
        return (this.a * v2.a) + (this.b * v2.b) + (this.c * v2.c);
    }

    public Vector somme(Vector v2) {
        int x = this.a + v2.a;
        int y = this.b + v2.b;
        int z = this.c + v2.c;
        Vector v = new Vector(x, y, z);
        return v;
    }

    public int nbVector() {
        return count;
    }

    public String toString() {
        String s = String.valueOf(this.a) + " " + String.valueOf(this.b) + " " + String.valueOf(this.c);
        return s;
    }
}

/**
 * @author Chris_Chevalier
 *
 */
class PairVect {
    private Vector v1;
    private Vector v2;

    public PairVect(int aa, int bb, int cc, int dd, int ee, int ff) {
        v1 = new Vector(aa, bb, cc);
        v2 = new Vector(dd, ee, ff);
    }

    public PairVect(Vector vec1, Vector vec2) {
        v1 = vec1;
        v2 = vec2;
    }

    public void displayV1() { // Affiche les composantes du vecteur
        v1.display();
    }

    public void displayV2() { // Affiche les composantes du vecteur
        v2.display();
    }
}
