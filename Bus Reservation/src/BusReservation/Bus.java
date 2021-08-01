package BusReservation;

import java.util.ArrayList;

public class Bus {

    private int capacity=10;
    private String destination;
    private ArrayList<Passenger> passengers = new ArrayList<>();




    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public void insertPassenger(Passenger p, Destination d)
    {

    }
}
