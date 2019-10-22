package dao.impl;

import beans.Flight;
import dao.FlightDAO;

import java.util.Map;

public class TextFlightDAO implements FlightDAO {
    private static Map<Integer, Flight> flights;
    private Integer lastID = 0;

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

    private static final String DATA_FILE_NAME = "flights.xml";
    private void readFlightsFromFile() {
        //каждому полету ставить в соответствие число

    }

    private void writeFlightsToFile(){

    }
}
