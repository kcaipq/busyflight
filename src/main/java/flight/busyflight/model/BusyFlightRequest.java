package flight.busyflight.model;

import flight.busyflight.service.ResultVisitor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kcai on 13/06/2016.
 *
 * TODO make this in the hierarchy of the provider request objects?
 */
public class BusyFlightRequest implements Serializable {

    private String origin;
    private String destination;
    private Date departureDate;
    private Date returnDate;
    private int numberOfPassengers;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
