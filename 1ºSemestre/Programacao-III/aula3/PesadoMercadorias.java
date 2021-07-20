package aula3;

public class PesadoMercadorias extends Veiculos{
    public PesadoMercadorias(int cilindrada, int potencia, int lotacao, int pesoBruto){
        super(cilindrada, potencia, lotacao,"C", pesoBruto);

    }

    public String toString(){
        return "--------Pesado Mercadorias--------" + 
               "\nCilindrada: " + this.getCilindrada() +
               "\nPotencia: "   + this.getPotencia() +
               "\nLotaçao: "    + this.getLotacao() +
               "\nTipo de Carta: " + this.getTipoCarta() + 
               "\nPesoBruto: "  + this.getPesoBruto();
    }
}
