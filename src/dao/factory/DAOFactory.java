package dao.factory;

import dao.FlightDAO;
import dao.UserDAO;
import dao.impl.TextFlightDAO;
import dao.impl.TextUserDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final FlightDAO csvFlightImpl = new TextFlightDAO();
    private final UserDAO csvUserImpl = new TextUserDAO();

    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return instance;
    }
    public FlightDAO getFlightDAO(){
        return csvFlightImpl;
    }
    public UserDAO getUserDAO(){
        return csvUserImpl;
    }
}
