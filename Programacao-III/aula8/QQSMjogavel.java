package aula8;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class QQSMjogavel {
	//private JFrame QQSM;
	//private BufferedImage image;
	private JFrame f;
	private int[] dinheiro = { 0, 25, 50, 125, 250, 500, 750, 1500, 2500, 5000, 10000, 16000, 32000, 64000, 125000, 250000 };
	private int nQ = 0;
	private boolean a1 = true, a2 = true, a3 = true;
	private QuestionHandler n;
	private Questions q;
	private Vector<Questions> temp;
	private Vector<Questions> dif1 = new Vector<>();
	private Vector<Questions> dif2 = new Vector<>();
	private Vector<Questions> dif3 = new Vector<>();
	private LinkedList<JRadioButton> perguntasErradas;
	private String currentPath = System.getProperty("user.dir") + "/aula8/";
	Random rand = new Random();

	public QQSMjogavel() throws IOException {
		startVectors();
		play();
		gui();
	}

	public void gui() throws IOException {
		f = new JFrame("Quem quer ser milionario");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 600);
		JPanel content = new JPanel();
		content.setBackground(Color.WHITE);
		content.setLayout(null);

		JTextArea money = new JTextArea();
		money.setBackground(content.getBackground());
		money.setFont(new Font("Arial", Font.PLAIN, 20));
		money.setBounds(900, 20, 100, 50);
		money.setEditable(false);
		money.setText(String.valueOf(dinheiro[nQ]));

		String imagePath = currentPath + q.getImg();
		System.out.println(imagePath);
		BufferedImage myPicture = ImageIO.read(new File(imagePath));
		JLabel image = new JLabel(new ImageIcon(myPicture));

		image.setBounds(10, 5, 500, 390);

		JTextArea question = new JTextArea();
		question.setBackground(content.getBackground());
		question.setBounds(600, 90, 300, 300);
		question.setFont(new Font("Arial", Font.PLAIN, 30));
		question.setEditable(false);
		question.setWrapStyleWord(true);
		question.setLineWrap(true);
		question.setText(q.getQuestion());

		JButton desistir = new JButton("Desistir");
		desistir.setBounds(630, 500, 120, 30);
		desistir.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "Ganhou " + dinheiro[nQ]);
			System.exit(0);
		});

		String[] rr = q.getAnswers();
		Collections.shuffle(Arrays.asList(rr));
		ButtonGroup perguntas = new ButtonGroup();
		LinkedList<JRadioButton> perguntasList = new LinkedList<>();

		JRadioButton p1 = new JRadioButton();
		p1.setText(rr[0]);
		JRadioButton p2 = new JRadioButton();
		p2.setText(rr[1]);
		JRadioButton p3 = new JRadioButton();
		p3.setText(rr[2]);
		JRadioButton p4 = new JRadioButton();
		p4.setText(rr[3]);

		perguntas.add(p1);
		perguntasList.add(p1);
		perguntas.add(p2);
		perguntasList.add(p2);
		perguntas.add(p3);
		perguntasList.add(p3);
		perguntas.add(p4);
		perguntasList.add(p4);

		JButton publico = new JButton("Ajuda público");
		if (a1 == false) publico.setEnabled(false);
		publico.setBounds(10, 400, 120, 30);
		publico.addActionListener(e -> {
			String s = "";
			int certo = rand.nextInt(95 - 85) + 85;
			int errado = 100 - certo;
			for (JRadioButton p : perguntasList) {
				if (!isRight(p.getText())) {
					s += p.getText() + ": " + errado/3 + "\n";
				} else {
					s += p.getText() + ": " + certo + "\n";
				}
			}
			JOptionPane.showMessageDialog(null, s);
			a1 = false;
			publico.setEnabled(false);
		});

		JButton telefone = new JButton("Telefone...");
		if (a2 == false) telefone.setEnabled(false);
		telefone.setBounds(190, 400, 120, 30);
		telefone.addActionListener(e -> {
			perguntasErradas = new LinkedList<>();
			String certa = "";
			for (JRadioButton p : perguntasList) {
				if (!(isRight(p.getText()))) {
					perguntasErradas.add(p);
				} else {
					certa = p.getText();
				}
			}
			int indexP = rand.nextInt(3);
			int errado = rand.nextInt(8);
			int certo = 100 - errado;
			JOptionPane.showMessageDialog(null, perguntasErradas.get(indexP).getText() + ": " + errado + "\n" + certa + ": " + certo);
			a2 = false;
			telefone.setEnabled(false);
		});

		JButton cinquenta = new JButton("50 - 50");
		if (a3 == false) cinquenta.setEnabled(false);
		cinquenta.setBounds(370, 400, 120, 30);
		cinquenta.addActionListener(e -> {
			perguntasErradas = new LinkedList<>();
			for (JRadioButton p : perguntasList) {
				if (!(isRight(p.getText())))
					perguntasErradas.add(p);
			}
			int indexP = rand.nextInt(3);
			for (int i = 0; i < 3; i++) {
				if (i != indexP) perguntasErradas.get(i).setEnabled(false);
			}
			a3 = false;
			cinquenta.setEnabled(false);
		});

        p1.setBounds(30,450,200,50);
		p2.setBounds(30,500,200,50);
		p3.setBounds(300,450,200,50);
		p4.setBounds(300,500,200,50);
		
		JButton confirmar = new JButton("Confirmar");
		confirmar.setBounds(800, 500, 110, 30);
		confirmar.addActionListener(e -> {
			boolean acerta = false;
			if(p1.isSelected()) {
				acerta = isRight(p1.getText());
				System.out.println(acerta);
			}
			else if(p2.isSelected()) {
				acerta = isRight(p2.getText());
				System.out.println(acerta);
			}
			else if(p3.isSelected()) {
				acerta = isRight(p3.getText());
				System.out.println(acerta);
			}
			else if(p4.isSelected()) {
				acerta = isRight(p4.getText());
				System.out.println(acerta);
			}
			if(acerta) {
				nQ++;
				if(nQ == 15){
					JOptionPane.showMessageDialog(null,"Ganhou " + dinheiro[nQ]);
					System.exit(0);
				}
				try {
					System.out.println("NQ:" + nQ);
					play();
					f.setVisible(false);
					gui();
					perguntas.clearSelection();
					SwingUtilities.updateComponentTreeUI(content);
				} catch (IOException e1) {
					e1.printStackTrace();
				};
				
			}else {
				JOptionPane.showMessageDialog(null,"Ganhou " + dinheiro[nQ]);
				System.exit(0);
			}
		});
		
		content.add(money);
		content.add(image);
		content.add(question);
		content.add(publico);
		content.add(telefone);
		content.add(cinquenta);
		content.add(p1);
		content.add(p2);
		content.add(p3);
		content.add(p4);
		content.add(desistir);
		content.add(confirmar);
		
		f.setContentPane(content);
		f.setVisible(true);
	}   
	
	private void startVectors() throws IOException{
		n = new QuestionHandler(currentPath + "/questions.txt");
        n.readFile();
        temp = n.getQuestions();
        for(int i = 0;i<5;i++){
            dif1.add(temp.get(i));
        }
        for(int i = 5;i < 10;i++){
            dif2.add(temp.get(i));
        }

        for(int i = 10;i<=14;i++){
            dif3.add(temp.get(i));
		}
	}

    private void play() throws IOException {
		System.out.println("Entrei Play");
        
		if(0 <= nQ && nQ < 5) {
			System.out.println("Entrei Dif1");
			int indice = (int) (Math.random() * (dif1.size() -1));
            q = dif1.get(indice);
            dif1.remove(indice);
		}
		else if(5 <= nQ && nQ < 10) {
			System.out.println("Entrei Dif2");
			int indice = (int) (Math.random() * (dif2.size() -1));
            q = dif2.get(indice);
            dif2.remove(indice);
		}
		else if(10 <= nQ && nQ <= 15) {
			System.out.println("Entrei Dif3");
			int indice = (int) (Math.random() * (dif3.size() -1));
            q = dif3.get(indice);
            dif3.remove(indice);
		}
	}
    
    private boolean isRight(String op) {
		return (op == q.getCorrectAnswer());
	}
}