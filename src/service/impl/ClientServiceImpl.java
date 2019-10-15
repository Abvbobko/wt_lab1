package service.impl;

import beans.User;
import dao.exception.DAOException;
import dao.factory.DAOFactory;
import dao.UserDAO;
import service.ClientService;
import service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {
    @Override
    public void singIn(String login, String password) throws ServiceException {
// проверяем параметры
        if(login == null || login.isEmpty()){
            throw new ServiceException("Incorrect login");
        }
        // реализуем функционал логинации пользователя в системе

        //ToDO: uncomment try
        //try{
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoObjectFactory.getUserDAO();
            userDAO.signIn(login, password);

       // } catch(DAOException e){
         //   throw new ServiceException(e);
     //   }

    }

    @Override
    public void singOut(String login) throws ServiceException {
    }

    @Override
    public void registration(User user) throws ServiceException {
    }
}