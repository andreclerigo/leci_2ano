package aula14;

import java.util.*;

public class Empresa {
    private String nome;
    private ArrayList<Empregado> empregados;
    private ArrayList<Brinquedo> brinquedos;
    private HashMap<String, LinkedList<Brinquedo>> pares;

    public Empresa(String nome) {
        this.nome = nome;
        empregados = new ArrayList<>();
        brinquedos = new ArrayList<>();
        pares = new HashMap<>();
    }

    public void addEmpregado(Empregado e) {
        if (empregados.contains(e))
            System.out.println("O empregado foi updated!");
        else    
            empregados.add(e);
        
        pares.put(e.getNome(), e.getPar());
    }

    public void addBrinquedo(Brinquedo b) {
        if (brinquedos.contains(b))
            System.out.println("O brinquedo " + b + " já foi fabricado");
        else
            brinquedos.add(b);
    }

    public String getNome() {
        return this.nome;
    }

    public ArrayList<Empregado> getEmpregados() {
        return this.empregados;
    }

    public ArrayList<Brinquedo> getBrinquedos() {
        return this.brinquedos;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setEmpregados(ArrayList<Empregado> empregados) {
        this.empregados = empregados;
    }

    public void setBrinquedos(ArrayList<Brinquedo> brinquedos) {
        this.brinquedos = brinquedos;
    }
}
