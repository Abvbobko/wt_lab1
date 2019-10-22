package beans;

import com.sun.org.apache.xpath.internal.operations.Equals;

import java.io.Serializable;

public class Ticket implements Serializable {

   // private int price;
    private Flight flight;
    private int place;

    public Ticket(Flight flight ){
        this.flight = flight;
//    public int getPrice(){
//        return this.price;
    }

    public int getPlace(){
        return place;
    }

    public void saveTicketToFile(){
     // TODO: add saving to file
    }


    @Override
    public String toString(){
        return "";
        // ToDo: Add string form for ticket
        // create pic of ticket
    }

}
