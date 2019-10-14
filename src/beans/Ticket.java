package beans;

import com.sun.org.apache.xpath.internal.operations.Equals;

public class Ticket {

    private int price;
    private Flight flight;
    private ServiceClass serviceClass;
    private int place;

    public Ticket(){}

    public int getPrice(){
        return this.price;
    }

    public ServiceClass getServiceClass() {
        return this.serviceClass;
    }

    public int getPlace(){
        return place;
    }

    public void saveTicketToFile(){
     ////
    }


    @Override
    public String toString(){
        return "";

        // create pic of ticket
    }

}
