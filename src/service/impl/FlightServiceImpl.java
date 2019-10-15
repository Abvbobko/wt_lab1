package service.impl;

import beans.Flight;
import service.FlightService;
import service.exception.ServiceException;

public class FlightServiceImpl implements FlightService {

    @Override
    public void addNewFlight(Flight flight) throws ServiceException {

    }

    @Override
    public void addEditedFlight(Flight flight) throws ServiceException {

    }

    //ToDO: !!! Каждый открытый метод реализации слоя сервисов имеет обязанность
    //проверять входящие параметры (кто бы и где бы до него это не делал)!
}

