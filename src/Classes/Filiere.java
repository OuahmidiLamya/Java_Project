package Classes;

import java.util.ArrayList;

public class Filiere {
    private long id;
    private String intitule;
    Departement departement;
    Enseignant responsable;
    ArrayList<Module> modules = new ArrayList<Module>();

    public Filiere() {
    }
    public Filiere( String intitule, Departement departement, Enseignant responsable) {
        this.intitule = intitule;
        this.departement = departement;
        this.responsable = responsable;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIntitule() {

        return intitule;
    }

    public void setIntitule(String intitule) {

        this.intitule = intitule;
    }

    public Departement getDepartement() {

        return departement;
    }

    public void setDepartement(Departement departement) {

        this.departement = departement;
    }

    public Enseignant getResponsable() {

        return responsable;
    }

    public void setResponsable(Enseignant responsable) {

        this.responsable = responsable;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "Filiere{" +
                "id=" + id +
                ", intitule='" + intitule + '\'' +
                ", departement=" + departement +
                ", responsable=" + responsable +
                ", modules=" + modules +
                '}';
    }
}
