package dao.impl;

import beans.User;

import dao.UserDAO;

import javax.xml.stream.XMLStreamReader;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextUserDAO implements UserDAO {


    private static Map<String, User> users;


    // ToDO: сделать бросание ошибки неправильный логин и тоже самое с паролем
    @Override
    public User signIn(String login, String password) {
        if (users.get(login).getPasswordHash().equals(String.valueOf(password.hashCode()))){
            return users.get(login);
        }
        //// именно в этом методы мы связываемся с базой данных и проверяем
        //корректность логина и пароля
        return null;//new User("",""); //ToDo: delete this string and throw error
    }

    @Override
    public User registration(String login, String password) throws IOException {
        if (users.get(login) == null){
            User newUser = new User(login, password);
            users.put(login, newUser);
            writeUsersToFile();
            return newUser;

        }


        return new User("",""); // ToDo: It's temp. Throw the error
    }

    private static final String DATA_FILE_NAME = "users.xml";

   // private final String fileName = "user.xml";
    private void readUsersFromFile() throws IOException {

        //ToDO:
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
    }

        private void writeUsersToFile() throws IOException {
            FileOutputStream fos = new FileOutputStream(DATA_FILE_NAME);
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(users.values());
            encoder.close();
            fos.close();
        }
}
//file format: login password user

