package aula2;

import java.util.*;

public class ex2 {
    public static Scanner sc = new Scanner(System.in);
    public static final LinkedList<Clients> clientList = new LinkedList<Clients>();
    public static final LinkedList<Employers> employerList = new LinkedList<Employers>();
    public static final LinkedList<Video> videoList =  new LinkedList<Video>(); 
    public static int quota = 0;
    public static void main(String[] args) {
        System.out.println("How many videos can a Client request at the same time?");
        quota = sc.nextInt();
        
        Video PulpFiction = new Video("Pulp Fiction", "Ação", "M18");
        Video KillBill = new Video("Kill Bill", "Ação", "M18");
        Video FightClub = new Video("Fight Club", "Ação", "M16");
         
        videoList.add(PulpFiction);
        videoList.add(KillBill);
        videoList.add(FightClub);
        
        int op;
        do{
            System.out.println("\nWelcome to the VideoClub App");
            System.out.println("Choose your option:");
            System.out.println("1--> Manage Users");
            System.out.println("2--> Manage Videos");
            System.out.println("3--> Quit");
            op = sc.nextInt();
            switch(op){
                case 1:
                int opt;
                    do{
                        System.out.println("\n---------------------------");
                        System.out.println("Manage Users:");
                        System.out.println("1--> Add User");
                        System.out.println("2--> Remove User");
                        System.out.println("3--> Search for Movie");
                        System.out.println("4--> See Movies available for Certain User");
                        System.out.println("5--> Quit");
                            opt = sc.nextInt();
                            switch(opt){
                                case 1:
                                    addClient();
                                    break;
                                case 2:
                                    removeClient();
                                    break;
                                case 3:
                                    searchMovie();
                                    break;
                                case 4:
                                    ageAvailable();
                                    break;
                            }
                    }while(opt!=5);
                        break;
                case 2:
                do{
                    System.out.println("\n---------------------------");
                    System.out.println("Manage Videos:");
                    System.out.println("1--> Add Video");
                    System.out.println("2--> Remove Video");
                    System.out.println("3--> Check Movie Availability");
                    System.out.println("4--> Movie CheckOut");
                    System.out.println("5--> Movie CheckIn");
                    System.out.println("6--> Movie CheckOut History");
                    System.out.println("7--> Check Movie Total and Average Rating");
                    System.out.println("8--> Sort Movie By Rating");
                    System.out.println("9--> Check Client History");
                    System.out.println("10--> Quit"); 
                        opt = sc.nextInt();
                        switch(opt){
                            case 1:
                                addVideo();
                                break;
                            case 2:
                                removeVideo();
                                break;
                            case 3:
                                availability();
                                break;
                            case 4:
                                checkOut();
                                break;
                            case 5:
                                checkIn();
                                break ;
                            case 6:
                                checkOuthistory();
                                break;
                            case 7:
                                checkMovieRatings();
                                break;
                            case 8:
                                sortMovieByRating();
                                break;
                            case 9:
                                checkClientHistory();
                                break;
                        }
                }while(opt!=10);
                        break;
            }
        }while(op!=3);
	}

