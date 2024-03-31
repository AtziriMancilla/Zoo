public class Guide extends Employee{
    public Guide(String name, String lastname, Date birthDate, String curp, String rfc, double salary, Date hireDate, String schedule){
        super(name,lastname,birthDate,curp,rfc,salary,"Guide", hireDate, schedule);
    }
    public String showGuide(){
        return super.showEmployee();
    }
}
