package aula7;

public class Companhia {
	
    private final String sigla, nome;
        
    public Companhia(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }
    
    public String getSigla() {
        return sigla;
    }
    
    public String getNome() {
        return nome;
    }
        
    @Override
    public String toString() {
        return nome;
    }    
}
