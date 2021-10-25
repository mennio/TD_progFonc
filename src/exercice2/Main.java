package exercice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        /*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
        //question 1
        //instanciate
        Paire<Integer,Double> clt = new Paire<Integer,Double>(110,789.0);

        //Predicate des 3 fonctions
        Predicate<Paire> tailleTropGrande = Paire::tailleTropGrande;
        Predicate<Paire> tailleTropPetit = Paire::tailleTropPetit;
        Predicate<Paire> poidsTropLourd = Paire::poidsTropLourd;



        //affichage resultat
        System.out.println("test tailleTropGrande=" + tailleTropGrande.test(clt));
        System.out.println("test tailleTropPetit="+ tailleTropPetit.test(clt));
        System.out.println("test poidsTropLourd="+ poidsTropLourd.test(clt));

        //Composition
        boolean tailleCorrect = (tailleTropGrande).negate().and((tailleTropPetit.negate())).test(clt) ; //taille pas trop grande + pas trop petite == return true
        boolean tailleIncorrect = (tailleTropGrande.or(tailleTropPetit).test(clt)); //taille trop grande ou trop petite  == return true
        boolean poidsCorrect = poidsTropLourd.negate().test(clt); //taille pas trop lourd == return true
        boolean accesAutorise = tailleCorrect && poidsCorrect; //(tailleTropGrande.negate().and(tailleTropPetit.negate())).and(poidsTropLourd.negate()).test(clt)

        System.out.println("test tailleCorrect=" + tailleCorrect);
        System.out.println("test tailleIncorrect="+ tailleIncorrect);
        System.out.println("test poidsCorrect="+ poidsCorrect);
        System.out.println("test accesAutorise="+ accesAutorise);
/*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
        //question 2
        Paire<Integer,Double> clt1 = new Paire<Integer,Double>(10,789.0);
        Paire<Integer,Double> clt2 = new Paire<Integer,Double>(110,150.0);
        Paire<Integer,Double> clt3 = new Paire<Integer,Double>(120,789.0);
        Paire<Integer,Double> clt4 = new Paire<Integer,Double>(110,789.0);

        Filtre filtre = new Filtre<>();
        List<Paire> listPaire = new ArrayList<>();
        listPaire.add(clt1);
        listPaire.add(clt2);
        listPaire.add(clt3);
        listPaire.add(clt4);

        List<Predicate<Paire>> predicat = new ArrayList<>();
        predicat.add(tailleTropGrande);
        predicat.add(tailleTropPetit);
        System.out.println(filtre.filtragePredicatif(predicat, listPaire));


    }
}
