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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class XmlFlightDAO implements FlightDAO {
    private List<Flight> flights = new ArrayList<>();
    private static final String DATA_FILE_NAME = "flights.xml";

    public XmlFlightDAO(){
        if (new File(DATA_FILE_NAME).exists()) {
            try {
                readFlightsFromFile();
                // sort flights and delete unnecessary (old)
                updateFlights();

            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param id flight number
     * @return Flight object if flight with that id exist (else null)
     */
    public Flight getFlightByID(int id){
        if ((id >= 0) && (id < flights.size())){
            return flights.get(id);
        }
        return null;
    }

    @Override
    public int getFlightsNumber(){
        return flights.size();
    }

    /**
     * Method sort flights in memory and delete old flights
     */
    private void updateFlights() {
        flights.sort(Flight::compareTo);
        flights.removeIf(flight -> LocalDate.now().compareTo(LocalDate.parse(flight.getDateOfFlight())) > 0);
    }

    /**
     *
     * @param flight new flight to saving
     * @throws DAOException if there are troubles with file writing
     */
    @Override
    public void addFlight(Flight flight) throws DAOException {
        flights.add(flight);
        updateFlights();
        writeFlightsToFile();
    }

    /**
     *
     * @param flightID flight number
     * @throws DAOException if there are troubles with file writing
     */
    @Override
    public void deleteFlight(int flightID) throws DAOException {
        flights.remove(flightID);
        writeFlightsToFile();
    }

    /**
     *
     * @throws DAOException if there are troubles with file reading
     */
    private void readFlightsFromFile() throws DAOException {
        try {
            flights = new ArrayList<>();
            FileInputStream fis = new FileInputStream(DATA_FILE_NAME);
            XMLDecoder decoder = new XMLDecoder(fis);
            flights = (ArrayList<Flight>)decoder.readObject();
            decoder.close();
            fis.close();

        } catch (IOException e) {
            throw new DAOException(e.getMessage());
        }
    }

    /**
     *
     * @throws DAOException if there are troubles with file writing
     */
    private void writeFlightsToFile() throws DAOException {
        try {
            File f = new File(DATA_FILE_NAME);
            if (!f.exists()){
                if (!f.createNewFile()) {
                    throw new DAOException("File with flights does not found.");
                }
            }
            FileOutputStream fos = new FileOutputStream(DATA_FILE_NAME);
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject((ArrayList<Flight>)flights);
            encoder.close();
            fos.close();
        } catch (IOException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
