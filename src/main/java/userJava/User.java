package userJava;
public class User {

    private String active;
    private String canal;

    public User() {

    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getResult() {
        if (this.active.equalsIgnoreCase("active")) {
            return "active";
        } else {
            return "inactive";
        }
    }
}