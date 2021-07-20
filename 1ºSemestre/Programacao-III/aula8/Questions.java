package aula8;

public class Questions {
    private String img;
    private String question;
    private String [] answers;
    private String correctAnswer;
    private int difficulty;

    public Questions(String img, String question, String[] answers, String correctAnswer, int difficulty) {
        this.img = img;
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.difficulty = difficulty;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getImg() {
        return img;
    }

    public  String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }
}
