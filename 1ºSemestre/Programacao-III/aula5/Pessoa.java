package aula5;

import aula1.*;

public class Pessoa {
	private String nome;
	private int NTelefone;
	private Data dataNasc;
	
	public String getnome() {
		//Validar o nome
		assert nomeValido(nome);
		return nome;
	}
	
	public Data getdataNasc() {
		return dataNasc;
	}
	
	public int getNTelefone() {
		assert NTelefoneValido(NTelefone);
		return NTelefone;
	}

	public Pessoa(String nome, Data dataNasc, int NTelefone) {
		assert nomeValido(nome) : "O nome nao deve ser vazio";

		this.nome = nome;
		this.dataNasc = dataNasc;
		this.NTelefone = NTelefone;
	}

	public static boolean NTelefoneValido(int NTelefone) {
		if (NTelefone < 0 && NTelefone > 999999999)
			return false;
		return true;
	}
	
	@Override
    public String toString() {
        return "Nome: " + nome +
				", Data de Nascimento: " + dataNasc +
				", Numero de Telefone: " + NTelefone;
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
	
	public int compareByName(Pessoa p){
        return nome.compareTo(p.getnome());
    }
}