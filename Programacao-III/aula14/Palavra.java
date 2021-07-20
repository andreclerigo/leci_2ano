package aula14;

import java.util.*;
import java.util.Map.Entry;

public class Palavra {
    String palavra;
    LinkedHashMap<String, Integer> pares;

    public Palavra(String palavra) {
        this.palavra = palavra;
        pares = new LinkedHashMap<>();
    }

    public void addPar(String s) {
        pares.merge(s, 1, (k, v) -> v + 1);
    }

    public String getPalavra() {
        return this.palavra;
    }

    public LinkedHashMap<String, Integer> getPares() {
        return this.pares;
    }

    @Override
    public String toString() {
        String res = palavra + "={";
        Iterator it = pares.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = (Entry<String, Integer>) it.next();
            res += entry.getKey() + "=" + entry.getValue() + ", ";
        }
        return res.substring(0, res.length() - 2) + "}";
    }
}
