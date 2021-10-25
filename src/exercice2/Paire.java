package exercice2;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Paire <T,P> {
    //Déclaration
    public T taille;
    public P poids;

    //constructeur
    public Paire(T taille, P poids){
        this.taille = taille;
        this.poids = poids;
    }

    //Récuperer poids et taille
    public P getPoids() {
        return poids;
    }

    public T getTaille() {
        return taille;
    }

    @Override public String toString(){
        return String.format("(%s,%s)", taille.toString(), poids.toString());
    }

    //return true if taille inférieur à 100
    public static Boolean tailleTropPetit(Paire<Integer, Double> clt){
        return clt.getTaille() < 100;
    }

    //return true if taille supérieur à 200
    public static Boolean tailleTropGrande(Paire<Integer, Double> clt){
        return clt.getTaille() > 200;
    }

    //return true if poids supérieur à 150
    public static Boolean poidsTropLourd(Paire<Integer, Double> clt){
        return clt.getPoids() > 150.0;
    }

    public static List<Paire> filtragePredicatif(List<Predicate<Paire>> predicat, List<Paire> elements) {
        return elements.stream().filter(t -> predicat.stream().anyMatch(f -> f.test(t))).collect(toList());
    }





}
