package dao;

import beans.Flight;

public interface FlightDAO {
    void addFlight(Flight flight);

    // ToDO: Realise adding of Flight, add deleting flight, download flights from files

    void deleteFlight(Integer flightID);
    //void delete(Book book);


}
