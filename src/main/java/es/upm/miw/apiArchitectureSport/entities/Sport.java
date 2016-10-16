package es.upm.miw.apiArchitectureSport.entities;

public class Sport {

    private int id;

    private String sportName;

    public Sport() {
    }

    public Sport(String sportName) {
        this.sportName = sportName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return sportName;
    }

}
