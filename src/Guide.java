public class Guide extends Employee{
    public Guide(String name, String lastname, Date birthDate, String curp, String rfc, double salary){
        super(name,lastname,birthDate,curp,rfc,salary,"Guide");
    }
    public String showGuide(){
        return super.showEmployee();
    }
}
