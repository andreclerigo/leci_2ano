package aula3;

public class PesadoPassageiros extends Veiculos{
    public PesadoPassageiros(int cilindrada, int potencia, int lotacao, int pesoBruto){
        super(cilindrada, potencia, lotacao,"D", pesoBruto);

    }

    public String toString(){
        return "--------Pesado Passageiros--------" + 
               "\nCilindrada: " + this.getCilindrada() +
               "\nPotencia: "   + this.getPotencia() +
               "\nLotaçao: "    + this.getLotacao() +
               "\nTipo de Carta: " + this.getTipoCarta() + 
               "\nPesoBruto: "  + this.getPesoBruto();
    }
}
