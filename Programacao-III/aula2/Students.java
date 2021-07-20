package aula2;

public class Students extends Clients{
    private int nMec;
    private String course;

    public Students(Data registerDate, String name, String cc, Data birthDate, int nMec, String course){
        super(registerDate, name, cc, birthDate);
        this.nMec = nMec;
        this.course = course;
    }

    public int getnMec(){
        return this.nMec;
    }

    public String getCourse(){
        return this.course;
    }

    @Override
    public String toString(){
        return "\nId: " + super.getId() + "\nRegister Date: " + super.getRegisterDate()
                + "\nName: " + super.getName() + "\nCC: " + super.getCc() + "\nBirthDate: " + super.getBirthDate() 
                + "\nStudent Number: " + getnMec() + "\nCourse: " + getCourse() + " ";
    }
    
}
