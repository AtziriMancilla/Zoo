import java.util.ArrayList;

public class Visit {

    private Guide guide;
    private ArrayList<Visitor> visitors=new ArrayList<>();
    private double totalCost=cost();
    private int kidsQuanty=kidsQuanty();
    private int adultsQuanty= calculateAdultsQuanty();
    private Date visitDate;
    public Visit(Guide guide,Date visitDate){
        this.guide=guide;
        this.visitDate=visitDate;
    }
    public double getTotalCost() {
        totalCost=cost();
        return totalCost;
    }
    public int getKidsQuanty() {
        kidsQuanty= kidsQuanty();
        return kidsQuanty;
    }
    public int getAdultsQuanty() {
        adultsQuanty= calculateAdultsQuanty();
        return adultsQuanty;
    }
    public Guide getGuide() {

        return guide;
    }
    public Date getVisitDate() {

        return visitDate;
    }
    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }
    public void addVisitor(Visitor visitor){
        if(visitors.contains(visitor)){
            System.out.println("Este visitante ya fue registrado");
        }
        else {
            visitor.addVisit();
            visitors.add(visitor);
        }
    }
    public void deleteVisitor(Visitor visitor){
        visitors.remove(visitor);
    }
    //Calcula el costo total de la visita
    private double cost(){
        double cost=0;
        for (int i=0;i<visitors.size();i++){
            cost+=visitors.get(i).calculateTicketCost();
        }
        return cost;
    }
    //calcula el total de ninos
    private int kidsQuanty(){
        int quanty=0;
        for (int i=0;i<visitors.size();i++){
            if(!visitors.get(i).isAnAdult()){
                quanty++;
            }
        }
        return quanty;
    }
    //calcula el total de adultos
    private int calculateAdultsQuanty(){
        int quanty=0;
        for (int i=0;i<visitors.size();i++){
            if(visitors.get(i).isAnAdult()){
                quanty++;
            }
        }
        return quanty;
    }
    public void showVisitors(){
        int i =1;
        for ( Visitor visitor : visitors){
            System.out.println(visitor.showVisitor());
            i++;
        }
    }
    public void showVisit (){
        System.out.println("Guía: "+getGuide().showGuide()+"\nVisitantes: ");
        showVisitors();
        System.out.println("\n Total cost: "+getTotalCost()+
                "\n Cantidad de niños: "+getKidsQuanty()+"\nCantidad adultos :"+getAdultsQuanty()+"\nFecha de visita: "+getVisitDate().showDate());
    }
}
