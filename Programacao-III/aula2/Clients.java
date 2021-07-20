package aula2;
import java.util.*;

public class Clients {
    private static int registerId = 0;
    private int id;
    private Data registerDate;
    private String name;
    private String cc;
    private Data birthDate;
    private List<String> history = new ArrayList<>();
    private int actualQuota = 0;

    public Clients(Data registerDate, String name, String cc, Data birthDate){
        setId(++registerId);
        this.registerDate = registerDate;
        this.name = name;
        this.cc = cc;
        this.birthDate = birthDate;
        System.out.println("\nClient Created Succesfully");

    }
    
    public int getActualQuota(){
        return this.actualQuota;
    }

    public boolean addQuota(int quota){
        if(actualQuota < quota){
            actualQuota++;
            return true;
        }
        else{
            return false;
        }
    }
    public void setId(int ID) {
        this.id = ID;
    }

    public double getRegisterId(){
        return registerId;
    }

    public int getId(){
        return this.id;
    }

    public Data getRegisterDate(){
        return this.registerDate;
    }

    public String getName(){
        return this.name;
    }

    public String getCc(){
        return this.cc;
    }
    
    

    public void movieCheck(String movieTitle){
        history.add(movieTitle);
    }

    public void getClientHistory(){

        if(history.size() > 0){
             System.out.println("The Client with ID: " + getId() + " has requested the following movies: ");
            for(int i = 0;i < history.size(); i++){
            System.out.println("Movie:" + history.get(i));
            }
        }
        else{
            System.out.println("The Client with ID: "+ getId() + " has not requested any movie ");
        }
    }
    public Data getBirthDate(){
        return this.birthDate;
    }

    @Override
    public String toString(){
        return "Client";
    }

}

