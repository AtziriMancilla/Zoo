public class Management extends Employee{
    public Management (String name, String lastname, Date birthDate, String curp, String rfc, double salary){
        super (name,lastname,birthDate,curp,rfc,salary,"Management");
    }

    public String showManagement(){
        return super.showEmployee();
    }
}