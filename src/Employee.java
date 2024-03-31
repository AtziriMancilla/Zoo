import java.util.Scanner;
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
    public void modify(){
        Scanner sc=new Scanner(System.in);
        System.out.println("¿Qué aspecto desea modificar? \n1)Nombre \n2) Apellido\n 3)Fecha de Nacimiento\n 4)CURP\n5) RFC\n6.Salario");
        int selection = sc.nextInt();
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
                System.out.println("Ingrese CURP");
                String newCurp = sc.nextLine();
                setCurp(newCurp);
            }
            case 5 -> {
                System.out.println("Ingrese el RFC");
                this.rfc = sc.nextLine();
            }
            case 6 -> {
                System.out.println("Ingrese el salario");
                salary = sc.nextDouble();
            }
            default-> System.out.println("Opción no válida");

        }
        System.out.println("Información guardada: "+ showEmployee());
    }
}
