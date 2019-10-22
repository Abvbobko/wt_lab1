package service;

import beans.Flight;
import service.exception.ServiceException;

public interface FlightService {

    void addNewFlight(Flight flight) throws ServiceException;
    void addEditedFlight(Flight flight) throws ServiceException;
    void deleteFlight(Integer id) throws ServiceException;
}
