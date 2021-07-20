package aula12;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Prato implements Comparable<Prato>{
    String nome;
    double proteinasTotais, caloriasTotais, pesoTotal;
    LinkedList<Alimento> engredientes;

    public Prato(String nome) {
        this.nome = nome;
        engredientes = new LinkedList<>();
    }

    public double getProteinasTotais() {
        return engredientes.stream().collect(Collectors.summingDouble(Alimento::getProteinas));
    }

    public double getCaloriasTotais() {
        return engredientes.stream().collect(Collectors.summingDouble(Alimento::getCalorias));
    }

    public double getPesoTotal() {
        return engredientes.stream().collect(Collectors.summingDouble(Alimento::getPeso));
    }
    
    public boolean addIngrediente(Alimento a) {
        if (!(a == null)){
            this.engredientes.add(a);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "Ingredientes no " + nome + ":\n";
        if(!(this.engredientes == null)) {
            for (Alimento a : this.engredientes) {
                s += a.toString();
            }
        }
        return s;
    }

    @Override
    public int compareTo(Prato p) {
        if (p == null)
            throw new NullPointerException("O prato nao existe!");
        return (int) (p.getCaloriasTotais() - this.getCaloriasTotais());
    }

    public boolean equals(Prato p) {
        if (p == this)
            return true;
        return false;
    }
}
