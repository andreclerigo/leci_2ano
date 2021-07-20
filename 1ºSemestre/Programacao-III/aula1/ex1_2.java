package aula1;
import java.util.*;

public class ex1_2 {
    public static Scanner sc = new Scanner(System.in);
    public static final LinkedList<Pessoa> list = new LinkedList<Pessoa>();  // Para funcionar nas outras funcoes
    public static void main(String[] args){
        showMenu();
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("Welcome to the People Manager");
        System.out.println("Choose your option:");
        System.out.println("1--> Create Person");
        System.out.println("2--> Remove Person");
        System.out.println("3--> Show all Persons");
        System.out.println("4--> Order List by ID");
        System.out.println("5--> Order List by Name");
        System.out.println("6--> Quit");
        
        int op = sc.nextInt();
        switch (op) {
            case 1 : 
                    addPerson();
                    showMenu();
                break;
            case 2 :
                    removePerson();
                    showMenu();
                break;
            case 3 :
                    showList();
                    showMenu();
                break;
            case 4 :
                    orderListBycc();
                    showMenu();
                break;
            case 5 :
                    orderListByName();
                    showMenu();
                break;
            case 6 :
                    System.exit(0);
                break;
            default :
                System.out.println("Choose a valid option");
                showMenu();
        }
    }

    private static void showList() {
        if (list.size() == 0) {
            System.out.println("No persons");
        }
        for (Pessoa p : list) {
            System.out.println(p.toString());
        }
    }

    private static void addPerson() {
        System.out.println("Choose the name:");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.println("Write your person's identifying number:");
        int cc = sc.nextInt();
        System.out.println("Write your birth date:");
        System.out.println("        Day: ");
        int day = sc.nextInt();
        if (day < 0 || day >31) {
            System.out.println("Choose a day between 0 and 31");
            do {
                day = sc.nextInt();
            } while(day < 0 || day > 31);
        }
        System.out.println("        Month: ");
        int month = sc.nextInt();
        if (month < 0 || month > 12) {
            System.out.println("Choose a month between 0 and 12");
            do {
                month = sc.nextInt();
            } while (month < 0 || month > 12);
        }

        System.out.println("        Year: ");
        int year = sc.nextInt();
        Data data = new Data(day, month, year);
        Pessoa pessoa = new Pessoa(nome, cc, data);
        list.add(pessoa);
    }

    private static void removePerson() {
        System.out.println("What's the person's cc?:");
        int cc = sc.nextInt();
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).cc() == cc) {
                list.remove(i);
                break;
            }else if (i == list.size() - 1) {
                System.out.println("CC not found");
            }
        }
    }

    private static void orderListBycc() {  
        list.sort(Pessoa::compareBycc);
        showList();
    }

    private static void orderListByName() {
        list.sort(Pessoa::compareByName);
        showList();
    }
}