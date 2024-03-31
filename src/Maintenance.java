public class Maintenance extends Employee{
    public Maintenance (String name, String lastname, Date birthDate, String curp, String rfc, double salary, Date hireDate, String schedule){
        super (name,lastname,birthDate,curp,rfc,salary,"Maintenance", hireDate, schedule);
    }

    public String showMaintenance(){
        return super.showEmployee();
    }
}