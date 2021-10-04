import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class batailleNavale {



    public static int randomX() {
        int x = ThreadLocalRandom.current().nextInt(0, 3 + 1);
        return x;
    }

    public static int randomY() {
        int y = ThreadLocalRandom.current().nextInt(0, 3 + 1);
        return y;
    }

    static char[][] plateau;

    static final int TAILLE = 4;

    public static void initialisationPlateau() {

        plateau = new char [4][4];
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                plateau[i][j] = '?';
            }
        }

    }

    public static void affichagePlateau() {

        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                System.out.print(plateau[j][i]);
            }
            System.out.println(" ");
        }

    }

    public static void main(String[] args) {
        
        int rejouer = 0;
        do {
            int propositionColonne = 10;
            int propositionLigne = 10;
            int X = randomX();
            int Y = randomY();

            initialisationPlateau();
            int essais = 0;

            do {
                affichagePlateau();
                Scanner scan = new Scanner(System.in);

                System.out.println("Quelle colonne ?");
                propositionColonne = scan.nextInt();
                propositionColonne = propositionColonne - 1;
            
                System.out.println("Quelle ligne ?");
                propositionLigne = scan.nextInt();
                propositionLigne = propositionLigne - 1;


                if (propositionColonne != X || propositionLigne != Y) {

                    System.out.println("Plouf ! À l'eau !!");
                    plateau[propositionColonne][propositionLigne] = '~';
                    
                    essais ++;
                } 
                
                

            } while (propositionColonne != X || propositionLigne != Y);

            
            Scanner scan2 = new Scanner(System.in);
            if (propositionColonne == X & propositionLigne == Y) {

                System.out.println("Vous avez gagné en " +(essais + 1) + " essais! Voulez vous rejouer ?");
                System.out.println(" 1. Oui ");
                System.out.println(" 2. Non ");

                rejouer = scan2.nextInt();

            }

            else {
                System.out.println("Vous avez perdu ! Voulez vous réessayer ?");
                System.out.println(" 1. Oui ");
                System.out.println(" 2. Non ");

                rejouer = scan2.nextInt();
            }

        } while (rejouer != 2);
    }
}
