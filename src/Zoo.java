import java.util.ArrayList;
import java.util.Scanner;

public class Zoo {
    private ArrayList<Guide> guides= new ArrayList<Guide>();
    private ArrayList<Maintenance> maintenances= new ArrayList<Maintenance>();
    private ArrayList<Vet> vets= new ArrayList<Vet>();
    private ArrayList<Management> managements= new ArrayList<Management>();
    private ArrayList<Visitor> visitors= new ArrayList<Visitor>();
    private ArrayList<Visit> visits = new ArrayList<Visit>();
    private ArrayList<Animals> animals = new ArrayList<Animals>();
    private ArrayList<Care> cares = new ArrayList<Care>();
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
    public void addVisitors(){
        Scanner sc = new Scanner(System.in);
        //nombre completo
        System.out.println("Ingrese el nombre: ");
        String name=sc.nextLine();
        System.out.println("Ingrese el apellido: ");
        String lastName=sc.nextLine();
        if (name.isEmpty()||lastName.isEmpty()){
            System.out.println("Debe llenar el nombre completo correctamente");
            return;
        }

        System.out.println("Ingrese el dia de nacimiento");
        int day=sc.nextInt();
        System.out.println("Ingrese el mes de nacimiento");
        int month=sc.nextInt();
        System.out.println("Ingrese el año de nacimiento");
        int year=sc.nextInt();
        if (validateDate(day, month, year)==false){
            System.out.println("Fecha inválida");
            return;
        }
        Date birthDate=new Date(day,month,year);

        System.out.println("Ingrese la curp");
        String curp=sc.next();  //hacemos método para validar curp??

        System.out.println("Fecha de registro del visitante: ");
        System.out.println("Ingrese día: ");
        int rday= sc.nextInt();
        System.out.println("Ingrese mes (1-12) : ");
        int rmonth = sc.nextInt();
        System.out.println("Ingrese año(AAAA): ");
        int ryear = sc.nextInt();
        if (validateDate(rday, rmonth, ryear)==false){
            System.out.println("Fecha inválida");
            return;
        }
        Date registerDate = new Date(rday, rmonth, ryear);
        //se crea el visitante
        Visitor newVisitor = new Visitor(name, lastName, birthDate, curp, registerDate);
        //se agrega a la lista
        visitors.add(newVisitor);
    }
    //Añade las visitas
    public void addVisit(){
        boolean revDate = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona el guía:\n");
        showGuides();
        System.out.print("\nRespuesta: ");
        int res = sc.nextInt();
        sc.nextLine();
        res -= 1;
        Guide guide = guides.get(res);
        System.out.println("Registra la fecha de la visita:\n");
        do{
            System.out.print("\nIngresa el día: ");
            int dayOfMonth = sc.nextInt();
            sc.nextLine();
            System.out.print("\nIngresa el mes: ");
            int month = sc.nextInt();
            sc.nextLine();
            System.out.print("\nIngresa el año: ");
            int year = sc.nextInt();
            sc.nextLine();
            revDate = validateDate(dayOfMonth,month,year);
            if(revDate==false) System.out.println("Error. La fecha ingresada no es válida.\n");
            else{
                Date date = new Date(dayOfMonth,month,year);
                Visit visit = new Visit(guide,date);
                visits.add(visit);
            }
        }while (revDate);
    }
    //Add animal
    public void addAnimal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese tipo de animal: ");
        String typeAnimal = sc.nextLine();
        System.out.println("Fecha de llegada");
        System.out.println("Ingrese día: ");
        int rday= sc.nextInt();
        System.out.println("Ingrese mes (1-12) : ");
        int rmonth = sc.nextInt();
        System.out.println("Ingrese año(AAAA): ");
        int ryear = sc.nextInt();
        if (validateDate(rday, rmonth, ryear)==false){
            System.out.println("Fecha inválida");
            return;
        }
        Date arrivalDate = new Date(rday, rmonth, ryear);

