package beans;

import java.io.Serializable;

public class User implements Serializable {

    private Ticket[] tickets;
    private boolean admin = false;
    private String login;

    public boolean isAdmin(){
        return admin;
    }

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
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

/*    public void removeTicket(){

    }*/

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
