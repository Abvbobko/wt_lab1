package beans;

import service.impl.FlightServiceImpl;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Flight implements Serializable, Comparable {
    private LocalDate dateOfFlight;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private String fromCity;
    private String toCity;

    public void setDateOfFlight(String dateOfFlight) {
        this.dateOfFlight = LocalDate.parse(dateOfFlight);
    }

    public String getDateOfFlight() {
        if (dateOfFlight == null) {
            return null;
        }
        return dateOfFlight.toString();
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = LocalTime.parse(departureTime);
    }

    public String getDepartureTime() {
        if (departureTime == null) {
            return null;
        }
        return departureTime.toString();
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = LocalTime.parse(arrivalTime);
    }

    public String getArrivalTime() {
        if (arrivalTime == null) {
            return null;
        }
        return arrivalTime.toString();
    }


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

    public Flight() { }

    public Flight(String fromCity, String toCity, LocalDate dateOfFlight, LocalTime departureTime,
                  LocalTime arrivalTime) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.dateOfFlight = dateOfFlight;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
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

    @Override
    public int compareTo(Object o) {
        Flight otherFlight = (Flight)o;

        int compareResult = dateOfFlight.compareTo(LocalDate.parse(otherFlight.getDateOfFlight()));
        if (compareResult == 0) {
            compareResult = arrivalTime.compareTo(LocalTime.parse(otherFlight.getArrivalTime()));
            if (compareResult == 0) {
                compareResult = fromCity.compareTo(otherFlight.getFromCity());
                if (compareResult == 0) {
                    compareResult = toCity.compareTo(otherFlight.getToCity());
                }
            }
        }
        return compareResult;
    }

}

