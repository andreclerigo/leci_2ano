package aula5;

public class Ligeiros extends Veiculos{
    
    public Ligeiros(int cilindrada, int potencia, int lotacao, int pesoBruto, int combustivelAtual, int consumoMedio,String matricula){
        super(cilindrada, potencia, lotacao,"B", pesoBruto,combustivelAtual,consumoMedio,matricula);

    }

    @Override
    public int getCombustivel() {
        return super.getCombustivel();
    }

    @Override
    public int getCilindrada() {
        return super.getCilindrada();
    }


    @Override
    public int getConsumo() {
        return super.getConsumo();
    }

    @Override
    public int getLotacao() {
        return super.getLotacao();
    }

    @Override
    public String getMatricula() {
        return super.getMatricula();
    }

    @Override
    public int getPesoBruto() {
        return super.getPesoBruto();
    }

    @Override
    public int getPotencia() {
        return super.getPotencia();
    }

    @Override
    public String getTipoCarta() {
        return super.getTipoCarta();
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
