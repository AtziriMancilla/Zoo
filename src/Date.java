import java.util.Scanner;

public class Date {
    private int dayOfMonth;
    private int month;
    private int year;
    Date (int dayOfMonth, int month, int year){
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.year = year;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    //modifica la fecha actual y valida los datos
    public void modifyDate(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese la fecha de Nacimiento: ");
        System.out.println("Año: ");
        int newYear = sc.nextInt();
        if(newYear>1900&&newYear<2024)
            year=newYear;
        else{
            System.out.println("Año no valido");
        }
        System.out.println("Mes: ");
        int newMonth = sc.nextInt();
        if(newMonth<13&&newMonth>0)
            month=newMonth;
        else{
            System.out.println("Mes no valido");
        }
        System.out.println("Dia: ");
        int newDayOfMonth = sc.nextInt();
        if(newDayOfMonth>0&&newDayOfMonth<32)
            dayOfMonth=newDayOfMonth;
        else{
            System.out.println("dia no valido");
        }
    }
    public String showDate(){
        return Integer.toString(dayOfMonth) + "/" + Integer.toString(month) + "/" + Integer.toString(year);
    }
}

