
import java.util.ArrayList;
public class Animals {
    //private long id;
    //Andy: Quiero hacer mejor un id que empiece en 0 para que no haya problema con la verificación
    private static int cantAnimal=0;
    int id;
    private String type;
    private Date arrivalDate;
    private ArrayList<String> listDiseases = new ArrayList<>();
    private String diet;
    private Date birthDate;
    private double weight;
    private int feedingFrequency;
    private boolean isVaccinated;

    public Animals(String type, Date arrivalDate, String diet, Date birthDate, double weight, int feedingFrequency, boolean isVaccinated) {
        //this.id = id;
        id = Animals.cantAnimal++;
        this.type = type;
        this.arrivalDate = arrivalDate;
        this.diet = diet;
        this.birthDate = birthDate;
        this.weight = weight;
        this.feedingFrequency = feedingFrequency;
        this.isVaccinated = isVaccinated;
    }
    public void addDisease(String newDisease){
        listDiseases.add(newDisease);
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public ArrayList<String> getListDiseases() {
        return listDiseases;
    }

    public String getDiet() {
        return diet;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public double getWeight() {
        return weight;
    }

    public int getFeedingFrequency() {
        return feedingFrequency;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setFeedingFrequency(int feedingFrequency) {
        this.feedingFrequency = feedingFrequency;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }
    public String showAnimal(){
        String aDate= Integer.toString(arrivalDate.getDayOfMonth())+"/" +Integer.toString(arrivalDate.getMonth())+"/"+Integer.toString(arrivalDate.getYear());
        String bDate= Integer.toString(birthDate.getDayOfMonth())+"/" +Integer.toString(birthDate.getMonth())+"/"+Integer.toString(birthDate.getYear());
        return String.format("ID: %d|| type: %s|| Fecha de llegada: %s|| diet: %s|| Fecha nacimiento: %s|| Peso: %f|| Frecuencia de alimentacion: %d|| Esta vacunado: %b", id, type, aDate,diet, bDate,weight,feedingFrequency,isVaccinated);
    }
}
