import java.util.ArrayList;

public class Visit {

    private Guide guide;
    private ArrayList<Visitor> visitors=new ArrayList<>();
    private double totalCost=cost();
    private int kidsQuanty=kidsQuanty();
    private int adultsQuanty=adultsQuanty();
    private Date visitDate;
    public Visit(Guide guide,Date visitDate){
        this.guide=guide;
        this.visitDate=visitDate;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public int getKidsQuanty() {
        return kidsQuanty;
    }
    public int getAdultsQuanty() {
        return adultsQuanty;
    }
    public Guide getGuide() {
        return guide;
    }
    public Date getVisitDate() {
        return visitDate;
    }
    public void addVisitor(Visitor visitor){
        if(visitors.contains(visitor)){
            System.out.println("Este visitante ya fue registrado");
        }
        else {
            visitor.setTotalVisits(visitor.getTotalVisits() + 1);
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
    private int adultsQuanty(){
        int quanty=0;
        for (int i=0;i<visitors.size();i++){
            if(visitors.get(i).isAnAdult()){
                quanty++;
            }
        }
        return quanty;
    }
}
