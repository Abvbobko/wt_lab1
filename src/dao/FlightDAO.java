package dao;

import beans.Flight;
import dao.exception.DAOException;

import java.util.Map;

public interface FlightDAO {
    void addFlight(Flight flight) throws DAOException;

    // ToDO: Realise adding of Flight, add deleting flight, download flights from files

    void deleteFlight(Integer flightID) throws DAOException;
    int getFlightsNumber();
    Flight getFlightByID(int flightID);
    //void delete(Book book);

}
