package Controlleurs;

import Classes.Etudiant;
import Main.Main;
import Services.DB;
import Services.EtudiantServices;

public class EtudiantControlleur {

    private static final EtudiantServices etudiantServices = new EtudiantServices();

    public static void showMenu() {
        System.out.println("-------------------------[ Etudiants ]---------------------------");

        System.out.println("1: Pour ajouter un étudiant");
        System.out.println("2: Pour afficher les étudiants");
        System.out.println("3: Pour modifier un étudiant");
        System.out.println("4: Pour supprimer un étudiant");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createEtudiant();
                break;
            case 2:
                showEtudiants();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showEtudiants() {
        for (Etudiant etudiant : DB.etudiants) {
            System.out.print("Id : " + etudiant.getId());
            System.out.print(" | Nom : " + etudiant.getNom() + " " + etudiant.getPrenom());
            System.out.print(" | Email : " + etudiant.getEmail());
            System.out.println(" | Apogée : " + etudiant.getApogee());
            System.out.println(" ");
        }
        showMenu();
    }

    public static void createEtudiant() {
        String nom = Main.getStringInput("Veuillez saisir le nom de l'étudiant : ");
        String prenom = Main.getStringInput("Veuillez saisir le prénom de l'étudiant : ");
        String email = Main.getStringInput("Veuillez saisir l'email de l'étudiant : ");
        int apogee = Main.getIntInput("Veuillez saisir l'apogée de l'étudiant : ");
        Etudiant nouvelEtudiant = new Etudiant(nom, prenom, email, apogee, null);
        etudiantServices.ajouterEtudiant(nouvelEtudiant);
        System.out.println("Étudiant ajouté avec succès !");
        showMenu();
    }

    public static void editEtudiant() {
        long idEtudiantAModifier = Main.getLongInput("Veuillez saisir l'ID de l'étudiant à modifier : ");
        Etudiant ancienEtudiant = findEtudiantById(idEtudiantAModifier);
        if (ancienEtudiant != null) {
            String nouveauNom = Main.getStringInput("Veuillez saisir le nouveau nom de l'étudiant : ");
            String nouveauPrenom = Main.getStringInput("Veuillez saisir le nouveau prénom de l'étudiant : ");
            String nouvelEmail = Main.getStringInput("Veuillez saisir le nouvel email de l'étudiant : ");
            int nouvelApogee = Main.getIntInput("Veuillez saisir le nouvel apogée de l'étudiant : ");
            Etudiant nouveauEtudiant = new Etudiant(nouveauNom, nouveauPrenom, nouvelEmail, nouvelApogee, null);
            etudiantServices.modifierEtudiant(ancienEtudiant, nouveauEtudiant);
            System.out.println("Étudiant modifié avec succès !");
        }
        else {
            System.out.println("Étudiant non trouvé !");
        }
        showMenu();
    }

    public static void destroyEtudiant() {
        long idEtudiantASupprimer = Main.getLongInput("Veuillez saisir l'ID de l'étudiant à supprimer : ");
        Etudiant etudiantASupprimer = findEtudiantById(idEtudiantASupprimer);
        if (etudiantASupprimer != null) {
            etudiantServices.supprimerEtudiant(etudiantASupprimer);
            System.out.println("Étudiant supprimé avec succès !");
        }
        else {
            System.out.println("Étudiant non trouvé !");
        }
        showMenu();
    }

    private static Etudiant findEtudiantById(long id) {
        for (Etudiant etudiant : DB.etudiants) {
            if (etudiant.getId() == id) {
                return etudiant;
            }
        }
        return null;
    }
}

