package aula13;

public class Peixe extends Alimento {
    enum Tipo {
        Fresco,
        Congelado
    }

    public Tipo tipoDePeixe;

    public Peixe (Tipo type, double proteinas, double calorias, double peso) {
        super(proteinas, calorias, peso);
        tipoDePeixe = type;
    }

    public Tipo getTipoDePeixe() {
        return tipoDePeixe;
    }

    @Override
    public String toString() {
        return super.toString() + "\tTipo de Peixe: " + getTipoDePeixe() + "\n";
    }

    @Override
    public int compareTo(Alimento o) {
        return 0;
    }
}
