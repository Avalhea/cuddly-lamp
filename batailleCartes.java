import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class batailleCartes {

    static int[][] tableau;
    static int valeurCarte;

    public static void initialisation() {
        tableau = new int[2][52];

        int coef = 0;
        for (coef = 0; coef < 4; coef++) {
            for (int i = 0; i < 2; i++) {
                valeurCarte = 1;
                for (int j = coef * 13; j < 13 * (coef + 1); j++) {
                    if (i == 0) {
                        tableau[i][j] = 1 * (coef + 1);
                    } else {
                        tableau[i][j] = valeurCarte;
                        valeurCarte++;
                    }
                }
            }
        }

    }

    public static int random() {

        int pioche = 0;
        int r = 0;

        r = ThreadLocalRandom.current().nextInt(0, 52);

        while (tableau[1][r] == 0) {
            r = ThreadLocalRandom.current().nextInt(0, 52);
        }

        return r;
    }

    public static int pioche(int r) {

        int vC = tableau[1][r];
        tableau[1][r] = 0;
        return vC;
    }

    public static char couleur(int r) {

        char color = ' ';

        switch (tableau[0][r]) {
            case 1:
                color = '♥';
                break;
            case 2:
                color = '♠';
                break;
            case 3:
                color = '♦';
                break;
            case 4:
                color = '♣';
                break;
        }
        return color;
    }

    public static int ptsJ1 = 0;
    public static int ptsJ2 = 0;

    public static void comparaison(int j1, int j2) {


        if (j1 > j2) {
            System.out.println("Le joueur 1 gagne ce tour! ");
            ptsJ1 = ptsJ1 + 1;

        }
        if (j2 > j1) {
            System.out.println("Le joueur 2 gagne ce tour! ");
            ptsJ2 = ptsJ2 + 1;
        }
        if (j2 == j1) {
            System.out.println("Égalité !");
        }
        System.out.println("Le joueur 1 a gagné " + ptsJ1 + " manches.");
        System.out.println("Le joueur 2 a gagné " + ptsJ2 + " manches.");

    }

    public static void afficherTableau() {
        for (int coef = 0; coef < 4; coef++) {
            for (int i = 0; i < 2; i++) {
                for (int j = coef * 13; j < 13 * (coef + 1); j++) {
                    System.out.print(tableau[i][j]);
                }
                System.out.println("");
            }
        }
    }

    public static int verification() {
        int v = 0;
        for (int j = 0; j < 52; j++) {
            int valeur = tableau[1][j];
            v = v + valeur;
        }
        return v;
    }

    public static void pause() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

// public char[] readPassword() {
//     char readpassword;
//     return readPassword("");
// }

    static int jouer;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        initialisation();
        int joueur = 1;

        int carteJ1 = 0;
        int carteJ2 = 0;
        int verif = verification();

        do {

            if (verif != 0) {

                int r = random();
                System.out.println(
                        "Joueur 1, saisissez un chiffre positif pour piocher votre carte. Saisissez -1 pour arrêter la partie");
                jouer = scan.nextInt();
                //jouer = readPassword("");

                carteJ1 = pioche(r);
                char colorJ1 = couleur(r);
                joueur = joueur + 1;
                pause();
                System.out.println("Joueur 1 pioche un " + carteJ1 + " de " + colorJ1);

                r = random();
                pause();
                System.out.println(
                        "Joueur 2, saisissez un chiffre positif pour piocher votre carte. Saisissez -1 pour arrêter la partie");
                jouer = scan.nextInt();
                carteJ2 = pioche(r);
                char colorJ2 = couleur(r);
                joueur = joueur - 1;
                pause();
                System.out.println("Joueur 2 pioche un " + carteJ2 + " de " + colorJ2);
                pause();
                comparaison(carteJ1, carteJ2);
            }

            else {
                System.out.println("Merci d'avoir joué !");
            }

        } while (jouer != -1 && verif != 0);
        
    }
}