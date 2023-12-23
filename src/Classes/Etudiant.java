package Classes;

import java.util.ArrayList;

public class Etudiant {
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private Integer apogee;
    Filiere filiere;
    ArrayList<Note> notes = new ArrayList<Note>();

    public Etudiant() {
    }

    public Etudiant(String nom, String prenom, String email, Integer apogee, Filiere filiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.apogee = apogee;
        this.filiere = filiere;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {

        return nom;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    public String getPrenom() {

        return prenom;
    }

    public void setPrenom(String prenom) {

        this.prenom = prenom;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getApogee() {

        return apogee;
    }

    public void setApogee(Integer apogee) {

        this.apogee = apogee;
    }

    public Filiere getFiliere() {

        return filiere;
    }

    public void setFiliere(Filiere filiere) {

        this.filiere = filiere;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", apogee=" + apogee +
                ", filiere=" + filiere +
                ", notes=" + notes +
                '}';
    }
}

