package aula14;

import java.util.Objects;

public class Provincia extends Regiao{
    private String governador;

    public Provincia(String nome, int populacao, String governador) {
        super(nome, populacao);
        this.governador = governador;
    }


    public String getGovernador() {
        return this.governador;
    }

    public void setGovernador(String governador) {
        this.governador = governador;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Provincia)) {
            return false;
        }
        Provincia provincia = (Provincia) o;
        return Objects.equals(governador, provincia.governador);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(governador);
    }
}
