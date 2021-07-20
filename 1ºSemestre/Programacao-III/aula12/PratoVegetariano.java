package aula12;

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
    
    public void addIngrediente(AlimentoVegetariano a) {
        this.engredientes.add(a);
    }
}
