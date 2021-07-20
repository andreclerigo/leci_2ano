package aula12;

public abstract class Alimento implements Comparable<Alimento>{
    private double proteinas;
	private double calorias;
	private double peso;

    public Alimento(double proteinas, double calorias, double peso) {
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.peso = peso;
    }

    public double getProteinas() {
        return proteinas;
    }
    public double getCalorias() {
        return calorias;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "\nProteinas: " + this.getProteinas() +
               "\tCalorias: " + this.getCalorias() +
               "\tPeso: " + this.getPeso();
    }

    @Override
    public int compareTo(Alimento a) {
        if (a == null)
            throw new NullPointerException("O alimento nao existe!");
        return (int) (this.calorias - a.getCalorias());
    }

    public boolean equals(Alimento a) {
        if (a == this)
            return true;
        return false;
    }
}