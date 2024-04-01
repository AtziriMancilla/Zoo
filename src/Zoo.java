import java.awt.image.VolatileImage;
import java.util.ArrayList;
import java.util.Scanner;

public class Zoo{
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
        System.out.println("Fecha de Nacimiento");
        Date date=registerDate();
        System.out.println("Fecha de contratación");
        Date hireDate = registerDate(); //sorry se me pasó la fecha de contratación :(
        if(date!=null&&hireDate!=null) {
            System.out.println("Ingrese la curp");
            String curp = sc.next();
            System.out.println("Ingrese el RFC");
            String rfc = sc.next();
            System.out.println("Ingrese el salario");
            double salary = sc.nextDouble();
            sc.nextLine();
            System.out.println("Ingrese el horario: ");
            String schedule = sc.nextLine();

            //asigna el rol al empleado
            System.out.println("Seleccione el tipo de empleado: \n1. Guia\n2. Veterinario\n3. Mantenimiento\n4. Administracion");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    guides.add(new Guide(name, lastName, date, curp, rfc, salary, hireDate, schedule));
                    System.out.println("Guia agregado con exito");
                    break;
                case 2:
                    vets.add(new Vet(name,lastName,date,curp,rfc,salary, hireDate, schedule));
                    System.out.println("Veterinario agregado con exito");
                    break;
                case 3:
                    maintenances.add(new Maintenance(name,lastName,date,curp,rfc,salary, hireDate, schedule));
                    System.out.println("Empleado de mantenimiento agregado con exito");
                    break;
                case 4:
                    managements.add(new Management(name,lastName,date,curp,rfc,salary, hireDate, schedule));
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
    // Crea una fecha de tipo date pidiendo datos al usuario, y verifica si es valida, en caso contrario regresa null
    public Date registerDate(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Dia (1-31): ");
        int newDay = sc.nextInt();
        System.out.println("Mes(1-12): ");
        int newMonth = sc.nextInt();
        System.out.println("Año(AAAA): ");
        int newYear = sc.nextInt();
        if(validateDate(newDay,newMonth,newYear)) {
            Date date = new Date(newDay, newMonth, newYear);
            return date;
        }
        return null;
    }
    private static boolean validateDate(int dayOfMonth,int month,int year){
        Boolean band=true;
        if(dayOfMonth<1||dayOfMonth>31)
            band=false;
        if(month<1||month>12)
            band=false;
        if(year<1900||year>2024)
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
    public void showAnimals(){
        if(animals.isEmpty())
            System.out.println("No hay animales registrados");
        else {
            int i=1;
            for (Animals animal : animals) {
                System.out.println(i+") "+animal.showAnimal());
                i++;
            }
        }
    }
    public void showVisitors(){
        if(visitors.isEmpty())
            System.out.println("No hay visitantes registrados");
        else {
            int i=1;
            for (Visitor visitor : visitors) {
                System.out.println(i+") "+visitor.showVisitor());
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
        System.out.println("Registro de fecha nacimiento");
        Date birthDate=registerDate();
        if (birthDate==null){
            System.out.println("Fecha de nacimiento no válida");
            return;}
        System.out.println("Ingrese la curp");
        String curp=sc.next();  //hacemos método para validar curp??

        System.out.println("Fecha de registro del visitante: ");
        Date registerDate= registerDate();
        if (registerDate==null){
            System.out.println("Fecha de registro no válida");
            return;
        }

        //se crea el visitante
        Visitor newVisitor = new Visitor(name, lastName, birthDate, curp, registerDate);
        //se agrega a la lista
        visitors.add(newVisitor);
        System.out.println("Visitante creado con éxito");
    }

    //Añade las visitas, agrega visitantes y válida si el visitante para que no sea agregado dos veces
    public void addVisit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Guias");
        showGuides();
        System.out.print("Ingrese el numero de guia: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        Guide guide = guides.get(opcion-1);
        System.out.println("Ingresa la fecha de visita");
        Date date=registerDate();
        if(date==null)
            System.out.println("Error. La fecha ingresada no es válida.\n");
        else {
            boolean band = true;
            Visit visit = new Visit(guide, date);
            visits.add(visit);
            while (band) {
                System.out.println("Si desea ingresar un visitante ingrese el numero, ingrese 0 para salir");
                showVisitors();
                opcion = sc.nextInt();
                sc.nextLine();
                if (opcion == 0) {
                    band = false;
                }
                if(opcion > visitors.size()){
                    System.out.println("Ingrese un numero de visitante valido");
                }
                if(opcion>0&&opcion<=visitors.size()){
                    if (validateVisitors(visit,visitors.get(opcion - 1))) {
                        visit.addVisitor(visitors.get(opcion - 1));
                        System.out.println("Usuario agregado");
                    }
                    else {
                        System.out.println("El usuario ya está en ésta visita");
                    }
                }
            }
            System.out.println("Visita creada con éxito");
        }
    }
    //válida que el usuario no esté en una visita
    private static boolean validateVisitors(Visit visit,Visitor visitor){
        boolean band=true;
        if(visit.getVisitors().contains(visitor))
            band=false;
        return band;
    }

    //Add animal
    public void addAnimal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese tipo de animal: ");
        String typeAnimal = sc.nextLine();
        System.out.println("Fecha de llegada");
        Date arrivalDate = registerDate();
        if(arrivalDate==null){
            System.out.println("Fecha no válida");
            return;
        }

        System.out.println("Ingrese tipo de dieta: ");
        String diet = sc.nextLine();
        System.out.println("Fecha Nacimiento");
        Date birthDate = registerDate();
        if(birthDate==null){
            System.out.println("Fecha no válida");
            return;
        }

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
        System.out.println("Animal registrado en sistema");
    }
    //Añade los cuidados realizados
    public void addCare(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccionaste añadir cuidado/mantenimiento \n" +
                "Selecciona el número de empleado a cargo");
            showMaintenances();
            int employeeSelected = sc.nextInt();
            employeeSelected--;
            Maintenance staff = maintenances.get(employeeSelected);
         //empleado es el staff
            System.out.println("Ingrese proceso realizado:");
             sc.nextLine();
             String processRealized = sc.nextLine();
             System.out.println("Selecciona el número de animal al que realizarás cuidado");
        showAnimals();
        int animalselected = sc.nextInt();
        animalselected--;
        System.out.println("Seleccionaste "+animals.get(animalselected).showAnimal());
        int idAnimal = animals.get(animalselected).getId();
        // fecha del proceso
        System.out.println("Fecha del proceso: ");
        Date processDate = registerDate();
        if(processDate==null){
            System.out.println("Fecha no válida");
            return;
        }
        System.out.println("Observaciones (opcional): ");
        sc.nextLine();
        String observations = sc.nextLine();
        ///////////Crear obejto
        Care newCare = new Care(staff, processRealized, idAnimal, processDate, observations);
        System.out.println("Cuidado registrado, gracias por cuidar tqm");

    }
    //modificar registrodelAnimal
    public void modifyAnimalRegister() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elija el animal al que desea actualizar su registro");
        //falta mostrar lista y elija
        showAnimals();
        int opcion=sc.nextInt();
        System.out.println("Has seleccionado: "+ animals.get(opcion-1).showAnimal() );

        System.out.println("¿Qué cambio desea realizar?\n1)Registrar Enfermedad\n2)Actualizar peso\n" +
                "3)Cambiar tipo de alimentación\n4)Cambiar frecuencia de alimentación\n5)Registrar vacunación\n0) Atrás ");
         int option = sc.nextInt();
        switch (option){
            case 1 -> {
                System.out.println("Ingrese enfermedad: ");
                sc.nextLine();
                String newDiesease = sc.nextLine();
                animals.get(opcion-1).addDisease(newDiesease);
                System.out.println("Enfermedad agregada");
            }
            case 2 ->{
                System.out.println("Ingrese nuevo peso (Kg): ");
                double newWeight = sc.nextDouble();
                animals.get(opcion-1).setWeight(newWeight);
                System.out.println("El nuevo peso de "+animals.get(opcion-1).getType()+" ||ID: "+animals.get(opcion-1).getId()+ " es: "+animals.get(opcion-1).getWeight()+ "Kg");
            }
            case 3 ->{
                System.out.println("Ingrese nueva dieta: ");
                sc.nextLine();
                String newDiet = sc.nextLine();
                animals.get(opcion-1).setDiet(newDiet);
                System.out.println("Dieta actualizada");
            }
            case 4 ->{
                System.out.println("Elegiste cambiar frecuencia de alimentación");
                System.out.println("Ingrese número de veces por semana: ");
                int newFrequency = sc.nextInt();
                animals.get(opcion-1).setFeedingFrequency(newFrequency);
                System.out.println("Frecuencia actualizada");
            }
            case 5 ->{
                System.out.println("Elegiste actualizar vacunación");
                System.out.println("¿Tiene todas sus vacunas?\n 1)Si 2) No");
                int desition = sc.nextInt();
                        if (desition==1){animals.get(opcion-1).setVaccinated(true);
                            System.out.println("Ahora "+animals.get(opcion-1).getType()+" ||ID: "+animals.get(opcion-1).getId()+ " está vacunado");
                        }
                            else if (desition==2) {animals.get(opcion-1).setVaccinated(false);
                            System.out.println("Se ha actualizado que "+animals.get(opcion-1).getType()+" ||ID: "+animals.get(opcion-1).getId()+ " requiere vacunas");
                            }
                             else {
                                System.out.println("Entrada no válida");
                             }
            }

            case 0 ->{ }
            default -> System.out.println("Entrada no válida");

        }

    }
    //Borrar empleados
    public void deleteEmployee(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué tipo de empleado desea eliminar? \n1. Guia\n2. Veterinario\n3. Mantenimiento\n4. Administracion\n0. Salir");
        int selection = sc.nextInt();
        switch (selection){
            case 1->{//mostrar guias
                showGuides();
                System.out.println("Selecciona el empleado que desea eliminar");
                int guideToDelete = sc.nextInt();
                guideToDelete--;
                guides.remove(guideToDelete);
                System.out.println("Empleado eliminado");
                //segun yo solo se elimina de la lista guias y no afecta el que haya objetos creados con él.
                //creo que de empleados no se debe eliminar porque borrarlo si afectaria el objeto visita
            }
            case 2 ->{//mostrar veterinarios
                showVets();
                System.out.println("Selecciona el empleado que desea eliminar");
                int vetToDelete = sc.nextInt();
                vetToDelete--;
                vets.remove(vetToDelete);
                System.out.println("Empleado eliminado");
            }
            case 3 ->{
                showMaintenances();
                System.out.println("Selecciona el empleado que desea eliminar");
                int staffToDelete = sc.nextInt();
                staffToDelete--;
                vets.remove(staffToDelete);
                System.out.println("Empleado eliminado");
            }
            case 4 ->{
                showManagements();
                System.out.println("Selecciona el em´leado que desea eliminar");
                int managerToDelete = sc.nextInt();
                managerToDelete--;
                vets.remove(managerToDelete);
                System.out.println("Empleado eliminado");
            }
            case 0->{}
            default -> {
                System.out.println("Entrada no válida");
            }

        }

    }
    public void deleteAnimal(){
        Scanner sc = new Scanner(System.in);
        int i = 1;
        System.out.println("Selecciona el animal a eliminar:");
        for(Animals animal:animals){
            System.out.println(i+") "+animal.showAnimal());
            i += 1;
        }

        int selection = sc.nextInt();
        selection -= 1;
        System.out.println("Seleccionaste: "+ animals.get(selection).showAnimal());
        System.out.println("¿Estás seguro de que lo quieres eliminar?\n 1)Si 2)Cancelar");
        sc.nextLine();
        int confirmation= sc.nextInt();
        if (confirmation==1) {
            animals.remove(selection);
            System.out.println("Animal eliminado de la base de datos.");
        }
        else {
            System.out.println("Se canceló su eliminación");
        }
    }
    //eliminar visitante
    public void deleteVisitor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el visitante que desea eliminar: ");
        showVisitors();
        int visitorToDelete = sc.nextInt(); //el método showVisitors muestra a partir de 1. fíjate en eso si te causa problema
        visitorToDelete--;
        //asegurarse que no haya un objeto visita con un solo visitante
        //Andy Pregunta:¿Será buena idea que el visitor tenga un arraylist de sus visitas?
        //no sé como filtrar en lista de visitas
        //
        // ya si no rompe relación
        visitors.remove(visitorToDelete);
    }

