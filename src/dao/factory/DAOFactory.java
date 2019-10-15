package dao.factory;

import dao.FlightDAO;
import dao.UserDAO;
import dao.impl.CSVFlightDAO;
import dao.impl.CSVUserDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final FlightDAO csvFlightImpl = new CSVFlightDAO();
    private final UserDAO csvUserImpl = new CSVUserDAO();

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