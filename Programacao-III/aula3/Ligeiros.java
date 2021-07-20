package aula3;

public class Ligeiros extends Veiculos{
    public Ligeiros(int cilindrada, int potencia, int lotacao, int pesoBruto){
        super(cilindrada, potencia, lotacao,"B", pesoBruto);

    }

    public String toString(){
        return "--------Ligeiros--------" + 
               "\nCilindrada: " + this.getCilindrada() +
               "\nPotencia: "   + this.getPotencia() +
               "\nLotaçao: "    + this.getLotacao() +
               "\nTipo de Carta: " + this.getTipoCarta() + 
               "\nPesoBruto: "  + this.getPesoBruto();
    }
}
