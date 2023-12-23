package Services;

import Classes.Note;

public class NoteServices {
    public void ajouterNote(Note note) {
        DB.notes.add(note);
    }

    public void supprimerNote(Note note) {
        DB.notes.remove(note);
    }

    public void modifierNote(Note ancienneNote, Note nouvelleNote) {
        int index = DB.notes.indexOf(ancienneNote);
        if (index != -1) {
            DB.notes.set(index, nouvelleNote);
        }
    }

    public void afficherNotes() {
        System.out.println(DB.notes);
    }
}

