package controller.impl;

import beans.Flight;
import controller.Command;
import controller.ConsoleCommand;
import service.FlightService;
import service.exception.ServiceException;
import service.factory.ServiceFactory;

public class AddFlight implements ConsoleCommand {
    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        FlightService flightService = serviceFactory.getFlightService();
        String response;
        try {
            String[] parameters = request.split(" ");
            flightService.addFlight(parameters);
            response = "Success";
        } catch (ServiceException e) {
            response = e.getMessage();
        }
        return response;
    }

    @Override
    public String getParametersInfo() {
        return String.join(", ", Flight.getFieldsNames());
    }


}