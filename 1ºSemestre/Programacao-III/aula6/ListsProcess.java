package aula6;
import java.util.*;

public class ListsProcess {
    public static <T> List<T> filter(List<T> list, java.util.function.Predicate<T> predicate) {
        List<T> aux = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                aux.add(t);
            }
        }
        return aux;
    }
}
