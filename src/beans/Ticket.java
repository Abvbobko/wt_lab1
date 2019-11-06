package beans;

import com.sun.org.apache.xpath.internal.operations.Equals;

import java.io.Serializable;

public class Ticket implements Serializable {

   // private int price;
    private Flight flight;

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    //private int place;
    public Ticket(){
        //flight = new Flight();
    }
    public Ticket(Flight flight ){
        this.flight = flight;
    }

    @Override
    public String toString(){
        return "_TICKET_\n" + flight.toString();
    }

}
