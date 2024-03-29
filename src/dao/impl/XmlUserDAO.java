package dao.impl;

import beans.User;

import dao.UserDAO;
import dao.exception.DAOException;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlUserDAO implements UserDAO {

    private static Map<String, User> users = new HashMap<>();
    private static final String DATA_FILE_NAME = "users.xml";

    public XmlUserDAO(){

        if (new File(DATA_FILE_NAME).exists()) {
            try {
                readUsersFromFile();
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Func update user information in memory and in file
     *
     * @param user user in which there are changes
     * @throws DAOException if errors occurred while writing to the file
     */
    @Override
    public void updateUser(User user) throws DAOException {
        users.put(user.getLogin(), user);
        writeUsersToFile();
    }

    /**
     *
     * @param login user's login
     * @param password user's password
     * @return user if sign in was successful
     * @throws DAOException if user enter incorrect login/password
     */
    @Override
    public User signIn(String login, String password) throws DAOException {
        if (users.get(login) != null){
            if (users.get(login).getPasswordHash().equals(String.valueOf(password.hashCode()))){
                return users.get(login);
            }
            throw new DAOException("Error. Incorrect password.");
        }
        throw new DAOException("Error. Incorrect login.");
    }

    /**
     *
     * @param login new user login
     * @param password new user password
     * @throws DAOException if user with this login is exist
     */
    @Override
    public void registration(String login, String password) throws DAOException {
        if (users.get(login) == null){
            User newUser = new User(login, password);
            users.put(login, newUser);
            writeUsersToFile();
            return;
        }
        throw new DAOException("User with this login exists.");
    }

    /**
     *
     * @throws DAOException if there are troubles with file reading
     */
    private void readUsersFromFile() throws DAOException {
        try {
            users = new HashMap<>();
            FileInputStream fis = new FileInputStream(DATA_FILE_NAME);
            XMLDecoder decoder = new XMLDecoder(fis);
            List<User> listOfUsers = (List<User>)decoder.readObject();
            decoder.close();
            fis.close();
            for (User user: listOfUsers) {
                users.put(user.getLogin(), user);
            }
        } catch (IOException e) {
            throw new DAOException(e.getMessage());
        }
    }

    /**
     *
     * @throws DAOException if there are troubles with file writing
     */
    private void writeUsersToFile() throws DAOException {
        try {
            File f = new File(DATA_FILE_NAME);
            if (!f.exists()){
                if (!f.createNewFile()) {
                    throw new DAOException("File with users does not found.");
                }
            }
            FileOutputStream fos = new FileOutputStream(DATA_FILE_NAME);
            XMLEncoder encoder = new XMLEncoder(fos);

            ArrayList<User> us = new ArrayList<>(users.values());
            encoder.writeObject(us);

            encoder.close();
            fos.close();
        } catch (IOException e) {
            throw new DAOException(e.getMessage());
        }
    }

}


