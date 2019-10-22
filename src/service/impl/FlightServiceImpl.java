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
    //ToDo: сделать, чтобы в сервисы передавались параметры, в контроллерах проверки, а тут создание

    public String getFlightsID(){

        return "";
    }

    @Override
    public void addNewFlight(Object[] flightAttributes) throws ServiceException {
        try {
            //  public Flight(String fromCity, String toCity, LocalDate dateOfFlight, LocalTime departure,
            //                  LocalTime arrival, int numberOfFreeSeats) {
            flightDAO.addFlight(new Flight(
                    (String)flightAttributes[0], (String)flightAttributes[1],
                    (LocalDate)flightAttributes[2], (LocalTime)flightAttributes[3],
                    (LocalTime)flightAttributes[4], (int)flightAttributes[5]
            ));
        } catch (DAOException | ArrayIndexOutOfBoundsException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void deleteFlight(Integer flightID) throws ServiceException {
        try {
            flightDAO.deleteFlight(flightID);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }



    //ToDO: !!! Каждый открытый метод реализации слоя сервисов имеет обязанность
    //проверять входящие параметры (кто бы и где бы до него это не делал)!
}

