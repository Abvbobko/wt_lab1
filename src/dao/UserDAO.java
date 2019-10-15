package dao;


import beans.User;

public interface UserDAO {
    // ToDo: add buy ticket, bring back
    // todo: May be add workers of airline(administrations)

    void signIn(String login, String password);
    void registration(User user);
}
