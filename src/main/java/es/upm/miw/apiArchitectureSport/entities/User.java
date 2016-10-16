package es.upm.miw.apiArchitectureSport.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class User {

    private int id;

    private String nick;

    private String email;

    private List<Sport> sportList;

    private Calendar date;

    public User() {
    }

    public User(String nick, String email) {
        this.nick = nick;
        this.email = email;
        this.date = Calendar.getInstance();
        this.sportList = new ArrayList<Sport>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public String getEmail() {
        return email;
    }

    public List<Sport> getSportSlist() {
        return sportList;
    }

    public Calendar getDate() {
        return date;
    }

    public boolean PracticeSport(String sport) {

        for (Sport sportPractie : sportList) {
            if (sport == sportPractie.getName())
                return true;
        }
        return false;
    }

}
