package beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Flight implements Serializable {
    private LocalDate dateOfFlight;

    public void setDateOfFlight(LocalDate dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setNumberOfFreeSeats(int numberOfFreeSeats) {
        this.numberOfFreeSeats = numberOfFreeSeats;
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

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int numberOfFreeSeats;
    private String fromCity;
    private String toCity;
    private Plane plane;

    public Flight(String fromCity, String toCity, LocalDate dateOfFlight, LocalTime departure,
                  LocalTime arrival, Plane plane) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.dateOfFlight = dateOfFlight;
        this.departureTime = departure;
        this.arrivalTime = arrival;
        this.plane = plane;
        this.numberOfFreeSeats = plane.getNumberOfSeats();
    }

    public Flight(String fromCity, String toCity, LocalDate dateOfFlight, LocalTime departure,
                  LocalTime arrival, Plane plane, int numberOfFreeSeats) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.dateOfFlight = dateOfFlight;
        this.departureTime = departure;
        this.arrivalTime = arrival;
        this.plane = plane;
        this.numberOfFreeSeats = numberOfFreeSeats;
    }

    public String getDateOfFlight(){
        // DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd MMM uuuu");
        return DateTimeFormatter.ofPattern("dd MMM uuuu").format(dateOfFlight);
    }

    public String getArrivalTime() {

        return DateTimeFormatter.ofPattern("HH:mm").format(arrivalTime);
    }

    public String getDepartureTime() {
        return DateTimeFormatter.ofPattern("HH:mm").format(departureTime);
    }

    public int getNumberOfFreeSeats() {
        return this.numberOfFreeSeats;
    }

    public boolean takePlace(){
        if (numberOfFreeSeats == 0) {
            return false;
        }
        numberOfFreeSeats--;
        return true;
    }

    public boolean takePlace(int occupiedSeats){
        if (numberOfFreeSeats - occupiedSeats < 0) {
            return false;
        }
        numberOfFreeSeats -= occupiedSeats;
        return true;
    }

    public int getID(){
        return this.hashCode();
    }
}

