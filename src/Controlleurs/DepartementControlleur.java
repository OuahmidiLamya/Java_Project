package Controlleurs;

import Main.Main;
import Classes.Departement;
import Services.DB;
import Services.DepartementServices;

public class DepartementControlleur {

    private static final DepartementServices departementServices = new DepartementServices();

    public static void showMenu() {
        System.out.println("-------------------------[ Départements ]---------------------------");

        System.out.println("1: Pour ajouter un département");
        System.out.println("2: Pour afficher les départements");
        System.out.println("3: Pour modifier un département");
        System.out.println("4: Pour supprimer un département");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createDepartement();
                break;
            case 2:
                showDepartements();
                break;
            case 3:
                editDepartement();
                break;
            case 4:
                destroyDepartement();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showDepartements() {
        for (Departement departement : DB.departements) {
            System.out.print("Id : " + departement.getId());
            System.out.print(" | Intitulé : " + departement.getIntitule());
            if (departement.getResponsable() != null) {
                System.out.print(" | Chef : " + departement.getResponsable().getNom() + " " + departement.getResponsable().getPrenom());
            }
            showMenu();

        }
    }

    public static void createDepartement() {
        String intitule = Main.getStringInput("Veuillez saisir l'intitulé du département : ");
        Departement nouveauDepartement = new Departement(intitule, null);
        departementServices.ajouterDepartement(nouveauDepartement);
        System.out.println("Département ajouté avec succès !");
        showMenu();
    }

    public static void editDepartement() {
        int idDepartementAModifier = Main.getIntInput("Veuillez saisir l'ID du département à modifier : ");
        Departement ancienDepartement = findDepartementById(idDepartementAModifier);
        if (ancienDepartement != null) {
            String nouvelIntitule = Main.getStringInput("Veuillez saisir le nouvel intitulé du département : ");
            Departement nouveauDepartement = new Departement(nouvelIntitule, null);
            departementServices.modifierDepartement(ancienDepartement, nouveauDepartement);
            System.out.println("Département modifié avec succès !");
        }
        else {
            System.out.println("Département non trouvé !");
        }
        showMenu();
    }

    public static void destroyDepartement() {
        int idDepartementASupprimer = Main.getIntInput("Veuillez saisir l'ID du département à supprimer : ");
        Departement departementASupprimer = findDepartementById(idDepartementASupprimer);
        if (departementASupprimer != null) {
            departementServices.supprimerDepartement(departementASupprimer);
            System.out.println("Département supprimé avec succès !");
        }
        else {
            System.out.println("Département non trouvé !");
        }
        showMenu();
    }

    private static Departement findDepartementById(int id) {
        for (Departement departement : DB.departements) {
            if (departement.getId() == id) {
                return departement;
            }
        }
        return null;
    }
}

