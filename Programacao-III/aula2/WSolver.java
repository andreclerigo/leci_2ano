package aula2;

import java.util.*;
import java.io.*;

public class WSolver {
    private static int linhas = 1, colunas, linhasPalavras, numPalavras;
    private static String[] palavras = new String[80];
    public static void main (String[] args) throws IOException {
        //Verificar se o ficheiro existe e é válido
        System.out.println("This program assumes that there's only 1 KeyWord only appears once in the Word Solver.");
        validFile(args[0]);

        if(!puzzleIsSquared(args[0])) {
            System.out.println("The puzzle must be squared.");
            System.exit(0);
        }else {
            System.out.println("The puzzle is squared.");
        }

        if(!allUpperCase(args[0])) {
            System.out.println("The puzzle must be ALL in upper case.");
            System.exit(0);
        }else {
            System.out.println("The puzzle is ALL in upper case.");
        }

        // Funcao print das keywords para debug
        System.out.print("\nKeyWords:\n");
        for (int i = 0; i < palavras.length; i++) {
            if(palavras[i] != null) {
                System.out.println(palavras[i]);
            }
        }

        char[][] sopa = new char[linhas][linhas];
        arrayBidemnsional(args[0], sopa);

        //Funcao print da sopa de letras para debug
        System.out.print("\nSopa:\n");
        for (int i = 0; i < sopa[0].length; i++) {
            for (int j = 0; j < sopa.length; j++) {
                System.out.print(sopa[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < palavras.length; i++) {
            if (palavras[i] != null) {
                System.out.println(palavras[i] + "\t" + keyWordLocation(palavras[i], sopa));
            }
        }
    }

    // Funções de validação da Sopa e das key words
    private static String validFile(String fileName) throws IOException {
        File fin = new File(fileName);
        
        if (!fin.exists()) {
            return ("ERRO: ficheiro " + fileName + " não existe!");
        }
        if (fin.isDirectory()) {
            return ("Ficheiro " + fileName + " is a directory!");
        }
        if (!fin.canRead()) {
            return ("ERRO: ficheiro " + fileName + "não pode ser lido!");
        }
        return ("Ficheiro válido!");   // Debug
    }
    
    private static boolean allUpperCase(String fileName) throws IOException {
        // Função verifica se a sopa em si está em Upper Case e preenche um array com as key words
        Scanner scFile = new Scanner(new File(fileName));

        for (int i = 0; i < linhas; i++) {
            String str = scFile.nextLine();
            if (!str.equals(str.toUpperCase())) {  // Verifica se a sopa está em maiusculas
                scFile.close(); 
                return false;
            } 
        }

        // Preencher o array palavras com as palavras chave válidas
        String [] a = new String[80];
        for (int i = 0; i < linhasPalavras; i++) {
            String str = scFile.nextLine();
            a = str.split(",|;|\\.");

            for (int j = 0; j < a.length; j++) {
                if (keyWordIsValid(a[j].trim())) {
                    palavras[numPalavras++] = a[j].trim().toUpperCase();
                }
            }
        }
        scFile.close();
        return true;
    }
    
    private static boolean puzzleIsSquared(String fileName) throws IOException {
        // Verifica se o puzzle é quadrado, tem dimensao máxima de 80x80
        Scanner scFile = new Scanner(new File(fileName));
        colunas = scFile.nextLine().length();

        while (scFile.hasNextLine()) {
            String str = scFile.nextLine();  // Faz o scanner mudar de linha
            
            if(!str.equals(str.toUpperCase()) && linhas == colunas) {
                linhasPalavras++;
                continue;
            }else {
                linhas++;
            }
        }
        scFile.close();
        if(linhas == colunas  && linhas >= 2 && linhas <= 80 ) return true;
        return false;
    }

    private static boolean keyWordIsValid(String keyWord) {
        // Verifica o comprimento
        if (keyWord.length() < 2) return false;

        if (keyWord.equals(keyWord.toUpperCase())) return false;

        // Verifica se tem caracteres não alfabeticos
        for (int i = 0; i < keyWord.length(); i++) {
            if(Character.isDigit(keyWord.charAt(i))) return false;
        }

        // Verifica se tem palavras duplicadas
        for (int i = 0; i < palavras.length; i++) {
            if (palavras[i] != null && ( palavras[i].contains(keyWord.toUpperCase()) || keyWord.toUpperCase().contains(palavras[i]) )) {
                return false;
            } 
        }
        return true;
    }

    // Funções de algoritmo e formatação da solução
    private static void arrayBidemnsional(String fileName, char[][] sopa) throws IOException {
        Scanner scFile = new Scanner(new File(fileName));
        String linha;

        for (int i = 0; i < sopa[0].length; i++) {
            linha = scFile.nextLine();
            for (int j = 0; j < sopa.length; j++) {
                sopa[i][j] = linha.charAt(j);
            }
        }
        scFile.close();
    }

    private static String keyWordLocation(String keyWord, char[][] sopa) {
        String direction = "not found";
        String keyWordTest = "";
        int charCheckPosition = 0, linhaFound = 0, colunaFound = 0;

        // Ler esquerda para a direita  (Working)
        for (int linha = 0; linha < linhas; linha++) {
            keyWordTest = "";
            charCheckPosition = 0;

            for (int coluna = 0; coluna < sopa[linha].length; coluna++) {
                if (sopa[linha][coluna] == keyWord.charAt(charCheckPosition)) { 
                    keyWordTest = keyWordTest + sopa[linha][coluna];
                    charCheckPosition++;
                    // Verificar se a palavra já está totalmente encontrada
                    if (charCheckPosition == keyWord.length() && keyWordTest.equals(keyWord)) {
                        linhaFound = linha + 1;
                        colunaFound = coluna - keyWord.length() + 2;
                        direction = "right";
                        break;
                    }
                }
            }
        }

        // Ler direita para a esquerda (Working)
        for (int linha = 0; linha < linhas; linha++) {
            keyWordTest = "";
            charCheckPosition = 0;

            for (int coluna = colunas - 1; coluna >= 0; coluna--) {
                if (sopa[linha][coluna] == keyWord.charAt(charCheckPosition)) {
                    keyWordTest = keyWordTest + sopa[linha][coluna];
                    charCheckPosition++;
                    // Verificar se a palavra já está totalmente encontrada
                    if (charCheckPosition == keyWord.length() && keyWordTest.equals(keyWord)) {
                        linhaFound = linha + 1;
                        colunaFound = coluna + keyWord.length();
                        direction = "left";
                        break;
                    }
                }
            }
        }

        // Ler de baixo para cima (Working)
        for (int coluna = 0; coluna < linhas; coluna++) {
            keyWordTest = "";
            charCheckPosition = 0;

            for (int linha = linhas - 1; linha >= 0; linha--) {
                if (sopa[linha][coluna] == keyWord.charAt(charCheckPosition)) {
                    keyWordTest = keyWordTest + sopa[linha][coluna];
                    charCheckPosition++;
                    // Verificar se a palavra já está totalmente encontrada
                    if (charCheckPosition == keyWord.length() && keyWordTest.equals(keyWord)) {
                        linhaFound = linha + keyWord.length();
                        colunaFound = coluna + 1;
                        direction = "up";
                        break;
                    }
                }
            }
        }
        
        // Ler de cima para baixo (Working)
        for (int coluna = 0; coluna < linhas; coluna++) {
            keyWordTest = "";
            charCheckPosition = 0;

            for (int linha = 0; linha < linhas; linha++) {
                if (sopa[linha][coluna] == keyWord.charAt(charCheckPosition)) {
                    keyWordTest = keyWordTest + sopa[linha][coluna];
                    charCheckPosition++;
                    if (charCheckPosition == keyWord.length() && keyWordTest.equals(keyWord)) {
                        linhaFound = linha - keyWord.length() + 2;
                        colunaFound = coluna + 1;
                        direction = "down";
                        break;
                    }
                }
            }
        }

        // Downright nao esta a funcionar
        for (int coluna = 0 ; coluna < colunas; coluna++) {
            for (int linha = 0; linha < linhas; linha++) {
                if (sopa[linha][coluna] == keyWord.charAt(charCheckPosition)) {
                    keyWordTest = keyWordTest + sopa[linha][coluna];
                    charCheckPosition++;
                    if (charCheckPosition == keyWord.length() && keyWordTest.equals(keyWord)) {
                        linhaFound = 0;
                        colunaFound = 0;
                        direction = "downright";
                        break;
                    }
                    System.out.println(keyWordTest);
                }
            }
        }

        return linhaFound + "," + colunaFound + "\t" + direction;
    }
}