package aula3;

public class Motociclo extends Veiculos{
    public Motociclo(int cilindrada, int potencia, int lotacao, int pesoBruto){
        super(cilindrada, potencia, lotacao,"A", pesoBruto);
    }

    public String toString(){
        return "--------Motociclo--------" + 
               "\nCilindrada: " + this.getCilindrada() +
               "\nPotencia: "   + this.getPotencia() +
               "\nLotaçao: "    + this.getLotacao() +
               "\nTipo de Carta: " + this.getTipoCarta() + 
               "\nPesoBruto: "  + this.getPesoBruto();
    }
}
