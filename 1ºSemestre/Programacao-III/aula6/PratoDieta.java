package aula6;

import java.util.LinkedList;

public class PratoDieta extends Prato {
    String nome;
    double caloriasMax, proteinasTotais, caloriasTotais, pesoTotal;
    LinkedList<Alimento> engredientes;

    public PratoDieta(String nome, double caloriasMax) {
        super(nome);
        this.caloriasMax = caloriasMax;
        engredientes = new LinkedList<>();
    }

    @Override
    public String toString() {
        String s = "Ingredientes no " + nome + ":\n";
        for (Alimento a : this.engredientes) {
            s += a.toString();
        }
        return s;
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
        if (this.getCaloriasTotais() + a.getCalorias() < this.caloriasMax) {
            this.engredientes.add(a);
            return true;
        } else {
            System.out.println("ERROR: Alimento ultrapassa caloriaias para o " + this.nome);
            return false;
        }
    }
}