    private static void addClient() {
        System.out.println("\n---------------------------");
        System.out.println("Add a Client");
        int op;
        System.out.println("Choose the type of Client:");
        System.out.println("1--> Student");
        System.out.println("2--> Employer");
        op = sc.nextInt();

            System.out.println("Insert your Register Date: (dd-mm-yy)");
            System.out.println("Day: ");
            int day = sc.nextInt();
            if (day < 0 || day >31) {
                System.out.println("Choose a day between 0 and 31");
                do {
                    day = sc.nextInt();
                } while(day < 0 || day > 31);
            }
            System.out.println("Month: ");
            int month = sc.nextInt();
            if (month < 0 || month > 12) {
                System.out.println("Choose a month between 0 and 12");
                do {
                    month = sc.nextInt();
                } while (month < 0 || month > 12);
            }
            System.out.println("Year: ");
            int year = sc.nextInt();
            Data registerDate = new Data(day, month, year);
            System.out.println("Insert your name:");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Insert your CC number: ");
            String cc = sc.nextLine();
            System.out.println("Insert your Birth Date: (dd-mm-yy)");
            System.out.println("Day: ");
            int birthday = sc.nextInt();
            if (day < 0 || day >31) {
                System.out.println("Choose a day between 0 and 31");
                do {
                    day = sc.nextInt();
                } while(day < 0 || day > 31);
            }
            System.out.println("Month: ");
            int birthmonth = sc.nextInt();
            if (month < 0 || month > 12) {
                System.out.println("Choose a month between 0 and 12");
                do {
                    month = sc.nextInt();
                } while (month < 0 || month > 12);
            }
            System.out.println("Year: ");
            int birthyear = sc.nextInt();
            Data birthDate = new Data(birthday, birthmonth, birthyear);
        if(op == 1){
            System.out.println("Insert your Student Number: ");
            int nMec = sc.nextInt();
            System.out.println("Insert your Course: ");
            sc.nextLine();
            String course = sc.nextLine();

            Students s = new Students(registerDate, name, cc, birthDate,nMec, course);
            
            clientList.add(s);

            System.out.println(s.toString());
        }
        if(op == 2){
            System.out.println("Insert your Employers Number: ");
            int employerId = sc.nextInt();
            System.out.println("Insert your Fiscal Number: ");
            sc.nextLine();
            int fiscalNumber = sc.nextInt();

            Employers e = new Employers(registerDate, name, cc, birthDate, employerId, fiscalNumber);
            clientList.add(e);
            employerList.add(e);

            System.out.println(e.toString());
        }
    }

    public static void removeClient(){
        System.out.println("Insert the ID of the client you want to remove: ");
        int removeClientbyId = sc.nextInt();
        for(int i = 0; i<clientList.size(); i++){
            if(clientList.get(i).getId() == removeClientbyId){
                clientList.remove(i);
                System.out.println("Client Removed Succesfully");
                break;
            }else if (i == clientList.size() - 1) {
                System.out.println("ID not found");
            }
        }
    }

    public static void searchMovie(){
        System.out.println("Insert the name of the movie you want to search: ");
        sc.nextLine();
        String movieName = sc.nextLine();
        boolean exists = false;
        for(int i = 0;i< videoList.size(); i++){
            if(videoList.get(i).getTitle().equals(movieName)){
                System.out.println("The Movie " + movieName + " exists in our videoclub");
                System.out.println("\n--------------------------");
                System.out.println(videoList.get(i).toString());
                exists = true;
            }
        }

        if(!exists){
            System.out.println("The Movie doesn't exist");
        }

    }

    public static void ageAvailable(){
        System.out.println("Insert the id of the User to see the movies available for his age: ");
        int idUser = sc.nextInt();
        int currentAge = 0; 
        List<String> availableMovies = new ArrayList<>();
        for(int i = 0; i<clientList.size();i++){
            if(clientList.get(i).getRegisterId() == idUser){
                currentAge = 2020 - clientList.get(i).getBirthDate().ano();
                System.out.println(currentAge);
            }
        }

        for(int i = 0; i<videoList.size();i++){
            System.out.println(videoList.get(i).getCheckAge());
            if(videoList.get(i).getCheckAge() <= currentAge || videoList.get(i).getCheckAge() == 0){
                availableMovies.add(videoList.get(i).getTitle());
            }
        }

        if(availableMovies.size()>0){
            System.out.println("You have the following movies available to your age: ");
            for(int i = 0; i<availableMovies.size();i++){
                System.out.println(availableMovies.get(i));
            }
        }else{
            System.out.println("You don't have movies available to you age");
        }

    }

