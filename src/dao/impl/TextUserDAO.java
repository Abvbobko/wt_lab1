package dao.impl;

import beans.User;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import dao.UserDAO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    public User registration(String login, String password) {
        if (users.get(login) == null){

            // may be return user
            User newUser = new User(login, password);
            users.put(login, newUser);
            return newUser;
        }


        return new User("",""); // ToDo: It's temp. Throw the error
    }

    private static final String DATA_FILE_NAME = "users.xml";


    private void readUsersFromFile() {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xmlText = new String(Files.readAllBytes(Paths.get(fileName)));
            return xmlMapper.readValue(xmlText, Team.class);
        } catch (IOException e) {
            throw new XmlOutInException("can't parse file Xml name = [" + fileName + "]", e);
        }
    }

        private void writeUsersToFile(){

        }
}
//file format: login password user

