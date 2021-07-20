package aula8;
public class TestJogoDoGalo {
    public static void main(String[] args) {
        char escolha = args[0].toCharArray()[0];
        new JogoDoGalo(escolha);
    }
}