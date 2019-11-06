package service.impl;

import beans.Flight;
import dao.FlightDAO;
import dao.exception.DAOException;
import dao.factory.DAOFactory;

import service.FlightService;
import service.exception.ServiceException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FlightServiceImpl implements FlightService {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private FlightDAO flightDAO = daoFactory.getFlightDAO();

    public static final String DATE_FORMAT = "d.MM.yyyy";
    public static final String TIME_FORMAT = "HH:mm";

    @Override
    public void addFlight(String[] flightAttributes) throws ServiceException {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(TIME_FORMAT);
            flightDAO.addFlight(new Flight(
                    flightAttributes[0],
                    flightAttributes[1],
                    LocalDate.parse(flightAttributes[2], dateFormatter),
                    LocalTime.parse(flightAttributes[3]),
                    LocalTime.parse(flightAttributes[4], timeFormatter)/*, (int)flightAttributes[5]*/
            ));
        } catch (DAOException | ArrayIndexOutOfBoundsException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}

