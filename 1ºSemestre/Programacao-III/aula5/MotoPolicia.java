package aula5;

public class MotoPolicia extends Veiculos{
    private String tipoPolicia;
    private int    idPolicia;

    public MotoPolicia(int cilindrada, int potencia, int lotacao, int pesoBruto, int combustivelAtual, int consumoMedio,String matricula,String TipoPolicia, int idPolicia){
        super(cilindrada, potencia, lotacao,"A", pesoBruto,combustivelAtual,consumoMedio,matricula);
        this.tipoPolicia = TipoPolicia;
        this.idPolicia   = idPolicia;
    }

    @Override
    public int getCombustivel() {
        return super.getCombustivel();
    }

    @Override
    public int getID() {
        return this.idPolicia;
    }

    @Override
    public String getTipo() {

        return this.tipoPolicia;
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
        return "--------Motociclo--------" + 
               "\nCilindrada: " + this.getCilindrada() +
               "\nPotencia: "   + this.getPotencia() +
               "\nLotaçao: "    + this.getLotacao() +
               "\nTipo de Carta: " + this.getTipoCarta() + 
               "\nPesoBruto: "  + this.getPesoBruto();
    }
}
