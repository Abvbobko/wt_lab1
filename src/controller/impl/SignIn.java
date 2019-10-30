package controller.impl;

import controller.ConsoleCommand;
import service.ClientService;
import service.exception.ServiceException;
import service.factory.ServiceFactory;

public class SignIn implements ConsoleCommand {

    @Override
    public String execute(String request) {
        String login;
        String password;
        String response;

        String delimiters = "[ ]+";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();

        try {
            login = request.split(delimiters)[0];
            password = request.split(delimiters)[1];

            clientService.singIn(login, password);
            response = "Welcome";

        } catch (ServiceException e) {
            // write log
            response = e.getMessage();
        }

        return response;
    }

    @Override
    public String getParametersInfo() {
        return "login, password";
    }


}
