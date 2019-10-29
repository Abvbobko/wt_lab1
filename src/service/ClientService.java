package service;

import beans.User;
import dao.exception.DAOException;
import service.exception.ServiceException;

import java.io.IOException;

public interface ClientService {
    boolean isAdminMode();
    void singIn(String login, String password) throws ServiceException;
    void singOut() throws ServiceException;
    void registration(String login, String password) throws ServiceException;
}
