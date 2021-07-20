package aula14;

import java.util.Objects;

public class Localidade {
    enum TipoLocalidade{
        Cidade,
        Vila,
        Aldeia
    }

    private String nome;
    private int populacao;
    private TipoLocalidade capital = null;

    public Localidade(String nome, int populacao, TipoLocalidade capital) {
        this.nome = nome;
        this.populacao = populacao;
        this.capital = capital;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopulacao() {
        return this.populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public TipoLocalidade getCapital() {
        return this.capital;
    }

    public void setCapital(TipoLocalidade capital) {
        this.capital = capital;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Localidade)) {
            return false;
        }
        Localidade localidade = (Localidade) o;
        return Objects.equals(nome, localidade.nome) && populacao == localidade.populacao && Objects.equals(capital, localidade.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, populacao, capital);
    }

    @Override
    public String toString() {
        if(capital == null)
            return "*Indefenida*";
        else    
            return getCapital().toString() + " " + getNome() + ", populacao " + getPopulacao();
    }
}
