package controller.impl;

import controller.ConsoleCommand;
import service.ClientService;
import service.exception.ServiceException;
import service.factory.ServiceFactory;

import javax.xml.ws.Service;

public class BuyTicket implements ConsoleCommand {
    @Override
    public String getParametersInfo() {
        return "Enter flight id.";
    }

    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        String response;
        try {
            int flightID = Integer.parseInt(request);
            clientService.butTicket(flightID);
            response = "Success";
        } catch (ServiceException e) {
            response = e.getMessage();
        }
        return response;
    }
}
