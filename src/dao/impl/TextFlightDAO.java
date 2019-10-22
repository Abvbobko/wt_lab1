package dao.impl;

import beans.Flight;
import dao.FlightDAO;
import dao.exception.DAOException;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextFlightDAO implements FlightDAO {
    private static Map<Integer, Flight> flights;
    private Integer lastID = 0;
    private static final String DATA_FILE_NAME = "flights.xml";
    public Map<Integer, Flight> getFlights(){
        return flights;
    }

    public TextFlightDAO(){
        if (new File(DATA_FILE_NAME).exists()) {
            try {
                readFlightsFromFile();
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addFlight(Flight flight) throws DAOException {
        lastID++;
        flights.put(lastID, flight);
        writeFlightsToFile();
    }

    @Override
    public void deleteFlight(Integer flightID) throws DAOException {
        flights.remove(flightID);
        writeFlightsToFile();
    }


    private void readFlightsFromFile() throws DAOException {
        try {
            flights = new HashMap<>();
            FileInputStream fis = new FileInputStream("settings.xml");
            XMLDecoder decoder = new XMLDecoder(fis);
            List<Flight> listOfUsers = (List<Flight>)decoder.readObject();
            decoder.close();
            fis.close();
            int i = 0;
            for (Flight user:
                    listOfUsers) {

                flights.put(i, user);
                i++;
            }
        } catch (IOException e) {
            throw new DAOException(e.getMessage());
        }

    }

    private void writeFlightsToFile() throws DAOException {
        try {
            FileOutputStream fos = new FileOutputStream(DATA_FILE_NAME);
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(flights.values());
            encoder.close();
            fos.close();
        } catch (IOException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
