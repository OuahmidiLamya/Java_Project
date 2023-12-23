package Main;
import Controlleurs.*;

import java.util.Scanner;
public class Main {
    public static boolean isNull(Object ob) {
        return ob == null ;
    }
    public static int getIntInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un nombre entier : ";
        if (msg.length > 0 )
            message = msg[0] ;
        System.out.print(message);
        int num = scan.nextInt();
        return num;
    }
    public static float getFloatInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un nombre float : ";
        if (msg.length > 0)
            message = msg[0];
        System.out.print(message);
        float num = scan.nextFloat();
        return num;
    }

    public static long getLongInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un nombre long : ";
        if (msg.length > 0)
            message = msg[0];
        System.out.print(message);
        long num = scan.nextLong();
        return num;
    }
    public static String getStringInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un texte : ";
        if (msg.length > 0 )
            message = msg[0] ;
        System.out.print(message);
        String str = scan.nextLine();
        return str;
    }
    public static void showPrincipalMenu(){
        System.out.println("-------------------------[ Bienvenu ]---------------------------");


        System.out.println("1: Pour gérer les départements");
        System.out.println("2: Pour gérer les enseignants");
        System.out.println("3: Pour gérer les étudiants");
        System.out.println("4: Pour gérer les filières");
        System.out.println("5: Pour gérer les modules");
        System.out.println("6: Pour gérer les notes");
        System.out.println("0: Pour sortir");

        int option = getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                DepartementControlleur.showMenu();
                break;
            case 2:
                EnseignantControlleur.showMenu();
                break;
            case 3:
                EtudiantControlleur.showMenu();
                break;
            case 4:
                FiliereControlleur.showMenu();
                break;
            case 5:
                ModuleControlleur.showMenu();
                break;
            case 6:
                NoteControlleur.showMenu();
                break;

            default:
                System.out.println("Option invalide. Veuillez réessayer.");
                showPrincipalMenu();
        }
    }
    public static void main(String[] args) {

        showPrincipalMenu();
    }
}
