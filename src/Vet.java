public class Vet extends Employee{
    public Vet (String name, String lastname, Date birthDate, String curp, String rfc, double salary, Date hireDate, String schedule){
        super (name,lastname,birthDate,curp,rfc,salary,"Vet", hireDate, schedule);
    }

    public String showVet(){
        return super.showEmployee();
    }
}