public class Care {
    private Maintenance employeeInCharge;
    private String processRealized;
    private int idAnimal;
    private Date processDate;
    private String observations; //Obs son opcionales. como no se puede modificar el usuario va a poder no ingresar nada al momento de crear el objeto

    public Care(Maintenance employeeInCharge, String processRealized, int idAnimal, Date processDate, String observations) {
        this.employeeInCharge = employeeInCharge;
        this.processRealized = processRealized;
        this.idAnimal = idAnimal;
        this.processDate = processDate;
        this.observations = observations;
    }

    public Maintenance getEmployeeInCharge() {
        return employeeInCharge;
    }

    public String getProcessRealized() {
        return processRealized;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public String getObservations() {
        return observations;
    }
}
