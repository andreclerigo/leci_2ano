package aula1;

public class Pessoa {
	private String nome;
	private int cc;
	private Data dataNasc;
	
	public String nome() {
		//Validar o nome
		assert nomeValido(nome);
		return nome;
	}
	
	public int cc() {
		//Validar o cc
		assert ccValido(cc);
		return cc;
	}
	
	public Data dataNasc() {
		return dataNasc;
	}
	
	/**
	 * 
	 * @param nome
	 * @param cc
	 * @param data
	 */
	public Pessoa(String nome, int cc, Data data) {
		assert nomeValido(nome) : "O nome nao deve ser vazio";
		assert ccValido(cc) : "O cc tem que ser valido";

		this.nome = nome;
		this.cc = cc;
		this.dataNasc = data;
	}
	
	@Override
    public String toString() {
        return "Nome: " + nome +
                ", CC: " + cc +
                ", Data de Nascimento: " + dataNasc;
    }

	// Valida o nome
	public static boolean nomeValido(String nome) {
		for (int i = 0; i < nome.length(); i++) {
			if (Character.isDigit(nome.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	// Valida o cc
	public static boolean ccValido(int cc) {
		if (cc < 1 || cc > 99999999) {
			return false;
		}
		return true;
	}

	public int compareBycc(Pessoa p) {
        return Integer.compare(cc, p.cc());
	}
	
	public int compareByName(Pessoa p){
        return nome.compareTo(p.nome());
    }
}