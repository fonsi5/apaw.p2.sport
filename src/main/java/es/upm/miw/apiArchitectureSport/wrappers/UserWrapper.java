package es.upm.miw.apiArchitectureSport.wrappers;

public class UserWrapper {
    private int id;

    private String nick;

    private String email;

    public UserWrapper() {
    }

    public UserWrapper(int id, String nick, String email) {
        this.setId(id);
        this.setNick(nick);
        this.setMail(email);
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

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMail() {
        return email;
    }

    public void setMail(String email) {
        this.email = email;
    }

    public String toString(boolean justNick) {
        if (justNick) {
            return "{\"nick\":\"" + nick + "\"}";
        } else {
            return "{\"nick\":\"" + nick + "\",\"email\":\"" + email + "\"}";
        }
    }

}
