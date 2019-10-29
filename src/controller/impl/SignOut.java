package controller.impl;

import controller.ConsoleCommand;
import service.ClientService;
import service.exception.ServiceException;
import service.factory.ServiceFactory;

public class SignOut implements ConsoleCommand {
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
            clientService.singOut();
            response = "Success";
        } catch (ServiceException e) {
            response = e.getMessage();
        }
        return response;
    }
}
