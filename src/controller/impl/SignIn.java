package controller.impl;

import controller.ConsoleCommand;
import service.ClientService;
import service.exception.ServiceException;
import service.factory.ServiceFactory;

public class SignIn implements ConsoleCommand {

    @Override
    public String execute(String request) {
        String login = null;
        String password = null;
        String response = null;

        String delimiters = "[ ]+";

        //ToDo: check that request has two args
        login = request.split(delimiters)[0];
        password = request.split(delimiters)[1];

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

    @Override
    public String getParametersInfo() {
        return "Enter login and password by space.";
    }


}
