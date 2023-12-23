package Controlleurs;

import Classes.Module;
import Main.Main;
import Services.DB;
import Services.ModuleServices;

public class ModuleControlleur {

    private static final ModuleServices moduleServices = new ModuleServices();

    public static void showMenu() {
        System.out.println("-------------------------[ Modules ]---------------------------");

        System.out.println("1: Pour ajouter un module");
        System.out.println("2: Pour afficher les modules");
        System.out.println("3: Pour modifier un module");
        System.out.println("4: Pour supprimer un module");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createModule();
                break;
            case 2:
                showModules();
                break;
            case 3:
                editModule();
                break;
            case 4:
                destroyModule();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showModules() {
        for (Module module : DB.modules) {
            System.out.print("Id : " + module.getId());
            System.out.print(" | Intitule : " + module.getIntitule());
            System.out.println(" ");
        }
        showMenu();
    }

    public static void createModule() {
        String intitule = Main.getStringInput("Veuillez saisir l'intitulé du module : ");
        Module nouveauModule = new Module(intitule, null, null);
        moduleServices.ajouterModule(nouveauModule);
        System.out.println("Module ajouté avec succès !");
        showMenu();
    }

    public static void editModule() {
        long idModuleAModifier = Main.getLongInput("Veuillez saisir l'ID du module à modifier : ");
        Module ancienModule = findModuleById(idModuleAModifier);
        if (ancienModule != null) {
            String nouveauIntitule = Main.getStringInput("Veuillez saisir le nouvel intitulé du module : ");
            Module nouveauModule = new Module(nouveauIntitule, null, null);
            moduleServices.modifierModule(ancienModule, nouveauModule);
            System.out.println("Module modifié avec succès !");
        }
        else {
            System.out.println("Module non trouvé !");
        }
        showMenu();
    }

    public static void destroyModule() {
        long idModuleASupprimer = Main.getLongInput("Veuillez saisir l'ID du module à supprimer : ");
        Module moduleASupprimer = findModuleById(idModuleASupprimer);
        if (moduleASupprimer != null) {
            moduleServices.supprimerModule(moduleASupprimer);
            System.out.println("Module supprimé avec succès !");
        } else {
            System.out.println("Module non trouvé !");
        }
        showMenu();
    }

    private static Module findModuleById(long id) {
        for (Module module : DB.modules) {
            if (module.getId() == id) {
                return module;
            }
        }
        return null;
    }
}


