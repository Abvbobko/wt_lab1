package controller.impl;

import controller.ConsoleCommand;
import dao.exception.DAOException;
import service.ClientService;
import service.exception.ServiceException;
import service.factory.ServiceFactory;

import java.io.IOException;

public class Register implements ConsoleCommand {

    @Override
    public String execute(String request) {
        String response;
        String delimiters = "[ ]+";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();

        try {
            String login = request.split(delimiters)[0];
            String password = request.split(delimiters)[1];

            clientService.registration(login, password);
            response = "Success";

        } catch (ServiceException e) {
            // write log
            response = e.getMessage();
        }
        return response;
    }

    @Override
    public String getParametersInfo() {
        return "Enter login and password by space.";
    }


}
