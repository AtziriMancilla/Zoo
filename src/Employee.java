import java.util.Scanner;
public class Employee extends Person{
    private String rfc;
    private double salary;
    private String rol;
    private Date hireDate;
    private String schedule;

    public Employee(String name, String lastname, Date birthDate, String curp, String rfc, double salary, String rol, Date hireDate, String schedule) {
        super (name, lastname, birthDate, curp);
        this.rfc = rfc;
        this.salary = salary;
        this.rol = rol;
        this.hireDate = hireDate;
        this.schedule = schedule;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String showEmployee (){
        return super.showInfo()+" RFC: "+rfc+" Salary: $"+salary+" Position: "+rol+" Fecha de contratación: "+hireDate+"Horario: "+schedule; //esta llamando el metodo de clase padre y le concatena los atributos de esta clase

    }
    public void modify(){
        Scanner sc=new Scanner(System.in);
        System.out.println("¿Qué aspecto desea modificar? \n1)Nombre \n2) Apellido\n 3)Fecha de Nacimiento\n 4)CURP\n5) RFC\n6)Salario\n 7)Horario");
        int selection = sc.nextInt();
        sc.nextLine();
        switch (selection){
            case 1 -> {
                System.out.println("Ingrese el Nombre: ");
                String newName = sc.nextLine();
                setName(newName);

            }
            case 2 -> {
                System.out.println("Ingrese el Apellido: ");
                String newLastname = sc.nextLine();
                setLastname(newLastname);
            }
            case 3 -> {
                getBirthDate().modifyDate();
            }
            case 4 -> {
                System.out.println("Ingrese CURP:");
                String newCurp = sc.nextLine();
                setCurp(newCurp);
            }
            case 5 -> {
                System.out.println("Ingrese el RFC:");
                rfc = sc.nextLine();
            }
            case 6 -> {
                System.out.println("Ingrese el salario:");
                salary = sc.nextDouble();
            }
            case 7 ->{
                System.out.println("Ingrese nuevo horario:");
                schedule = sc.nextLine();
            }
            default-> System.out.println("Opción no válida");

        }
        System.out.println("Empleado modificado: "+ showEmployee());
    }
}
