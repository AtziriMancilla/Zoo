public class Maintenance extends Employee{
    public Maintenance (String name, String lastname, Date birthDate, String curp, String rfc, double salary){
        super (name,lastname,birthDate,curp,rfc,salary,"Maintenance");
    }

    public String showMaintenance(){
        return super.showEmployee();
    }
}