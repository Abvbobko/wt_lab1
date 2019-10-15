package controller.impl;

import controller.Command;
import service.ClientService;
import service.exception.ServiceException;
import service.factory.ServiceFactory;

public class SingIn implements Command {

    @Override
    public String execute(String request) {
        String login = null;
        String password = null;
        String response = null;
// get parameters from request and initialize the variables login and password
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        try {
            clientService.singIn(login, password);
            response = "Welcome";
        } catch (ServiceException e) {
// write log
            response = "Error during login procedure";
        }
        return response;
    }
}
