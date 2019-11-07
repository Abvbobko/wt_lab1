package dao;

import beans.Flight;
import dao.exception.DAOException;

import java.util.Map;

public interface FlightDAO {
    void addFlight(Flight flight) throws DAOException;
    void deleteFlight(int flightID) throws DAOException;
    int getFlightsNumber();
    Flight getFlightByID(int flightID);
}
