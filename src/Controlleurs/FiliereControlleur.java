package Controlleurs;

import Classes.Filiere;
import Main.Main;
import Services.DB;
import Services.FiliereServices;

public class FiliereControlleur {

    private static final FiliereServices filiereServices = new FiliereServices();

    public static void showMenu() {
        System.out.println("-------------------------[ Filieres ]---------------------------");

        System.out.println("1: Pour ajouter une filière");
        System.out.println("2: Pour afficher les filières");
        System.out.println("3: Pour modifier une filière");
        System.out.println("4: Pour supprimer une filière");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createFiliere();
                break;
            case 2:
                showFilieres();
                break;
            case 3:
                editFiliere();
                break;
            case 4:
                destroyFiliere();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showFilieres() {
        for (Filiere filiere : DB.filieres) {
            System.out.print("Id : " + filiere.getId());
            System.out.print(" | Intitule : " + filiere.getIntitule());
            System.out.println(" ");
        }
        showMenu();
    }

    public static void createFiliere() {
        String intitule = Main.getStringInput("Veuillez saisir l'intitulé de la filière : ");
        Filiere nouvelleFiliere = new Filiere(intitule, null, null);
        filiereServices.ajouterFiliere(nouvelleFiliere);
        System.out.println("Filière ajoutée avec succès !");
        showMenu();
    }

    public static void editFiliere() {
        long idFiliereAModifier = Main.getLongInput("Veuillez saisir l'ID de la filière à modifier : ");
        Filiere ancienneFiliere = findFiliereById(idFiliereAModifier);
        if (ancienneFiliere != null) {
            String nouveauIntitule = Main.getStringInput("Veuillez saisir le nouvel intitulé de la filière : ");
            Filiere nouvelleFiliere = new Filiere(nouveauIntitule, null, null);
            filiereServices.modifierFiliere(ancienneFiliere, nouvelleFiliere);
            System.out.println("Filière modifiée avec succès !");
        }
        else {
            System.out.println("Filière non trouvée !");
        }
        showMenu();
    }

    public static void destroyFiliere() {
        long idFiliereASupprimer = Main.getLongInput("Veuillez saisir l'ID de la filière à supprimer : ");
        Filiere filiereASupprimer = findFiliereById(idFiliereASupprimer);
        if (filiereASupprimer != null) {
            filiereServices.supprimerFiliere(filiereASupprimer);
            System.out.println("Filière supprimée avec succès !");
        }
        else {
            System.out.println("Filière non trouvée !");
        }
        showMenu();
    }

    private static Filiere findFiliereById(long id) {
        for (Filiere filiere : DB.filieres) {
            if (filiere.getId() == id) {
                return filiere;
            }
        }
        return null;
    }
}

