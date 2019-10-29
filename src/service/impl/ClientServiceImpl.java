package service.impl;

import beans.Flight;
import beans.Ticket;
import beans.User;
import dao.exception.DAOException;
import dao.factory.DAOFactory;
import dao.UserDAO;
import service.ClientService;
import service.exception.ServiceException;

import java.io.IOException;

public class ClientServiceImpl implements ClientService {

    private User currentUser = null;
    private DAOFactory daoObjectFactory = DAOFactory.getInstance();

    public boolean isAdminMode(){
        return currentUser.isAdmin();
    }

    @Override
    public void singIn(String login, String password) throws ServiceException {
        if(login == null || login.isEmpty()){
            throw new ServiceException("Error. Incorrect login");
        }

        try{
            UserDAO userDAO = daoObjectFactory.getUserDAO();
            currentUser = userDAO.signIn(login, password);
            throw new DAOException("Incorrect login or password.");
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void singOut(String login) {
        currentUser = null;
    }

    @Override
    public void registration(String login, String password) throws ServiceException {
        UserDAO userDAO = daoObjectFactory.getUserDAO();
        if ((!login.equals("")) && (!password.equals(""))) {
            try {
                userDAO.registration(login, password);
            } catch (IOException | DAOException e) {
                throw new ServiceException(e.getMessage());
            }
        }
    }

    public void buyTicket(Flight flight){
        currentUser.addTicket(new Ticket(flight));
    }
}