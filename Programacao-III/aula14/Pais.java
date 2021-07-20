package aula14;

import java.util.*;
import java.util.Objects;

public class Pais {
    private String nome;
    private Localidade capital = null;
    private ArrayList<Regiao> regioes = new ArrayList<>();

    public Pais(String nome, Localidade capital, ArrayList<Regiao> regioes) {
        this.nome = nome;
        this.capital = capital;
        this.regioes = regioes;
        if(capital.getCapital() != Localidade.TipoLocalidade.Cidade)
            throw new IllegalArgumentException("Capital Inválida");
    }

    public Pais(String nome) {
        this.nome = nome;
    }

    public Pais(String nome, Localidade capital) {
        this.nome = nome;
        this.capital = capital;
        if(capital.getCapital() != Localidade.TipoLocalidade.Cidade)
            throw new IllegalArgumentException("Capital Inválida");
    }

    public void addRegiao(Regiao r) {
        regioes.add(r);
    }

    public void removeRegiao(Regiao r) {
        regioes.remove(r);
    }

    public int getPopulacao() {
        int p = 0;
        for(Regiao r : regioes)
            p += r.getPopulacao();
        return p;
    }

    @Override
    public String toString() {
        return  " Pais:" + getNome() +
                ", Populacao: " + getPopulacao() +
                ", (Capital:" + getCapitalString() +
                ")";
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Localidade getCapital() {
        return this.capital;
    }

    public String getCapitalString() {
        if (capital == null)
            return "*Indefenida*";
        return capital.toString();
    }

    public void setCapital(Localidade capital) {
        this.capital = capital;
    }

    public ArrayList<Regiao> getRegioes() {
        return this.regioes;
    }

    public void setRegioes(ArrayList<Regiao> regioes) {
        this.regioes = regioes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pais)) {
            return false;
        }
        Pais pais = (Pais) o;
        return Objects.equals(nome, pais.nome) && Objects.equals(capital, pais.capital) && Objects.equals(regioes, pais.regioes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, capital, regioes);
    }
}
