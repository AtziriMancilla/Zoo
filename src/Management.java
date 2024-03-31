public class Management extends Employee{
    public Management (String name, String lastname, Date birthDate, String curp, String rfc, double salary, Date hireDate, String schedule){
        super (name,lastname,birthDate,curp,rfc,salary,"Management", hireDate, schedule);
    }

    public String showManagement(){
        return super.showEmployee();
    }
}