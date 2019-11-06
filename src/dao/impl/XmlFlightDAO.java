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
    //private static Map<Integer, Flight> flights;
    //private Integer lastID = 0;
    private List<Flight> flights = new ArrayList<>();
    private static final String DATA_FILE_NAME = "flights.xml";


    //private Map<Integer, Flight> getFlights(){
  //      return flights;
   // }
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

    public XmlFlightDAO(){
        if (new File(DATA_FILE_NAME).exists()) {
            try {
                readFlightsFromFile();
//                for (Flight flight:
//                        flights) {
//                    if (LocalDate.now().compareTo(LocalDate.parse(flight.getDateOfFlight())) > 0){
//                        deleteFlight(flight);
//                    }
//                }


            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addFlight(Flight flight) throws DAOException {
      //  lastID++;
       // flights.put(lastID, flight);
        flights.add(flight);
        writeFlightsToFile();
    }

    @Override
    public void deleteFlight(Flight flight) throws DAOException {
       // flights.remove(flightID);
        flights.remove(flight);
        writeFlightsToFile();
    }

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
