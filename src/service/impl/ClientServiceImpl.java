package service.impl;

import beans.Ticket;
import beans.User;
import dao.FlightDAO;
import dao.exception.DAOException;
import dao.factory.DAOFactory;
import dao.UserDAO;
import service.ClientService;
import service.exception.ServiceException;
import java.util.ArrayList;

public class ClientServiceImpl implements ClientService {

    private User currentUser = null;
    private DAOFactory daoObjectFactory = DAOFactory.getInstance();

    /**
     *
     * @return list of current user tickets
     * @throws ServiceException if user is not authorized
     */
    public ArrayList<Ticket> getTickets() throws ServiceException {
        if (isAuthorized()) {
            return currentUser.getTickets();
        }
        throw new ServiceException("Authorization required.");
    }

    public boolean isAuthorized() {
        return currentUser != null;
    }

    /**
     *
     * @return true if user is admin
     */
    public boolean isAdminMode(){
        if (currentUser == null) {
            return false;
        }
        return currentUser.isAdmin();
    }

    /**
     *
     * @param login user login
     * @param password user password
     * @throws ServiceException if there are some troubles with sign in
     *      (like incorrect entered data)
     */
    @Override
    public void signIn(String login, String password) throws ServiceException {
        if (login == null || login.isEmpty()){
            throw new ServiceException("Error. Incorrect login");
        }

        try{
            UserDAO userDAO = daoObjectFactory.getUserDAO();
            currentUser = userDAO.signIn(login, password);

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     *
     * @param login login of new user
     * @param password password of new user
     * @throws ServiceException if user with this login exist or incorrect entered data
     */
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

    /**
     *
     * @param flightID number of desired flight
     * @throws ServiceException if troubles with authorization, flightID or others
     */
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

    /**
     * Method remove ticket from user tickets
     *
     * @param ticketNumber undesired ticket
     * @throws ServiceException if ticket with this number doesn't exist
     */
    @Override
    public void returnTicket(int ticketNumber) throws ServiceException {
        if ((ticketNumber >= 0) && (ticketNumber < currentUser.getTickets().size())) {
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