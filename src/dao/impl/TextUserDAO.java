package dao.impl;

import beans.User;

import dao.UserDAO;
import dao.exception.DAOException;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextUserDAO implements UserDAO {

    private static Map<String, User> users;
    private static final String DATA_FILE_NAME = "users.xml";

    public TextUserDAO(){

        if (new File(DATA_FILE_NAME).exists()) {
            try {
                readUsersFromFile();
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }

    }

    // ToDO: сделать бросание ошибки неправильный логин и тоже самое с паролем
    @Override
    public User signIn(String login, String password) {
        if (users.get(login).getPasswordHash().equals(String.valueOf(password.hashCode()))){
            return users.get(login);
        }
        return null;//ToDo: delete this string and throw error
    }

    @Override
    public User registration(String login, String password) throws DAOException {
        if (users.get(login) == null){
            User newUser = new User(login, password);
            users.put(login, newUser);
            writeUsersToFile();
            return newUser;
        }
        throw new DAOException("User with this login exists.");
    }



   // private final String fileName = "user.xml";
    private void readUsersFromFile() throws DAOException {

        //ToDO:
        try {
            users = new HashMap<>();
            FileInputStream fis = new FileInputStream("settings.xml");
            XMLDecoder decoder = new XMLDecoder(fis);
            List<User> listOfUsers = (List<User>)decoder.readObject();
            decoder.close();
            fis.close();
            for (User user:
                 listOfUsers) {
                users.put(user.getLogin(), user);
            }
        } catch (IOException e) {
            throw new DAOException(e.getMessage());
        }
    }

    private void writeUsersToFile() throws DAOException {
        try {
            FileOutputStream fos = new FileOutputStream(DATA_FILE_NAME);
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(users.values());
            encoder.close();
            fos.close();
        } catch (IOException e) {
            throw new DAOException(e.getMessage());
        }
    }

}


