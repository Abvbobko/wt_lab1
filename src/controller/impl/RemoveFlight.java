package controller.impl;

import controller.ConsoleCommand;
import service.FlightService;
import service.exception.ServiceException;
import service.factory.ServiceFactory;

public class RemoveFlight implements ConsoleCommand {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private FlightService flightService = serviceFactory.getFlightService();

    @Override
    public String getParametersInfo() {
        String flights = flightService.getFlightsList();
        if (!flights.equals("")) {
            // if there are some flights in flights list

            return "Enter flight id.\n" + flights;
        }
        System.out.println("There are no flights.");
        return "";
    }

    @Override
    public String execute(String request) {

        String response = "";
        //if request is "" it's mean that flights list is empty

        if (!request.equals("")) {
            try {
                int flightID = Integer.parseInt(request);
                flightService.deleteFlight(flightID);
                response = "Success";
            } catch (ServiceException e) {
                response = e.getMessage();
            }
        }
        return response;
    }
}
