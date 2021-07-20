package aula3;
import aula1.Pessoa;
import aula1.Data;

public class Condutor extends Pessoa{
    private String tipoCarta;
    
    public Condutor(String nome, int cc, Data dataNasc, String tipoCarta ){
        super(nome, cc, dataNasc);
        this.tipoCarta = tipoCarta;
    }

    public String getTipoCarta() {
        return tipoCarta;
    }

    @Override
    public String toString() {
        return "Nome: " + super.nome() +
                ", CC: " + super.cc() +
                ", Data de Nascimento: " + super.dataNasc() + 
                ", Tipo Carta: " + this.getTipoCarta(); 
    }
}