    public static void addVideo(){
        String movieCategory = "";
        String ageRating = "";

        System.out.println("\n---------------------------");
        System.out.println("Add a Movie");
        System.out.println("Insert your Employers Number");
        int employerNumber = sc.nextInt();
        for(int i = 0;i<employerList.size(); i++){
            if(employerList.get(i).getEmployerId() == employerNumber){
                System.out.println("Insert the movie name: ");
                sc.nextLine();
                sc.nextLine();
                String movieName = sc.nextLine();
                System.out.println("Insert the movie category: ");
                System.out.println("1---> Action");
                System.out.println("2---> Comedy");
                System.out.println("3---> Child");
                System.out.println("4---> Drama");
                int numberCategory = sc.nextInt();

                switch(numberCategory){
                    case 1: movieCategory = "Action";
                            break;
                    case 2: movieCategory = "Comedy";
                            break;
                    case 3: movieCategory = "Child";
                            break;
                    case 4: movieCategory = "Drama";
                            break;
                }

                System.out.println("Insert the movie age rating: ");
                System.out.println("1---> ALL");
                System.out.println("2---> M6");
                System.out.println("3---> M12");
                System.out.println("4---> M16");
                System.out.println("5---> M18");
                int numberAgeRating = sc.nextInt();

                switch(numberAgeRating){
                    case 1: ageRating = "ALL";
                            break;
                    case 2: ageRating = "M12";
                            break;
                    case 3: ageRating = "M16";
                            break;
                    case 4: ageRating = "M18";
                            break;
                }

                Video v = new Video(movieName, movieCategory, ageRating);

                videoList.add(v);
                System.out.println("Video Inserted Successfully");
                System.out.println(v.toString());
            }else if (i == employerList.size() - 1) {
                System.out.println("You don't have the permissions to do that");
            }
        }

    }

    public static void removeVideo(){
        System.out.println("\n---------------------------");
        System.out.println("Remove a Movie");
        System.out.println("Insert your Employers Number");
        int employerNumber = sc.nextInt();
        for(int i = 0;i<employerList.size(); i++){
            if(employerList.get(i).getEmployerId() == employerNumber){
                System.out.println("Insert the ID of the video you want to remove: ");
                int removeMoviebyId = sc.nextInt();
                for(int j = 0; j<videoList.size(); j++){
                    if(videoList.get(j).getId() == removeMoviebyId){
                        videoList.remove(j);
                        System.out.println("Video Removed Succesfully");
                        break;
                    }else if (i == videoList.size() - 1) {
                        System.out.println("Movie Id not found");
                    }
                }
            }else if (i == employerList.size() - 1) {
                System.out.println("You don't have the permissions to do that");
            }
        }
    }

    public static void availability(){
        System.out.println("\n---------------------------");
        System.out.println("Check Availability");
        System.out.println("Insert the Id of the Movie you want to check: ");
        int idAvailable = sc.nextInt();
        boolean isAvailable = false;
        for(int i = 0; i<videoList.size(); i++){
            if(videoList.get(i).getId() == idAvailable){
                isAvailable = videoList.get(i).getAvailability();
            }
        }
        if(isAvailable){
            System.out.println("The Movie is Available");
        }else{
            System.out.println("The Movie isn't Available");
        }
    }

