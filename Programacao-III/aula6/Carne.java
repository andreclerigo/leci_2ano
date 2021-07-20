package aula6;
public class Carne extends Alimento {
    enum Tipo {
        Vaca,
        Porco,
        Peru,
        Frango,
        Outra
    }

    Tipo tipoDeCarne;

    public Carne(Tipo type, double proteinas, double calorias, double peso) {
        super(proteinas, calorias, peso);
        tipoDeCarne = type;

    }

    public Tipo getTipoDeCarne() {
        return tipoDeCarne;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\tTipo de Carne: " + getTipoDeCarne() + "\n";
    }

    @Override
    public int compareTo(Alimento o) {
        return 0;
    }
}