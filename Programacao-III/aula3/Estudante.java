package aula3;

import aula1.Data;
import aula1.Pessoa;

public class Estudante extends Pessoa { 
    private int nMec;
    private static int nMecgeral = 100;
    private Data DataInsc;

    public Estudante(String nome, int cc, Data dataNasc, Data iDataInsc){
        super(nome,cc,dataNasc);
        this.nMec = nMecgeral++;
        this.DataInsc = iDataInsc;
    }

    public Estudante(String nome, int cc, Data dataNasc){
        super(nome,cc,dataNasc);
        this.nMec = nMecgeral++;
        this.DataInsc = new Data();

    }
    
    public int getNmec(){
        return nMec;
    }

    public Data getDataInsc() {
        return DataInsc;
    }
    
    @Override
    public String toString() {
        return "Nome: " + super.nome() +
                ", CC: " + super.cc() +
                ", Data de Nascimento: " + super.dataNasc() + 
                ", Número Mecanográfico: " + this.getNmec() + 
                 ", Data de Inscrição: " + this.getDataInsc();
    }
}