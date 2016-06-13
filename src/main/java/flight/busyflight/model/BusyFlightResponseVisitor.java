package flight.busyflight.model;

import flight.busyflight.provider.model.CrazyAirResponse;
import flight.busyflight.provider.model.Provider;
import flight.busyflight.provider.model.ToughJetResponse;
import flight.busyflight.service.ResultVisitor;

import java.math.BigDecimal;

/**
 * Created by kcai on 13/06/2016.
 */
public class BusyFlightResponseVisitor implements ResultVisitor {

    @Override
    public BusyFlightResponse visit(CrazyAirResponse cr) {
        BusyFlightResponse r = new BusyFlightResponse();
        r.setAirline(cr.getAirline());
        r.setSupplier(Provider.crazyair.name());
        r.setFare(new BigDecimal(cr.getPrice()));
        r.setDepartureAirportCode(cr.getDepartureAirportCode());
        r.setDestinationAirportCode(cr.getDestinationAirportCode());
        r.setDepartureDate(cr.getDepartureDate());
        r.setArrivalDate(cr.getArrivalDate());
        return r;
    }

    @Override
    public BusyFlightResponse visit(ToughJetResponse tr) {
        BusyFlightResponse r = new BusyFlightResponse();
        r.setAirline(tr.getAirline());
        r.setSupplier(Provider.toughjet.name());
        r.setFare(new BigDecimal(tr.getPrice() + tr.getTax() - tr.getDiscount()));
        r.setDepartureAirportCode(tr.getDepartureAirportCode());
        r.setDestinationAirportCode(tr.getDestinationAirportCode());

        //TODO decorate the dates later
        r.setDepartureDate(tr.getDepartureDate() == null ? "" : tr.getDepartureDate());
        r.setArrivalDate(tr.getArrivalDate() == null ? "" : tr.getArrivalDate());
        return r;
    }
}
