package aula2;
import java.util.*;

public class Video {
    private static int global_id = 0;
    private int id;
    private String title, category, age;
    private boolean available = true;
    private List<String> history = new ArrayList<>();
    private double avgRating = 0;
    private int numberOfReviews, checkAge, oneCounter = 0, twoCounter = 0,threeCounter = 0, fourCounter = 0, fiveCounter = 0;

    public Video(String title, String category, String age){
        setId(++global_id);
        this.title = title;
        this.category = category;
        this.age = age;
        AgeCheck(this.age);
    }

    public int setId(int ID) {
        return this.id = ID;
    }
    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getCategory(){
        return this.category;
    }
    public String getAge(){
        return this.age;
    }

    public int AgeCheck(String ageCheck){
        if(ageCheck.equals("M18")){
            return this.checkAge = 18;
        }
        if(ageCheck.equals("M16")){
            return this.checkAge = 16;
        }
        if(ageCheck.equals("M12")){
            return this.checkAge = 12;
        }
        if(ageCheck.equals("M6")){
            return this.checkAge = 6;
        }
        else{
            return this.checkAge = 0;
        }
    }

    public int getCheckAge(){
        return this.checkAge;
    }

    public boolean CheckOut(int clientId){
        history.add(Integer.toString(clientId));
        return this.available = false;
    }

    public boolean CheckIn(){
        return this.available = true;
    }

    public void addRating(double rating){
        switch((int)rating){
            case 1:
                oneCounter++;
                break;
            case 2:
                twoCounter++;
                break;
            case 3:
                threeCounter++;
                break;
            case 4:
                fourCounter++;
                break;
            case 5:
                fiveCounter++;
                break;
        }
        numberOfReviews++;
        avgRating+=rating;
        avgRating = avgRating/numberOfReviews;
    }

    public String totalRating(){
        return "\nThe Movie " + getTitle() + " has " + numberOfReviews + " reviews" + 
        "\nNumber of rating 1: " + oneCounter + 
        "\nNumber of rating 2: " + twoCounter + 
        "\nNumber of rating 3: " + threeCounter + 
        "\nNumber of rating 4: " + fourCounter + 
        "\nNumber of rating 5: " + fiveCounter;
    }

    public double getRating(){
        return this.avgRating;
    }

    public void getHistory(){
        if(history.size() > 0){
             System.out.println("The Movie " + getTitle() + " has been requested by: ");
            for(int i = 0;i < history.size(); i++){
            System.out.println("Client Id:" + history.get(i));
            }
        }
        else{
            System.out.println("This Movie hasn´t been requested yet");
        }
    }

    public boolean getAvailability(){
        return this.available;
    }

    public String toString(){
        return "\nId: " + getId() + "\nMovie Name: " + getTitle()
                + "\nCategory: " + getCategory() + "\nAge Rating: " + getAge();
    }

    public int compareByAvgRating(Video v) {
        return Double.compare(v.getRating(), avgRating);
	}
}