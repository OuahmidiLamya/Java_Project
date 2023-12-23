package Classes;

import Classes.Enseignant;
import Classes.Filiere;

public class Module {
    private long id;
    private String intitule;
    Enseignant professeur;
    Filiere filiere;

    public Module() {
    }

    public Module(String intitule, Enseignant professeur, Filiere filiere) {
        this.intitule = intitule;
        this.professeur = professeur;
        this.filiere = filiere;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id= id;
    }

    public String getIntitule() {

        return intitule;
    }

    public void setIntitule(String intitule) {

        this.intitule = intitule;
    }

    public Enseignant getProfesseur() {

        return professeur;
    }

    public void setProfesseur(Enseignant professeur) {

        this.professeur = professeur;
    }

    public Filiere getFiliere() {

        return filiere;
    }

    public void setFiliere(Filiere filiere) {

        this.filiere = filiere;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", intitule='" + intitule + '\'' +
                ", professeur=" + professeur +
                ", filiere=" + filiere +
                '}';
    }
}
