package dao;

import beans.User;

public interface UserDAO {
    // ToDo: add buy ticket, bring back
    // todo: May be add workers of airline(administrations)


    User signIn(String login, String password);
    User registration(String login, String password);
}
