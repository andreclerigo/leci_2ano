package aula12;

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

    @Override
    public double getProteinasTotais() {
        return super.getProteinasTotais();
    }

    @Override
    public double getPesoTotal() {
        return super.getPesoTotal();
    }

    @Override
    public double getCaloriasTotais() {
        return super.getCaloriasTotais();
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
