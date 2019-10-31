package beans;

import com.sun.org.apache.xpath.internal.operations.Equals;

import java.io.Serializable;

public class Ticket implements Serializable {

   // private int price;
    private Flight flight;
    //private int place;

    public Ticket(Flight flight ){
        this.flight = flight;
    }

    @Override
    public String toString(){
        return "_TICKET_\n" + flight.toString();
    }

}
