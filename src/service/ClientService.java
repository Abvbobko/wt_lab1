package service;

import beans.User;
import service.exception.ServiceException;

public interface ClientService {
    boolean singIn(String login, String password) throws ServiceException;
    void singOut(String login) throws ServiceException;
    void registration(String login, String password) throws ServiceException;
}
