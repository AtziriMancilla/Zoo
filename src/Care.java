public class Care {
    private Maintenance employeeInCharge;
    private String processRealized;
    private int id;
    private Date processDate;
    private String observations; //Obs son opcionales. como no se puede modificar el usuario va a poder no ingresar nada al momento de crear el objeto

    public Care(Maintenance employeeInCharge, String processRealized, int id, Date processDate, String observations) {
        this.employeeInCharge = employeeInCharge;
        this.processRealized = processRealized;
        this.id = id;
        this.processDate = processDate;
        this.observations = observations;
    }

    public Maintenance getEmployeeInCharge() {
        return employeeInCharge;
    }

    public String getProcessRealized() {
        return processRealized;
    }

    public int getId() {
        return id;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public String getObservations() {
        return observations;
    }

    public void showCare() {
        System.out.println("Empleado a cargo: " + getEmployeeInCharge().showEmployee() +
                "\nProceso: " + processRealized +"\n"+
                "ID Animal: " + getId() +
                "\nFecha Proceso: " + getProcessDate().showDate() +
                "\nObservaciones: " + getObservations());
        System.out.println("......................................");
    }

}
