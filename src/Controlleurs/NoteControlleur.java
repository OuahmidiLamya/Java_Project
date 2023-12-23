package Controlleurs;

import Classes.Note;
import Main.Main;
import Services.DB;
import Services.NoteServices;

public class NoteControlleur {

    private static final NoteServices noteServices = new NoteServices();

    public static void showMenu() {
        System.out.println("-------------------------[ Notes ]---------------------------");

        System.out.println("1: Pour ajouter une note");
        System.out.println("2: Pour afficher les notes");
        System.out.println("3: Pour modifier une note");
        System.out.println("4: Pour supprimer une note");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createNote();
                break;
            case 2:
                showNotes();
                break;
            case 3:
                editNote();
                break;
            case 4:
                destroyNote();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showNotes() {
        for (Note note : DB.notes) {
            System.out.println("Id : " + note.getId());
            System.out.print("Note : " + note.getNote());
            System.out.print(" | Etudiant : " + note.getEtudiant().getNom() + " " + note.getEtudiant().getPrenom());
            System.out.print(" | Filiere : " + note.getFiliere().getIntitule());
            System.out.println("");
        }
        showMenu();
    }

    public static void createNote() {
        float note = Main.getFloatInput("Veuillez saisir la note : ");
        Note nouvelleNote = new Note(note, null, null);
        noteServices.ajouterNote(nouvelleNote);
        System.out.println("Note ajoutée avec succès !");
        showMenu();
    }

    public static void editNote() {
        long idNoteAModifier = Main.getLongInput("Veuillez saisir l'ID de la note à modifier : ");
        Note ancienneNote = findNoteById(idNoteAModifier);
        if (ancienneNote != null) {
            float nouvelleNote = Main.getFloatInput("Veuillez saisir la nouvelle note : ");
            Note nouvelleNoteObj = new Note(nouvelleNote, null, null);
            noteServices.modifierNote(ancienneNote, nouvelleNoteObj);
            System.out.println("Note modifiée avec succès !");
        }
        else {
            System.out.println("Note non trouvée !");
        }
        showMenu();
    }

    public static void destroyNote() {
        long idNoteASupprimer = Main.getLongInput("Veuillez saisir l'ID de la note à supprimer : ");
        Note noteASupprimer = findNoteById(idNoteASupprimer);
        if (noteASupprimer != null) {
            noteServices.supprimerNote(noteASupprimer);
            System.out.println("Note supprimée avec succès !");
        }
        else {
            System.out.println("Note non trouvée !");
        }
        showMenu();
    }

    private static Note findNoteById(long id) {
        for (Note note : DB.notes) {
            if (note.getNote() == id) {
                return note;
            }
        }
        return null;
    }
}

