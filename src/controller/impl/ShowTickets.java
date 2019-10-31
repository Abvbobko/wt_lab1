package controller.impl;

import beans.Ticket;
import controller.ConsoleCommand;
import service.ClientService;
import service.exception.ServiceException;
import service.factory.ServiceFactory;
import service.impl.ClientServiceImpl;


public class ShowTickets implements ConsoleCommand {
    @Override
    public String getParametersInfo() {
        return "";
    }

    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        String response;
        try {
            for (Ticket ticket:
                    clientService.getTickets()) {
                System.out.println(ticket);
            }
            response = "End of tickets list";
        } catch (ServiceException e) {
            response = e.getMessage();
        }
        return response;
    }
}
