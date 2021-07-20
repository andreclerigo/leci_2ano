package aula13;

public class Cereal extends AlimentoVegetariano {
    public String nome;

    public Cereal (String nome, double proteinas, double calorias, double peso) {
        super(proteinas, calorias, peso);
        this.nome = nome;
    }

    @Override
    public String toString() {
        return super.toString() + "\tNome do Cereal: " + this.nome + "\n";
    }

    @Override
    public int compareTo(Alimento o) {
        return 0;
    }
}
