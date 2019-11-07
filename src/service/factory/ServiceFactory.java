package service.factory;

import service.ClientService;
import service.FlightService;
import service.impl.ClientServiceImpl;
import service.impl.FlightServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ClientService clientService = new ClientServiceImpl();
    private final FlightService flightService = new FlightServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public ClientService getClientService(){
        return clientService;
    }

    public FlightService getFlightService(){
        return flightService;
    }
}