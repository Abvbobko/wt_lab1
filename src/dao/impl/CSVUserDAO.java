package dao.impl;

import beans.User;
import dao.UserDAO;

public class CSVUserDAO implements UserDAO {
    @Override
    public void signIn(String login, String password) {
        //// именно в этом методы мы связываемся с базой данных и проверяем
        //корректность логина и пароля
    }

    @Override
    public void registration(User user) {

    }
}
