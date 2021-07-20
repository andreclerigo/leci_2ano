package aula14;

import java.util.Objects;

import aula14.Localidade.TipoLocalidade;

public class Estado extends Regiao{
    private Localidade capital;
    
    public Estado(String nome, int populacao, Localidade capital) {
        super(nome, populacao);
        this.capital = capital;
        if(capital.getCapital() != TipoLocalidade.Cidade)
            throw new IllegalArgumentException("Capital Inválida");
    }

    public Localidade getCapital() {
        return this.capital;
    }

    public void setCapital(Localidade capital) {
        this.capital = capital;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Estado)) {
            return false;
        }
        Estado estado = (Estado) o;
        return Objects.equals(capital, estado.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(capital);
    }
}