        System.out.println("Ingrese tipo de dieta: ");
        String diet = sc.nextLine();
        System.out.println("Fecha Nacimiento");
        System.out.println("Ingrese día: ");
        int bday= sc.nextInt();
        System.out.println("Ingrese mes (1-12) : ");
        int bmonth = sc.nextInt();
        System.out.println("Ingrese año(AAAA): ");
        int byear = sc.nextInt();
        if (validateDate(rday, rmonth, ryear)==false){
            System.out.println("Fecha inválida");
            return;
        }
        Date birthDate = new Date(rday, rmonth, ryear);
        System.out.println("Ingrese peso (kg) : ");
        double weight = sc.nextDouble();
        System.out.println("Veces que se alimenta por semana: ");
        int feedingFrequency = sc.nextInt();
        System.out.println("¿Tiene sus vacunas?\n 1) Si 2) No");
        int vaccinated = sc.nextInt();
        boolean isVaccinated;
        if (vaccinated==1){isVaccinated=true;}
            else if (vaccinated==2) {isVaccinated=false;}
                else{
            System.out.println("No es una entrada válida");
            return;
                }
             //crear objeto y añadirlo a la lista
        Animals newAnimal = new Animals(typeAnimal, arrivalDate, diet, birthDate,weight,feedingFrequency,isVaccinated );
        animals.add(newAnimal);
    }
    //Añade los cuidados realizados
    public void addCare(){
        boolean revDate = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Registra la fecha de cuidados:");
        do{
            System.out.print("\nIngresa el día: ");
            int dayOfMonth = sc.nextInt();
            sc.nextLine();
            System.out.print("\nIngresa el mes: ");
            int month = sc.nextInt();
            sc.nextLine();
            System.out.print("\nIngresa el año: ");
            int year = sc.nextInt();
            sc.nextLine();
            revDate = validateDate(dayOfMonth,month,year);
            if(revDate==false) System.out.println("Error. La fecha ingresada no es válida.\n");
            else{
                Date processDate = new Date(dayOfMonth,month,year);
                System.out.println("Selecciona el empleado:\n");
                showMaintenances();
                System.out.print("\nRespuesta: ");
                int res = sc.nextInt();
                sc.nextLine();
                res -= 1;
                Maintenance employeeInCharge = maintenances.get(res);
                System.out.println("Selecciona el animal:\n");
                int x = 1;
                for(Animals animal:animals){
                    System.out.printf("\n%d) Animal: %s",x,animal.getType());
                    x+=1;
                }
                System.out.print("\nRespuesta: ");
                int an=sc.nextInt();
                sc.nextLine();
                an-=1;
                Animals animal = animals.get(an);
                long idAnimal = animal.getId();
                System.out.print("\nEsribe el proceso realizado: ");
                String processRealized = sc.nextLine();
                System.out.print("\nAnota las observaciones: ");
                String observations = sc.nextLine();
                Care care = new Care(employeeInCharge,processRealized,idAnimal,processDate,observations);
                cares.add(care);
            }
        }while (revDate);
    }

    public void deleteAnimal(){
        Scanner sc = new Scanner(System.in);
        int x = 1;
        System.out.println("Selecciona el animal a eliminar:");
        for(Animals animal:animals){
            System.out.printf("\n%d) Animal: %s",x,animal.getType());
            x += 1;
        }
        System.out.print("\nRespuesta: ");
        int res = sc.nextInt();
        sc.nextLine();
        res -= 1;
        animals.remove(res);
        System.out.println("Animal eliminado de la base de datos.");
    }

    public void showVisits(){
        for(Visit visit:visits){
            System.out.println("\n\tVisita:");
            System.out.printf("Guía: %s",visit.getGuide());
            System.out.printf("Fecha: %s",visit.getVisitDate());
            System.out.printf("Costo: %f",visit.getTotalCost());
            System.out.println("***************");
        }
    }

    public void showCareList(){
        for(Care care:cares){
            System.out.println("\n\tCuidados:");
            Maintenance employee = care.getEmployeeInCharge();

        }
    }
    public void Tester(){
        Date birthDateAlex = new Date(4,2,2003);
        Date birthDateAtziri = new Date(5, 6, 1996);
        Date birthDateJafet = new Date (30, 1, 1997);
        Guide guide1 = new Guide("Alejandro", "Montejano", birthDateAlex, "MODA030204LMN01", "MODA83726", 2000);
        Guide guide2 = new Guide("Jafet", "Santoyo", birthDateJafet, "SABE970130LJBSA01", "SABJ87657", 2000);
        Guide guide3 = new Guide("Atziri", "Mancilla", birthDateAtziri, "MACA05061997LMN12", "MACA0506199710", 2001);
        guides.add(guide1);
        guides.add(guide2);
        guides.add(guide3);

    }
}

    }