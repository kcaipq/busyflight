package flight.busyflight.service;

import flight.busyflight.model.BusyFlightRequest;
import flight.busyflight.provider.model.CrazyAirRequest;
import flight.busyflight.provider.model.Provider;
import flight.busyflight.provider.model.ToughJetRequest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by kcai on 13/06/2016.
 */
public class ProviderRequestBuilderTest {

    private ProviderRequestBuilder builder = new ProviderRequestBuilder();

    @Test
    public void testCrazyAirRequestShouldNotHaveDayMonthYear() {
        BusyFlightRequest r = new BusyFlightRequest();
        r.setOrigin("HTR");
        r.setDestination("TUL");
        r.setDepartureDate(new Date());
        r.setReturnDate(new Date());
        r.setNumberOfPassengers(1);
        CrazyAirRequest req = (CrazyAirRequest) builder.build(Provider.crazyair, r);

        Assert.assertTrue(req.getDepartureDay() == 0);
        Assert.assertTrue(req.getDepartureMonth() == 0);
        Assert.assertTrue(req.getDepartureYear() == 0);
        Assert.assertTrue(req.getReturnDay() == 0);
        Assert.assertTrue(req.getReturnMonth() == 0);
        Assert.assertTrue(req.getReturnYear() == 0);
    }

    @Test
    public void testToughJetRequestShouldHaveDayMonthYear() {
        BusyFlightRequest r = new BusyFlightRequest();
        r.setOrigin("HTR");
        r.setDestination("TUL");
        r.setDepartureDate(new Date());
        r.setReturnDate(new Date());
        r.setNumberOfPassengers(1);
        ToughJetRequest req = (ToughJetRequest) builder.build(Provider.toughjet, r);

        Assert.assertTrue(req.getDepartureDay() != 0);
        Assert.assertTrue(req.getDepartureMonth() != 0);
        Assert.assertTrue(req.getDepartureYear() != 0);
        Assert.assertTrue(req.getReturnDay() != 0);
        Assert.assertTrue(req.getReturnMonth() != 0);
        Assert.assertTrue(req.getReturnYear() != 0);
    }
}
