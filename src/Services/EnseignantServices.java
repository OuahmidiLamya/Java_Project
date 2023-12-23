package Services;
import Classes.Enseignant;
import java.util.ArrayList;

public class EnseignantServices {
        public void ajouterEnseignant(Enseignant enseignant) {

            DB.enseignants.add(enseignant);
        }

        public void supprimerEnseignant(Enseignant enseignant) {

            DB.enseignants.remove(enseignant);
        }

        public void modifierEnseignant(Enseignant ancienEnseignant, Enseignant nouveauEnseignant) {
            int i=DB.enseignants.indexOf(ancienEnseignant);
            if (i != -1) {
                DB.enseignants.set(i,nouveauEnseignant);
            }
        }

        public void afficherEnseignant(){
            DB.enseignants.toString();
        }

    public static Enseignant getEnsById(long id){
        for (Enseignant enseignant : DB.enseignants) {
            if (enseignant.getId() == id) return  enseignant;
        }
        return  new Enseignant();
    }

    public static ArrayList<Enseignant> getAllEns(){
        return  DB.enseignants;
}


}
