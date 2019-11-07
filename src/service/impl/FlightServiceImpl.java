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

    public static final String DATE_FORMAT = "d.MM.yyyy";
    public static final String TIME_FORMAT = "HH:mm";

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private FlightDAO flightDAO = daoFactory.getFlightDAO();

    /**
     *
     * @return list of flights in String format
     */
    @Override
    public String getFlightsList() {
        StringBuilder response = new StringBuilder();
        for (int i = 0; i < flightDAO.getFlightsNumber(); i++){
            response.append(String.format("%d.\n%s", i, flightDAO.getFlightByID(i).toString()));
        }
        return String.valueOf(response);
    }

    /**
     *
     * @param flightID number of flight
     * @throws ServiceException if can't delete flight (flight doesn't exist for example)
     */
    @Override
    public void deleteFlight(int flightID) throws ServiceException {
        try {
            flightDAO.deleteFlight(flightID);
        } catch (DAOException | ArrayIndexOutOfBoundsException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     *
     * @param flightAttributes array of attributes of new flight
     * @throws ServiceException if error in the transmitted attributes
     */
    @Override
    public void addFlight(String[] flightAttributes) throws ServiceException {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            flightDAO.addFlight(new Flight(
                    flightAttributes[0],
                    flightAttributes[1],
                    LocalDate.parse(flightAttributes[2], dateFormatter),
                    LocalTime.parse(flightAttributes[3]),
                    LocalTime.parse(flightAttributes[4])));
        } catch (DAOException | ArrayIndexOutOfBoundsException e) {
            throw new ServiceException("Error, check the entered parameters");
        }
    }


}

