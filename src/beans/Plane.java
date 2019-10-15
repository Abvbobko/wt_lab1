package beans;

import java.time.LocalDate;

public class Plane {
    private Pilot pilot;
    final private String brand;
    final private int numberOfSeats;
    final private LocalDate yearOfManufacture;

    Plane(String brand, int numberOfSeats, LocalDate yearOfManufacture){
        this.brand = brand;
        this.numberOfSeats = numberOfSeats;
        this.yearOfManufacture = yearOfManufacture;
    }

    /*public int getNumberOfSeats(){

        return this.numberOfSeats;
    }*/
    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }

    public LocalDate getYearOfManufacture(){

        return this.yearOfManufacture;
    }

    public String getBrand(){

        return this.brand;
    }

    public Pilot getPilot(){

        return this.pilot;
    }

    public void setPilot(Pilot pilot){

        this.pilot = pilot;
    }

}
