package dao.impl;

import beans.User;
import dao.UserDAO;
import beans.User;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVUserDAO implements UserDAO {


    private static final Map<String, Pair<String, User>> users = new HashMap<>();

    @Override
    public void signIn(String login, String password) {
        if (users.get(login).getKey().equals(password)){
            // return User!!!
        }
        //// именно в этом методы мы связываемся с базой данных и проверяем
        //корректность логина и пароля
    }

    @Override
    public void registration(String login, String password) {
        if (users.get(login) == null){

            // may be return user
            users.put(login, new Pair<>(password, new User()));
        }
    }

    private void readUsersFromFile() {
        //формат логин пароль билеты

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("users.csv"));
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                // log pass tickets
                users.put(data[0], new Pair<>(data[1], new User()));
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private void writeUsersFromFile(){

    }
}
