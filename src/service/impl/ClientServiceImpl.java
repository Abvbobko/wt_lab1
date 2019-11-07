package service.impl;

import beans.Flight;
import beans.Ticket;
import beans.User;
import dao.FlightDAO;
import dao.exception.DAOException;
import dao.factory.DAOFactory;
import dao.UserDAO;
import service.ClientService;
import service.exception.ServiceException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientServiceImpl implements ClientService {

    private User currentUser = null;
    private DAOFactory daoObjectFactory = DAOFactory.getInstance();

    public ArrayList<Ticket> getTickets() throws ServiceException {
        if (isAuthorized()) {
            return currentUser.getTickets();
        }
        throw new ServiceException("Authorization required.");
    }

    public boolean isAuthorized() {
        return currentUser != null;
    }

    public boolean isAdminMode(){
        if (currentUser == null) {
            return false;
        }
        return currentUser.isAdmin();
    }

    @Override
    public void singIn(String login, String password) throws ServiceException {
        if (login == null || login.isEmpty()){
            throw new ServiceException("Error. Incorrect login");
        }

        try{
            UserDAO userDAO = daoObjectFactory.getUserDAO();
            currentUser = userDAO.signIn(login, password);

            //throw new DAOException("Incorrect login or password.");
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void registration(String login, String password) throws ServiceException {
        if (login == null || login.isEmpty()){
            throw new ServiceException("Error. Incorrect login");
        }
        if (password == null || password.isEmpty()){
            throw new ServiceException("Error. Incorrect password");
        }

        try {
            UserDAO userDAO = daoObjectFactory.getUserDAO();
            userDAO.registration(login, password);

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public void butTicket(int flightID) throws ServiceException {
        if (!isAuthorized()) {
            throw new ServiceException("Authorization required.");
        }
        FlightDAO flightDAO = daoObjectFactory.getFlightDAO();
        if ((flightID >= 0) && (flightID < flightDAO.getFlightsNumber())) {
            currentUser.addTicket(new Ticket(flightDAO.getFlightByID(flightID)));
            UserDAO userDAO = daoObjectFactory.getUserDAO();
            try {
                userDAO.updateUser(currentUser);
            } catch (DAOException e) {
                throw new ServiceException(e.getMessage());
            }
            return;
        }
        throw new ServiceException("Incorrect flight index.");
    }

    @Override
    public void returnTicket(int ticketNumber) throws ServiceException {
        if ((ticketNumber > 0) && (ticketNumber < currentUser.getTickets().size())) {
            currentUser.getTickets().remove(ticketNumber);
            UserDAO userDAO = daoObjectFactory.getUserDAO();
            try {
                userDAO.updateUser(currentUser);
            } catch (DAOException e) {
                throw new ServiceException(e.getMessage());
            }
        }

    }

    @Override
    public void singOut() {
        currentUser = null;
    }


}