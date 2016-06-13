package flight.busyflight.provider.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import flight.busyflight.model.BusyFlightResponse;
import flight.busyflight.service.ResultVisitor;

/**
 * Created by kcai on 13/06/2016.
 */
public class ToughJetResponse extends AbstractProviderResponse {

    private Double discount;

    public ToughJetResponse() {

    }

    public ToughJetResponse(String airline, Double price, Double tax, Double discount, String departCode, String destCode) {
        this.setAirline(airline);
        this.setPrice(price);
        this.setTax(tax);
        this.setDiscount(discount);
        this.setDepartureAirportCode(departCode);
        this.setDestinationAirportCode(destCode);
    }

    @JsonProperty("carrier")
    @Override
    public String getAirline() {
        return super.getAirline();
    }

    @JsonProperty("basePrice")
    @Override
    public Double getPrice() {
        return super.getPrice();
    }

    @JsonProperty("arrivalAirportName")
    @Override
    public String getDestinationAirportCode() {
        return super.getDestinationAirportCode();
    }

    @JsonIgnore
    @Override
    public String getDepartureDate() {
        return null;
    }

    @JsonIgnore
    @Override
    public String getArrivalDate() {
        return null;
    }

    @JsonProperty("departureAirportName")
    @Override
    public String getDepartureAirportCode() {
        return super.getDepartureAirportCode();
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public BusyFlightResponse accept(ResultVisitor visitor) {
        return visitor.visit(this);
    }
}
