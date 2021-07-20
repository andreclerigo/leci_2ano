package aula3;
import aula1.Data;

public class Bolseiro extends Estudante{
    private int bolsaAmount;
    
    public Bolseiro(String nome, int cc, Data dataNasc){
        super(nome, cc, dataNasc);
        
    }

    public void setBolsa(int bolsaAmount) {
        this.bolsaAmount = bolsaAmount;
    }

    public int getBolsa() {
        return bolsaAmount;
    }

    @Override
    public String toString() {
        return "Nome: " + super.nome() +
                ", CC: " + super.cc() +
                ", Data de Nascimento: " + super.dataNasc() + 
                ", Número Mecanográfico: " + this.getNmec() + 
                ", Data de Inscrição: " + this.getDataInsc() + 
                ", Bolsa: " + this.getBolsa();
    }


}
