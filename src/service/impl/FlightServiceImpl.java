package service.impl;

import beans.Flight;
import dao.FlightDAO;
import dao.exception.DAOException;
import dao.factory.DAOFactory;
import dao.impl.TextFlightDAO;
import service.FlightService;
import service.exception.ServiceException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class FlightServiceImpl implements FlightService {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private FlightDAO flightDAO = daoFactory.getFlightDAO();

    @Override
    public void addFlight(Object[] flightAttributes) throws ServiceException {
        try {
            flightDAO.addFlight(new Flight(
                    (String)flightAttributes[0], (String)flightAttributes[1],
                    (LocalDate)flightAttributes[2], (LocalTime)flightAttributes[3],
                    (LocalTime)flightAttributes[4]/*, (int)flightAttributes[5]*/
            ));
        } catch (DAOException | ArrayIndexOutOfBoundsException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}

