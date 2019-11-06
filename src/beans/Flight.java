package beans;

import service.FlightService;
import service.impl.FlightServiceImpl;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flight implements Serializable {
    private LocalDate dateOfFlight;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    //private int numberOfFreeSeats;
    private String fromCity;
    private String toCity;

    public void setDateOfFlight(String dateOfFlight) {
        this.dateOfFlight = LocalDate.parse(dateOfFlight);
    }

    public void setDepartureTime(String departureTime) {

        this.departureTime = LocalTime.parse(departureTime);
    }

    public void setArrivalTime(String arrivalTime) {

        this.arrivalTime = LocalTime.parse(arrivalTime);
    }

    /*public void setNumberOfFreeSeats(int numberOfFreeSeats) {
        this.numberOfFreeSeats = numberOfFreeSeats;
    }*/

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    /*public Flight(String fromCity, String toCity, LocalDate dateOfFlight, LocalTime departure,
                  LocalTime arrival, Plane plane) {

        this.fromCity = fromCity;
        this.toCity = toCity;
        this.dateOfFlight = dateOfFlight;
        this.departureTime = departure;
        this.arrivalTime = arrival;
     //   this.numberOfFreeSeats = plane.getNumberOfSeats();
    }*/

    public Flight() {
//        this.fromCity = "";
//        this.toCity = "";
//        this.dateOfFlight = LocalDate.now();
//        this.arrivalTime = LocalTime.now();
//        this.departureTime = LocalTime.now();
    }

    public Flight(String fromCity, String toCity, LocalDate dateOfFlight, LocalTime departureTime,
                  LocalTime arrivalTime) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.dateOfFlight = dateOfFlight;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        //   this.numberOfFreeSeats = numberOfFreeSeats;
    }

    public static List<String> getFieldsNames() {
        List<String> fieldsNames = new ArrayList<>();
        fieldsNames.add("Departure City");
        fieldsNames.add("Arrival City");
        fieldsNames.add(String.format("Date of Flight (%s)", FlightServiceImpl.DATE_FORMAT));
        fieldsNames.add(String.format("Departure Time (%s)", FlightServiceImpl.TIME_FORMAT));
        fieldsNames.add(String.format("Arrival Time (%s)", FlightServiceImpl.TIME_FORMAT));

        return fieldsNames;
    }

    public String getDateOfFlight() {
        if (dateOfFlight == null) {
            return null;
        }
        return dateOfFlight.toString();
    }

    public String getArrivalTime() {
        if (arrivalTime == null) {
            return null;
        }
        return arrivalTime.toString();
    }

    public String getDepartureTime() {
        if (departureTime == null) {
            return null;
        }
        return departureTime.toString();
    }

    @Override
    public String toString(){
        return String.format("%s: %s;\n%s: %s;\n%s: %s;\n%s: %s;\n%s: %s;\n",
                "Departure city", fromCity,
                "Arrival city", toCity,
                "Date of flight", dateOfFlight
                        .format(DateTimeFormatter.ofPattern(FlightServiceImpl.DATE_FORMAT)),
                "Departure time", departureTime
                        .format(DateTimeFormatter.ofPattern(FlightServiceImpl.TIME_FORMAT)),
                "Arrival time", arrivalTime
                        .format(DateTimeFormatter.ofPattern(FlightServiceImpl.TIME_FORMAT)));
    }


//    public int getID() {
//        return this.hashCode();
//    }
}