    public static void checkOut(){
        System.out.println("\n---------------------------");
        System.out.println("Check Out");
        System.out.println("\nInsert your Client Id:");
        int clientToCheckOutId = sc.nextInt();
        for(int i = 0; i<clientList.size();i++){
            if(clientList.get(i).getId() == clientToCheckOutId){
                int currentAge = 0;
                for(int j = 0; j<clientList.size();j++){
                    if(clientList.get(j).getId() == clientToCheckOutId){
                        currentAge = 2020-clientList.get(j).getBirthDate().ano();
                    }

                    System.out.println("\nYou have the following Movies Available for your age: ");
                    for(int l = 0; l<videoList.size();l++){
                        if(videoList.get(l).getCheckAge() <= currentAge){
                            System.out.println("\n---------------------------");
                            System.out.println(videoList.get(l).toString());
                            System.out.println("\n---------------------------");
                        }
                    }

                    System.out.println("\nInsert The ID Of The Movie You Want to Check Out: ");
                    int movieToCheckOut = sc.nextInt();
                    
                    for(int m = 0;m<videoList.size();m++){
                        if(videoList.get(m).getId() == movieToCheckOut){
                            boolean isAvailable = videoList.get(m).getAvailability();
                            if(isAvailable){
                                for(int k = 0; k < clientList.size(); k++){
                                    boolean canAddQuota = clientList.get(k).addQuota(quota);
                                    if(canAddQuota){
                                        videoList.get(m).CheckOut(clientToCheckOutId);
                                        clientList.get(k).movieCheck(videoList.get(m).getTitle());
                                        System.out.println("Check Out Successfully");
                                    }else{
                                        System.out.println("Max Quota exceeded. Try to Check In some Movies First");
                                    }
                                }
                                break;
                            }else{
                                System.out.println("This movie is not available");
                                break;
                            }
                        }else if (m == videoList.size() - 1) {
                            System.out.println("Movie Id not found");
                        }
                    }
                }
            }else if (i == clientList.size() - 1 || clientList.size() == 0) {
                System.out.println("Client ID not found");
            }
        }

        
    }

    public static void checkIn(){
        System.out.println("\n---------------------------");
        System.out.println("Check In");
        System.out.println("Insert the Id Of The Movie You Want To Check In: ");
        int movietoCheckIn= sc.nextInt();
        for(int i = 0;i<videoList.size(); i++){
            if(videoList.get(i).getId() == movietoCheckIn){
                if(videoList.get(i).getAvailability() == false){
                    videoList.get(i).CheckIn();
                    System.out.println("Rate the Movie from 1 to 5");
                    double rating = sc.nextDouble();
                    videoList.get(i).addRating(rating);
                    System.out.println("The Movie Rating is now " + videoList.get(i).getRating());
                    System.out.println("Check In Successfully");
                    break;
                }else{
                    System.out.println("This Movie has not been Checked Out");
                    break;
                }
            }else if (i == videoList.size() - 1) {
                System.out.println("Movie Id not found");
            }
        }
    }

    public static void checkOuthistory(){
        System.out.println("\n---------------------------");
        System.out.println("Check Out History");
        System.out.println("Insert The Id Of The Movie You Want To Check The History: ");
        int movieToCheckHistory = sc.nextInt();
        for(int i = 0;i<videoList.size();i++){
            if(videoList.get(i).getId() == movieToCheckHistory){
                videoList.get(i).getHistory();
                break;
            }else if (i == videoList.size() - 1) {
                System.out.println("Movie Id not found");
            }
        }
    }

    public static void checkMovieRatings(){
        System.out.println("\n---------------------------");
        System.out.println("Check Movie Total Rating and Average Rating");
        for(int i = 0; i<videoList.size();i++){
            String totalRating = videoList.get(i).totalRating();
            System.out.println(videoList.get(i).getTitle() + " rating's are: ");
            System.out.println("Total Rating: ");
            System.out.println(totalRating);
            System.out.println("Average Rating: " + videoList.get(i).getRating());

        }
    }

    public static void sortMovieByRating(){
        videoList.sort(Video :: compareByAvgRating);
        for (Video v : videoList) {
            System.out.println(v.toString());
        }
    }

    public static void checkClientHistory(){
        System.out.println("\n---------------------------");
        System.out.println("Check Out History");
        System.out.println("Insert The Id Of The Client You Want To Check The History: ");
        int clientToCheckHistory = sc.nextInt();
        for(int i = 0;i<clientList.size();i++){
            if(clientList.get(i).getId() == clientToCheckHistory){
                clientList.get(i).getClientHistory();
                break;
            }else if (i == videoList.size() - 1) {
                System.out.println("Movie Id not found");
            }
        }
    }
}