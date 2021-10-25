package exercice3;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;


public class Main {
    public static void main(String[] args) {
        Matiere m1 = new Matiere("MAT1");
        Matiere m2 = new Matiere("MAT2");
        UE ue1 = new UE("UE1", Map.of(m1, 2, m2, 2)); //
        Matiere m3 = new Matiere("MAT3");
        UE ue2 = new UE("UE2", Map.of(m3, 1));
        Annee a1 = new Annee(Set.of(ue1, ue2));
        Etudiant e1 = new Etudiant("39001", "Alice", "Merveille", a1);
        e1.noter(m1, 12.0);
        e1.noter(m2, 14.0);
        e1.noter(m3, 10.0);
        System.out.println(e1);
        Etudiant e2 = new Etudiant("39002", "Bob", "Eponge", a1);
        e2.noter(m1, 14.0);
        e2.noter(m3, 14.0);
        Etudiant e3 = new Etudiant("39003", "Charles", "Chaplin", a1);
        e3.noter(m1, 18.0);
        e3.noter(m2, 5.0);
        e3.noter(m3, 14.0);

        //Question1
        Predicate<Etudiant> allEtudiant = etudiant -> etudiant.numero() != "";
        afficheSi("**TOUS LES ETUDIANTS",allEtudiant,a1);

        //Question2
        Predicate<Etudiant> aDEF = etudiant -> {
            for(UE ue : etudiant.annee().ues()){
                for(Map.Entry<Matiere, Integer> notes : ue.ects().entrySet()){
                    if(!etudiant.notes().containsKey(notes.getKey())) return true;
                }
            }
            return false;
        };
        afficheSi("**TOUS LES ETUDIANTS ----------",aDEF,a1);

        //Question3
        Predicate<Etudiant> aNoteEliminatoire = etudiant -> {
        for (Map.Entry<Matiere, Double> i : etudiant.notes().entrySet()) {
            if (i.getValue() < 6)return true;
        }
            return false;
        };
        afficheSi("**ETUDIANTS AVEC NOTE ELIMINATOIRE",aNoteEliminatoire,a1);

        //Question4

        //Question5

        //Question6

        //Question7

        //Question8

        //Question9

        //Question10
    }

    public static void afficheSi(String enTete, Predicate<Etudiant> etud, Annee annee) {
        System.out.println(enTete);
        //version 1
        /*for (Etudiant i : annee.etudiants()) {
            if (etud.test(i)) {
                System.out.println(i.toString());
            }
        }*/

        //version 2
        annee.etudiants().forEach( i -> {
            if (etud.test(i)) {
                System.out.println(i.toString());
            }
        });
    }
}


