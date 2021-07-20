package aula6;

import java.util.LinkedList;

public class PratoVegetariano extends Prato {
    String nome;
    double proteinasTotais, caloriasTotais, pesoTotal;
    LinkedList<AlimentoVegetariano> engredientes;

    public PratoVegetariano(String nome) {
        super(nome);
        engredientes = new LinkedList<>();
    }

    @Override
    public String toString() {
        String s = "";
        for (AlimentoVegetariano a : this.engredientes) {
            s += a.toString();
        }
        return super.toString() + s;
    }

    public double getProteinasTotais() {
        for (AlimentoVegetariano a : this.engredientes) {
            this.proteinasTotais += a.getProteinas();
        }
        return this.proteinasTotais;
    }

    public double getCaloriasTotais() {
        for (AlimentoVegetariano a : this.engredientes) {
            this.caloriasTotais += a.getCalorias();
        }
        return this.caloriasTotais;
    }

    public double getPesoTotal() {
        for (AlimentoVegetariano a : this.engredientes) {
            this.pesoTotal += a.getPeso();
        }
        return this.pesoTotal;
    }
    
    public void addIngrediente(AlimentoVegetariano a) {
        this.engredientes.add(a);
    }
}
