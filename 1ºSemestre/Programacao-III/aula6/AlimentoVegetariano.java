package aula6;

public class AlimentoVegetariano extends Alimento {
    boolean vegetariano = true;
    
    public AlimentoVegetariano(double proteinas, double calorias, double peso) {
        super(proteinas, calorias, peso);
    }

    @Override
    public String toString() {
        return super.toString() + "\tVegetariano: Sim\n";
    }

    @Override
    public int compareTo(Alimento o) {
        return 0;
    }
}
