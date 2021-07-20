package aula8;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JogoDoGalo {
    private int size = 300, jogador = 1, jogadas = 1;
    private ArrayList<JButton> buttons = new ArrayList<>();
    private char[] escolhas = new char[2];
    
    public JogoDoGalo(char c) {
        if (c == 'X') {
            escolhas[1] = 'X'; escolhas[0] = 'O';
        } else {
            escolhas[1] = 'O'; escolhas[0] = 'X';
        }
        setDesign();
    }

    public void algorithm() {
        // Condicoes de Vitoria
        // Linhas Horizontais
        if (!buttons.get(0).getText().equals("") && buttons.get(0).getText().equals(buttons.get(1).getText()) && buttons.get(0).getText().equals(buttons.get(2).getText())) {
            JOptionPane.showMessageDialog(null, "O jogador " + buttons.get(0).getText() + " Ganhou!");
            System.exit(0);
        }
        else if (!buttons.get(3).getText().equals("") && buttons.get(3).getText().equals(buttons.get(4).getText()) && buttons.get(3).getText().equals(buttons.get(5).getText())) {
            JOptionPane.showMessageDialog(null, "O jogador " + buttons.get(3).getText() + " Ganhou!");
            System.exit(0);
        }
        else if (!buttons.get(6).getText().equals("") && buttons.get(6).getText().equals(buttons.get(7).getText()) && buttons.get(6).getText().equals(buttons.get(8).getText())) {
            JOptionPane.showMessageDialog(null, "O jogador " + buttons.get(6).getText() + " Ganhou!");
            System.exit(0);
        }

        // Linhas Verticais
        if (!buttons.get(0).getText().equals("") && buttons.get(0).getText().equals(buttons.get(3).getText()) && buttons.get(0).getText().equals(buttons.get(6).getText())) {
            JOptionPane.showMessageDialog(null, "O jogador " + buttons.get(0).getText() + " Ganhou!");
            System.exit(0);
        }
        else if (!buttons.get(1).getText().equals("") && buttons.get(1).getText().equals(buttons.get(4).getText()) && buttons.get(1).getText().equals(buttons.get(7).getText())) {
            JOptionPane.showMessageDialog(null, "O jogador " + buttons.get(1).getText() + " Ganhou!");
            System.exit(0);
        }
        else if (!buttons.get(2).getText().equals("") && buttons.get(2).getText().equals(buttons.get(5).getText()) && buttons.get(2).getText().equals(buttons.get(8).getText())) {
            JOptionPane.showMessageDialog(null, "O jogador " + buttons.get(2).getText() + " Ganhou!");
            System.exit(0);
        }

        // Linhas Obliquas
        if (!buttons.get(0).getText().equals("") && buttons.get(0).getText().equals(buttons.get(4).getText()) && buttons.get(0).getText().equals(buttons.get(8).getText())) {
            JOptionPane.showMessageDialog(null, "O jogador " + buttons.get(0).getText() + " Ganhou!");
            System.exit(0);
        }
        else if (!buttons.get(6).getText().equals("") && buttons.get(6).getText().equals(buttons.get(4).getText()) && buttons.get(6).getText().equals(buttons.get(2).getText())) {
            JOptionPane.showMessageDialog(null, "O jogador " + buttons.get(6).getText() + " Ganhou!");
            System.exit(0);
        }

        // Fim do Jogo Inevitável
        if(jogadas == 9) {
            JOptionPane.showMessageDialog(null, "Empate"); 
            System.exit(0);
        }

        jogadas++;
    }
    
    public void setDesign() {
        JFrame frame = new JFrame("Jogo do Galo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(size, size + 35);
        
        JPanel panel = new JPanel(new GridLayout(3, 3));
        frame.setContentPane(panel);
        
        for (int i = 0; i < 9; i++) {
            buttons.add(new JButton());
            panel.add(buttons.get(i));
            buttons.get(i).addActionListener(new GaloListener());
        }
        frame.setVisible(true); 
    }
    
    public class GaloListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource();
            jogador = jogadas % 2;
            b.setText(String.valueOf(escolhas[jogador]));
            b.setEnabled(false);

            algorithm();
        }
    }
}