package exercice2;

import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

//question 2
public class Filtre <T> {
    public List<T> filtragePredicatif(List<Predicate<T>> predicat, List<T> elements) {
        return elements.stream().filter(t -> predicat.stream().anyMatch(f -> f.test(t))).collect(toList());
    }
}