    public void showVisits() {
        if (visits.isEmpty()) {
            System.out.println("No hay visitas para mostrar");
        } else {
            int i=1;
            for (Visit visit : visits) {
                System.out.print("Visita: "+i+" ");visit.showVisit();
                i++;
                System.out.println(".....................................");
            }
        }
    }

    public void showCareList () {
        if(cares.isEmpty()){
            System.out.println("No hay registros");
        }
        else {
            System.out.println(">>>Lista de Cuidados<<<");
            int i =1;
            for (Care care : cares) {

                System.out.print(i+")");care.showCare();
                i++;
            }
        }
    }

    public void Tester(){
        Date birthDateAlex = new Date(4,2,2003);
        Date birthDateAtziri = new Date(5, 6, 1996);
        Date birthDateJafet = new Date (30, 1, 1997);
        Date birthDateAlan = new Date(5, 6, 1996);
        Date registerAlan=new Date(31,3,2024);
        Date birthDatePao= new Date(23, 4, 1997);
        Date registerPao = new Date(30, 03, 2024);
        Date birthDateMarcos = new Date(15,1, 1990);
        Date birthDateFany = new Date(7, 6, 2003);
        Date birthDateRubi = new Date (10, 2, 1996);
        Date birthDateMore = new Date(25, 8, 2003);
        Date birthDateEd = new Date(23, 1, 2000);
        Date registerMarcos=new Date(25, 02, 2014);
        Date registerFany = new Date(12, 04, 2005);
        Date registerRubi = new Date(25, 8, 2019);
        Date registerMore = new Date(26, 8, 2008);
        Date registerEd = new Date(20, 9, 2019);
        Date visitDate = new Date(31, 03, 2024);
        Date hireDategeneral = new Date(2, 1, 2005);
        String guideSchedule = "Mie-Dom 9-17";

        Guide guide1 = new Guide("Alejandro", "Montejano", birthDateAlex, "MODA030204LMN01", "MODA83726", 2000, hireDategeneral,guideSchedule);
        Guide guide2 = new Guide("Jafet", "Santoyo", birthDateJafet, "SABE970130LJBSA01", "SABJ87657", 2000, hireDategeneral, guideSchedule);
        Guide guide3 = new Guide("Atziri", "Mancilla", birthDateAtziri, "MACA05061997LMN12", "MACA0506199710", 2001, hireDategeneral, guideSchedule);
        guides.add(guide1);
        guides.add(guide2);
        guides.add(guide3);
        Visitor visitor1 = new Visitor("Alan","Lopez",birthDateAlan,"LOMA220522HHNOSE",registerAlan);
        Visitor visitor2 = new Visitor("Paola Itzel", "Cobián", birthDatePao, "NECO970423HLOUWU", registerPao );
        Visitor visitor3= new Visitor("Marcos", "Sánchez", birthDateMarcos, "SAHM9862543HOLI", registerMarcos);
        Visitor visitor4= new Visitor("Estefanía", "López", birthDateFany, "ESLO982345JAHSBR", registerFany);
        Visitor visitor5= new Visitor("Rubi", "Martinez", birthDateRubi, "RUBA986543JSHLKL", registerRubi);
        Visitor visitor6= new Visitor("Morelia", "Durán", birthDateMore, "MODU030825JSHDGET", registerMore);
        visitors.add(visitor1);
        visitors.add(visitor2);
        visitors.add(visitor3);
        visitors.add(visitor4);
        visitors.add(visitor5);
        visitors.add(visitor6);
        Visit visit1 = new Visit(guide3, visitDate);
        visit1.addVisitor(visitor1);
        visit1.addVisitor(visitor2);
        visit1.addVisitor(visitor3);
        Visit visit2= new Visit(guide1,visitDate);
        visit2.addVisitor(visitor4);
        visit2.addVisitor(visitor5);
        visit2.addVisitor(visitor6);
        visits.add(visit1);
        visits.add(visit2);
        Date hireDate = new Date(2, 2, 2020);

        Vet vet1 = new Vet("Eduardo", "Martinez",birthDateEd,"MARE8976625LKJ", "JDHSGHKL1625", 2000, hireDate, "L-V 8-4");
        vets.add(vet1);
        Management manager = new Management("Dr professor", "Alejandro", birthDateAlex, "MODA030204JSHDG", "KDJDHSKL", 3000, hireDate, "L-V 8-4");
        managements.add(manager);
        Maintenance maintenance1 = new Maintenance("Juan", "Pérez", birthDateMarcos, "JDHHG09876123", "HDGHAJK1278", 2000, hireDategeneral,"L-V 8-4");
        Maintenance maintenance2 = new Maintenance("Diana", "Garnica", birthDateFany, "JHGJKLLJJK", "JDHSKLN",2000, hireDategeneral, "M-D 12-8" );
        maintenances.add(maintenance1);
        maintenances.add(maintenance2);
        //ahora animales
        Date arrivalDate = new Date (2, 6, 2000);
        Date animalbirthDate = new Date(23, 3, 1990);
        Animals animal1 =new Animals("Dolphin", arrivalDate, "piscivorous", animalbirthDate,100.5, 7, true );
        Animals animal2 = new Animals("Capybara", arrivalDate, "grasses, berries, seeds", animalbirthDate, 35, 14, true);
        Animals animal3 = new Animals("Penguin", arrivalDate, "piscivorous", animalbirthDate, 30, 14, true);
        Animals animal4 = new Animals("Flamingo", arrivalDate, "crustaceans", animalbirthDate, 3, 7, true);
        Animals animal5 = new Animals("Elephant", arrivalDate, "grasses, fruit, tree bark, roots", animalbirthDate, 5000, 21, true);
        Animals animal6 = new Animals("Panda", arrivalDate, "Bambu", animalbirthDate, 80, 14, true);
        Animals animal7 = new Animals("Red panda", arrivalDate, "Fruits, roots, bambu", animalbirthDate,14, 4, true);
        Animals animal8 = new Animals("Rattlesnake",arrivalDate, "rats", animalbirthDate, 4, 1,true);
        Animals animal9 = new Animals("Galapagos giant tortoise", arrivalDate, "fruit, leaves, vegetables", animalbirthDate, 40, 5, true);
        Animals animal10 = new Animals("White tiger", arrivalDate, "carnivorous", animalbirthDate, 1000, 3, true);
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);
        animals.add(animal5);
        animals.add(animal6);
        animals.add(animal7);
        animals.add(animal8);
        animals.add(animal9);
        animals.add(animal10);
        //crear  mantenimientos
        Date processDate = new Date(31, 3, 2024);
        Care care1 = new Care(maintenance1,"Alimentar", 0, processDate, "comió poquito :(" );
        Care care2 = new Care(maintenance2, "Curacion", 4, processDate, "Mejora significativa en sus heridas");
        cares.add(care1);
        cares.add(care2);

    }
    public void modifyEmployee(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Seleccione el tipo de empleado: \n1. Guia\n2. Veterinario\n3. Mantenimiento\n4. Administracion");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("seleccione el numero: ");
                showGuides();

                opcion=sc.nextInt();
                guides.get(opcion-1).modify();
                break;
            case 2:
                System.out.println("seleccione el numero: ");
                showVets();
                opcion=sc.nextInt();
                vets.get(opcion-1).modify();
                break;
            case 3:
                System.out.println("seleccione el numero: ");
                showMaintenances();
                opcion=sc.nextInt();
                maintenances.get(opcion-1).modify();
                break;
            case 4:
                System.out.println("seleccione el numero: ");
                showManagements();
                opcion=sc.nextInt();
                managements.get(opcion-1).modify();
                break;
            default:
                System.out.println("Opcion no válida");
                break;
        }
    }
    public void modifyVisitor(){
        Scanner sc=new Scanner(System.in);
        showVisitors();
        System.out.println("Ingrese el numero de visitante:");
        int opcion=sc.nextInt();
        visitors.get(opcion-1).modify();
    }
}