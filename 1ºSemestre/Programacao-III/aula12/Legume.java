package aula12;

public class Legume extends AlimentoVegetariano {
    String nome;

    public Legume (String nome, double proteinas, double calorias, double peso) {
        super(proteinas, calorias, peso);
        this.nome = nome;
    }

    @Override
    public String toString() {
        return super.toString() + "\tNome do Legume: " + this.nome + "\n";
    }

    @Override
    public int compareTo(Alimento o) {
        return 0;
    }
}
