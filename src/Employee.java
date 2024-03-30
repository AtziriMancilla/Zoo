public class Employee extends Person{
    private String rfc;
    private double salary;
    private String rol;

    public Employee(String name, String lastname, Date birthDate, String curp, String rfc, double salary, String rol) {
        super (name, lastname, birthDate, curp);
        this.rfc = rfc;
        this.salary = salary;
        this.rol = rol;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String showEmployee (){
        return super.showInfo()+" RFC: "+rfc+" Salary: $"+salary+" Position: "+rol; //esta llamando el metodo de clase padre y le concatena los atributos de esta clase

    }
}
