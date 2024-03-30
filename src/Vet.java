public class Vet extends Employee{
    public Vet (String name, String lastname, Date birthDate, String curp, String rfc, double salary){
        super (name,lastname,birthDate,curp,rfc,salary,"Vet");
    }

    public String showVet(){
        return super.showEmployee();
    }
}