import java.util.Arrays;

class TP3 {
    public static void main(String[] args) {
        Vector a = new Vector(1, 5, 7);
        Vector b = new Vector(8, 4, 2);
        System.out.print("Vecteur a : ");
        a.display();
        System.out.print("Vecteur b : ");
        b.display();
        System.out.println();

        System.out.println("Échange des vecteurs a et b...");

        System.out.println();
        b.echange(a, b);
        System.out.print("Vecteur a : ");
        a.display();
        System.out.print("Vecteur b : ");
        b.display();

        System.out.println();
        System.out.println("Matrice de doubles :");
        DoubleArray p = new DoubleArray();
        double Tab[][] = {{3.6, 5.2}, {5.3, 8.7}};
        p.display(Tab);

        System.out.println();
        System.out.println(p.regular(Tab));
        System.out.println();

        System.out.println("Somme des lignes :");
        double t[] = p.lineSum(Tab);
        for(int i = 0; i < t.length; i++) {
            System.out.println(t[i]);
        }
        System.out.println();

        System.out.println("Somme de 2 matrices :");
        double P[][] = p.sum(Tab, Tab);
        if(P != null) {
            p.display(P);
        }
        else {
            System.out.println("Les matrices ne respectent pas les conditions.");
        }
        System.out.println();

        System.out.println("Index :");
        System.out.println();

        Index I = new Index(10);

        Subscriber s = new Subscriber("Toto", "0656789856");
        Subscriber s1 = new Subscriber("Titi", "0455678560");
        Subscriber s2 = new Subscriber("Tata", "0434565678");

        System.out.println("L'ajout d'abonné s'est-il bien passé ('Toto') ?");
        System.out.println(I.addSubscriber(s));

        I.addSubscriber(s1);
        I.addSubscriber(s2);

        System.out.println();

        System.out.println("Affichage :");
        I.display();
        System.out.println();

        System.out.println("Recherche d'un abonné par nom ('Titi') :");
        System.out.println(I.getNumber("Titi"));
        System.out.println();

        System.out.print("Nombre d'abonné(s) : ");
        System.out.println(I.getNbSubscribers());
        System.out.println();

        System.out.println("Afficher l'abonné numéro 2 :");
        I.getSubscriber(2).display();
        System.out.println();

        System.out.println("Index trié par ordre alphabétique :");
        Subscriber[] tmp = I.getSortedSubscribers();
        for(Subscriber x : tmp) {
        	x.display();
        }
    }
}

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

    public void echange(Vector v1, Vector v2) {
        int tmp = v1.a;
        v1.a = v2.a;
        v2.a = tmp;
        tmp = v1.b;
        v1.b = v2.b;
        v2.b = tmp;
        tmp = v1.c;
        v1.c = v2.c;
        v2.c = tmp;
    }
}

class DoubleArray {
    public static void display(double t[][]) {
        for(int i = 0; i < t.length; i++) {
            for(int j = 0; j < t[i].length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean regular(double [][]t) {
        int tmp = t.length;
        for(int i = 0; i < t.length; i++) {
            if(tmp != t[i].length) {
                return false;
            }
        }
        return true;
    }

    public static double[] lineSum(double[][]t) {
        double sum[] = new double[t.length];
        for(int i = 0; i < t.length; i++) {
            for(int j = 0; j < t[i].length; j++) {
                sum[i] += t[i][j];
            }
        }
        return sum;
    }

    public static double [][]sum(double [][]t1, double [][]t2) {
        if(regular(t1) && regular(t2)) {
            if(t1[0].length == t2[0].length) {
                double sum[][] = new double[t1.length][t1.length];
                for(int i = 0; i < t1.length; i++) {
                    for(int j = 0; j < t1[i].length; j++) {
                        sum[i][j] += t1[i][j] + t2[i][j];
                    }
                }
                return sum;
            }
        }
        return null;
    }
}

class Subscriber implements Comparable <Subscriber> {
    public String nom;
    public String numero;

    public Subscriber(String name, String num) {
        nom = name;
        numero = num;
    }

    public void display() {
        System.out.println(this.nom + " : " + this.numero);
    }

    public String getNom() {
        return this.nom;
    }

    public String getNum() {
        return this.numero;
    }

    public int compareTo(Subscriber s) {
        return nom.compareTo(s.nom);
    }
}

class Index {
    private int num_sub;
    private int nbMax;
    public Subscriber []S;

        public Index(int n) {
            num_sub = 0;
            nbMax = n;
            S = new Subscriber[n];
        }

        public boolean addSubscriber(Subscriber s) {
            if(num_sub < nbMax) {
                S[num_sub++] = s;
                return true;
            }
            return false;
        }

        public void display() {
            for(int i = 0; i < num_sub; i++) {
                S[i].display();
            }
        }

        public String getNumber(String name) {
            for(int i = 0; i < num_sub; i++) {
                if(S[i].getNom() == name) {
                    return S[i].getNum();
                }
            }
            return "Le nom demandé n'apparaît pas dans le répertoire.";
        }

        public int getNbSubscribers() {
            return num_sub;
        }

        public Subscriber getSubscriber(int t) {
            if(t <= num_sub) {
            	return S[t];
            }
            return null;
        }

        public Subscriber[] getSortedSubscribers() {
        	Subscriber tmp[] = new Subscriber[num_sub];
        	for(int i = 0; i < num_sub; i++) {
        		tmp[i] = S[i];
        	}
            Arrays.sort(tmp);
            return tmp;
        }
}
