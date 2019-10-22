package service.impl;

import beans.Flight;
import dao.FlightDAO;
import dao.factory.DAOFactory;
import service.FlightService;
import service.exception.ServiceException;

import java.util.Map;

public class FlightServiceImpl implements FlightService {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private FlightDAO flightDAO = daoFactory.getFlightDAO();
    //ToDo: сделать, чтобы в сервисы передавались параметры, в контроллерах проверки, а тут создание

    public String getFlightsID(){
        return "";
    }

    @Override
    public void addNewFlight(Flight flight) throws ServiceException {


    }

    @Override
    public void addEditedFlight(Flight flight) throws ServiceException {

    }

    public void deleteFlight(Integer flightID) throws ServiceException {

        flightDAO.deleteFlight(flightID);
    }



    //ToDO: !!! Каждый открытый метод реализации слоя сервисов имеет обязанность
    //проверять входящие параметры (кто бы и где бы до него это не делал)!
}

