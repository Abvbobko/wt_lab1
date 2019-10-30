package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

    private List<Ticket> tickets = new ArrayList<>();
    private boolean admin = false;
    private String login;

    public boolean isAdmin(){
        return admin;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    private String passwordHash;

    public User(){}

    public User(String login, String password){
        this.login = login;
        this.passwordHash = String.valueOf(password.hashCode());
    }

    public User(String login, String password, List<Ticket> tickets){
        this.tickets = tickets;
        this.login = login;
        this.passwordHash = String.valueOf(password.hashCode());
    }

    public void addTicket(Ticket ticket){

    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

}
