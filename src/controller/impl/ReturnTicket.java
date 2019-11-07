package controller.impl;

import beans.Ticket;
import controller.ConsoleCommand;
import service.ClientService;
import service.exception.ServiceException;
import service.factory.ServiceFactory;

public class ReturnTicket implements ConsoleCommand {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private ClientService clientService = serviceFactory.getClientService();

    @Override
    public String getParametersInfo() {
        //СДелать проверку: авторизован, значит вывести список билетов, если не авторизован вернуть что требуется авторизация!
        if (clientService.isAuthorized()) {
            try {
                if (!clientService.getTickets().isEmpty()) {
                    int i = 0;
                    for (Ticket ticket:
                            clientService.getTickets()) {
                        System.out.println(String.format("%d.\n", i) + ticket);
                        i++;
                    }
                    return "Enter flight id.";
                }
                System.out.println("There are no tickets.");
                return "";
            } catch (ServiceException e) {
                System.out.println(e.getLocalizedMessage());
                return "";
            }
        }
        System.out.println("Аuthorization required.");
        return "";
    }

    @Override
    public String execute(String request) {
        String response = "";
        if (!request.equals("")) {
            try {
                int ticketNumber = Integer.parseInt(request);
                clientService.returnTicket(ticketNumber);
                response = "Success";
            } catch (ServiceException e) {
                response = e.getMessage();
            }

        }
        return response;
    }
}
