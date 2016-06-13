package flight.busyflight.provider.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import flight.busyflight.model.BusyFlightResponse;
import flight.busyflight.service.ResultVisitor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kcai on 13/06/2016.
 */
public class CrazyAirResponse extends AbstractProviderResponse {

    private DateFormat df = new SimpleDateFormat("mm-DD-yyyy HH:MM:ss");

    public CrazyAirResponse(){

    }

    public CrazyAirResponse(String airline, Double price, String cabinclass, String departCode, String destCode, Date departDate, Date arrivalDate) {
        this.setAirline(airline);
        this.setPrice(price);
        this.setCabinclass(cabinclass);
        this.setDepartureAirportCode(departCode);
        this.setDestinationAirportCode(destCode);
        this.setDepartureDate(df.format(departDate));
        this.setArrivalDate(df.format(arrivalDate));
    }

    private String cabinclass;

    @JsonIgnore
    public Double getTax() {
        return 0.00;
    }

    public String getCabinclass() {
        return cabinclass;
    }

    public void setCabinclass(String cabinclass) {
        this.cabinclass = cabinclass;
    }

    @Override
    public BusyFlightResponse accept(ResultVisitor visitor) {
        return visitor.visit(this);
    }
}
