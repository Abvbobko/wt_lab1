package dao.impl;

import beans.Flight;
import dao.FlightDAO;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextFlightDAO implements FlightDAO {
    private static Map<Integer, Flight> flights;
    private Integer lastID = 0;
    private static final String DATA_FILE_NAME = "flights.xml";

    public TextFlightDAO(){
        if (new File(DATA_FILE_NAME).exists()) {
            readFlightsFromFile();
        }
    }

    public Map<Integer, Flight> getFlights(){
        return flights;
    }


    @Override
    public void addFlight(Flight flight) {
        lastID++;
        flights.put(lastID, flight);
        writeFlightsToFile();
    }

    @Override
    public void deleteFlight(Integer flightID) {
        flights.remove(flightID);
        writeFlightsToFile();
    }


    private void readFlightsFromFile() {
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
            e.printStackTrace();
        }

    }

    private void writeFlightsToFile(){

    }
}
