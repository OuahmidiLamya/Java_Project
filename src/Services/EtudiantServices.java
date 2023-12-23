package Services;
import Classes.Etudiant;

public class EtudiantServices {
        public void ajouterEtudiant(Etudiant etudiant) {

            DB.etudiants.add(etudiant);
        }

        public void supprimerEtudiant(Etudiant etudiant) {

            DB.etudiants.remove(etudiant);
        }

        public void modifierEtudiant(Etudiant ancienEtudiant, Etudiant nouveauEtudiant) {
            int i=DB.etudiants.indexOf(ancienEtudiant);
            if (i != -1) {
                DB.etudiants.set(i,nouveauEtudiant);
            }
        }

        public void afficherEtudiant(){
            DB.etudiants.toString();
        }
}
