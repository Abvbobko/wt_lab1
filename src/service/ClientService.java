package service;

import beans.User;
import service.exception.ServiceException;

import java.io.IOException;

public interface ClientService {
    boolean singIn(String login, String password) throws ServiceException;
    void singOut(String login) throws ServiceException;
    void registration(String login, String password) throws ServiceException, IOException;
}
