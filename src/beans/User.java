package beans;

import java.io.Serializable;

public class User implements Serializable {

    private Ticket[] tickets;
    //boolean administration = false;
    private String login;

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    private String passwordHash;

    public User(){}

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
