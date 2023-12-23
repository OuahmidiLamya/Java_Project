package Classes;

import java.util.ArrayList;

public class Departement {
    private int id;
    private String intitule;
    Enseignant responsable;
    ArrayList<Filiere> filieres = new ArrayList<Filiere>();

    public Departement() {
    }

    public Departement(String intitule, Enseignant responsable) {
        this.intitule = intitule;
        this.responsable = responsable;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getIntitule() {

        return intitule;
    }

    public void setIntitule(String intitule) {

        this.intitule = intitule;
    }

    public Enseignant getResponsable() {

        return responsable;
    }

    public void setResponsable(Enseignant responsable) {

        this.responsable = responsable;
    }

    public ArrayList<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(ArrayList<Filiere> filieres) {
        this.filieres = filieres;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", intitule='" + intitule + '\'' +
                ", responsable=" + responsable +
                ", filieres=" + filieres +
                '}';
    }
}
