package flight.busyflight.service;

import flight.busyflight.model.BusyFlightResponse;
import flight.busyflight.provider.model.CrazyAirRequest;
import flight.busyflight.provider.model.CrazyAirResponse;
import flight.busyflight.provider.model.ToughJetRequest;
import flight.busyflight.provider.model.ToughJetResponse;

/**
 * Created by kcai on 13/06/2016.
 */
public interface ResultVisitor {
    public BusyFlightResponse visit(CrazyAirResponse cr);
    public BusyFlightResponse visit(ToughJetResponse tr);
}
