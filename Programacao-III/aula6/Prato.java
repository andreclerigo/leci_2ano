package aula6;

import java.util.LinkedList;
public class Prato implements Comparable<Prato>{
    String nome;
    double proteinasTotais, caloriasTotais, pesoTotal;
    LinkedList<Alimento> engredientes;

    public Prato(String nome) {
        this.nome = nome;
        engredientes = new LinkedList<>();
    }

    public double getProteinasTotais() {
        for (Alimento a : this.engredientes) {
            this.proteinasTotais += a.getProteinas();
        }
        return this.proteinasTotais;
    }

    public double getCaloriasTotais() {
        for (Alimento a : this.engredientes) {
            this.caloriasTotais += a.getCalorias();
        }
        return this.caloriasTotais;
    }

    public double getPesoTotal() {
        for (Alimento a : this.engredientes) {
            this.pesoTotal += a.getPeso();
        }
        return this.pesoTotal;
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
