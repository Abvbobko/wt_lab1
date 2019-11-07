package controller.impl;

import controller.ConsoleCommand;
import service.ClientService;
import service.FlightService;
import service.exception.ServiceException;
import service.factory.ServiceFactory;

import javax.xml.ws.Service;

public class BuyTicket implements ConsoleCommand {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private ClientService clientService = serviceFactory.getClientService();
    private FlightService flightService = serviceFactory.getFlightService();

    @Override
    public String getParametersInfo() {
        String flights = flightService.getFlightsList();
        if (!flights.equals("")) {
            return "Enter flight id.\n" + flights;
        }
        System.out.println("There are no flights.");
        return "";
    }

    @Override
    public String execute(String request) {

        String response = "";
        if (!request.equals("")) {
            try {
                int flightID = Integer.parseInt(request);
                clientService.butTicket(flightID);
                response = "Success";
            } catch (ServiceException e) {
                response = e.getMessage();
            }
        }
        return response;
    }
}
