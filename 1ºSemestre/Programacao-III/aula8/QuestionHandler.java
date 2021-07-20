package aula8;
import java.io.*;
import java.util.*;

public class QuestionHandler {
    private String file;
    private static Vector<Questions> questions = new Vector<Questions>();

    public QuestionHandler(String file) throws NumberFormatException, IOException {
        this.file = file;
    }

    public void readFile() throws NumberFormatException, IOException {
        File inputFile = new File(this.file);
        BufferedReader inputReader = new BufferedReader(new FileReader(inputFile.getAbsolutePath()));
        String answer;
        while((answer = inputReader.readLine()) != null){
            String data = answer;
            System.out.println(data);
            String[] parts = data.split("&&");
            String imagePath = parts[0];
            String question = parts[1];
            String [] answers =  {parts[2],parts[3],parts[4],parts[5]};
            String correctAnswer = parts[2];
            int difficulty = Integer.parseInt(parts[6]);

            Questions createdQuestion = new Questions(imagePath, question, answers, correctAnswer, difficulty);
            questions.add(createdQuestion);
        }
        System.out.println("Saí");  

    }

    public Vector<Questions> getQuestions() {
        return questions;
    }

    public void printQuestions(){
        for (Questions q : questions) {
            System.out.println("--------------");
            System.out.println("Image Path: " + q.getImg());
            System.out.println("Question: " + q.getQuestion());
            String [] printAnswers = q.getAnswers();
            System.out.println("Answer 1: " +  printAnswers[0]);
            System.out.println("Answer 2: " +  printAnswers[1]);
            System.out.println("Answer 3: " +  printAnswers[2]);
            System.out.println("Answer 4: " +  printAnswers[3]);
            System.out.println("Correct Answer:  " + q.getCorrectAnswer());
            System.out.println("Difficulty: "+ q.getDifficulty());
            System.out.println("--------------");
        }
    }  
}
