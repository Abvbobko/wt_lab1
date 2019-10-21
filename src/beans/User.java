package beans;

import java.io.Serializable;

public class User implements Serializable {

    private Ticket[] tickets;
    //boolean administration = false;
    private String login;
    private String passwordHash;

    public User(String login, String password){
        this.login = login;
        this.passwordHash = String.valueOf(password.hashCode());
    }

    public User(String login, String password, Ticket[] tickets){
        this.tickets = tickets;
        this.login = login;
        this.passwordHash = String.valueOf(password.hashCode());
    }

    public void addTicket(Ticket ticket){

    }

    public void removeTicket(){

    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

}
