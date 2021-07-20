package aula14;

import java.util.*;

public class Empregado {
    private String nome;
    private LinkedList<Brinquedo> par;
    private Empresa empresa;

    public Empregado(String nome) {
        this.nome = nome;
        par = new LinkedList<>();
    }

    public Empregado(String nome, Empresa empresa) {
        this.nome = nome;
        par = new LinkedList<>();
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Empregado)) {
            return false;
        }
        Empregado empregado = (Empregado) o;
        return Objects.equals(nome, empregado.nome) && Objects.equals(par, empregado.par) && Objects.equals(empresa, empregado.empresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, par, empresa);
    }

    public void addBrinquedo(Brinquedo b) {
        if (empresa.getBrinquedos().contains(b)) {
            par.add(b);
        }
        throw new IllegalArgumentException("O brinquedo não existe na tua empresa!");
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empresa getEmpresa() {
        return this.empresa;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LinkedList<Brinquedo> getPar() {
        return this.par;
    }

    public void setPar(LinkedList<Brinquedo> par) {
        this.par = par;
    }
}
