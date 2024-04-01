public class Person {
    private String name;
    private String lastname;
    private Date birthDate;
    private String curp;

    public Person(String name, String lastname, Date birthDate, String curp) {
        this.name = name;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.curp = curp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Date getBirthDate() {
        return birthDate;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }



    public String showInfo(){
        String date= Integer.toString(birthDate.getDayOfMonth())+"/" +Integer.toString(birthDate.getMonth())+"/"+Integer.toString(birthDate.getYear());
        return String.format("Nombre completo: %s %s || Fecha de nacimiento: %s|| CURP: %s", name, lastname,date, curp);
    }
}
