package aula9;

import java.time.LocalDateTime;  

public class Data {
	private int dia, mes, ano;
	
	public int dia() {
		return dia;
	}
	
	public int mes() {
		return mes;
	}
	
	public int ano() {
		return ano;
	}
	
	public Data(int dia, int mes, int ano) {
		assert dataValida(dia, mes, ano):"Insert a valid Date";
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
    }
    
    public static Data today() {
		String[] now = LocalDateTime.now().toString().split("-");
        return new Data(Integer.parseInt(now[2].substring(0, 2)), Integer.parseInt(now[1]), Integer.parseInt(now[0]));
    }
	
	private static final int[] diasMesComum = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public String toString() {
		return String.format("%02d-%02d-%04d", dia, mes, ano);
	}
	
	// Indica se um terno (dia, mes, ano) forma uma data válida.
	public static boolean dataValida(int dia, int mes, int ano) {
		boolean dataValida = false;
		
		if (ano > 0 && (mes > 0 && mes <13) && (dia > 0 && dia < diasMesComum[mes-1] + 1)) {
			dataValida = true;
		}else if (ano > 0 && mes == 2 && dia == 29){
			dataValida = true;
		}else {
			dataValida = false;
		}
	    return dataValida;
	}
}