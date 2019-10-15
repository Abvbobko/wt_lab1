package service;

import beans.User;
import service.exception.ServiceException;

public interface ClientService {
    void singIn(String login, String password) throws ServiceException;
    void singOut(String login) throws ServiceException;
    void registration(User user) throws ServiceException;
}
