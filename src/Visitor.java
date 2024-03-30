
import java.util.Scanner;
public class Visitor extends Person{
    private int totalVisits;
    private final Date registerDate;
    Scanner sc = new Scanner(System.in);
    public Visitor(String name, String lastname, Date birthDate, String curp, Date registerDate){
        super (name, lastname, birthDate, curp);
        this.totalVisits = 0;
        this.registerDate = registerDate;
    }
    //Setters no le puse porque se supone que fecha de registro ni visitas se pueden modificar
    public int getTotalVisits() {
        return totalVisits;
    }

    public void setTotalVisits(int totalVisits) {
        this.totalVisits = totalVisits;
    }
    public String showVisitor (){
        return super.showInfo()+" Total visits: "+totalVisits+" Register date: "+registerDate;

    }
    public void modify(){
        System.out.println("¿Qué aspecto desea modificar? \n1)Nombre \n2) Apellido\n 3)Fecha de Nacimiento\n 4)CURP");
        int selection = sc.nextInt();
        switch (selection){
            case 1 -> {
                System.out.println("Ingrese el Nombre: ");
                String newName = sc.nextLine();
                setName(newName);

            }
            case 2 -> {
                System.out.println("Ingrese el Apellido: ");
                Scanner sc =new Scanner(System.in);
                String newLastname = sc.nextLine();
                setLastname(newLastname);
            }
            case 3 -> {
                System.out.println("Ingrese la fecha de Nacimiento: ");
                System.out.println("Año: ");
                int newYear = sc.nextInt();
                System.out.println("Mes: ");
                int newMonth = sc.nextInt();
                System.out.println("Dia: ");
                int newDay = sc.nextInt();

                Date newDate = new Date(newDay, newMonth, newYear);
                setBirthDate(newDate);
            }
            case 4 -> {
                System.out.println("Ingrese CURP");
                String newCurp = sc.nextLine();
                setCurp(newCurp);}

            default-> System.out.println("Opción no válida");

        }
        System.out.println("Información guardada: "+ showVisitor());
    }
    public double calculateTicketCost(){
        if(isAnAdult()){
            if(totalVisits%5==0)
                return 100*0.8;
            else return 100;
        }
        else {
            if(totalVisits%5==0)
                return 50*0.8;
            else return 50;
        }
    }
    public boolean isAnAdult(){
        int actualYear = 2024;
        int personYear = getBirthDate().getYear();
        int visitorsAge = actualYear-personYear;
        return (visitorsAge >= 18);
    }
}
