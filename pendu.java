
import java.util.Scanner;
import java.util.Arrays;

public class pendu {

    public static void sauterLigne() {
        for (int i = 0; i < 50; i++)
            System.out.println();
    }

    static Scanner scan = new Scanner(System.in);
    static char[] tabMotCache;
    static boolean boucle = false;
    static int tentatives = 11;
    static boolean pasEssais = false;

    public static void main(String[] args) {

        String mot = " ";
        mot = scan.nextLine();
        sauterLigne();
        char[] tabMot = mot.toCharArray();

        int tailleMot = mot.length();
        tabMotCache = new char[tailleMot];

        for (int i = 0; i < tailleMot; i++) {
            if (tabMot[i] != '-') {
                tabMotCache[i] = '_';
            }
            if (tabMot[i] == '-') {
                tabMotCache[i] = '-';
            }
            System.out.print(tabMotCache[i]);

        }
        System.out.println();

        do {
            if (tentatives > 0 && boucle == true)
                ;
            {
                System.out.println("proposez une lettre");
                String l = scan.nextLine();
                char lettre = l.charAt(0);

                for (int i = 0; i < tailleMot; i++) {
                    if (tabMot[i] == lettre) {
                        tabMotCache[i] = lettre;
                        pasEssais = true;
                    }
                    else {
                        pasEssais = false;
                    }

                    System.out.print(tabMotCache[i]);

                }
                System.out.println("");

                if (pasEssais == false){
                    tentatives = tentatives - 1;
                }

                if (java.util.Arrays.equals(tabMotCache, tabMot)) {
                    boucle = true;

                } else {
                    boucle = false;
                }
            }
        } while (tentatives > 0 && boucle == false);

        if (boucle == true) {
            System.out.println("Bravo!!");
        } else {
            System.out.println("Pendu!");
        }
    }
}
