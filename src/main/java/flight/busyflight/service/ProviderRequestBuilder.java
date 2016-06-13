package flight.busyflight.service;

import flight.busyflight.model.BusyFlightRequest;
import flight.busyflight.provider.model.AbstractProviderRequest;
import flight.busyflight.provider.model.CrazyAirRequest;
import flight.busyflight.provider.model.Provider;
import flight.busyflight.provider.model.ToughJetRequest;
import org.joda.time.DateTime;

/**
 * Created by kcai on 13/06/2016.
 */
public class ProviderRequestBuilder {

    public AbstractProviderRequest build(Provider provider, BusyFlightRequest request) {
        switch (provider) {
            case crazyair:
                CrazyAirRequest r = new CrazyAirRequest();
                r.setOrigin(request.getOrigin());
                r.setDestination(request.getDestination());
                r.setDepartureDate(request.getDepartureDate());
                r.setReturnDate(request.getReturnDate());
                r.setNumberOfAdults(request.getNumberOfPassengers());
                return r;

            case toughjet:
                ToughJetRequest rj = new ToughJetRequest();
                DateTime departureDate = new DateTime(request.getDepartureDate());
                DateTime returnDate = new DateTime(request.getReturnDate());
                rj.setOrigin(request.getOrigin());
                rj.setDestination(request.getDestination());
                rj.setDepartureDay(departureDate.getDayOfMonth());
                rj.setDepartureMonth(departureDate.getMonthOfYear());
                rj.setDepartureYear(departureDate.getYear());
                rj.setReturnDay(returnDate.getDayOfMonth());
                rj.setReturnMonth(returnDate.getMonthOfYear());
                rj.setReturnYear(returnDate.getYear());
                rj.setNumberOfAdults(request.getNumberOfPassengers());
                return rj;

            default: throw new IllegalArgumentException("Illegal airlines");
        }
    }
}
