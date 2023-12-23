package Classes;

import Classes.Etudiant;
import Classes.Filiere;

public class Note {
    private long id;
    private float note;
    private Etudiant etudiant;
    private Filiere filiere;

    public Note() {
    }

    public Note(float note, Etudiant etudiant, Filiere filiere) {
        this.note = note;
        this.etudiant = etudiant;
        this.filiere = filiere;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", note=" + note +
                ", etudiant=" + etudiant +
                ", filiere=" + filiere +
                '}';
    }
}
