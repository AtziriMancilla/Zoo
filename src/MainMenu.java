import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String password = "uwu";
        System.out.println(">>>Bienvenido al zoológico<<<");
        System.out.println("Ingrese contraseña: ");
        String userInput = sc.nextLine();

        if(userInput.equals(password)){
            showMenu();
        }
        else {
            System.out.println("Contraseña inválida, intente más tarde");
        }
    }
    public static void showMenu(){
        Scanner sc = new Scanner(System.in);
        Zoo zoo = new Zoo();
        boolean flag = true;
        zoo.Tester();
            do{
                System.out.println(">>>Bienvenido al sistema<<<");
                System.out.println("¿Qué acción desea realizar?\n" +
                        "1) Registrar empleado\n" +
                        "2) Registrar visitante\n" +
                        "3) Registrar visita\n" +
                        "4) Registrar animal\n" +
                        "5) Registrar mantenimiento\n" +
                        "6) Modificar empleado\n" +
                        "7) Modificar registro de animal\n" +
                        "8) Modificar visitante\n" +
                        "9) Eliminar empleado\n" +
                        "10) Eliminar Animal\n" +
                        "11) Eliminar visitante\n" +
                        "12) Consultar empleados\n" +
                        "13) Consultar animales\n" +
                        "14) Consultar visitantes\n" +
                        "15) Consultar visitas\n" +
                        "16) Consultar mantenimientos\n" +
                        "0) Salir");

                int option = sc.nextInt();
                switch (option){
                case 1 -> zoo.addEmployee();
                case 2 -> zoo.addVisitors();
                case 3 -> zoo.addVisit();
                case 4 -> zoo.addAnimal();
                case 5 -> zoo.addCare();
                case 6 -> zoo.modifyEmployee();
                case 7 -> zoo.modifyAnimalRegister();
                case 8 -> zoo.modifyVisitor();
                case 9 -> zoo.deleteEmployee();
                case 10 -> zoo.deleteAnimal();
                case 11 -> zoo.deleteVisitor();
                case 12 -> zoo.showEmployees();
                case 13 -> zoo.showAnimals();
                case 14 -> zoo.showVisitors();
                case 15 -> zoo.showVisits();
                case 16 -> zoo.showCareList();
                case 0 -> flag=false;
                 }

            } while (flag);
    }
}