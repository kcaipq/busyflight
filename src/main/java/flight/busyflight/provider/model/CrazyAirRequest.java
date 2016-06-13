package flight.busyflight.provider.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by kcai on 13/06/2016.
 */
public class CrazyAirRequest extends AbstractProviderRequest {

    private Date departureDate;
    private Date returnDate;

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

    @JsonProperty("numberOfPassengers")
    @Override
    public void setNumberOfAdults(int numberOfPassengers) {
        super.setNumberOfAdults(numberOfPassengers);
    }
}
