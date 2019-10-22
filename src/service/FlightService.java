package service;

import beans.Flight;
import service.exception.ServiceException;

public interface FlightService {

    void addNewFlight(Object[] flightAttributes) throws ServiceException;
    void deleteFlight(Integer id) throws ServiceException;
}
