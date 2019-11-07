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
        if (clientService.isAuthorized()) {
            try {
                if (!clientService.getTickets().isEmpty()) {
                    // if user has tickets - print them
                    int i = 0;
                    for (Ticket ticket:
                            clientService.getTickets()) {
                        System.out.println(String.format("%d.\n", i) + ticket);
                        i++;
                    }
                    return "Enter flight id.";
                }
                throw new ServiceException("There are no tickets.");

            } catch (ServiceException e) {
                System.out.println(e.getMessage());
                return "";
            }
        }
        throw new RuntimeException("Аuthorization required.");
    }

    @Override
    public String execute(String request) {
        String response = "";
        // if request is "" it's mean that user hasn't tickets

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
