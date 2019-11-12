package beans.sorts;


import beans.Ticket;

import java.util.Comparator;

public class SortTicketsByDateComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket firstTicket, Ticket secondTicket) {
        return firstTicket.getFlight().getDateOfFlight().compareTo(
                secondTicket.getFlight().getDateOfFlight());
    }
}