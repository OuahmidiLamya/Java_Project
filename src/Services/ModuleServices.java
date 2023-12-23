package Services;
import Classes.Module;

public class ModuleServices {
        public void ajouterModule(Module module) {

            DB.modules.add(module);
        }

        public void supprimerModule(Module module) {

            DB.modules.remove(module);
        }

        public void modifierModule(Module ancienModule, Module nouveauModule) {
            int i=DB.modules.indexOf(ancienModule);
            if (i != -1) {
                DB.modules.set(i,nouveauModule);
            }
        }

        public void afficherModule(){
            DB.modules.toString();
        }
}
