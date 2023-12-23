package Services;
import Classes.Departement;

public class DepartementServices {
        public void ajouterDepartement(Departement departement) {
            DB.departements.add(departement);
        }

        public void supprimerDepartement(Departement departement) {

            DB.departements.remove(departement);
        }

        public void modifierDepartement(Departement ancienDepartement, Departement nouveauDepartement) {
            int i=DB.departements.indexOf(ancienDepartement);
            if (i != -1) {
                DB.departements.set(i,nouveauDepartement);
            }
        }

        public void afficherDepartement(){
            DB.departements.toString();
        }

}
