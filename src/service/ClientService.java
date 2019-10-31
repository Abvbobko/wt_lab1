package service;

import beans.Ticket;
import beans.User;
import dao.exception.DAOException;
import service.exception.ServiceException;

import java.io.IOException;
import java.util.List;

public interface ClientService {
    boolean isAdminMode();
    boolean isAuthorized();
    List<Ticket> getTickets() throws ServiceException;
    void singIn(String login, String password) throws ServiceException;
    void singOut() throws ServiceException;
    void registration(String login, String password) throws ServiceException;
    void butTicket(int flightID) throws ServiceException;
}
