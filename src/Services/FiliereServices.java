package Services;
import Classes.Filiere;

public class FiliereServices {
        public void ajouterFiliere(Filiere filiere) {
            DB.filieres.add(filiere);
        }

        public void supprimerFiliere(Filiere filiere) {
            DB.filieres.remove(filiere);
        }

        public void modifierFiliere(Filiere ancienFiliere, Filiere nouvelleFiliere) {
            int i=DB.filieres.indexOf(ancienFiliere);
            if (i != -1) {
                DB.filieres.set(i,nouvelleFiliere);
            }
        }

        public void afficherFiliere(){
            DB.filieres.toString();
        }
}
