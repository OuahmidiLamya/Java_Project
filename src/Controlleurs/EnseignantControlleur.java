package Controlleurs;

import Classes.Enseignant;
import Main.Main;
import Services.DB;
import Services.EnseignantServices;

public class EnseignantControlleur {

    private static final EnseignantServices enseignantServices = new EnseignantServices();

    public static void showMenu() {
        System.out.println("-------------------------[ Enseignants ]---------------------------");

        System.out.println("1: Pour ajouter un enseignant");
        System.out.println("2: Pour afficher les enseignants");
        System.out.println("3: Pour modifier un enseignant");
        System.out.println("4: Pour supprimer un enseignant");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createEnseignant();
                break;
            case 2:
                showEnseignants();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                destroyEnseignant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showEnseignants() {
        for (Enseignant enseignant : DB.enseignants) {
            System.out.print("Id : " + enseignant.getId());
            System.out.print(" | Nom : " + enseignant.getNom() + " " + enseignant.getPrenom());
            System.out.print(" | Email : " + enseignant.getEmail());
            System.out.println(" | Grade : " + enseignant.getGrade());
            System.out.println(" ");
        }
        showMenu();
    }

    public static void createEnseignant() {
        String nom = Main.getStringInput("Veuillez saisir le nom de l'enseignant : ");
        String prenom = Main.getStringInput("Veuillez saisir le prénom de l'enseignant : ");
        String email = Main.getStringInput("Veuillez saisir l'email de l'enseignant : ");
        String grade = Main.getStringInput("Veuillez saisir le grade de l'enseignant : ");
        Enseignant nouvelEnseignant = new Enseignant(nom, prenom, email, grade, null);
        enseignantServices.ajouterEnseignant(nouvelEnseignant);
        System.out.println("Enseignant ajouté avec succès !");
        showMenu();
    }

    public static void editEnseignant() {
        int idEnseignantAModifier = Main.getIntInput("Veuillez saisir l'ID de l'enseignant à modifier : ");
        Enseignant ancienEnseignant = findEnseignantById(idEnseignantAModifier);
        if (ancienEnseignant != null) {
            String nouveauNom = Main.getStringInput("Veuillez saisir le nouveau nom de l'enseignant : ");
            String nouveauPrenom = Main.getStringInput("Veuillez saisir le nouveau prénom de l'enseignant : ");
            String nouvelEmail = Main.getStringInput("Veuillez saisir le nouvel email de l'enseignant : ");
            String nouveauGrade = Main.getStringInput("Veuillez saisir le nouveau grade de l'enseignant : ");
            Enseignant nouveauEnseignant = new Enseignant(nouveauNom, nouveauPrenom, nouvelEmail, nouveauGrade, null);
            enseignantServices.modifierEnseignant(ancienEnseignant, nouveauEnseignant);
            System.out.println("Enseignant modifié avec succès !");
        } else {
            System.out.println("Enseignant non trouvé !");
        }
        showMenu();
    }

    public static void destroyEnseignant() {
        int idEnseignantASupprimer = Main.getIntInput("Veuillez saisir l'ID de l'enseignant à supprimer : ");
        Enseignant enseignantASupprimer = findEnseignantById(idEnseignantASupprimer);
        if (enseignantASupprimer != null) {
            enseignantServices.supprimerEnseignant(enseignantASupprimer);
            System.out.println("Enseignant supprimé avec succès !");
        } else {
            System.out.println("Enseignant non trouvé !");
        }
        showMenu();
    }

    private static Enseignant findEnseignantById(int id) {
        for (Enseignant enseignant : DB.enseignants) {
            if (enseignant.getId() == id) {
                return enseignant;
            }
        }
        return null;
    }
}

