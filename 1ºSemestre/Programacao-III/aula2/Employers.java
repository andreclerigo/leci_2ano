package aula2;

public class Employers extends Clients{
    private int employerId;
    private int fiscalNumber;

    public Employers(Data assignDate, String name, String cc, Data birthDate, int employerId, int fiscalNumber){
        super(assignDate, name, cc, birthDate);
        this.employerId = employerId;
        this.fiscalNumber = fiscalNumber;
    }

    public int getEmployerId(){
        return this.employerId;
    }

    public int getFiscalNumber(){
        return this.fiscalNumber;
    }

    @Override
    public String toString(){
        return "\nId: " + super.getId() + "\nRegister Date: " + super.getRegisterDate()
                + "\nName: " + super.getName() + "\nCC: " + super.getCc() + "\nBirthDate: " + super.getBirthDate() 
                + "\nEmployer Id: " + getEmployerId() + "\nFiscal Number: " + getFiscalNumber() + " ";
    }
    
}
