package service;

import beans.Flight;
import service.exception.ServiceException;

public interface FlightService {

    void addFlight(String[] flightAttributes) throws ServiceException;
    String getFlightsList();
    void deleteFlight(int flightID) throws ServiceException;
}
