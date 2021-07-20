package aula5;

public abstract class Veiculos implements VehicleInterface{
    private int cilindrada;
    private int potencia;
    private int lotacao;
    private String tipoCarta;
    private int pesoBruto;
    private int combustivel;
    private int consumo;
    private String matricula;

    public Veiculos(int cilindrada, int potencia, int lotacao, String tipoCarta, int pesoBruto, int combustivelAtual, int consumoMedio,String matricula){
        this.cilindrada  = cilindrada;
        this.potencia    = potencia;
        this.lotacao     = lotacao;
        this.tipoCarta   = tipoCarta;
        this.pesoBruto   = pesoBruto;
        this.combustivel = combustivelAtual;
        this.consumo     = consumoMedio;
        this.matricula   = matricula;
    }

    public Veiculos(String tipoCarta){
        this.tipoCarta = tipoCarta;
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

   
    public int getCombustivel() {
        return combustivel;
    }

    public String getMatricula() {
        return matricula;
    }


    public int getConsumo() {
        return consumo;
    }

    public String getTipoCarta() {
        return tipoCarta;
    }

    public String getTipo(){

        return "Este veículo não pertence à Polícia";
    }

    public int getID(){

        return 0;
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
