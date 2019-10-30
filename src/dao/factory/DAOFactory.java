package dao.factory;

import dao.FlightDAO;
import dao.UserDAO;
import dao.impl.XmlFlightDAO;
import dao.impl.XmlUserDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final FlightDAO xmlFlightImpl = new XmlFlightDAO();
    private final UserDAO xmlUserImpl = new XmlUserDAO();

    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return instance;
    }
    public FlightDAO getFlightDAO(){
        return xmlFlightImpl;
    }
    public UserDAO getUserDAO(){
        return xmlUserImpl;
    }
}
