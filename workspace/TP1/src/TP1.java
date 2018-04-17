/**
 * @author Chris_Chevalier
 * @version 1.0
 */

class TP1 { //Toujours avec une majuscule
    public static void main(String[] args) {
        exo1a(args);
        exo1b(args);
        exo2(args);
        exo3(args);
    }

    public static void exo1a(String[] args) {
        System.out.println("Ex. 1 - a) :");
        for(int i = args.length - 1; i >= 0; i--) {
            System.out.println(args[i]);
        }
    }

    public static void exo1b(String[] args) {
        System.out.println("Ex. 1 - b) :");
        for(int i = args.length - 1; i >= 0; i--) {
            for(int j = args[i].length() - 1; j >= 0; j--) {
                System.out.print(args[i].charAt(j));
            }
            System.out.println();
        }
    }

    public static void exo2(String[] args) {
        System.out.println("Ex. 2 :");
        int a = Integer.valueOf(args[0]);
        int b = Integer.valueOf(args[1]);
        int c = Integer.valueOf(args[2]);
        double d = b * b - 4 * a * c;
        if(d < 0) {
            System.out.println("Pas de solution.");
        }
        else if(d == 0) {
            int x = -b / (2 * a);
            System.out.println("Une solution à l'équation : " + x);
        }
        else if(d > 0) {
            double x1 = (-Math.sqrt(d) - b) / (2 * a);
            double x2 = (Math.sqrt(d) - b) / (2 * a);
            System.out.println("Deux solutions à l'équation : " + x1 + " et " + x2);
        }
    }
    public static void exo3(String[] args) {
        System.out.println("Ex. 3 :");
        boolean correct = true;
        int jour = Integer.valueOf(args[0]);
        int mois = Integer.valueOf(args[1]);
        int annee = Integer.valueOf(args[2]);
        if(mois > 12 || mois < 1) {
            correct = false;
            System.out.println("Le mois est incorrect.");
        }
        else if(mois == 1||mois == 3||mois == 5||mois == 7||mois == 8||mois == 10||mois == 12) { //Mois à 31 jours
            if(jour < 1 || jour > 31) {
                correct = false;
                System.out.println("La date est incorrecte.");
            }
            else if(jour == 31) {
                jour = 1;
                if(mois == 12) {
                    mois = 1;
                    annee = annee + 1;
                }
                else {
                    mois = mois + 1;
                }
            }
            else {
                jour = jour + 1;
            }
        }
        else if(mois == 4||mois == 6||mois == 9||mois == 11) { //Mois à 30 jours
            if(jour < 1 || jour > 30) {
                correct = false;
                System.out.println("La date est incorrecte.");
            }
            else if(jour == 30) {
                jour = 1;
                if(mois == 12) {
                    mois = 1;
                    annee = annee + 1;
                }
                else {
                    mois = mois + 1;
                }
            }
            else {
                jour = jour + 1;
            }
        }
        else if(mois == 2) { //Février
            if(annee % 4 == 0) { // Année bisextile
                if(jour < 1 || jour > 29) {
                    correct = false;
                    System.out.println("La date est incorrecte.");
                }
                else if(jour == 29) {
                    jour = 1;
                    if(mois == 12) {
                        mois = 1;
                        annee = annee + 1;
                    }
                    else {
                        mois = mois + 1;
                    }
                }
                else {
                    jour = jour + 1;
                }
            }
            else {
                if(jour < 1 || jour > 28) { // Année non bisextile
                    correct = false;
                    System.out.println("La date est incorrecte.");
                }
                else if(jour == 28) {
                    jour = 1;
                    if(mois == 12) {
                        mois = 1;
                        annee = annee + 1;
                    }
                    else {
                        mois = mois + 1;
                    }
                }
                else {
                    jour = jour + 1;
                }
            }
        }
        if(correct == true) {
            System.out.println("Demain, nous serons le " + jour + "/" + mois + "/" + annee);
        }
    }
}
