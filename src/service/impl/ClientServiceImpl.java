package service.impl;

import beans.User;
import dao.exception.DAOException;
import dao.factory.DAOFactory;
import dao.UserDAO;
import service.ClientService;
import service.exception.ServiceException;


//ToDO: сделать тут логику, чтобы БД только можно было получать что то(это я про регистрацию)
public class ClientServiceImpl implements ClientService {

    private User currentUser = null;
    private DAOFactory daoObjectFactory = DAOFactory.getInstance();
    @Override
    public boolean singIn(String login, String password) throws ServiceException {
// проверяем параметры
        if(login == null || login.isEmpty()){
            throw new ServiceException("Incorrect login");
        }
        // реализуем функционал логинации пользователя в системе

        //ToDO: uncomment try
        try{
            UserDAO userDAO = daoObjectFactory.getUserDAO();
            currentUser = userDAO.signIn(login, password);
            if (currentUser != null) {
                return true;
            }

            //ToDo: похоже на фигню
            throw new ServiceException("Incorrect login or password");

        } catch(ServiceException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public void singOut(String login) throws ServiceException {
        currentUser = null;
    }

    @Override
    public void registration(String login, String password) throws ServiceException {
        UserDAO userDAO = daoObjectFactory.getUserDAO();
        if ((!login.equals("")) && (!password.equals(""))) {
            userDAO.registration(login, password);
        }
    }

    public void buyTucket(){

    }
}