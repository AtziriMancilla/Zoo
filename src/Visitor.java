
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

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setTotalVisits(int totalVisits) {
        this.totalVisits = totalVisits;
    }
    public String showVisitor (){
        return super.showInfo()+" Total visits: "+getTotalVisits()+" Register date: "+getRegisterDate().showDate();

    }
    //permite que el usuario modifique los atributos de un visitante
    public void modify(){
        System.out.println("¿Qué aspecto desea modificar? \n1)Nombre \n2)Apellido\n3)Fecha de Nacimiento\n4)CURP");
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
                Scanner sc =new Scanner(System.in);
                String newLastname = sc.nextLine();
                setLastname(newLastname);
            }
            case 3 -> {
                getBirthDate().modifyDate();
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
