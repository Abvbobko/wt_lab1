package service;

import beans.Flight;
import service.exception.ServiceException;

public interface FlightService {

    void addFlight(Object[] flightAttributes) throws ServiceException;
}
