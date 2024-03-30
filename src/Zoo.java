import java.util.ArrayList;
import java.util.Scanner;

public class Zoo {
    private ArrayList<Guide> guides= new ArrayList<Guide>();
    private ArrayList<Maintenance> maintenances= new ArrayList<Maintenance>();
    private ArrayList<Vet> vets= new ArrayList<Vet>();
    private ArrayList<Management> managements= new ArrayList<Management>();
    private ArrayList<Visitor> visitors= new ArrayList<Visitor>();
    //Metodo agregar empleados de cualquier tipo
    public void addEmployee(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese el nombre: ");
        String name=sc.nextLine();
        System.out.println("Ingrese el apellido: ");
        String lastName=sc.nextLine();
        System.out.println("Ingrese el dia de nacimiento");
        int day=sc.nextInt();
        System.out.println("Ingrese el mes de nacimiento");
        int month=sc.nextInt();
        System.out.println("Ingrese el año de nacimiento");
        int year=sc.nextInt();
        if(validateDate(day,month,year)) {
            Date date = new Date(day, month, year);
            System.out.println("Ingrese la curp");
            String curp = sc.next();
            System.out.println("Ingrese el RFC");
            String rfc = sc.next();
            System.out.println("Ingrese el salario");
            double salary = sc.nextDouble();
            //asigna el rol al empleado
            System.out.println("Seleccione el tipo de empleado: \n1. Guia\n2. Veterinario\n3. Mantenimiento\n4. Administracion");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    guides.add(new Guide(name, lastName, date, curp, rfc, salary));
                    System.out.println("Guia agregado con exito");
                    break;
                case 2:
                    vets.add(new Vet(name,lastName,date,curp,rfc,salary));
                    System.out.println("Veterinario agregado con exito");
                    break;
                case 3:
                    maintenances.add(new Maintenance(name,lastName,date,curp,rfc,salary));
                    System.out.println("Empleado de mantenimiento agregado con exito");
                    break;
                case 4:
                    managements.add(new Management(name,lastName,date,curp,rfc,salary));
                    System.out.println("Administrador agregado con exito");
                    break;
                default:
                    System.out.println("No fue posible agregar el empleado");
                    break;
            }
        }
        else{
            System.out.println("La fecha no es valida, no se pudo realizar el registro");
        }
    }
    private static boolean validateDate(int dayOfMonth,int month,int year){
        Boolean band=true;
        if(dayOfMonth<1||dayOfMonth>31)
            band=false;
        if(month<1||month>12)
            band=false;
        if(year<1900&&year>2024)
            band=false;
        return band;
    }
    //muestra los guias
    public void showGuides(){
        if(guides.isEmpty()) System.out.println("No hay guias registrados");
        else {
            int i=1;
            for (Guide guide : guides) {
                System.out.println(i+") "+guide.showGuide());
                i++;
            }
        }
    }
    //muestra los veterinarios
    public void showVets(){
        if(vets.isEmpty()) System.out.println("No hay veterinarios registrados");
        else {
            int i=1;
            for (Vet vet : vets) {
                System.out.println(i+") "+vet.showVet());
                i++;
            }
        }
    }
    //muestra los administradores
    public void showManagements(){
        if(managements.isEmpty()) System.out.println("No hay administradores registrados");
        else {
            int i=1;
            for (Management management : managements) {
                System.out.println(i+") "+management.showManagement());
                i++;
            }
        }
    }
    //muestra los empleados de mantenimiento
    public void showMaintenances(){
        if(maintenances.isEmpty()) System.out.println("No hay empleados de mantenimiento registrados");
        else {
            int i=1;
            for (Maintenance maintenance : maintenances) {
                System.out.println(i+") "+maintenance.showMaintenance());
                i++;
            }
        }
    }
    public void showEmployees(){
        System.out.println("Guias: ");
        showGuides();
        System.out.println("Veterinarios: ");
        showVets();
        System.out.println("Mantenimiento: ");
        showMaintenances();
        System.out.println("Administradores: ");
        showManagements();
    }
}
