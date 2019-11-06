package dao;

import beans.User;
import dao.exception.DAOException;

public interface UserDAO {
    void updateUser(User user) throws DAOException;
    User signIn(String login, String password) throws DAOException;
    void registration(String login, String password) throws DAOException;
}
