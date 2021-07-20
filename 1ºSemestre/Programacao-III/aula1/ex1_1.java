package aula1;
import java.util.*;

public class ex1_1 {
	public static void main(String[] args) {
		int charnumeric = 0, palavras = 1;
		boolean lowercase = true, uppercase = true;
		
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		
		// Caso exclusivo para string vazia
		if (string.trim().isEmpty()) {
			lowercase = false;
			uppercase = false;
			palavras = 0;
		}else {
			for (int i = 0; i  < string.length(); i++) {
				// Verificar se tem numericos
				if(Character.isDigit(string.charAt(i))) {
					charnumeric++;
					lowercase = false;
					uppercase = false;
				}
				//Verificar se é tudo lowercase ou tudo uppercase
				if (string.charAt(i) != ' ') {     // Tenho que excluir o espaco se não uma frase com várias palavras só com minusculas não é detetada
					if (!Character.isLowerCase(string.charAt(i))) {
						lowercase = false;
					}else if (!Character.isUpperCase(string.charAt(i))) {
						uppercase = false;
					}
				}
				// Verificar número de palavras
				if(i != 0 && string.charAt(i-1) == ' ') {
					palavras++;
				}
			}
		}
		// Display da informação pedida
		System.out.println("O número de caracteres númericos nesta string é: " + charnumeric + ".");
		if (lowercase) {
			System.out.println("A string está toda em minusculas.");
		}else if (uppercase) {
			System.out.println("A string está toda em maiusculas.");
		}
		System.out.println("A string contem " + palavras + " palavras.");
		System.out.println(string);
		Troca2a2(string);
		sc.close();
	}
	// Inverter 2 a 2
	private static void Troca2a2(String frase) {
		String[] palavras = frase.split(" ");
		String nova_frase = "";
		int impar;
		char ultimo_caracter = ' ';

		for (int j = 0; j < palavras.length ; j++) {
			// Reset dos parametros para a nova palavra
			ultimo_caracter = ' ';
			impar = 0;
			if (palavras[j].length() == 1) {            // Palavra com 1 letra
				nova_frase = nova_frase + palavras[j] + " ";
				continue;
			}else if (palavras[j].length() % 2 != 0) {  // Palavra com numero impar de letras
				impar = 1;
				ultimo_caracter = palavras[j].charAt(palavras[j].length() - 1);  // Armazenar o ultimo caracter de uma palavra impar
				palavras[j] = palavras[j].substring(0, palavras[j].length() - 1);  // Fazer com que a palavra seja par
			}
			// Procedimento para palavras com número para de letras
			for	(int i = 0; i < palavras[j].length(); i = i + 2) {
				nova_frase = nova_frase + palavras[j].charAt(i+1) + palavras[j].charAt(i);
			}
			if (impar == 1) {  // Adicionar o ultimo caracter caso a palavra tenha um compriumento impar
				nova_frase = nova_frase + ultimo_caracter;
			}
			nova_frase = nova_frase + " ";
		}
		System.out.println(nova_frase);
	}
}