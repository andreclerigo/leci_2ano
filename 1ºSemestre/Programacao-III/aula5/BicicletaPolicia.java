package aula5;

public class BicicletaPolicia extends Veiculos{
    private String tipoPolicia;
    private int    idPolicia;

    public BicicletaPolicia(String tipoCarta,String tipoPolicia,int idPolicia){
        super("Não Necessita de Carta");
        this.tipoPolicia = tipoPolicia;
        this.idPolicia   = idPolicia;
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
    public String getTipoCarta() {
        return super.getTipoCarta();
    }
}
