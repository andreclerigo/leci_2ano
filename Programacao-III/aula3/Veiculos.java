package aula3;

public abstract class Veiculos {
    private int cilindrada, potencia, lotacao, pesoBruto;
    private String tipoCarta;

    public Veiculos(int cilindrada, int potencia, int lotacao, String tipoCarta, int pesoBruto){
        this.cilindrada  = cilindrada;
        this.potencia    = potencia;
        this.lotacao     = lotacao;
        this.tipoCarta   = tipoCarta;
        this.pesoBruto   = pesoBruto;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public int getLotacao() {
        return lotacao;
    }

    public int getPesoBruto() {
        return pesoBruto;
    }

    public int getPotencia() {
        return potencia;
    }

    public String getTipoCarta() {
        return tipoCarta;
    }

    public String toString(){
        return "--------Veiculo--------" + 
               "\nCilindrada: " + this.getCilindrada() +
               "\nPotencia: "   + this.getPotencia() +
               "\nLotaçao: "    + this.getLotacao() +
               "\nTipo de Carta: " + this.getTipoCarta() + 
               "\nPesoBruto: "  + this.getPesoBruto();
    }
}
